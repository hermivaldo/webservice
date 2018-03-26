package br.com.hermivaldo.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "livro")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dtInsercao", "dtUltimaAtualicao"},
        allowGetters = true)
public class Livro implements Serializable {


    @Id
    private String sku;

    @NotBlank
    private String nome;

    @NotBlank
    private String marca;

    private Float preco;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dtInsercao;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dtUltimaAtualicao;


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getDtInsercao() {
        return dtInsercao;
    }

    public void setDtInsercao(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
    }

    public Date getDtUltimaAtualicao() {
        return dtUltimaAtualicao;
    }

    public void setDtUltimaAtualicao(Date dtUltimaAtualicao) {
        this.dtUltimaAtualicao = dtUltimaAtualicao;
    }
}
