package Execucao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VerificaPrimos {

    public static void main(String[] args) {
        String inputFile = "Entrada01.txt";
        String outputFile = "Saida02.txt";

        // Captura o tempo inicial
        long t0 = System.nanoTime();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linha);
                    if (verificaPrimo(numero)) {
                        writer.write(numero + " - Primo \n");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Erro: " + linha);
                }
            }

            // Captura o tempo final
            long tf = System.nanoTime();

            // Calcula o tempo decorrido em milissegundos
            long duracao = (tf - t0) / 1_000_000;

            System.out.println("Thread sequencial finalizada com sucesso.\nVerifique a saída: " + outputFile);
            System.out.println("Tempo de execução: " + duracao + " ms");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static boolean verificaPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}