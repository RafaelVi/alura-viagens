package br.com.rafaelvi.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String PATTERN = "dd/MM";

    public static @NonNull String periodoEmTexto(int dias) {
        Calendar dataDeIda = Calendar.getInstance();
        Calendar dataDeVolta = Calendar.getInstance();
        dataDeVolta.add(Calendar.DATE, dias);
        SimpleDateFormat format = new SimpleDateFormat(PATTERN);
        String formatDataDeIda = format.format(dataDeIda.getTime());
        String formatDataDeVolta = format.format(dataDeVolta.getTime());
        return formatDataDeIda + " - "
                + formatDataDeVolta
                + " de "
                + dataDeVolta.get(Calendar.YEAR);
    }
}
