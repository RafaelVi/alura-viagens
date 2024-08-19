package br.com.rafaelvi.aluraviagens.ui.activity;

import static br.com.rafaelvi.aluraviagens.ui.activity.PacoteAcitivityConstantes.CHAVE_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote.getPreco());
            Button botaoFinalizaCompra = findViewById(R.id.botao_pagamento_finalizar_comprar);
            botaoFinalizaCompra.setOnClickListener(view -> vaiParaResumoCompra(pacote));
        }
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(BigDecimal valor) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String precoFormatado = MoedaUtil.converteParaReal(valor);
        preco.setText(precoFormatado);
    }
}