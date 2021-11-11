package br.com.zupacademy.dmagliano.transacoes.transacao;

import br.com.zupacademy.dmagliano.transacoes.cartao.Cartao;
import br.com.zupacademy.dmagliano.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idTransacao;
    private BigDecimal valor;
    @Embedded
    private Estabelecimento estabelecimento;
    @Embedded
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    /*
    for hibernate use only
    */
    @Deprecated
    public Transacao() {
    }

    public Transacao(String idTransacao, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
