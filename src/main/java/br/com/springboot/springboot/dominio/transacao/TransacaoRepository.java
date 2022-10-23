package br.com.springboot.springboot.dominio.transacao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    
}
