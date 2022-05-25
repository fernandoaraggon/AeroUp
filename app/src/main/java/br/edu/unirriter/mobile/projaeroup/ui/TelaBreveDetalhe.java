package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.edu.unirriter.mobile.projaeroup.R;

public class TelaBreveDetalhe extends AppCompatActivity {



    //Valores temporarios

    int hora, minuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_breve_detalhe);

        String titulo = getIntent().getStringExtra("titulo");
        TextView tvTitulo = findViewById(R.id.tvTitulo);
        tvTitulo.setText(titulo);

        TextView tvTemp = findViewById(R.id.tvTempHora);

        Button botao = findViewById(R.id.buttonAgendar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popCalendario(tvTitulo);
                popHorario(tvTemp);
            }
        });
    }

    //Temporario Calendario
    public void popCalendario(TextView tvTitulo)
    {
        final Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                Calendar dataSelecionada = Calendar.getInstance();
                dataSelecionada.set(ano,mes,dia);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                //Teste
                tvTitulo.setText(format.format(dataSelecionada.getTime()));
                }
            },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    //Temporario Horario
    public void popHorario(TextView tvTemp) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSelecionada, int minutosSelecionado) {
                hora = horaSelecionada;
                minuto = minutosSelecionado;
                tvTemp.setText(String.format(Locale.getDefault(),"%02d:%02d",hora,minuto, true));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,onTimeSetListener,hora,minuto,true);
        timePickerDialog.setTitle("Selecione a hora");
        timePickerDialog.show();
    }
}