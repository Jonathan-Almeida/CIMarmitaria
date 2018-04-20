package br.ufpb.ci.marmitariaci.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.ufpb.ci.marmitariaci.R;

public class PainelFornecedorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText texto_itens;
    private EditText preco;
    private Button cadastrar;

    public void iniciaComponentes(){
        texto_itens = findViewById(R.id.txt_itens_id);
        preco = findViewById(R.id.editText2);
        cadastrar = findViewById(R.id.btn_enviar_card_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painel_fornecedor);
        iniciaComponentes();
        cadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_enviar_card_id){
            String itens = texto_itens.getText().toString();
            String preco_marmita = preco.getText().toString();
        }
    }
}
