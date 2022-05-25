package br.edu.unirriter.mobile.projaeroup.presenter;

import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.TelaLogin;

public class LoginPresenter {

        private TelaLogin tela;
        public LoginPresenter(TelaLogin act) {
            this.tela = act;
        }

        public void telaHome() {
            Intent telaHome = new Intent(tela.getApplicationContext(), TelaHome.class);
            tela.startActivity(telaHome);
        }
}
