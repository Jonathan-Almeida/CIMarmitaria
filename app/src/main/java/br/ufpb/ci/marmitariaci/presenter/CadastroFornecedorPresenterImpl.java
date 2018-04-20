package br.ufpb.ci.marmitariaci.presenter;

import br.ufpb.ci.marmitariaci.model.business.ModelUsuario;
import br.ufpb.ci.marmitariaci.model.business.ModelUsuarioFornecedorImpl;
import br.ufpb.ci.marmitariaci.model.domain.Fornecedor;
import br.ufpb.ci.marmitariaci.view.CadastroView;

public class CadastroFornecedorPresenterImpl implements CadastroPresenter {

    private CadastroView view;
    private ModelUsuario model;

    public CadastroFornecedorPresenterImpl(CadastroView view) {
        this.view = view;
        model = new ModelUsuarioFornecedorImpl(this);
    }

    @Override
    public void cadastraUsuario(String... strings) {
        String empresa = strings[0];
        String email = strings[1];
        String senha = strings[2];
        String endereco = strings[3];
        String telefone = strings[4];
        Fornecedor f = new Fornecedor();
        f.setNome(empresa);
        f.setEmail(email);
        f.setSenha(senha);
        f.setEndereco(endereco);
        f.setTelefone(telefone);
        model.adiciona(f);
    }

    @Override
    public void resultadoCadastro(String msg, boolean encerra) {
        view.exibeMensagem(msg, encerra);
    }

    @Override
    public void onFinish() {
        view = null;
    }
}
