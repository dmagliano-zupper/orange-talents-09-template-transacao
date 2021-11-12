package br.com.zupacademy.dmagliano.transacoes.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Long> {

    @Query(value = "SELECT * FROM transacao WHERE cartao_id = ?1",
            countQuery = "SELECT count(*) FROM transacao WHERE cartao_id = ?1",
            nativeQuery = true)
    Page<Transacao> findAllByCartaoId(String cartaoId, Pageable pageable);

    @Query(value =  "SELECT CASE WHEN COUNT(t)> 0 THEN 'true' ELSE 'false' END FROM Transacao t WHERE t.cartao.cartaoId = :cartao_id")
    boolean existsByCartaoId(@Param("cartao_id") String cartaoId);
}
