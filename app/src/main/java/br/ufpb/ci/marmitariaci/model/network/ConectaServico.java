package br.ufpb.ci.marmitariaci.model.network;

import java.util.concurrent.ExecutionException;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;
import br.ufpb.ci.marmitariaci.presenter.CadastroPresenter;
import br.ufpb.ci.marmitariaci.presenter.LoginPresenter;

public class ConectaServico {
    private ConexaoRemotaEnvioTemplate conexao;
    private ConexaoRemotaRecuperaTemplate con;

    public ConectaServico(TipoDeConexao modo, LoginPresenter loginPresenter, CadastroPresenter cadastroPresenter) {
        switch (modo){
            case porLoginCliente:
                con = new LoginClienteRemoto(loginPresenter);
                break;
            case porCadastroCliente:
                conexao = new CadastroClienteRemoto(cadastroPresenter);
                break;
            case porCadastroFornecedor:
                conexao = new CadastroFornecedorRemoto(cadastroPresenter);
                break;
            case porLoginFornecedor:
                con = new LoginFornecedorRemoto(loginPresenter);
                break;
            case porCadastroCardapio:
                conexao = new CadastraCardapioRemoto();
                break;
        }
    }

    public void enviaDados(String parametros){
        conexao.execute(parametros);
    }

    public void recuperaDados(String... parametros){
        con.execute(parametros);
    }
}
