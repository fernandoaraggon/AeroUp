package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.databinding.ActivityTelaHomeBinding;
import br.edu.unirriter.mobile.projaeroup.presenter.BrevePresenter;
import br.edu.unirriter.mobile.projaeroup.ui.drawer.TelaBaseDrawer;

public class TelaHome extends TelaBaseDrawer {

    ActivityTelaHomeBinding activityTelaHomeBinding;
    BrevePresenter presenterBreve = new BrevePresenter(this);

    //Lista Items
    String[] items = {"Todos", "Pendente", "Concluido", "Dísponivel", "Indisponivel"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTelaHomeBinding = activityTelaHomeBinding.inflate(getLayoutInflater());
        setContentView(activityTelaHomeBinding.getRoot());
        allocateAcitivityTitle("Home");

        //Lista items
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter(this,R.layout.dropdown_items,items);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                presenterBreve.buscaBreve(item);
            }
        });
    }

    public void prepararRecyclerView(RecyclerView.Adapter adapter)
    {
        RecyclerView rv = findViewById(R.id.rvBreve);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }
}


