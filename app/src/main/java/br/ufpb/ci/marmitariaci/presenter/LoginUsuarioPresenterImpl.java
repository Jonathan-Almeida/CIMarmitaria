package br.ufpb.ci.marmitariaci.presenter;

import android.content.Context;
import android.view.View;

import br.ufpb.ci.marmitariaci.R;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuarioClienteImpl;
import br.ufpb.ci.marmitariaci.model.domain.Usuario;
import br.ufpb.ci.marmitariaci.view.CadastroClienteActivity;
import br.ufpb.ci.marmitariaci.view.LoginView;
import br.ufpb.ci.marmitariaci.view.PainelUsuarioActivity;

public class LoginUsuarioPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private ModelUsuario model;

    public LoginUsuarioPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.model = new ModelUsuarioClienteImpl(this);
    }

    @Override
    public void validaDados(String usuario, String senha) {
        Usuario u = new Usuario();
        u.setUsuario(usuario);
        u.setSenha(senha);
        model.autentica(u);
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
    public void loginFalhou(String mensagem) {
        loginView.exibeMensagem(mensagem);
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
