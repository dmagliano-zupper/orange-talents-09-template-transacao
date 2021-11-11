package br.com.zupacademy.dmagliano.transacoes.transacao;

import br.com.zupacademy.dmagliano.transacoes.cartao.CartaoMessage;
import br.com.zupacademy.dmagliano.transacoes.estabelecimento.Estabelecimento;
import br.com.zupacademy.dmagliano.transacoes.estabelecimento.EstabelecimentoMessage;

import javax.persistence.Embedded;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoMessage estabelecimento;
    private CartaoMessage cartao;
    private LocalDateTime efetivadaEm;

    /*
    for hibernate use only
    */
    @Deprecated
    public TransacaoMessage() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoMessage getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMessage getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toEntity() {
        return new Transacao(
                this.id,
                this.valor,
                this.estabelecimento.toEntity(),
                this.cartao.toEntity(),
                this.efetivadaEm
        );
    }

    @Override
    public String toString() {
        return "TransacaoMessage{\n" +
                "id='" + id +
                ",\nvalor=" + valor +
                ",\nestabelecimento=" + estabelecimento.getNome() +
                ",\ncartao=" + cartao.getId() +
                ",\nefetivadaEm=" + efetivadaEm +
                "\n }";
    }
}
