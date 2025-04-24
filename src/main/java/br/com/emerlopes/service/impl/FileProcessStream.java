package br.com.emerlopes.service.impl;

import br.com.emerlopes.service.FileProcess;
import br.com.emerlopes.service.helpers.ServicesShared;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessStream implements FileProcess {

    private ServicesShared servicesShared = new ServicesShared();

    @Override
    public void process(final Path path) throws Exception {
        try (var linhas = Files.lines(path)) {
            linhas.forEach(servicesShared::processLine);
        }
    }
}
