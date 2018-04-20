package br.ufpb.ci.marmitariaci.model.network;

public class ListaCardapioRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return "http://192.168.43.135:8080/cardapio?login=" + parametro[0]
                + "&senha=" + parametro[1] + "&id_fornecedor=" + parametro[2];
    }
}
