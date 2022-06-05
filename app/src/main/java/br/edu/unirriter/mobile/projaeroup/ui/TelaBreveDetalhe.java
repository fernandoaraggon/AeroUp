package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.presenter.AgendaPresenter;
import br.edu.unirriter.mobile.projaeroup.utils.Pickers;

public class TelaBreveDetalhe extends AppCompatActivity {

    Pickers pickers = new Pickers(this);
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_breve_detalhe);

        String titulo = getIntent().getStringExtra("titulo");

        TextView tvTitulo = findViewById(R.id.tvBreveTitulo);
        tvTitulo.setText(titulo);

        botao = findViewById(R.id.buttonAgendar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add Agendamento
                Intent telaAgenda = new Intent(getApplicationContext(), TelaAgenda.class);
                telaAgenda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                telaAgenda.putExtra("titulo", tvTitulo.getText().toString());
                botao = findViewById(R.id.datePickerButton);
                telaAgenda.putExtra("data", botao.getText());
                botao = findViewById(R.id.timeButton);
                telaAgenda.putExtra("hora", botao.getText());

                //gera Local e Instrutor
                telaAgenda.putExtra("localinst",list[random()]);

                telaAgenda.putExtra("tela","BreveD");
                getApplicationContext().startActivity(telaAgenda);
            }
        });
    }

    public int random(){
        int random = new Random().nextInt(list.length);
        return random;
    }

    String[] list= {"Instrutor: Carlos silva\nLocal: Aeroporto salgado filho\n",
            "Instrutor: Jorge antunes\nLocal: Aerodromo privado de aguas claras\n",
            "Instrutor: Rodrigo smerlit\nLocal: Aeroclube do Rio Grande do Sul",
            "Instrutor: Bruce wayne\nLocal: AeroClube São Leopoldo"};

    public void DatePicker(View view) {
        botao = findViewById(R.id.datePickerButton);
        pickers.popCalendario(botao);
    }

    public void popTimePicker(View view) {
        botao = findViewById(R.id.timeButton);
        pickers.popHorario(botao);
    }
}