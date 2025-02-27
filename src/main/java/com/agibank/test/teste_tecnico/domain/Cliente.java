package com.agibank.test.teste_tecnico.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 letras")
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail deve ser válido no formato email@email.com")
    private String email;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Column(length = 13)
    @Pattern(regexp = "\\d{11,13}", message = "Telefone deve ter entre 11 e 13 dígitos numéricos")
    private String telefone;

    @Column(nullable = false, length = 255)
    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @Column(nullable = false, precision = 18, scale = 2)
    @DecimalMin(value = "0.00", inclusive = true, message = "Saldo não pode ser negativo")
    private BigDecimal saldo;
}
