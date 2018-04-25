package br.ufpb.ci.marmitariaci.presenter;

public interface CadastroPresenter {
    void cadastraUsuario(String... strings);
    void realizandoCadastro();
    void resultadoCadastro(String resultado);
    void onFinish();
}
