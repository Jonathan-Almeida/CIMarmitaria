package br.ufpb.ci.marmitariaci.presenter;

import br.ufpb.ci.marmitariaci.model.domain.Usuario;
import br.ufpb.ci.marmitariaci.view.CadastroView;

public class CadastroClientePresenterImpl implements CadastroPresenter {

    private CadastroView cadastroView;

    public CadastroClientePresenterImpl(CadastroView cadastroView){
        this.cadastroView = cadastroView;
    }


    @Override
    public void cadastraUsuario(String... strings) {
        Usuario u = new Usuario();
        u.setNome(strings[0]);
        u.setUsuario(strings[1]);
        u.setSenha(strings[2]);
        u.setTelefone(strings[3]);
        //Enviar para o model
    }

    @Override
    public void resultadoCadastro(String msg, boolean encerra) {
        cadastroView.exibeMensagem(msg, encerra);
    }

    @Override
    public void onFinish() {
        cadastroView = null;
    }
}
