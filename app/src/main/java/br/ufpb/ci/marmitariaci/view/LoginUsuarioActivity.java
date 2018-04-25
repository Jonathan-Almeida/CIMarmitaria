package br.ufpb.ci.marmitariaci.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;
import br.ufpb.ci.marmitariaci.presenter.LoginUsuarioPresenterImpl;

public class LoginUsuarioActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextView texto_cadastro;
    private Button botao_login;
    private LoginPresenter presenter;
    private EditText campo_login;
    private EditText campo_senha;
    private ProgressDialog dialogo_progresso;

    private void iniciaComponentes(){
        texto_cadastro = findViewById(R.id.cadCliId);
        botao_login = findViewById(R.id.entrarButtonCliId);
        campo_login = findViewById(R.id.loginInputId);
        campo_senha = findViewById(R.id.senhaInputCliId);
        dialogo_progresso = new ProgressDialog(this);
        dialogo_progresso.setMessage("Realizando login, aguarde...");
        dialogo_progresso.setCancelable(false);
        dialogo_progresso.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);
        iniciaComponentes();
        texto_cadastro.setOnClickListener(this);
        botao_login.setOnClickListener(this);
        presenter = new LoginUsuarioPresenterImpl(this);
    }

    @Override
    public void exibeProgresso() {
        dialogo_progresso.show();
    }

    @Override
    public void ocultaProgresso() {
        dialogo_progresso.dismiss();
    }

    @Override
    public void exibeMensagem(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    @Override
    public void iniciaActivity(Class<?> cls, boolean encerra) {
        startActivity(new Intent(this, cls));
        if(encerra)
            finish();
    }

    @Override
    public void finish() {
        super.finish();
        presenter.onFinish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.entrarButtonCliId:
                String login = campo_login.getText().toString();
                String senha = campo_senha.getText().toString();
                presenter.validaDados(login, senha);
                break;
            default:
                presenter.eventoBotao(view.getId());
                break;
        }
    }
}
