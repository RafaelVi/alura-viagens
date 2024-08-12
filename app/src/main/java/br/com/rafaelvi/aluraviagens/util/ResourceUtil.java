package br.com.rafaelvi.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.rafaelvi.aluraviagens.model.Pacote;

public class ResourceUtil {
    public static Drawable devolveDrawable(String drawable, Context context) {
        Resources resource = context.getResources();
        int idDoDrawable = resource.getIdentifier(drawable, "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resource.getDrawable(idDoDrawable);
        return drawableImagemPacote;
    }
}
