package br.ufpb.ci.marmitariaci.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.presenter.CadastroClientePresenterImpl;
import br.ufpb.ci.marmitariaci.presenter.CadastroPresenter;

public class CadastroClienteActivity extends AppCompatActivity implements CadastroView, View.OnClickListener {


    private CadastroPresenter presenter;
    private EditText nomeInput;
    private EditText senhaInput;
    private EditText telefoneInput;
    private EditText loginInput;
    private Button botaoCadastrar;
    private ProgressDialog dialogo_progresso;

    public CadastroClienteActivity(){
        presenter = new CadastroClientePresenterImpl(this);
    }

    private void iniciaComponentes(){
        nomeInput = findViewById(R.id.editTextNomeCadCliId);
        loginInput = findViewById(R.id.editTextLoginCadCliId);
        senhaInput = findViewById(R.id.editTextSenhaCadCliId);
        telefoneInput = findViewById(R.id.editTextTelCadCliId);
        botaoCadastrar = findViewById(R.id.cadButtonCadCliId);
        dialogo_progresso = new ProgressDialog(this);
        dialogo_progresso.setMessage("Realizando cadastro, aguarde...");
        dialogo_progresso.setCancelable(false);
        dialogo_progresso.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
        iniciaComponentes();
        botaoCadastrar.setOnClickListener(this);
    }

    @Override
    public void exibeMensagem(String mensagem, boolean encerra) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        if(encerra)
            finish();
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
    public void finish() {
        super.finish();
        presenter.onFinish();
    }

    @Override
    public void onClick(View view) {
        String nome = nomeInput.getText().toString();
        String login = loginInput.getText().toString();
        String senha = senhaInput.getText().toString();
        String telefone = telefoneInput.getText().toString();
        presenter.cadastraUsuario(nome, login, senha, telefone);
    }
}
