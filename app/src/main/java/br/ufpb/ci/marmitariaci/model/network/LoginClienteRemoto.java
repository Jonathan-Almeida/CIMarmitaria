package br.ufpb.ci.marmitariaci.model.network;

public class LoginClienteRemoto extends ConexaoRemotaRecuperaTemplate {
    @Override
    public String linkAcesso(String... parametro) {
        return "http://192.168.43.135:8080/usuario?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }
}