package br.ufpb.ci.marmitariaci.presenter;

import android.content.Context;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.view.CadastroClienteActivity;
import br.ufpb.ci.marmitariaci.view.CadastroFornecedorActivity;
import br.ufpb.ci.marmitariaci.view.LoginView;

public class LoginFornecedorPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginFornecedorPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validaDados(String usuario, String senha) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void loginSucesso() {

    }

    @Override
    public void loginFalhou() {

    }

    @Override
    public void eventoBotao(int id) {
        switch (id){
            case R.id.entrarButtonFornId:
                //Implementar o login
                break;
            case R.id.cadFornId:
                loginView.iniciaActivity(CadastroFornecedorActivity.class, false);
                break;
        }
    }

    @Override
    public void onFinish() {

    }
}
