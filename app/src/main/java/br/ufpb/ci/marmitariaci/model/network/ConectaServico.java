package br.ufpb.ci.marmitariaci.model.network;

import java.util.concurrent.ExecutionException;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;

public class ConectaServico {
    private ConexaoRemotaEnvioTemplate conexao;

    public ConectaServico(TipoDeConexao modo, ModelUsuario model) {
        switch (modo){
            case porLoginCliente:
                //conexao = new LoginRemoto();
                break;
            case porCadastroCliente:
                conexao = new CadastroClienteRemoto();
                break;
            case porCadastroFornecedor:
                conexao = new CadastroFornecedorRemoto();
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
}
