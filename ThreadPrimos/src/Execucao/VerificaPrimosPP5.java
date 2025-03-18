package Execucao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VerificaPrimosPP5 {

    public static void main(String[] args) {
        String inputFile = "Entrada01.txt"; // Para arquivo do professor, use Entrada01, 
        								//para um arquivo menor e de fácil visualização use Entrada02
        String outputFile = "Saida03.txt"; // Para 5 threads, se usa a Saida 03

        // Captura o tempo inicial
        long t0 = System.nanoTime();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            List<String> qtdeLinhas = new ArrayList<>();
            String linha;
            while ((linha = reader.readLine()) != null) {
            	qtdeLinhas.add(linha);
            }

            int NumeroLinhas = qtdeLinhas.size();
            int bloco = (NumeroLinhas + 4) / 5; // Divide o trabalho em 5 partes para cada uma das threads

            ConcurrentHashMap<Integer, String> resultado = new ConcurrentHashMap<>();

            // Cria e inicia as threads
            VerificaPrimosPP[] threads = new VerificaPrimosPP[5];
            for (int i = 0; i < 5; i++) {
                int start = i * bloco;
                int end = Math.min(start + bloco, NumeroLinhas);
                List<String> chunk = qtdeLinhas.subList(start, end);
                threads[i] = new VerificaPrimosPP(chunk, start, resultado);
                threads[i].start();
            }

            // Aguarda todas as threads terminarem
            for (VerificaPrimosPP thread : threads) {
                thread.join();
            }

            // Escreve os resultados no arquivo de saída na ordem original
            for (int i = 0; i < NumeroLinhas; i++) {
                String saida = resultado.get(i);
                if (saida != null) {
                    writer.write(saida);
                }
            }

            // Captura o tempo final
            long tf = System.nanoTime();

            // Calcula o tempo decorrido em milissegundos
            long duracao = (tf - t0) / 1_000_000;

            System.out.println("Processamento concluído.\nVerifique o arquivo de saída: " + outputFile);
            System.out.println("Tempo de execução: " + duracao + " ms");
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}