package br.ufpb.ci.marmitariaci.model.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.Date;
import java.util.List;

import br.ufpb.ci.marmitariaci.model.domain.Cardapio;

@Dao
public interface CardapioDao {
    @Query("SELECT * FROM Cardapio WHERE id LIKE :id")
    Cardapio getById(int id);

    @Query("SELECT * FROM Cardapio WHERE data=Date(:data)")
    List<Cardapio> getByData(String data);

    @Query("SELECT * FROM Cardapio WHERE id_fornecedor LIKE :fornecedorId")
    List<Cardapio> getByFornecedor(String fornecedorId);

    @Query("SELECT * FROM Cardapio WHERE id_fornecedor LIKE :fornecedorId AND "
            + "data=Date(:data)")
    List<Cardapio> getByFornecedorEData(String fornecedorId, String data);

    @Delete
    void delete(Cardapio cardapio);

    @Insert
    void insertAll(Cardapio... cardapios);

    @Update
    void update(Cardapio cardapio);
}
