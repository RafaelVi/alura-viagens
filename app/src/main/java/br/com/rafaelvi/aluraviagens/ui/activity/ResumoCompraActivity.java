package br.com.rafaelvi.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.rafaelvi.aluraviagens.R;
import br.com.rafaelvi.aluraviagens.model.Pacote;
import br.com.rafaelvi.aluraviagens.util.DataUtil;
import br.com.rafaelvi.aluraviagens.util.MoedaUtil;
import br.com.rafaelvi.aluraviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLE);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraBanner(pacoteSaoPaulo.getImagem());

        mostraLocal(pacoteSaoPaulo.getLocal());

        mostraData(pacoteSaoPaulo.getDias());

        mostraPreco(pacoteSaoPaulo.getPreco());


    }

    private void mostraBanner(String drawable) {
        ImageView banner = findViewById(R.id.resumo_compra_imagem);
        Drawable drawableBanner = ResourceUtil.devolveDrawable(drawable, this);
        banner.setImageDrawable(drawableBanner);
    }

    private void mostraPreco(BigDecimal preco) {
        TextView precoView = findViewById(R.id.resumo_compra_preco);
        String precoConvertido = MoedaUtil.converteParaReal(preco);
        precoView.setText(precoConvertido);
    }

    private void mostraData(int dias) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.periodoEmTexto(dias);
        data.setText(dataFormatada);
    }

    private void mostraLocal(String local) {
        TextView localView = findViewById(R.id.resumo_compra_local);
        localView.setText(local);
    }
}