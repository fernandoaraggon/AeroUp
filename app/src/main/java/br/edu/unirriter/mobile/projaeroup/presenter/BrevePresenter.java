package br.edu.unirriter.mobile.projaeroup.presenter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.edu.unirriter.mobile.projaeroup.adapters.BreveAdapter;
import br.edu.unirriter.mobile.projaeroup.model.Breve;
import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.TelaBreveDetalhe;
import br.edu.unirriter.mobile.projaeroup.ui.rvInterface;

public class BrevePresenter implements rvInterface {

    private List<Breve> listaBreves = new ArrayList<>();
    private TelaHome tela;

    //Temporario
    private List<Breve> listaBrevesFake = new ArrayList<>();


    public BrevePresenter(TelaHome act) {
        this.tela = act;
    }

    public void buscaBreve(String item)
    {
        listaBreves.clear();
        listaBrevesFake.clear();

        BreveAdapter adapter = new BreveAdapter(listaBreves,this);
        tela.prepararRecyclerView(adapter);

        listaBrevesFake.add(new Breve("Teórico 1","Pendente"));
        listaBrevesFake.add(new Breve("Pratico 1","Pendente"));
        listaBrevesFake.add(new Breve("Pratico 2","Pendente"));
        listaBrevesFake.add(new Breve("Teórico 2","Concluido"));
        listaBrevesFake.add(new Breve("Voo Comercial","Dísponivel"));
        listaBrevesFake.add(new Breve("Voo Comercial 2","Dísponivel"));
        listaBrevesFake.add(new Breve("Voo Comercial 3","Dísponivel"));
        listaBrevesFake.add(new Breve("Voo Comercial 4","Dísponivel"));
        listaBrevesFake.add(new Breve("Voo de Carga 1","Indisponivel"));
        listaBrevesFake.add(new Breve("Voo de Carga 2","Indisponivel"));
        listaBrevesFake.add(new Breve("Voo de Carga 3","Indisponivel"));
        listaBrevesFake.add(new Breve("Voo de Carga 4","Indisponivel"));

        //Mudar com Nuvem
        //Temporário
        try {
            for (int i = 0; i <= listaBrevesFake.size()-1; i++) {
                if(listaBrevesFake.get(i).getEstado() == item)
                {
                    listaBreves.add(listaBrevesFake.get(i));
                }else if(item == "Todos")
                {
                    listaBreves.add(listaBrevesFake.get(i));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(int pos) {
        //Mudar para Parceble
        Intent breveDetalhe = new Intent(tela.getApplicationContext(), TelaBreveDetalhe.class);
        breveDetalhe.putExtra("titulo", listaBreves.get(pos).getTitulo());
        tela.startActivity(breveDetalhe);
    }
}
