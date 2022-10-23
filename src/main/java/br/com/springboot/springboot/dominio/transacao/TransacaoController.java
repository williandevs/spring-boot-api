package br.com.springboot.springboot.dominio.transacao;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.engine.transaction.spi.TransactionObserver;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    // @Autowired
    // private TransacaoService transacaoService

    final TransacaoService transacaoService;

    public TransacaoController(TransacaoService ts) {
        this.transacaoService = ts;
    }

    @GetMapping()
    public List<Transacao> selectAll() {
        List<Transacao> listaDeTransacao = this.transacaoService.findAll();
        return listaDeTransacao;
    }

    @PostMapping()
    public ResponseEntity<Object> insert(@RequestBody @Valid TransacaoDto transaocaoDaRequisicao) {

        Transacao transaocao = new Transacao();

        BeanUtils.copyProperties(transaocaoDaRequisicao, transaocao);

        transaocao.setAtivo(true);
        transaocao.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        transaocao.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        Transacao transacaoSalva = this.transacaoService.save(transaocao);

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalva);

    }







    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID idDaRequisicao, @RequestBody TransacaoDto transaocaoDaRequisicao) {

        Optional<Transacao> transacaoOptinal = this.transacaoService.findById(idDaRequisicao)


        if (!transacaoOptinal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontarda")
           
        } 
            Transacao transaocao = new Transacao();
                BeanUtils.copyProperties(transaocaoDaRequisicao, transaocao);
               /*  transacao.setId(transacaoOptinal.get().getId(UUID id));
                 transacao.setCreatedAt(transacaoOptinal.)   
                transaocao.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC"))); */


       /*  Transacao transacaoAtualizada = this.transacaoService.save(transaocaoDaRequisicao);
       
        return transacaoAtualizada; */
    }











    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID idDaRequisicao) {

        Optional<Transacao> opTransacao = this.transacaoService.findById(idDaRequisicao);

        if (opTransacao.isPresent()) {
            this.transacaoService.delete(opTransacao.get());
            return "Deletado com Sucesso!";
        } else {
            return "Registro não existe ou já foi Deletata";
        }

    }

}