package br.com.emerlopes.service.impl;

import br.com.emerlopes.service.FileProcess;
import br.com.emerlopes.service.helpers.ServicesShared;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessSync implements FileProcess {

    private ServicesShared servicesShared = new ServicesShared();

    @Override
    public void process(final Path path) throws Exception {
        for (String linha : Files.lines(path).toList()) {
            servicesShared.processLine(linha);
        }
    }
}
