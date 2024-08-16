package br.com.rafaelvi.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.rafaelvi.aluraviagens.R;
import br.com.rafaelvi.aluraviagens.model.Pacote;
import br.com.rafaelvi.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITLE);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraPreco(pacoteSaoPaulo.getPreco());

    }

    private void mostraPreco(BigDecimal valor) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String precoFormatado = MoedaUtil.converteParaReal(valor);
        preco.setText(precoFormatado);
    }
}