package br.ufpb.ci.marmitariaci.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.presenter.LoginFornecedorPresenterImpl;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;
import br.ufpb.ci.marmitariaci.presenter.LoginUsuarioPresenterImpl;

public class LoginFornecedorActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextView txt_cadastro;
    private TextView campoLogin;
    private TextView campoSenha;
    private Button bt_login;
    private LoginPresenter presenter;
    private ProgressDialog dialogo_progresso;

    private void iniciaComponentes(){
        txt_cadastro = findViewById(R.id.cadFornId);
        bt_login = findViewById(R.id.entrarButtonFornId);
        campoLogin = findViewById(R.id.emailInputId);
        campoSenha = findViewById(R.id.senhaInputFornId);
        dialogo_progresso = new ProgressDialog(this);
        dialogo_progresso.setMessage("Realizando login, aguarde...");
        dialogo_progresso.setCancelable(false);
        dialogo_progresso.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_fornecedor);
        iniciaComponentes();
        txt_cadastro.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        presenter = new LoginFornecedorPresenterImpl(this);
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
            case R.id.entrarButtonFornId:
                String login = campoLogin.getText().toString();
                String senha = campoSenha.getText().toString();
                presenter.validaDados(login, senha);
                break;
        }
        presenter.eventoBotao(view.getId());
    }
}
