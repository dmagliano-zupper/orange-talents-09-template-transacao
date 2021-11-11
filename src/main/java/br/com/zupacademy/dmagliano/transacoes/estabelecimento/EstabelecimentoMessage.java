package br.com.zupacademy.dmagliano.transacoes.estabelecimento;

public class EstabelecimentoMessage {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoMessage() {
    }

    public EstabelecimentoMessage(String nome, String cidade, String endereco) {
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

    public Estabelecimento toEntity(){
        return new Estabelecimento(
                this.nome,
                this.cidade,
                this.endereco
        );
    }
}
