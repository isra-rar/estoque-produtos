package com.stock.demo.mappers;

import com.stock.demo.models.Empresa;
import com.stock.demo.models.dto.EmpresaDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-13T00:19:37-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_265 (Private Build)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public EmpresaDTO empresaToEmpresaDTO(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setId( empresa.getId() );
        empresaDTO.setNomeFantasia( empresa.getNomeFantasia() );

        return empresaDTO;
    }

    @Override
    public Empresa empresaDTOToEmpresa(EmpresaDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        Empresa empresa = new Empresa();

        empresa.setId( produtoDTO.getId() );
        empresa.setNomeFantasia( produtoDTO.getNomeFantasia() );

        return empresa;
    }
}
