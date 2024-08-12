package br.com.rafaelvi.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {
    public static String converteParaReal(BigDecimal preco){
        NumberFormat toReal = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return toReal.format(preco);
    }
}
