package br.edu.unirriter.mobile.projaeroup.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Pickers {

    int hora, minuto;
    Context tela;

    public Pickers(Context tela) {
         this.tela = tela;
    }

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    public void popCalendario(Button botao)
    {
        final Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(tela, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                Calendar dataSelecionada = Calendar.getInstance();
                dataSelecionada.set(ano,mes,dia);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                botao.setText(format.format(dataSelecionada.getTime()));
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    //Temporario Horario
    public void popHorario(Button botao) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horaSelecionada, int minutosSelecionado) {
                hora = horaSelecionada;
                minuto = minutosSelecionado;
                botao.setText(String.format(Locale.getDefault(),"%02d:%02d",hora,minuto, true));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(tela,onTimeSetListener,hora,minuto,true);
        timePickerDialog.setTitle("Selecione a hora");
        timePickerDialog.show();
    }
}
