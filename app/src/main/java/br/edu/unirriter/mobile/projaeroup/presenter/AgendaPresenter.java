package br.edu.unirriter.mobile.projaeroup.presenter;

import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.unirriter.mobile.projaeroup.adapters.AgendaAdapter;
import br.edu.unirriter.mobile.projaeroup.model.Agenda;
import br.edu.unirriter.mobile.projaeroup.ui.TelaAgenda;
import br.edu.unirriter.mobile.projaeroup.ui.TelaAgendaDetalhe;
import br.edu.unirriter.mobile.projaeroup.ui.rvInterface;

public class AgendaPresenter implements rvInterface {

    private List<Agenda> listaAgendamentos = new ArrayList<>();
    private TelaAgenda tela;

    int posAtual = 0;
    AgendaAdapter adapter = new AgendaAdapter(listaAgendamentos, this);

    public AgendaPresenter(TelaAgenda act) {
        this.tela = act;
    }

    public void buscaAgenda() {
        listaAgendamentos.clear();

        listaAgendamentos.add(new Agenda("14:00", "04/06/2022",
                "Teórico 1", "Instrutor: Carlos silva\nLocal: Aeroporto salgado filho\n"));

        tela.prepararRecyclerView(adapter);
    }

    public void adicionaAgenda(String hora, String data, String titulo, String localinst)
    {
        listaAgendamentos.add(new Agenda(hora, data, titulo, localinst));

        Toast.makeText(tela.getApplicationContext(), "Agendado com sucesso",
                Toast.LENGTH_SHORT).show();
    }

    public void alterarAgenda(Agenda agenda)
    {
        listaAgendamentos.set(posAtual,agenda);
        Toast.makeText(tela.getApplicationContext(), "Alteração realizada com sucesso",
                Toast.LENGTH_SHORT).show();

    }

    public void removerAgenda()
    {
        listaAgendamentos.remove(posAtual);
        Toast.makeText(tela.getApplicationContext(), "Cancelado com sucesso",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int pos) {
        posAtual = pos;

        Intent agendaDetalhe = new Intent(tela.getApplicationContext(), TelaAgendaDetalhe.class);
        agendaDetalhe.putExtra("hora", listaAgendamentos.get(pos).getHora());
        agendaDetalhe.putExtra("data",listaAgendamentos.get(pos).getData());
        agendaDetalhe.putExtra("titulo",listaAgendamentos.get(pos).getTitulo());
        agendaDetalhe.putExtra("localinst",listaAgendamentos.get(pos).getLocalinst());
        tela.startActivity(agendaDetalhe);
    }
}