package br.ufpb.ci.marmitariaci.presenter;

import br.ufpb.ci.marmitariaci.model.domain.Cardapio;

public interface PainelPresenter {
    void adicionaCardapio(String itens, String preco);
    void listaCardapio();
    void resultado(String mensagem);
    void onFinish();
}
