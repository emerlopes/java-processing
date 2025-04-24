package br.com.emerlopes.service.impl;

import br.com.emerlopes.service.FileProcess;
import br.com.emerlopes.service.helpers.ServicesShared;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class FileProcessAsync implements FileProcess {

    private ServicesShared servicesShared = new ServicesShared();

    @Override
    public void process(final Path path) throws Exception {
//        final ExecutorService executor = Executors.newFixedThreadPool(10);
        Files.lines(path)
                .map(linha -> CompletableFuture.runAsync(
                        () -> servicesShared.processLine(linha))
                ).forEach(CompletableFuture::join);
    }
}
