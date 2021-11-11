package br.com.zupacademy.dmagliano.transacoes.estabelecimento;

public class EstabelecimentoResponseDto {

    private String nome;
    private String cidade;
    private String endereco;

    /*
    for hibernate use only
    */
    @Deprecated
    public EstabelecimentoResponseDto() {
    }

    public EstabelecimentoResponseDto(String nome, String cidade, String endereco) {
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
}
