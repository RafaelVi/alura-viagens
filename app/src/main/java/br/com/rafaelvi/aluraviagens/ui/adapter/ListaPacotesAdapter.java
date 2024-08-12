package br.com.rafaelvi.aluraviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.rafaelvi.aluraviagens.R;
import br.com.rafaelvi.aluraviagens.model.Pacote;
import br.com.rafaelvi.aluraviagens.util.DiasUtil;
import br.com.rafaelvi.aluraviagens.util.MoedaUtil;
import br.com.rafaelvi.aluraviagens.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    private static void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String precoEmReal = MoedaUtil.converteParaReal(pacote.getPreco());
        preco.setText(precoEmReal);
    }

    private static void mostraDia(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto;
        diasEmTexto = DiasUtil.formataData(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private static void mostraLocal(View viewCriada, Pacote pacote) {
        TextView localView = viewCriada.findViewById(R.id.item_pacote_local);
        localView.setText(pacote.getLocal());
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int i) {
        return pacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, viewGroup, false);

        Pacote pacote = pacotes.get(i);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDia(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(pacote.getImagem(), context);
        imagem.setImageDrawable(drawableImagemPacote);
    }
}
