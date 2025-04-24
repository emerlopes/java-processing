package br.com.emerlopes.service;

import java.nio.file.Path;

public interface FileProcess {
    void process(final Path path) throws Exception;
}
