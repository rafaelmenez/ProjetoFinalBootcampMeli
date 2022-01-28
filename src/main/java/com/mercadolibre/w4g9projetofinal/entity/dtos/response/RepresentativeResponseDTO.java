package com.mercadolibre.w4g9projetofinal.entity.dtos.response;

import com.mercadolibre.w4g9projetofinal.entity.enums.CargoRepresentante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepresentativeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private CargoRepresentante job;
}