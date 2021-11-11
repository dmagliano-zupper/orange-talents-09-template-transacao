package br.com.zupacademy.dmagliano.transacoes.cartao;

import javax.persistence.Embeddable;

public class CartaoMessage {

    private String id;
    private String email;

    /*
    for hibernate use only
    */
    @Deprecated
    public CartaoMessage() {
    }

    public CartaoMessage(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public Cartao toEntity(){
        return new Cartao(
                this.id,
                this.email
        );
    }
}
