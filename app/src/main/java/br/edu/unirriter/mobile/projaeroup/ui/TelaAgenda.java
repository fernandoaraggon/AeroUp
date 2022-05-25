package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.databinding.ActivityTelaAgendaBinding;
import br.edu.unirriter.mobile.projaeroup.databinding.ActivityTelaHomeBinding;
import br.edu.unirriter.mobile.projaeroup.presenter.AgendaPresenter;
import br.edu.unirriter.mobile.projaeroup.presenter.BrevePresenter;
import br.edu.unirriter.mobile.projaeroup.ui.drawer.TelaBaseDrawer;

public class TelaAgenda extends TelaBaseDrawer {

    ActivityTelaAgendaBinding activityTelaAgendaBinding;
    AgendaPresenter presenterAgenda = new AgendaPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTelaAgendaBinding = activityTelaAgendaBinding.inflate(getLayoutInflater());
        setContentView(activityTelaAgendaBinding.getRoot());
        allocateAcitivityTitle("Agenda");

        presenterAgenda.buscaAgenda();
    }

    public void prepararRecyclerView(RecyclerView.Adapter adapter)
    {
        RecyclerView rv = findViewById(R.id.rvAgenda);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }
}