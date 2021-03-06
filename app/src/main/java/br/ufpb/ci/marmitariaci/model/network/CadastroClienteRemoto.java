package br.ufpb.ci.marmitariaci.model.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.presenter.CadastroPresenter;

public class CadastroClienteRemoto extends ConexaoRemotaEnvioTemplate {

    private CadastroPresenter presenter;

    public CadastroClienteRemoto(CadastroPresenter presenter) {
        this.presenter = presenter;
    }

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
        return "http://192.168.43.135:8080/usuario";
    }

    @Override
    public String tipoConexao() {
        return "POST";
    }

    @Override
    protected void onPreExecute() {
        presenter.realizandoCadastro();
    }

    @Override
    protected void onPostExecute(String retorno) {
        presenter.resultadoCadastro(retorno);
    }
}
