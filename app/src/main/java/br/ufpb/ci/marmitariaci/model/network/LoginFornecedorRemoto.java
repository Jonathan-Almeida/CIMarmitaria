package br.ufpb.ci.marmitariaci.model.network;

public class LoginFornecedorRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return "http://192.168.43.135:8080/fornecedor?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }
}
