package br.ufpb.ci.marmitariaci.model.domain;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import br.ufpb.ci.marmitariaci.model.db.DateConverter;


@Entity(foreignKeys = @ForeignKey(entity = Fornecedor.class,
        parentColumns = "id",
        childColumns = "id_fornecedor",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE))
public class Cardapio {
    @PrimaryKey
    private int id;
    private String itens;
    @TypeConverters({DateConverter.class})
    private Date data;
    private String preco;
    private int id_fornecedor;

    public Cardapio(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
}