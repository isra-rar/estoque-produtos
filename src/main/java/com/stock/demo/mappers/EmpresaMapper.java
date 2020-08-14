package com.stock.demo.mappers;

import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.EmpresaDTO;
import com.stock.demo.models.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaDTO empresaToEmpresaDTO(Empresa empresa);

    Empresa empresaDTOToEmpresa(EmpresaDTO produtoDTO);

}
