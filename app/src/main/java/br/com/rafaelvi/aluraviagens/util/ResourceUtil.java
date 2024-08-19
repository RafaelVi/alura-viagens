package br.com.rafaelvi.aluraviagens.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.content.res.AppCompatResources;

public class ResourceUtil {
    public static Drawable devolveDrawable(String drawable, Context context) {
        int id = context.getResources().getIdentifier(drawable, "drawable", context.getPackageName());
        return AppCompatResources.getDrawable(context, id);
    }
}
