package br.com.zupacademy.dmagliano.transacoes.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoRepository transacaoRepository;

    @GetMapping(value = "/{idCartao}")
    public Page<TransacaoResponseDto> listaTodasTransacoes(@PathVariable String idCartao,
                                                           @RequestParam(value = "page",
                                                                   required = false,
                                                                   defaultValue = "0") int page,
                                                           @RequestParam(value = "size",
                                                                   required = false,
                                                                   defaultValue = "10") int size) {

        if (!transacaoRepository.existsByCartaoId(idCartao)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pageable firstPage = PageRequest.of(page, size, Sort.by("efetivada_em").descending());
        return transacaoRepository.findAllByCartaoId(idCartao, firstPage).map(TransacaoResponseDto::new);

    }

}
