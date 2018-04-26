package br.ufpb.ci.marmitariaci.model.network;

import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;

public class LoginFornecedorRemoto extends ConexaoRemotaRecuperaTemplate {

    private LoginPresenter presenter;

    public LoginFornecedorRemoto(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String linkAcesso(String... parametro) {
        return NetworkResources.ip + "fornecedor?login=" + parametro[0]
                + "&senha=" + parametro[1];
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String retorno) {
        presenter.resultadoLogin(retorno);
    }
}
