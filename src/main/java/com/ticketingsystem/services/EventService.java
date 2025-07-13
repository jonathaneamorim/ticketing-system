package com.ticketingsystem.services;

import com.ticketingsystem.model.entities.Endereco;
import com.ticketingsystem.model.entities.Evento;
import com.ticketingsystem.model.entities.Ingresso;
import com.ticketingsystem.model.entities.Usuario;
import com.ticketingsystem.model.enums.CategoriaEnum;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.utils.Printer;
import jdk.jfr.Event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class EventService implements EventInterface {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final String FILE_NAME_EVENT = "eventos.csv";
    private final String PATH_INGRESSOS = "ingressos/";

    public void newEvent() {
        Printer.clearScreen();
        Printer.message("Cadastro de Novo Evento");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nome do Evento: ");
            String nome = sc.nextLine();

            System.out.print("Data (dd/MM/yyyy): ");
            LocalDate dataEvento = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Classificação Indicativa (idade): ");
            int classificacao = Integer.parseInt(sc.nextLine());

            Printer.message("Endereço");
            System.out.print("Rua: ");
            String rua = sc.nextLine();
            System.out.print("Número: ");
            String numero = sc.nextLine();
            System.out.print("Cidade: ");
            String cidade = sc.nextLine();
            System.out.print("Estado: ");
            String estado = sc.nextLine();
            System.out.print("Bairro: ");
            String bairro = sc.nextLine();
            System.out.print("País: ");
            String pais = sc.nextLine();
            System.out.print("CEP: ");
            String cep = sc.nextLine();
            System.out.print("Complemento: ");
            String complemento = sc.nextLine();
            System.out.print("Ponto Referência: ");
            String pontoReferencia = sc.nextLine();

            Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado, pais, complemento, pontoReferencia);

            System.out.print("Descrição do evento: ");
            String descricao = sc.nextLine();
            System.out.print("Avisos importantes: ");
            String avisos = sc.nextLine();

            Printer.message("Cadastro de Atrações");
            List<String> atracoes = new ArrayList<>();
            while (true) {
                System.out.print("Digite uma atração (ENTER para sair): ");
                String atracao = sc.nextLine();
                if (atracao.isEmpty()) break;
                atracoes.add(atracao);
            }

            Printer.message("Cadastro de Patrocinadores");
            List<String> patrocinadores = new ArrayList<>();
            while (true) {
                System.out.print("Digite um patrocinador (ENTER para sair): ");
                String patrocinador = sc.nextLine();
                if (patrocinador.isEmpty()) break;
                patrocinadores.add(patrocinador);
            }

            Printer.message("Cadastro de Ingressos");

            System.out.print("Quantidade TOTAL de ingressos (Inteira + Meia): ");
            int totalIngressos = Integer.parseInt(sc.nextLine());

            System.out.print("Valor cheio do ingresso: R$ ");
            double valorInteira = Double.parseDouble(sc.nextLine());
            double valorMeia = valorInteira / 2;

            int qtdInteira = totalIngressos / 2;
            int qtdMeia = totalIngressos - qtdInteira;

            String eventoId = UUID.randomUUID().toString();
            Evento evento = new Evento(eventoId, nome, dataEvento, descricao, avisos, endereco, classificacao, atracoes, patrocinadores);

            List<Ingresso> ingressos = new ArrayList<>();

            for (int i = 0; i < qtdInteira; i++) {
                String cod = eventoId.substring(0, 4) + "-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
                ingressos.add(new Ingresso(cod, evento, CategoriaEnum.INTEIRA, valorInteira));
            }

            for (int i = 0; i < qtdMeia; i++) {
                String cod = eventoId.substring(0, 4) + "-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
                ingressos.add(new Ingresso(cod, evento, CategoriaEnum.MEIA, valorMeia));
            }

            boolean saved = saveEvent(evento, ingressos);
            if (saved) {
                Printer.message("Evento |" + nome + "| cadastrado com sucesso e " + totalIngressos + " ingressos gerados.");
            } else {
                Printer.message("Erro ao salvar o evento.");
            }

        } catch (NumberFormatException e) {
            Printer.clearScreen();
            Printer.message("Erro: valor numérico inválido.");
        } catch (DateTimeParseException e) {
            Printer.clearScreen();
            Printer.message("Erro: formato de data inválido. Use dd/MM/yyyy.");
        } catch (Exception e) {
            Printer.clearScreen();
            Printer.message("Erro inesperado: " + e.getMessage());
        }
    }


    public boolean saveEvent(Evento evento, List<Ingresso> ingressos) {
        try {
            String eventoLine = String.join(";",
                    evento.getId(),
                    evento.getNome(),
                    evento.getData().format(formatter),
                    evento.getDescricao(),
                    evento.getAvisos(),
                    evento.getEndereco().toString(),
                    String.valueOf(evento.getClassificacaoIndicativa()),
                    String.join(",", evento.getAtracoes()),
                    String.join(",", evento.getPatrocinadores()));

            boolean insertedInEventFile = FileService.writeNewlineFile(FILE_NAME_EVENT, eventoLine);
            if(!insertedInEventFile) {
                Printer.message("Erro ao gravar dados do evento.");
                return false;
            }

            for (Ingresso ingresso : ingressos) {
                String ingressLine = String.join(";",
                        ingresso.getCode(),
                        ingresso.getCategoria().toString(),
                        ingresso.getValor().toString(),
                        "");
                FileService.writeNewlineFile(PATH_INGRESSOS + evento.getId() + ".csv", ingressLine);
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEvent() {
        try {
            Scanner sc = new Scanner(System.in);
            List<Evento> eventos = getEvents();

            Printer.clearScreen();
            listEvents();

            System.out.print("Digite o número do evento que deseja deletar: ");
            int option = Integer.parseInt(sc.nextLine());

            if (option < 0 || option >= eventos.size()) {
                Printer.clearScreen();
                Printer.message("Evento não encontrado!");
                return;
            }

            eventos.remove(option);

            FileService.clearFile(FILE_NAME_EVENT);

            for (Evento evento : eventos) {
                String eventoLine = String.join(";",
                        evento.getId(),
                        evento.getNome(),
                        evento.getData().format(formatter),
                        evento.getDescricao(),
                        evento.getAvisos(),
                        evento.getEndereco().toString(),
                        String.valueOf(evento.getClassificacaoIndicativa()),
                        String.join(",", evento.getAtracoes()),
                        String.join(",", evento.getPatrocinadores()));

                FileService.writeNewlineFile(FILE_NAME_EVENT, eventoLine);
            }
            Printer.clearScreen();
            Printer.message("Evento deletado com sucesso.");

        } catch (NumberFormatException e) {
            Printer.clearScreen();
            Printer.message("Entrada inválida. Digite um número.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void listEvents() {
        try {
            List<Evento> eventos = getEvents();
            Printer.showEvents(eventos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Evento getEventById(String eventId) {
        List<Evento> events = getEvents();
        for (Evento evento : events) {
            if (evento.getId().equals(eventId)) {
                return evento;
            }
        }
        return null;
    }

    public List<Evento> getEvents() {
        try {
            List<String> lines = FileService.readFile(FILE_NAME_EVENT);
            List<Evento> eventos = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(";");

                String id = parts[0];
                String nome = parts[1];
                LocalDate data = LocalDate.parse(parts[2], formatter);
                String descricao = parts[3];
                String avisos = parts[4];

                String[] enderecoParts = parts[5].split(",");

                Endereco endereco = new Endereco(
                        enderecoParts[0],
                        enderecoParts[1],
                        enderecoParts[2],
                        enderecoParts[3],
                        enderecoParts[4],
                        enderecoParts[5],
                        enderecoParts[6],
                        enderecoParts[7],
                        enderecoParts[8]
                );

                int classificacao = Integer.parseInt(parts[6]);
                List<String> atracoes = Arrays.asList(parts[7].split(","));
                List<String> patrocinadores = Arrays.asList(parts[8].split(","));

                Evento evento = new Evento(id, nome, data, descricao, avisos, endereco, classificacao, atracoes, patrocinadores);

                eventos.add(evento);
            }
            return eventos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}