package com.ticketingsystem.services;

import com.ticketingsystem.model.entities.Venda;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.model.interfaces.IngressoInterface;
import com.ticketingsystem.model.interfaces.SalesModeInterface;
import com.ticketingsystem.model.interfaces.VendaInterface;
import com.ticketingsystem.utils.Printer;

import java.util.Scanner;

public class SalesModeService implements SalesModeInterface {

    public void load() {
        Scanner sc = new Scanner(System.in);
        EventInterface event = new EventService();

        IngressoInterface ingresso = new IngressoService();
        VendaInterface vendaService = new VendaService();

        Printer.clearScreen();
        while (true) {
            Printer.userMenu();
            System.out.print("Selecione uma opção: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    Printer.clearScreen();
                    event.listEvents();
                    break;
                case "2":
                    Printer.clearScreen();
                    vendaService.load();
                    break;
                case "0":
                    Printer.clearScreen();
                    Printer.byeMessage();
                    return;
                default:
                    Printer.clearScreen();
                    Printer.message("Opção inválida!");
                    break;
            }
        }
    }
}