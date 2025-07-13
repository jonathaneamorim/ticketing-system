package com.ticketingsystem.services;

import com.ticketingsystem.model.entities.Administrador;
import com.ticketingsystem.model.interfaces.AdminInterface;
import com.ticketingsystem.utils.Printer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AdminService implements AdminInterface {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Boolean startAdmin() {
       try (Scanner sc = new Scanner(System.in)) {
           Printer.welcome();

           System.out.println("Digite o nome do administrador: ");
           String nome = sc.nextLine();

           System.out.println("Digite o CPF do administrador: ");
           String cpf = sc.nextLine();

           System.out.println("Digite o email do administrador: ");
           String email = sc.nextLine();

           System.out.println("Digite a data de nascimento do administrador(01/01/2000): ");
           String dataNascimento = sc.nextLine();
           LocalDate data = LocalDate.parse(dataNascimento, formatter);

           System.out.println("Digite o nome da empresa organizadora ou vendedora dos ingressos: ");
           String nomeOrganizador = sc.nextLine();

           System.out.println("Digite uma senha de segurança para acesso a sessão administrativa: ");
           String senha = sc.nextLine();

           Administrador administrador = new Administrador(nome, cpf, nomeOrganizador, senha);

           boolean writeFile = FileService.writeNewlineFile(administrador.toString(), "administrador.csv");

           if(!writeFile) {
               Printer.message("Dados salvos com sucesso!");
               return false;
           }
           return true;
       } catch(DateTimeParseException e) {
           Printer.message("Erro no formato da data!");
           return false;
       } catch (Exception e) {
           Printer.message("Erro ao salvar informações de administrador!");
           return false;
       }
    }
}
