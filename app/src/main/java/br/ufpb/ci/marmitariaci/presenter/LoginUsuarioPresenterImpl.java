package br.ufpb.ci.marmitariaci.presenter;

import android.content.Context;
import android.view.View;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.view.CadastroClienteActivity;
import br.ufpb.ci.marmitariaci.view.LoginView;
import br.ufpb.ci.marmitariaci.view.PainelUsuarioActivity;

public class LoginUsuarioPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginUsuarioPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validaDados(String usuario, String senha) {

    }

    @Override
    public Context getContext(){
        return (Context) loginView;
    }

    @Override
    public void loginSucesso() {
        loginView.exibeMensagem(getContext().getString(R.string.login_correto_name));
        loginView.iniciaActivity(PainelUsuarioActivity.class, true);
    }

    @Override
    public void loginFalhou() {
        loginView.exibeMensagem(getContext().getString(R.string.login_incorreto_name));
    }

    @Override
    public void eventoBotao(int id) {
        switch (id){
            case R.id.entrarButtonCliId:
                //Implementar o login
                break;
            case R.id.cadCliId:
                loginView.iniciaActivity(CadastroClienteActivity.class, false);
                break;
        }
    }

    @Override
    public void onFinish() {
        loginView = null;
    }
}
