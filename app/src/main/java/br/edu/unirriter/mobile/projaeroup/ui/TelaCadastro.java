package br.edu.unirriter.mobile.projaeroup.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputLayout;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.presenter.CadastroPresenter;

public class TelaCadastro extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        CadastroPresenter presenterCadastro = new CadastroPresenter(this);

        Button botao = findViewById(R.id.buttonCadastrar);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputLayout NS = findViewById(R.id.editTextNS);
                TextInputLayout Idade = findViewById(R.id.editTextIdade);
                TextInputLayout Email = findViewById(R.id.editTextEmail);
                TextInputLayout Senha = findViewById(R.id.editTextSenha);

                presenterCadastro.cadastrarUsuario(NS.getEditText(),
                        Idade.getEditText(),Email.getEditText(),Senha.getEditText());
            }
        });
    }
}