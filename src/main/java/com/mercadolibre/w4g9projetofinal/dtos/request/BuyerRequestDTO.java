package com.mercadolibre.w4g9projetofinal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
/***
 * DTO para serialização
 * Classe de Request
 * contem: name(String), endereco(String), email(String)
 * @autor Leonardo
 */
public class BuyerRequestDTO {
    private String name;
    public String address;
    private String email;
    @NotEmpty(message = "Campo Obrigatório")
    private String pass;
}