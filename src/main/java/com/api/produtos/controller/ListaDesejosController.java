package com.api.produtos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.api.produtos.model.ListaDesejos;
import com.api.produtos.service.ListaDesejosService;

@Controller
public class ListaDesejosController {

    @Autowired
    private ListaDesejosService listaDesejosService;
 
    @GetMapping("/meusdesejos")
    public String mostrarListaDesejos() {
        return "listadesejos";
    }

    @GetMapping("/getListaDesejosPorClienteId")
    public ListaDesejos getListaDesejosPorClienteId(String clienteId) {
        return listaDesejosService.getListaDesejosPorClienteId(clienteId);
    }


    @PostMapping("/adicionarP/{clienteId}/produtos/{produtoId}")
    public ResponseEntity<ListaDesejos> adicionarProdutoAoDesejos(@PathVariable String clienteId, @PathVariable String produtoId) {
        ListaDesejos listaDesejos = listaDesejosService.adicionarProduto(clienteId, produtoId);
        return ResponseEntity.ok(listaDesejos);
    }

    @DeleteMapping("/removerP/{clienteId}/produtos/{produtoId}")
    public ResponseEntity<ListaDesejos> removerProdutoAoDesejos(@PathVariable String clienteId, @PathVariable String produtoId) {
        ListaDesejos listaDesejos = listaDesejosService.removerProduto(clienteId, produtoId);
        return ResponseEntity.ok(listaDesejos);
    }
}
