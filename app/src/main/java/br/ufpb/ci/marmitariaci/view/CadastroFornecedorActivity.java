package br.ufpb.ci.marmitariaci.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.presenter.CadastroFornecedorPresenterImpl;
import br.ufpb.ci.marmitariaci.presenter.CadastroPresenter;

public class CadastroFornecedorActivity extends AppCompatActivity implements CadastroView, View.OnClickListener {


    private CadastroPresenter presenter;

    private EditText empresa;
    private EditText email;
    private EditText senha;
    private EditText endereco;
    private EditText telefone;
    private Button botao;
    private ProgressDialog dialogo_progresso;

    private void iniciaComponentes(){
        empresa = findViewById(R.id.cadInputEmpresaFornId);
        email = findViewById(R.id.cadInputEmailFornId);
        senha = findViewById(R.id.cadInputSenhaFornId);
        endereco = findViewById(R.id.cadInputEndFornId);
        telefone = findViewById(R.id.cadInputTelFornId);
        botao = findViewById(R.id.button2);
        dialogo_progresso = new ProgressDialog(this);
        dialogo_progresso.setMessage("Realizando login, aguarde...");
        dialogo_progresso.setCancelable(false);
        dialogo_progresso.setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fornecedor);
        iniciaComponentes();
        botao.setOnClickListener(this);
        presenter = new CadastroFornecedorPresenterImpl(this);
    }

    @Override
    public void exibeMensagem(String mensagem, boolean encerra) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
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
        String emp = empresa.getText().toString();
        String em = email.getText().toString();
        String sen = senha.getText().toString();
        String end = endereco.getText().toString();
        String tel = telefone.getText().toString();
        presenter.cadastraUsuario(emp, em, sen, end, tel);
    }
}
