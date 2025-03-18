package Execucao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class VerificaPrimosPP extends Thread {

    private List<String> linhas; // Lista de linhas (números) a serem processadas
    private int indice0; // Índice inicial no arquivo original
    private ConcurrentHashMap<Integer, String> saida; // Mapa para armazenar resultados

    public VerificaPrimosPP(List<String> linhas, int indice0, ConcurrentHashMap<Integer, String> saida) {
        this.linhas = linhas;
        this.indice0 = indice0;
        this.saida = saida;
    }

    @Override
    public void run() {
        for (int i = 0; i < linhas.size(); i++) {
            try {
                int numero = Integer.parseInt(linhas.get(i));
                if (verificaPrimo(numero)) {
                    saida.put(indice0 + i, numero + " - Primo \n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Erro: " + linhas.get(i));
            }
        }
    }


    private boolean verificaPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}