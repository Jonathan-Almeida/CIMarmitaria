package br.ufpb.ci.marmitariaci.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.ufpb.ci.marmitariaci.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button botao_cliente;
    private Button botao_fornecedor;

    private void iniciaComponentes(){
        botao_cliente = findViewById(R.id.clientButtonId);
        botao_fornecedor = findViewById(R.id.fornButtonId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaComponentes();
        botao_cliente.setOnClickListener(this);
        botao_fornecedor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.clientButtonId:
                startActivity(new Intent(this, LoginUsuarioActivity.class));
                break;
            case R.id.fornButtonId:
                startActivity(new Intent(this, LoginFornecedorActivity.class));
                break;
        }
    }
}
