package br.ufpb.ci.marmitariaci.presenter;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuarioClienteImpl;
import br.ufpb.ci.marmitariaci.model.domain.Usuario;
import br.ufpb.ci.marmitariaci.util.HttpCodeResponse;
import br.ufpb.ci.marmitariaci.view.CadastroView;

public class CadastroClientePresenterImpl implements CadastroPresenter {

    private CadastroView cadastroView;
    private ModelUsuario model;

    public CadastroClientePresenterImpl(CadastroView cadastroView){
        this.cadastroView = cadastroView;
        model = new ModelUsuarioClienteImpl(this);
    }


    @Override
    public void cadastraUsuario(String... strings) {
        Usuario u = new Usuario();
        u.setNome(strings[0]);
        u.setUsuario(strings[1]);
        u.setSenha(strings[2]);
        u.setTelefone(strings[3]);
        model.adiciona(u);
    }

    @Override
    public void realizandoCadastro() {
        cadastroView.exibeProgresso();
    }

    @Override
    public void resultadoCadastro(String retorno) {
        cadastroView.ocultaProgresso();
        int status = HttpCodeResponse.getHttp_response_code();
        if(status == 404){
            cadastroView.exibeMensagem("Erro ao conectar ao servidor!", false);
        } else if (status == 400){
            cadastroView.exibeMensagem("O usuário já existe", false);
        } else if(status == 201) {
            cadastroView.exibeMensagem("Cadastro realizado com sucesso!", true);
        } else {
            cadastroView.exibeMensagem("Erro ao conectar ao servidor!", false);
        }
    }

    @Override
    public void onFinish() {
        cadastroView = null;
    }
}
