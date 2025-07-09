package com.ticketingsystem.utils;

public class Printer {
    public static void welcome() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.centralize("Welcome to Ticketing System"));
        System.out.println(Aligner.line());
    }

    public static void adminMenu() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.centralize("Admin Menu"));
        System.out.println(Aligner.centralize("Selecione uma opção: "));
        System.out.println("1. Cadastrar um evento");
        System.out.println("0. Sair");
        System.out.println(Aligner.line());
    }

    public static void byeMessage() {
        System.out.println(Aligner.emptyLine());
        System.out.println(Aligner.emptyLine());
        System.out.println(Aligner.line());
        System.out.println(Aligner.centralize("Thanks for use Ticketing System!"));
        System.out.println(Aligner.line());
    }
}
