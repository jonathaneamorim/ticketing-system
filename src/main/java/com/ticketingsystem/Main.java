package com.ticketingsystem;

import com.ticketingsystem.model.entities.Evento;
import com.ticketingsystem.model.interfaces.EventInterface;
import com.ticketingsystem.services.EventService;
import com.ticketingsystem.utils.Printer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EventInterface evento = new EventService();

        Printer.adminMenu();
        System.out.print("Select an option: ");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                Boolean newEvent = evento.newEvent();
                System.out.println(newEvent);
                break;
            case 0:
                Printer.byeMessage();
                break;
            default:
                System.out.println("Wrong option");
        }

        sc.close();
    }
}