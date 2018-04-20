package br.ufpb.ci.marmitariaci.view;

public interface LoginView {
    void exibeProgresso();
    void ocultaProgresso();
    void exibeMensagem(String mensagem);
    void iniciaActivity(Class<?> cls, boolean encerra);
}
