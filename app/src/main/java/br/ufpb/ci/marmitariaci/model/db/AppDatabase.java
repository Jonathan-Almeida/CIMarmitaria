package br.ufpb.ci.marmitariaci.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.ufpb.ci.marmitariaci.model.domain.Cardapio;
import br.ufpb.ci.marmitariaci.model.db.CardapioDao;
import br.ufpb.ci.marmitariaci.model.domain.Fornecedor;
import br.ufpb.ci.marmitariaci.model.db.FornecedorDao;

@Database(entities = {Cardapio.class, Fornecedor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FornecedorDao fornecedorDao();
    public abstract CardapioDao cardapioDao();
}
