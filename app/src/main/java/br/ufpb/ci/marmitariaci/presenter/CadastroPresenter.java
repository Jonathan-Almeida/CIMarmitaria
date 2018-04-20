package br.ufpb.ci.marmitariaci.presenter;

public interface CadastroPresenter {
    void cadastraUsuario(String... strings);
    void resultadoCadastro(String msg, boolean encerra);
    void onFinish();
}
