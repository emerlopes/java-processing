package br.com.emerlopes.service.impl;

import br.com.emerlopes.service.FileProcess;
import br.com.emerlopes.service.helpers.ServicesShared;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessVirtualThread implements FileProcess {

    private ServicesShared servicesShared = new ServicesShared();

    @Override
    public void process(final Path path) throws Exception {
        final List<Thread> threads = Files.lines(path)
                .map(linha -> Thread.startVirtualThread(
                        () -> servicesShared.processLine(linha))
                ).toList();

        for (Thread t : threads) {
            t.join();
        }
    }
}
