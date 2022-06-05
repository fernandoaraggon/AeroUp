package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.databinding.ActivityTelaAgendaBinding;
import br.edu.unirriter.mobile.projaeroup.model.Agenda;
import br.edu.unirriter.mobile.projaeroup.presenter.AgendaPresenter;
import br.edu.unirriter.mobile.projaeroup.ui.drawer.TelaBaseDrawer;

public class TelaAgenda extends TelaBaseDrawer {

    ActivityTelaAgendaBinding activityTelaAgendaBinding;
    AgendaPresenter presenterAgenda = new AgendaPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTelaAgendaBinding = activityTelaAgendaBinding.inflate(getLayoutInflater());
        setContentView(activityTelaAgendaBinding.getRoot());

        presenterAgenda.buscaAgenda();

        testarTela();
    }

    public void testarTela()
    {
        String titulo = getIntent().getStringExtra("titulo");
        String data = getIntent().getStringExtra("data");
        String hora = getIntent().getStringExtra("hora");
        String tela = getIntent().getStringExtra("tela");
        //local get
        //instrutor get

        if("BreveD".equals(tela))
        {
            presenterAgenda.adicionaAgenda(hora,data,titulo);
        }else if("AgendaDCancela".equals(tela))
        {
            presenterAgenda.removerAgenda();
        }else if("AgendaDAltera".equals(tela))
        {
            Agenda agendaAltera = new Agenda(hora,data,titulo);
            presenterAgenda.alterarAgenda(agendaAltera);
        }
    }


    public void prepararRecyclerView(RecyclerView.Adapter adapter)
    {
        RecyclerView rv = findViewById(R.id.rvAgenda);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }
}