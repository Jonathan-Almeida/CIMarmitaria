package br.ufpb.ci.marmitariaci.model.business;

import com.google.gson.Gson;

import java.util.List;

import br.ufpb.ci.marmitariaci.model.domain.Cardapio;
import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;
import br.ufpb.ci.marmitariaci.model.network.ConectaServico;
import br.ufpb.ci.marmitariaci.presenter.PainelPresenter;

public class ModelPainelImpl implements ModelPainel {

    /*private PainelPresenter presenter;

    public ModelPainelImpl(PainelPresenter presenter) {
        this.presenter = presenter;
    }*/

    @Override
    public void adicionaCardapio(Cardapio cardapio) {
    /*    ConectaServico servico = new ConectaServico(TipoDeConexao.porCadastroCardapio);
        String json = new Gson().toJson(cardapio);
        Integer retorno = servico.enviaDados(json);
        if(retorno == null){
            resultado("Erro ao conectar ao servidor", false);
        }else if(retorno == 409){
            resultado("Usuário já existe", false);
        }else if(retorno == 201){
            resultado("Cadastro realizado com sucesso", true);
        }*/
    }

    @Override
    public List listaFornecedores() {
        return null;
    }

    @Override
    public List listaCardapioDoFornecedor(int fornecedor_id) {
        return null;
    }

    @Override
    public void resultado(String mensagem, boolean encerra) {

    }
}
