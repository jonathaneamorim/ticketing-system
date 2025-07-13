package com.ticketingsystem.utils;

// https://www.ibm.com/docs/pt-br/i/7.6.0?topic=languages-using-javalangruntimeexec

import com.ticketingsystem.model.entities.Evento;

import java.util.List;

public class Printer {

    public static void spacing() {
        System.out.println(Aligner.emptyLine());
    }

    public static void welcome() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.position("Welcome to Ticketing System", Aligner.Alignment.CENTER));
        System.out.println(Aligner.line());
    }

    public static void adminMenu() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Admin Menu"));
        System.out.println(Aligner.alignBlockCenter("Selecione uma opção: "));
        System.out.println(Aligner.alingBlockLeft("1. Cadastrar novo evento"));
        System.out.println(Aligner.alingBlockLeft("2. Listar eventos"));
        System.out.println(Aligner.alingBlockLeft("3. Excluir evento"));
        System.out.println(Aligner.alingBlockLeft("4. Abrir modo Usuário"));
        System.out.println(Aligner.alingBlockLeft("0. Sair"));
        System.out.println(Aligner.line());
    }

    public static void userMenu() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("User Menu"));
        System.out.println(Aligner.alignBlockCenter("Selecione uma opção: "));
        System.out.println(Aligner.alingBlockLeft("1. Listar Eventos"));
        System.out.println(Aligner.alingBlockLeft("2. Comprar um ingresso"));
        System.out.println(Aligner.alingBlockLeft("0. Sair"));
        System.out.println(Aligner.line());
    }

    public static void requestAdminPassword() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Login | Painel Admin"));
        System.out.println(Aligner.line());
        System.out.print("Insira a senha: ");
    }

    public static void showEvents(List<Evento> eventos) {
        int contador = 0;
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Lista de eventos"));
        for (Evento evento : eventos) {
            System.out.println(Aligner.alingBlockLeft(contador + " - Nome: " + evento.getNome() + " - Descrição: " + evento.getDescricao()));
            contador++;
        }
        System.out.println(Aligner.line());
    }


    public static void byeMessage() {
        spacing();
        System.out.println(Aligner.line());
        System.out.println(Aligner.position("Thanks for use Ticketing System!", Aligner.Alignment.CENTER));
        System.out.println(Aligner.line());
    }

    public static void message(String message) {
        spacing();
        System.out.println(Aligner.line());
        System.out.println(Aligner.position(message,  Aligner.Alignment.CENTER));
        System.out.println(Aligner.line());
        spacing();
    }

    public static void selectCategory() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Selecione uma categoria"));
        System.out.println(Aligner.alingBlockLeft("1 - Meia entrada"));
        System.out.println(Aligner.alingBlockLeft("2 - Inteira"));
        System.out.println(Aligner.line());
    }


    public static void selectFormaPagamento() {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Selecione a forma de pagamento:"));
        System.out.println(Aligner.alingBlockLeft("1 - PIX"));
        System.out.println(Aligner.alingBlockLeft("2 - CREDITO"));
        System.out.println(Aligner.alingBlockLeft("3 - BOLETO"));
        System.out.println(Aligner.alingBlockLeft("4 - DEBITO"));
        System.out.println(Aligner.line());
    }

    public static void printerIngresso(String code, String categoria, Double valor, String formaPagamanto, String portador, String cpf, String eventoNome, String endereco, String atracoes,  String patrocinadores) {
        System.out.println(Aligner.line());
        System.out.println(Aligner.alignBlockCenter("Revendedora de Ingressos Aliza"));
        System.out.println(Aligner.alignBlockCenter("Evento: " + eventoNome));
        System.out.println(Aligner.alignBlockCenter("Atrações"));
        System.out.println(Aligner.alignBlockCenter(atracoes));
        System.out.println(Aligner.alignBlockCenter("Codigo do ingresso: " + code));
        System.out.println(Aligner.alingBlockLeft("Portador: " + portador));
        System.out.println(Aligner.alingBlockLeft("CPF: " + cpf));
        System.out.println(Aligner.alingBlockLeft("Categoria do ingresso: " + categoria));
        System.out.println(Aligner.alingBlockLeft("Valor do ingresso: " + valor));
        System.out.println(Aligner.alingBlockLeft("Forma de pagamento: " + formaPagamanto));
        System.out.println(Aligner.alingBlockLeft("Endereço: : " + endereco));
        System.out.println(Aligner.alingBlockLeft("Patrocinadores: " +  patrocinadores));
        System.out.println(Aligner.line());
    }

    /*
        Função para limpar o terminal
        Printa 20 linhas para ocultar os inputs anteriores
        Fonte de sugestão para solução: https://stackoverflow.com/questions/2979383/how-to-clear-the-console-using-java
    */
    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
