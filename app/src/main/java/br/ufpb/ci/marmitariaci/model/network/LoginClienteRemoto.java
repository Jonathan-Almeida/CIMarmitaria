package br.ufpb.ci.marmitariaci.model.network;

import android.util.Log;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;

public class LoginClienteRemoto extends ConexaoRemotaRecuperaTemplate {

    private LoginPresenter presenter;

    public LoginClienteRemoto(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String linkAcesso(String... parametro) {
        return NetworkResources.ip + "usuario?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }

    @Override
    protected void onPreExecute() {
        presenter.realizandoLogin();
    }

    @Override
    protected void onPostExecute(String retorno) {
        presenter.resultadoLogin(retorno);
    }
}