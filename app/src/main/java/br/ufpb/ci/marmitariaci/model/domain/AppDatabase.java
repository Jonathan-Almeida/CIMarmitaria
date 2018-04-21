package br.ufpb.ci.marmitariaci.model.domain;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Cardapio.class, Fornecedor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FornecedorDao fornecedorDao();
    public abstract CardapioDao cardapioDao();
}
