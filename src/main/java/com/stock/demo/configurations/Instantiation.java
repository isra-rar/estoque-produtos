package com.stock.demo.configurations;

import com.stock.demo.enums.EmpresaEnum;
import com.stock.demo.enums.GeneroEnum;
import com.stock.demo.enums.TipoProdutoEnum;
import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import com.stock.demo.repositories.EmpresaRepository;
import com.stock.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.stock.demo.singletons.FakerSingleton.getInstance;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public void run(String... args) throws Exception {

        produtoRepository.deleteAll();

        List<Empresa> empresas = new ArrayList<>();

        empresas.addAll(Arrays.asList(new Empresa(EmpresaEnum.NATURA), new Empresa(EmpresaEnum.BOTICARIO)));

        empresaRepository.saveAll(empresas);


        for (int i = 0; i < 10; i++) {

            Produto produto = new Produto(getInstance().commerce().material(), getInstance().number().randomNumber(6, true), TipoProdutoEnum.valueOf(getInstance().number().numberBetween(0, 7)), getInstance().number().numberBetween(10, 50), BigDecimal.valueOf(getInstance().number().randomDouble(2, 10, 30)),
                    BigDecimal.valueOf(getInstance().number().randomDouble(2, 10, 30)),LocalDate.now(), LocalDate.now(),GeneroEnum.valueOf(getInstance().number().numberBetween(0, 3)), empresas.get(getInstance().number().numberBetween(0, 2)));

            produtoRepository.save(produto);

            for (Empresa empresa : empresas) {
                if (produto.getEmpresa().getNomeFantasia().getDescricao() == "NATURA") {
                    empresas.get(0).getProdutos().add(produto);
                } else {
                    empresas.get(1).getProdutos().add(produto);
                }
            }

        }


    }
}
