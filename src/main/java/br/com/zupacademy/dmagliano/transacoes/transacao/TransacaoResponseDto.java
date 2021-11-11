package br.com.zupacademy.dmagliano.transacoes.transacao;

import br.com.zupacademy.dmagliano.transacoes.cartao.CartaoResponseDto;
import br.com.zupacademy.dmagliano.transacoes.estabelecimento.EstabelecimentoResponseDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponseDto {

    private String idTransacao;
    private BigDecimal valor;
    private EstabelecimentoResponseDto estabelecimento;
    private CartaoResponseDto cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoResponseDto() {
    }

    public TransacaoResponseDto(String idTransacao, BigDecimal valor, EstabelecimentoResponseDto estabelecimento, CartaoResponseDto cartao, LocalDateTime efetivadaEm) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponseDto(Transacao transacao) {
        this.idTransacao = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento().toResponseDto();
        this.cartao = transacao.getCartao().toResponseDto();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponseDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponseDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
