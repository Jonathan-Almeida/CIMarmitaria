package br.ufpb.ci.marmitariaci.model.business;

import br.ufpb.ci.marmitariaci.model.domain.Usuario;

public interface ModelUsuario<T> {
    void adiciona(T u);
    void autentica(T t);
    void resultado(String mensagem, boolean encerra);
    void erroLogin(String mensagem);
}
