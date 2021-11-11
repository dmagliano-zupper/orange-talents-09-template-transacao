package br.com.zupacademy.dmagliano.transacoes.cartao;

import javax.persistence.Column;

public class CartaoResponseDto {

    private String cartaoId;
    private String email;

    /*
    for hibernate use only
    */
    @Deprecated
    public CartaoResponseDto() {
    }


    public CartaoResponseDto(String cartaoId, String email) {
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
