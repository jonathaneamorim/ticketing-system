package com.ticketingsystem.services;

import com.ticketingsystem.model.entities.Evento;
import com.ticketingsystem.model.entities.Ingresso;
import com.ticketingsystem.model.enums.CategoriaEnum;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.model.interfaces.IngressoInterface;

import java.util.ArrayList;
import java.util.List;


public class IngressoService implements  IngressoInterface {
    public List<Ingresso> getIngressosByEventoId(String eventId) {
        FileService fileService = new FileService();
        EventInterface eventService = new EventService();
        List<Ingresso> ingressos = new ArrayList<>();
        List<String> lines = FileService.readFile("ingressos/" + eventId + ".csv");

        Evento evento = eventService.getEventById(eventId);

        for (String line : lines) {
            String[] parts = line.split(";");
            String codigo = parts[0];
            CategoriaEnum categoria = CategoriaEnum.valueOf(parts[1]);
            Double valor = Double.parseDouble(parts[2]);

            ingressos.add(new Ingresso(codigo, evento, categoria, valor));
        }

        return ingressos;
    }

    public void removerIngressoERegistrarBilhete(Ingresso ingresso) {
        String ingressoFile = "ingressos/" + ingresso.getEvento().getId() + ".csv";
        List<String> linhas = FileService.readFile(ingressoFile);
        List<String> novaLista = new ArrayList<>();

        for (String linha : linhas) {
            if (!linha.startsWith(ingresso.getCode() + ";")) {
                novaLista.add(linha);
            }
        }

        FileService.clearFile(ingressoFile);

        for (String linha : novaLista) {
            FileService.writeNewlineFile(ingressoFile, linha);
        }

        String bilheteFile = "bilhetes/" + ingresso.getEvento().getId() + "_emitidos.txt";
        String bilheteInfo = String.join(" | ",
                "Código: " + ingresso.getCode(),
                "Evento: " + ingresso.getEvento().getNome(),
                "Categoria: " + ingresso.getCategoria().getDescricao(),
                "Valor: R$" + ingresso.getValor());

        FileService.writeNewlineFile(bilheteFile, bilheteInfo);
    }

}
