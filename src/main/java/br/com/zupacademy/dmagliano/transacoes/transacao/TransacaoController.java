package br.com.zupacademy.dmagliano.transacoes.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping(value = "/{idCartao}")
    public Page<TransacaoResponseDto> listaTodasTransacoes(@PathVariable String idCartao){

        Pageable firstPage = PageRequest.of(0, 10, Sort.by("efetivada_em").descending());
        return transacaoRepository.findAllByCartaoId(idCartao, firstPage).map(TransacaoResponseDto::new);

    }

}
