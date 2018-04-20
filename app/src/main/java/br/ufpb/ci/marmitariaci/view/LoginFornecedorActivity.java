package br.ufpb.ci.marmitariaci.view;

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
    private Button bt_login;
    private LoginPresenter presenter;

    private void iniciaComponentes(){
        txt_cadastro = findViewById(R.id.cadFornId);
        bt_login = findViewById(R.id.entrarButtonFornId);
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
