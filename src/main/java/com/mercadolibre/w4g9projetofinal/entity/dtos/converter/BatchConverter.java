package com.mercadolibre.w4g9projetofinal.entity.dtos.converter;

import com.mercadolibre.w4g9projetofinal.entity.dtos.request.BatchRequestDTO;
import com.mercadolibre.w4g9projetofinal.entity.dtos.response.BatchResponseDTO;
import com.mercadolibre.w4g9projetofinal.entity.Advertise;
import com.mercadolibre.w4g9projetofinal.entity.Batch;

import java.util.ArrayList;
import java.util.List;

public class BatchConverter {

    public static List<BatchResponseDTO> convertEntityListToDtoList(List<Batch> batchList) {
        List<BatchResponseDTO> batchResponseDTOList = new ArrayList<>();
        for (Batch b : batchList) {
            batchResponseDTOList.add( convertEntityToDto(b) );
        }
        return batchResponseDTOList;
    }

    public static List<Batch> convertDtoListToEntityList(List<BatchRequestDTO> batchRequestDTOList) {
        List<Batch> batchList = new ArrayList<>();
        for (BatchRequestDTO b : batchRequestDTOList) {
            batchList.add(convertDtoToEntity(b));
        }
        return batchList;
    }

    public static Batch convertDtoToEntity (BatchRequestDTO b){
        return new Batch(
                null,
                b.getInitialQuantity(),
                b.getCurrentQuantity(),
                b.getCurrentTemperature(),
                b.getMinimumTemperature(),
                b.getDueDate(),
                b.getManufacturingDate(),
                b.getManufacturingTime(),
                new Advertise( b.getProductId() ,
                        null,
                        null,
                        null,
                        null,
                        null)
        );
    }
    public static BatchResponseDTO convertEntityToDto (Batch b){
        return new BatchResponseDTO(
                b.getId().intValue(),
                b.getAdvertise().getId(),
                b.getCurrentTemperature(),
                b.getMinTemperature(),
                b.getInitialQuantity(),
                b.getCurrentQuantity(),
                b.getManufacturingDate(),
                b.getManufacturingTime(),
                b.getDueDate()
        );
    }
}