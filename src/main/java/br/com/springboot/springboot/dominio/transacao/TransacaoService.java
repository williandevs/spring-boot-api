package br.com.springboot.springboot.dominio.transacao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository tr) {
        this.transacaoRepository = tr;
    }

    public List<Transacao> findAll() {
        return this.transacaoRepository.findAll();
    }
    public Optional<Transacao> findById(UUID id) {
        return this.transacaoRepository.findById(id);
    }



    @Transactional
    public Transacao save(Transacao transacao) {
        return this.transacaoRepository.save(transacao);
    }

    @Transactional
    public void delete(Transacao transacao) {
        this.transacaoRepository.delete(transacao);
    }

}
