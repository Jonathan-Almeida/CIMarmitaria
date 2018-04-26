package br.ufpb.ci.marmitariaci.model.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CadastroClienteRemoto extends ConexaoRemotaEnvioTemplate {

    @Override
    public String formataParametros(String parametro) {
        String dado;
        try {
            dado = URLEncoder.encode("json", "UTF-8")
                    + "=" + URLEncoder.encode(parametro, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return dado;
    }

    @Override
    public String linkAcesso() {
        return NetworkResources.ip + "usuario";
    }

    @Override
    public String tipoConexao() {
        return "POST";
    }
}
