package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.presenter.LoginPresenter;
import br.edu.unirriter.mobile.projaeroup.utils.PreferenciaComp;

public class TelaLogin extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        LoginPresenter presenterLogin = new LoginPresenter(this);

        TextView tvLogin = findViewById(R.id.tvLogin);
        TextView tvSenha = findViewById(R.id.tvSenha);

        //dar uma olhada
        String login = tvLogin.getText().toString();

        PreferenciaComp prefComp = new PreferenciaComp(this);

        Button botao = findViewById(R.id.buttonCadastra);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cadastro = new Intent(getApplicationContext(), TelaCadastro.class);
                startActivity(cadastro);
            }
        });

        botao = findViewById(R.id.buttonLogin);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterLogin.telaHome();

                //adicionar quando clica
                prefComp.add("login",tvLogin.getText().toString());
                prefComp.add("senha",tvSenha.getText().toString());

            }
        });
    }
}