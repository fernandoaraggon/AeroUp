package br.edu.unirriter.mobile.projaeroup.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenciaComp {

    private SharedPreferences pref;

    //Puxar do banco(nuvem) e validar
    public PreferenciaComp(Context tela) {
        pref = tela.getSharedPreferences("PrefComp", Context.MODE_PRIVATE);
    }

    public void add(String var, String valor) {
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(var,valor);
        edit.apply();
    }

    public String pegarPref(String var) {
        return pref.getString(var,null);
    }

    public void limpar() {
        pref.edit().clear().apply();
    }
}
