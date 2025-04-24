package br.com.emerlopes.service.helpers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileGenerator {

    private int lines;

    private static final String PATH = "src/main/resources/registros.txt";

    public FileGenerator(int lines) {
        this.lines = lines;
    }

    public void generate() throws IOException {
        final Path path = Path.of(PATH);

        final List<String> propostasBase = List.of(
                "Proposta: 1001 | Cliente: João Silva | Valor: 12000",
                "Proposta: 1002 | Cliente: Maria Souza | Valor: 8500",
                "Proposta: 1003 | Cliente: Pedro Oliveira | Valor: 10200",
                "Proposta: 1004 | Cliente: Ana Paula | Valor: 4500",
                "Proposta: 1005 | Cliente: Lucas Rocha | Valor: 7700"
        );

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < this.lines; i++) {
                String linha = propostasBase.get(i % propostasBase.size());
                writer.write(linha);
                writer.newLine();
            }
        }

        System.out.println("Arquivo gerado com " + lines + " linhas em: " + path);
    }
}
