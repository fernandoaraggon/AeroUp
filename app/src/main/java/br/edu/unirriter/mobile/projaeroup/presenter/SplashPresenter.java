package br.edu.unirriter.mobile.projaeroup.presenter;

import android.content.Intent;

import br.edu.unirriter.mobile.projaeroup.ui.SplashAeroUP;
import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.TelaLogin;
import br.edu.unirriter.mobile.projaeroup.utils.PreferenciaComp;

public class SplashPresenter {
    private SplashAeroUP tela;
    private String login,senha;
    public SplashPresenter(SplashAeroUP act) {this.tela = act;}

    public void telaLogin() {
        Intent telaLogin = new Intent(tela.getApplicationContext(), TelaLogin.class);
        tela.startActivity(telaLogin);
    }

    public void telaHome() {
        Intent telaHome = new Intent(tela.getApplicationContext(), TelaHome.class);
        tela.startActivity(telaHome);
    }
}
