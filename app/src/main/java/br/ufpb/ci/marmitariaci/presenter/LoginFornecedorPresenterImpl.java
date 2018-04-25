package br.ufpb.ci.marmitariaci.presenter;

import android.content.Context;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuarioFornecedorImpl;
import br.ufpb.ci.marmitariaci.model.domain.Fornecedor;
import br.ufpb.ci.marmitariaci.util.HttpCodeResponse;
import br.ufpb.ci.marmitariaci.view.CadastroFornecedorActivity;
import br.ufpb.ci.marmitariaci.view.LoginView;
import br.ufpb.ci.marmitariaci.view.PainelFornecedorActivity;

public class LoginFornecedorPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private ModelUsuario model;

    public LoginFornecedorPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.model = new ModelUsuarioFornecedorImpl(this);
    }

    @Override
    public void validaDados(String usuario, String senha) {
        Fornecedor f = new Fornecedor();
        f.setEmail(usuario);
        f.setSenha(senha);
        model.autentica(f);
    }

    @Override
    public Context getContext() {
        return (Context) loginView;
    }

    @Override
    public void realizandoLogin() {
        loginView.exibeProgresso();
    }

    @Override
    public void resultadoLogin(String resultado) {
        int retorno = HttpCodeResponse.getHttp_response_code();
        if (retorno == 404){
            loginFalhou("Erro ao conectar ao servidor");
        }else if(retorno == 401){
            loginFalhou("Usuário ou senha incorretos");
        }else if(retorno == 200){
            loginSucesso();
        } else {
            loginFalhou("Erro ao conectar ao servidor");
        }
    }

    @Override
    public void loginSucesso() {
        loginView.ocultaProgresso();
        loginView.exibeMensagem(getContext().getString(R.string.login_correto_name));
        loginView.iniciaActivity(PainelFornecedorActivity.class, true);
    }

    @Override
    public void loginFalhou(String mensagem) {
        loginView.ocultaProgresso();
        loginView.exibeMensagem(mensagem);
    }

    @Override
    public void eventoBotao(int id) {
        switch (id){
            case R.id.cadFornId:
                loginView.iniciaActivity(CadastroFornecedorActivity.class, false);
                break;
        }
    }

    @Override
    public void onFinish() {

    }
}
