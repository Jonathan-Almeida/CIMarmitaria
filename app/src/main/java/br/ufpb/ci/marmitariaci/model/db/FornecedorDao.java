package br.ufpb.ci.marmitariaci.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import br.ufpb.ci.marmitariaci.model.domain.Fornecedor;

@Dao
public interface FornecedorDao {
    @Query("SELECT * FROM Fornecedor WHERE id LIKE :id")
    Fornecedor getById(int id);

    @Query("SELECT * FROM Fornecedor WHERE email LIKE :email")
    Fornecedor getByEmail(String email);

    @Query("SELECT * FROM Fornecedor WHERE nome LIKE :nome LIMIT 1")
    Fornecedor getByNome(String nome);

    @Insert
    void insertAll(Fornecedor... fornecedores);

    @Delete
    void delete(Fornecedor fornecedor);

    @Update
    void update(Fornecedor fornecedor);
}
