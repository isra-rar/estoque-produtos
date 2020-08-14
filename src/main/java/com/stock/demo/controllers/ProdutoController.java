package com.stock.demo.controllers;

import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.ProdutoDTO;
import com.stock.demo.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController extends GenericController<ProdutoService> {

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id){
        ProdutoDTO obj = getService().getProdutoById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<ProdutoDTO>> getAll(){
        List<ProdutoDTO> obj = getService().getAllProdutos();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<ProdutoDTO> insertProduto(@Valid @RequestBody ProdutoDTO objDto) {
        ProdutoDTO produtoDTO = getService().insertProduto(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}").buildAndExpand((produtoDTO.getId())).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @PutMapping(value = "/produtos/{id}")
    public ResponseEntity<Void> updateProduto(@Valid @RequestBody ProdutoDTO obj, @PathVariable Long id) {
        getService().updateProduto(obj, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        getService().deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
