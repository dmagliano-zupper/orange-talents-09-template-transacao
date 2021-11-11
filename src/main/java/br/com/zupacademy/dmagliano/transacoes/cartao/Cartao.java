package br.com.zupacademy.dmagliano.transacoes.cartao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cartao {

    @Column(name = "cartao_id")
    private String cartaoId;
    @Column(name = "cartao_email")
    private String email;

    /*
    for hibernate use only
    */
    @Deprecated
    public Cartao() {
    }

    public Cartao(String cartaoId, String email) {
        this.cartaoId = cartaoId;
        this.email = email;
    }

    public String getCartaoId() {
        return cartaoId;
    }

    public String getEmail() {
        return email;
    }
}
