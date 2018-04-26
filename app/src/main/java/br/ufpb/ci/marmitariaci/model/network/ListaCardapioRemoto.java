package br.ufpb.ci.marmitariaci.model.network;

import br.ufpb.ci.marmitariaci.R;

import static android.support.v4.content.res.TypedArrayUtils.getString;


public class ListaCardapioRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return  NetworkResources.ip + "cardapio?login=" + parametro[0]
                + "&senha=" + parametro[1] + "&id_fornecedor=" + parametro[2];
    }
}
