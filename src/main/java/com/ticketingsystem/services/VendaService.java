package com.ticketingsystem.services;

import com.ticketingsystem.model.entities.Evento;
import com.ticketingsystem.model.entities.Ingresso;
import com.ticketingsystem.model.entities.Pagamento;
import com.ticketingsystem.model.entities.Usuario;
import com.ticketingsystem.model.enums.CategoriaEnum;
import com.ticketingsystem.model.enums.FormaPagamentoEnum;
import com.ticketingsystem.model.enums.StatusPagamentoEnum;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.model.interfaces.IngressoInterface;
import com.ticketingsystem.model.interfaces.VendaInterface;
import com.ticketingsystem.utils.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class VendaService implements VendaInterface {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void load() {
        Scanner sc = new Scanner(System.in);

        EventInterface eventService = new EventService();
        IngressoInterface ingressoService = new IngressoService();

        List<Evento> eventos = eventService.getEvents();
        int eventNumber = 0;

        while (true) {
            eventService.listEvents();
            System.out.print("Digite o número do evento que deseja comprar ingresso: ");
            int option = Integer.parseInt(sc.nextLine());
            if (option >= 0 && option < eventos.size()) {
                eventNumber = option;
                break;
            } else {
                Printer.clearScreen();
                Printer.message("Opção inválida!");
            }
        }

        Evento eventoSelecionado = eventos.get(eventNumber);

        List<Ingresso> ingressosDisponiveis = ingressoService.getIngressosByEventoId(eventoSelecionado.getId());
        if (ingressosDisponiveis.isEmpty()) {
            Printer.clearScreen();
            Printer.message("Não há mais ingressos disponíveis para esse evento! :(");
            return;
        }

        Printer.clearScreen();
        Printer.message("Compra de ingresso");

        System.out.print("Digite sua data de nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine(), formatter);

        if (ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()) < eventoSelecionado.getClassificacaoIndicativa()) {
            Printer.clearScreen();
            Printer.message("Você não possui idade suficiente para ingressar no evento!");
            return;
        }

        System.out.print("Digite seu CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Digite seu nome completo: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        Usuario usuario = new Usuario(cpf, nome, dataNascimento, email);

        CategoriaEnum selectCategory = null;
        Printer.clearScreen();
        while (selectCategory == null) {
            Printer.selectCategory();
            System.out.print("Selecione a categoria: ");
            switch (sc.nextLine()) {
                case "1": selectCategory = CategoriaEnum.MEIA; break;
                case "2": selectCategory = CategoriaEnum.INTEIRA; break;
                default:
                    Printer.clearScreen();
                    Printer.message("Opção inválida!");
            }
        }

        // Buscar um ingresso disponível da categoria escolhida
        Ingresso ingressoSelecionado = null;
        for (Ingresso ingresso : ingressosDisponiveis) {
            if (ingresso.getCategoria() == selectCategory && ingresso.getUsuario() == null) {
                ingressoSelecionado = ingresso;
                break;
            }
        }

        if (ingressoSelecionado == null) {
            Printer.clearScreen();
            Printer.message("Não há ingressos disponíveis para essa categoria.");
            return;
        }

        FormaPagamentoEnum formaPagamento = null;
        Printer.clearScreen();
        while (formaPagamento == null) {
            Printer.selectFormaPagamento();
            System.out.print("Selecione uma opção: ");
            System.out.println();
            switch (sc.nextLine()) {
                case "1":
                    formaPagamento = FormaPagamentoEnum.PIX;
                    break;
                case "2":
                    formaPagamento = FormaPagamentoEnum.CREDITO;
                    break;
                case "3":
                    formaPagamento = FormaPagamentoEnum.BOLETO;
                    break;
                case "4":
                    formaPagamento = FormaPagamentoEnum.DEBITO;
                    break;
                default:
                    Printer.clearScreen();
                    Printer.message("Forma de pagamento inválida!");
            }
        }

        Printer.clearScreen();

        Pagamento pagamento = new Pagamento(formaPagamento, ingressoSelecionado, StatusPagamentoEnum.PAGO);

        String atracoes = String.join(" - ", eventoSelecionado.getAtracoes());
        String patrocinadores = String.join(", ", eventoSelecionado.getPatrocinadores());

        Printer.printerIngresso(
                ingressoSelecionado.getCode(),
                ingressoSelecionado.getCategoria().getDescricao(),
                ingressoSelecionado.getValor(),
                pagamento.getFormaPagamentoEnum().name(),
                usuario.getNome(),
                usuario.getCpf(),
                eventoSelecionado.getNome(),
                eventoSelecionado.getEndereco().show(),
                atracoes,
                patrocinadores
        );

        ingressoService.removerIngressoERegistrarBilhete(ingressoSelecionado);
    }

}
