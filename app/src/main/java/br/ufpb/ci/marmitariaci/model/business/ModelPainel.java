package br.ufpb.ci.marmitariaci.model.business;

import java.util.List;

import br.ufpb.ci.marmitariaci.model.domain.Cardapio;

public interface ModelPainel {
    void adicionaCardapio(Cardapio cardapio);
    List listaFornecedores();
    List listaCardapioDoFornecedor(int fornecedor_id);
    void resultado(String mensagem, boolean encerra);
}
