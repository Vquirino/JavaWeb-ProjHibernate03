package model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="estoque")
public class Estoque {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="idproduto")
    private Integer idEstoque;
    
    @Column(name="descricao", length=1000, nullable=false)
    private String descricao;
    
    @ManyToMany
    @JoinTable( //entidade associada - TABELA DE JUNÇÃO
            name="lote",
            joinColumns=@JoinColumn(name="idestoque"), //foreign key para a tabela 'estoque'
            inverseJoinColumns=@JoinColumn(name="idproduto") //foreign key para a tabela 'produto'
    )
    private List<Produto> lote;

    public Estoque() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public List<Produto> getLote() {
        return lote;
    }

    public void setLote(List<Produto> lote) {
        this.lote = lote;
    }
    
    
    
}
