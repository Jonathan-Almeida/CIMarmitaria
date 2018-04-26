package br.ufpb.ci.marmitariaci.model.network;

public class LoginFornecedorRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return NetworkResources.ip + "fornecedor?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }
}
