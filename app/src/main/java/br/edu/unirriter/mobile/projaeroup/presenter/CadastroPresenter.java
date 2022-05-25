package br.edu.unirriter.mobile.projaeroup.presenter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.unirriter.mobile.projaeroup.ui.TelaHome;
import br.edu.unirriter.mobile.projaeroup.ui.TelaCadastro;

public class CadastroPresenter {
    private TelaCadastro tela;

    public CadastroPresenter(TelaCadastro act) {
        this.tela = act;
    }

    //Futuramente retirar nome e idade da praferencia compartilhada
    public void salvarPrefComp(String email, String senha, String nome, String idade)
    {
        //cria uma variavel de preferencia que fica salva no app ate que ela seja alterada
        SharedPreferences prefs = tela.getSharedPreferences("preferencia",MODE_PRIVATE);
        // chama o editor de preferencias
        SharedPreferences.Editor editor = prefs.edit();

        //cria o campo expecifico
        editor.putString("email", email);
        editor.putString("senha", senha);
        editor.putString("nome", nome);
        editor.putString("idade", idade);

        //aplica a edição
        editor.apply();
    }

    public void cadastrarUsuario(EditText NS, EditText Idade,EditText Email,EditText Senha) {
        String nomeString = NS.getText().toString();
        String idadeString = Idade.getText().toString();
        String emailString = Email.getText().toString();
        String senhaString = Senha.getText().toString();

        salvarPrefComp(emailString,senhaString,nomeString,idadeString);

        Toast.makeText(tela.getApplicationContext(), "Cadastro realizado com sucesso",
                Toast.LENGTH_SHORT).show();
        Intent temp = new Intent(tela.getApplicationContext(), TelaHome.class);
        tela.startActivity(temp);
    }
}
