package model;

import javax.persistence.*;

@Entity
@Table(name="produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idproduto")
    private Integer idProduto;
    
    @Column(name="nome", length=35, nullable=false)
    private String nome;
    
    @Column(name="marca", length=25, nullable=false)
    private String marca;

    public Produto() {
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
