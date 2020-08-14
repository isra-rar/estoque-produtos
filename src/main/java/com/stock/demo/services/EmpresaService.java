package com.stock.demo.services;

import com.stock.demo.models.Empresa;
import com.stock.demo.models.dto.EmpresaDTO;

public interface EmpresaService extends GenericService{

    EmpresaDTO getEmpresaDTOById(Long id);

    Empresa getEmpresaById(Long id);

    void deleteProduto(Long id, Long idProduto);

}
