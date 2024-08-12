package br.com.rafaelvi.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.rafaelvi.aluraviagens.R;
import br.com.rafaelvi.aluraviagens.dao.PacoteDAO;
import br.com.rafaelvi.aluraviagens.model.Pacote;
import br.com.rafaelvi.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        List<Pacote> pacotes = PacoteDAO.lista();
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes,this));
    }
}