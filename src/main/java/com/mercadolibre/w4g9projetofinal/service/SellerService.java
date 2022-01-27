package com.mercadolibre.w4g9projetofinal.service;

import com.mercadolibre.w4g9projetofinal.dtos.response.SellerResponseDTO;
import com.mercadolibre.w4g9projetofinal.entity.Seller;
import com.mercadolibre.w4g9projetofinal.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerResponseDTO> findAll() {
        List<SellerResponseDTO> list = repository.findAll().stream().map(x -> new SellerResponseDTO(x.getId(), x.getName())).collect(Collectors.toList());
        return list;
    }

    public Seller findById(Long id) {
        Optional<Seller> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Seller insert(SellerResponseDTO obj) {
        Seller newObj = new Seller(obj.getId(), obj.getName());
        newObj.setId(null);
        return repository.save(newObj);
    }
}
