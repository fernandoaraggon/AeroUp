package br.edu.unirriter.mobile.projaeroup.presenter;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import br.edu.unirriter.mobile.projaeroup.adapters.AgendaAdapter;
import br.edu.unirriter.mobile.projaeroup.model.Agenda;
import br.edu.unirriter.mobile.projaeroup.model.Breve;
import br.edu.unirriter.mobile.projaeroup.ui.TelaAgenda;
import br.edu.unirriter.mobile.projaeroup.ui.TelaAgendaDetalhe;
import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.rvInterface;

public class AgendaPresenter implements rvInterface {

    private List<Agenda> listaAgendamentos = new ArrayList<>();
    private TelaAgenda tela;


    public AgendaPresenter(TelaAgenda act) {
        this.tela = act;
    }

    public void buscaAgenda() {
        listaAgendamentos.clear();

        listaAgendamentos.add(new Agenda("9:33"));
        listaAgendamentos.add(new Agenda("Funciona"));

        AgendaAdapter adapter = new AgendaAdapter(listaAgendamentos, this);
        tela.prepararRecyclerView(adapter);
    }

    @Override
    public void onItemClick(int pos) {
        //Mudar para Parceble
        Intent agendaDetalhe = new Intent(tela.getApplicationContext(), TelaAgendaDetalhe.class);
        tela.startActivity(agendaDetalhe);
    }
}