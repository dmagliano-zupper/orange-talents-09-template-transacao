package br.com.zupacademy.dmagliano.transacoes.consumer;

import br.com.zupacademy.dmagliano.transacoes.transacao.TransacaoMessage;
import br.com.zupacademy.dmagliano.transacoes.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    @Autowired
    TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transacao}")
    public void ouvir(TransacaoMessage transacaoMessage) {
        System.out.println(transacaoMessage.toString());
        transacaoRepository.save(transacaoMessage.toEntity());
    }

}
