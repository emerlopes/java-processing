package br.com.emerlopes.service.helpers;

import br.com.emerlopes.dto.Constants;

public class ServicesShared {
    public void processLine(String linha) {
        try {
//            System.out.println("Processando linha: " + linha + " na thread " + Thread.currentThread().getName());
            Thread.sleep(Constants.EXECUTION_TIME);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
