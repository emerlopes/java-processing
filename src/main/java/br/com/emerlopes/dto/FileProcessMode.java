package br.com.emerlopes.dto;

import br.com.emerlopes.service.FileProcess;
import br.com.emerlopes.service.impl.*;

public enum FileProcessMode {
    SYNC(new FileProcessSync()),
    ASYNC(new FileProcessAsync()),
    PARALLEL(new FileProcessParallel()),
    STREAM(new FileProcessStream()),
    VIRTUAL_THREAD(new FileProcessVirtualThread());

    private final FileProcess processor;

    FileProcessMode(FileProcess processor) {
        this.processor = processor;
    }

    public FileProcess getProcessor() {
        return processor;
    }
}
