package br.ufpb.ci.marmitariaci.model.business;

import com.google.gson.Gson;

import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;
import br.ufpb.ci.marmitariaci.model.domain.Usuario;
import br.ufpb.ci.marmitariaci.model.network.ConectaServico;
import br.ufpb.ci.marmitariaci.presenter.CadastroPresenter;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;

public class ModelUsuarioClienteImpl implements ModelUsuario<Usuario> {

    private LoginPresenter loginPresenter;
    private CadastroPresenter cadastroPresenter;

    public ModelUsuarioClienteImpl(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    public ModelUsuarioClienteImpl(CadastroPresenter cadastroPresenter){
        this.cadastroPresenter = cadastroPresenter;
    }

    @Override
    public void adiciona(Usuario u) {
        ConectaServico servico = new ConectaServico(TipoDeConexao.porCadastroCliente, this);
        String json = new Gson().toJson(u);
        Integer retorno = servico.enviaDados(json);
        if(retorno == null){
            resultado("Erro ao conectar ao servidor", false);
        }else if(retorno == 409){
            resultado("Usuário já existe", false);
        }else if(retorno == 201){
            resultado("Cadastro realizado com sucesso", true);
        }
    }

    @Override
    public void autentica(Usuario u) {
    }

    @Override
    public void resultado(String mensagem, boolean encerra) {
        cadastroPresenter.resultadoCadastro(mensagem, encerra);
    }

    @Override
    public void erroLogin(String mensagem) {
        loginPresenter.loginFalhou(mensagem);
    }
}
