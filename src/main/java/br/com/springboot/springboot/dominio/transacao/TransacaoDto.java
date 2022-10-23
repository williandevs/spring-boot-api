package br.com.springboot.springboot.dominio.transacao;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class TransacaoDto {
    private Boolean ativo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
    @NotBlank( message = "A validação não pode ser em branco ")
    private String tipo;

    @NotNull()
    private Double valor;

    @NotNull()
    private Double saldo;

    @NotNull()
    private String descricao;
}
