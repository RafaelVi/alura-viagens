package br.com.rafaelvi.aluraviagens.util;

public class DiasUtil {
    public static String formataData(int quantidadeDeDias){
        if (quantidadeDeDias > 1){
            return quantidadeDeDias + " dias";
        }
        return quantidadeDeDias + " dia";

    }
}
