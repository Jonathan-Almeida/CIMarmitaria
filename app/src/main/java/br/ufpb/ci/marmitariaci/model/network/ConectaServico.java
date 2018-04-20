package br.ufpb.ci.marmitariaci.model.network;

import java.util.concurrent.ExecutionException;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;

public class ConectaServico {
    private ConexaoRemotaEnvioTemplate conexao;
    private ConexaoRemotaRecuperaTemplate con;

    public ConectaServico(TipoDeConexao modo) {
        switch (modo){
            case porLoginCliente:
                con = new LoginClienteRemoto();
                break;
            case porCadastroCliente:
                conexao = new CadastroClienteRemoto();
                break;
            case porCadastroFornecedor:
                conexao = new CadastroFornecedorRemoto();
                break;
            case porLoginFornecedor:
                con = new LoginFornecedorRemoto();
                break;
        }
    }

    public Integer enviaDados(String parametros){
        try {
            return conexao.execute(parametros).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer recuperaDados(String... parametros){
        try {
            return con.execute(parametros).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
