package br.ufpb.ci.marmitariaci.presenter;

import android.content.Context;
import android.view.View;

public interface LoginPresenter {
    void validaDados(String usuario, String senha);
    Context getContext();
    void loginSucesso();
    void loginFalhou(String mensagem);
    void eventoBotao(int id);
    void onFinish();
}
