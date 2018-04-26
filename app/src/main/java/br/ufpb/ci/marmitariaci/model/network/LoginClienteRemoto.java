package br.ufpb.ci.marmitariaci.model.network;

public class LoginClienteRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return NetworkResources.ip + "usuario?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }
}