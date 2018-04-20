package br.ufpb.ci.marmitariaci.model.network;

import br.ufpb.ci.marmitariaci.model.domain.TipoDeConexao;

public class ConectaServico {
    private ConexaoRemotaTemplate conexao;

    public ConectaServico(TipoDeConexao modo) {
        switch (modo){
            /*case porLogin:
                conexao = new LoginRemoto();
                break;*/
            case porCadastro:
                conexao = new CadastroRemoto();
                break;
        }
    }

    public void enviaDados(String parametros){
        conexao.execute(parametros);
    }
}
