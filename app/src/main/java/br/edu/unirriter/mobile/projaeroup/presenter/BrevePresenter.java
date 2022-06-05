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

    private List<Breve> listaBrevesTemp = new ArrayList<>();

    public BrevePresenter(TelaHome act) {
        this.tela = act;
    }

    public void buscaBreve(String item)
    {
        listaBreves.clear();
        listaBrevesTemp.clear();

        BreveAdapter adapter = new BreveAdapter(listaBreves,this);
        tela.prepararRecyclerView(adapter);

        listaBrevesTemp.add(new Breve("Teórico 1","Pendente"));
        listaBrevesTemp.add(new Breve("Pratico 1","Pendente"));
        listaBrevesTemp.add(new Breve("Pratico 2","Pendente"));
        listaBrevesTemp.add(new Breve("Teórico 2","Concluido"));
        listaBrevesTemp.add(new Breve("Voo Comercial","Dísponivel"));
        listaBrevesTemp.add(new Breve("Voo Comercial 2","Dísponivel"));
        listaBrevesTemp.add(new Breve("Voo Comercial 3","Dísponivel"));
        listaBrevesTemp.add(new Breve("Voo Comercial 4","Dísponivel"));
        listaBrevesTemp.add(new Breve("Voo de Carga 1","Indisponivel"));
        listaBrevesTemp.add(new Breve("Voo de Carga 2","Indisponivel"));
        listaBrevesTemp.add(new Breve("Voo de Carga 3","Indisponivel"));
        listaBrevesTemp.add(new Breve("Voo de Carga 4","Indisponivel"));

        try {
            for (int i = 0; i <= listaBrevesTemp.size()-1; i++) {
                if(listaBrevesTemp.get(i).getEstado() == item)
                {
                    listaBreves.add(listaBrevesTemp.get(i));
                }else if(item == "Todos")
                {
                    listaBreves.add(listaBrevesTemp.get(i));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(int pos) {
        Intent breveDetalhe = new Intent(tela.getApplicationContext(), TelaBreveDetalhe.class);
        breveDetalhe.putExtra("titulo", listaBreves.get(pos).getTitulo());
        tela.startActivity(breveDetalhe);
    }
}
