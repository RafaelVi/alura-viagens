package br.com.rafaelvi.aluraviagens.ui.activity;

import static br.com.rafaelvi.aluraviagens.ui.activity.PacoteAcitivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.rafaelvi.aluraviagens.R;
import br.com.rafaelvi.aluraviagens.model.Pacote;
import br.com.rafaelvi.aluraviagens.util.DataUtil;
import br.com.rafaelvi.aluraviagens.util.DiasUtil;
import br.com.rafaelvi.aluraviagens.util.MoedaUtil;
import br.com.rafaelvi.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE = "Resumo do Pacote";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITLE);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = inicializaCampos(intent);

            Button realizaPagamento = findViewById(R.id.botao_pagamento_resumo_compra);

            realizaPagamento.setOnClickListener(view -> vaiParaPagamento(pacote));

        }
    }

    private @NonNull Pacote inicializaCampos(Intent intent) {
        Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
        return pacote;
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String formatDataViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(formatDataViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView precoView = findViewById(R.id.resumo_pacote_preco);
        BigDecimal preco = pacote.getPreco();
        precoView.setText(MoedaUtil.converteParaReal(preco));
    }

    private void mostraDias(Pacote pacote) {
        TextView diasView = findViewById(R.id.resumo_pacote_dias);
        String dias = DiasUtil.formataData(pacote.getDias());
        diasView.setText(dias);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawable = ResourceUtil.devolveDrawable(pacote.getImagem(), this);
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
