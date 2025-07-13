package com.ticketingsystem;

import com.ticketingsystem.model.entities.Administrador;
import com.ticketingsystem.model.entities.Evento;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.model.interfaces.SalesModeInterface;
import com.ticketingsystem.services.EventService;
import com.ticketingsystem.services.SalesModeService;
import com.ticketingsystem.utils.Printer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Administrador adm = new Administrador("000.000.000-00", "Joilson", "Revendedora de Ingressos Aliza", "admin");

        EventInterface event = new EventService();
        SalesModeService salesMode = new SalesModeService();

        Printer.welcome();

        // Validação de senha
        Printer.requestAdminPassword();
        String senha =  sc.nextLine();
        if(senha.equals(adm.getSenha())){
            Printer.clearScreen();
            Printer.message("Login bem sucedido!");
            while (true) {
                Printer.adminMenu();
                System.out.print("Opção: ");
                String option = sc.nextLine();
                switch (option) {
                    case "1":
                        event.newEvent();
                        break;
                    case "2":
                        Printer.clearScreen();
                        event.listEvents();
                        break;
                    case "3":
                        event.deleteEvent();
                        break;
                    case "4":
                        salesMode.load();
                        break;
                    case "0":
                        Printer.clearScreen();
                        Printer.byeMessage();
                        return;
                    default:
                        Printer.clearScreen();
                        Printer.message("Opção inválida!");
                }
            }
        } else {
            Printer.clearScreen();
            Printer.message("Senha incorreta! - Tente novamente!");
        }
    }
}
