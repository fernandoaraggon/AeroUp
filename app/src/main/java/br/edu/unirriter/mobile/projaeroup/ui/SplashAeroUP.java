package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.presenter.SplashPresenter;
import br.edu.unirriter.mobile.projaeroup.utils.PreferenciaComp;

public class SplashAeroUP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_splash_aeroup);
        SplashPresenter splashPresenter = new SplashPresenter(this);

        PreferenciaComp prefComp = new PreferenciaComp(this);
        String login = prefComp.pegarPref("login");
        String senha = prefComp.pegarPref("senha");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(login != null && senha != null)
                {
                    splashPresenter.telaHome();
                }else
                {
                    splashPresenter.telaLogin();
                }
            }
        }, 2000);
    }
}