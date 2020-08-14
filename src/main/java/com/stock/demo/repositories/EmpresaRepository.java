package com.stock.demo.repositories;

import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
