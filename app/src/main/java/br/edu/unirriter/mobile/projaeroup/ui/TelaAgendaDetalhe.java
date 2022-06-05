package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.utils.Pickers;

public class TelaAgendaDetalhe extends AppCompatActivity {
    Pickers pickers = new Pickers(this);
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_agenda_detalhe);

        String hora = getIntent().getStringExtra("hora");
        String data = getIntent().getStringExtra("data");
        String titulo = getIntent().getStringExtra("titulo");
        String localinst = getIntent().getStringExtra("localinst");

        Button button = findViewById(R.id.timeButtonAgenda);
        button.setText(hora);

        button = findViewById(R.id.datePickerButtonAgenda);
        button.setText(data);

        TextView tvT = findViewById(R.id.tvTituloAgenda);
        tvT.setText(titulo);

        TextView tv  = findViewById(R.id.tvLocalinstAgenda);
        tv.setText(localinst);

        botao = findViewById(R.id.buttonAlterar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaAgenda = new Intent(getApplicationContext(), TelaAgenda.class);
                telaAgenda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                botao = findViewById(R.id.datePickerButtonAgenda);
                telaAgenda.putExtra("data", botao.getText());
                botao = findViewById(R.id.timeButtonAgenda);
                telaAgenda.putExtra("hora", botao.getText());
                telaAgenda.putExtra("titulo", tvT.getText().toString());
                telaAgenda.putExtra("localinst", tv.getText().toString());
                telaAgenda.putExtra("tela","AgendaDAltera");
                getApplicationContext().startActivity(telaAgenda);
            }
        });

        botao = findViewById(R.id.buttonCancelar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaAgenda = new Intent(getApplicationContext(), TelaAgenda.class);
                telaAgenda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                telaAgenda.putExtra("tela","AgendaDCancela");
                getApplicationContext().startActivity(telaAgenda);
            }
        });
    }

    public void DatePickerAgenda(View view) {
        botao = findViewById(R.id.datePickerButtonAgenda);
        pickers.popCalendario(botao);
    }

    public void popTimePickerAgenda(View view) {
        botao = findViewById(R.id.timeButtonAgenda);
        pickers.popHorario(botao);
    }
}