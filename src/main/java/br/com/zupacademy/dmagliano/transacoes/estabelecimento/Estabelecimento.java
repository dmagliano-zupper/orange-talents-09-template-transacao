package br.com.zupacademy.dmagliano.transacoes.estabelecimento;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    @Column(name = "estab_nome")
    private String nome;
    @Column(name = "estab_cidade")
    private String cidade;
    @Column(name = "estab_endereco")
    private String endereco;

    /*
    for hibernate use only
    */
    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public EstabelecimentoResponseDto toResponseDto(){
        return new EstabelecimentoResponseDto(
                this.nome,
                this.cidade,
                this.endereco
        );
    }
}
