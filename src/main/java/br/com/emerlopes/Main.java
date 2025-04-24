package br.com.emerlopes;

import br.com.emerlopes.dto.FileProcessMode;
import br.com.emerlopes.service.helpers.FileGenerator;

import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final String PATH = "src/main/resources/registros.txt";

    public static void main(String[] args) throws Exception {

        final FileGenerator fileGenerator = new FileGenerator(10);
        fileGenerator.generate();

        final Path path = Path.of(PATH);

        final List<FileProcessMode> processors = List.of(
                FileProcessMode.SYNC,
                FileProcessMode.ASYNC,
                FileProcessMode.PARALLEL,
                FileProcessMode.STREAM,
                FileProcessMode.VIRTUAL_THREAD
        );

        for (FileProcessMode processor : processors) {
            try {

                Runtime runtime = Runtime.getRuntime();
                runtime.gc();
                Thread.sleep(100);

                long beforeMem = runtime.totalMemory() - runtime.freeMemory();
                long startTime = System.nanoTime();

                processor.getProcessor().process(path);

                long endTime = System.nanoTime();
                long afterMem = runtime.totalMemory() - runtime.freeMemory();

                // Métricas
                long usedMemBytes = afterMem - beforeMem;
                double usedMemMB = usedMemBytes / (1024.0 * 1024.0);
                double durationMs = (endTime - startTime) / 1_000_000.0;

                System.out.printf("Modo [%s] => Tempo: %.2f ms | Memória usada: %.2f MB%n",
                        processor.name(), durationMs, usedMemMB);

            } catch (final Exception e) {
                System.err.println("Erro ao executar " + processor.name());
                e.printStackTrace();
            }
        }
    }
}
