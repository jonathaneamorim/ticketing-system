package com.ticketingsystem.services;

import com.ticketingsystem.utils.Printer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// https://www.baeldung.com/java-buffered-reader

public class FileService {

    private static final String PATH_DATA = "data/";

    public static void createDirectory(String relativePath) {
        try {
            Files.createDirectories(Paths.get(PATH_DATA + relativePath));
        } catch (IOException e) {
            Printer.message("Erro ao criar diretório: " + e.getMessage());
        }
    }

    public static boolean generateFile(String relativeFilePath) {
        try {
            File file = new File(PATH_DATA + relativeFilePath);
            if (!file.exists()) {
                return file.createNewFile();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            return false;
        }
    }

    public static boolean writeNewlineFile(String filename, String line) {
        try {
            String fullPath = PATH_DATA + filename;
            File file = new File(fullPath);
            File parentDir = file.getParentFile();

            if (parentDir != null && !parentDir.exists()) {
                if (!parentDir.mkdirs()) {
                    Printer.message("Erro ao criar diretórios: " + parentDir.getPath());
                    return false;
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(line);
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false;
        }
    }

    public static boolean rewriteFile(String filename, String line) {
        try {
            String fullPath = PATH_DATA + filename;
            File file = new File(fullPath);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(line);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            return false;
        }
    }

    public static boolean clearFile(String filename) {
        try {
            File file = new File(PATH_DATA + filename);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao limpar arquivo: " + e.getMessage());
            return false;
        }
    }

    public static List<String> readFile(String file) {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(PATH_DATA + file))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
            return lines;
        } catch (IOException e) {
            Printer.message("Erro ao ler arquivo: " + e.getMessage());
        }
        return lines;
    }

}
