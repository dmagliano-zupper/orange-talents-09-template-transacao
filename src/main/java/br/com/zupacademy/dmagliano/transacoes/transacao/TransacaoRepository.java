package br.com.zupacademy.dmagliano.transacoes.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    @Query(value = "SELECT * FROM transacao WHERE cartao_id = ?1",
            countQuery = "SELECT count(*) FROM transacao WHERE cartao_id = ?1",
            nativeQuery = true)
    Page<Transacao> findAllByCartaoId(String cartaoId, Pageable pageable);

}
