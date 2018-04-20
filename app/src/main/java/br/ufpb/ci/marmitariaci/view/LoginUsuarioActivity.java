package br.ufpb.ci.marmitariaci.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;
import br.ufpb.ci.marmitariaci.presenter.LoginUsuarioPresenterImpl;

public class LoginUsuarioActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextView texto_cadastro;
    private Button botao_login;
    private LoginPresenter presenter;

    private void iniciaComponentes(){
        texto_cadastro = findViewById(R.id.cadCliId);
        botao_login = findViewById(R.id.entrarButtonCliId);
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

    }

    @Override
    public void ocultaProgresso() {

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
        presenter.eventoBotao(view.getId());
    }
}
