package com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.produtos.model.Produto;
import com.api.produtos.model.ResponseModel;
import com.api.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService S;

    @GetMapping("/listar")
    @ResponseBody
    public Iterable<Produto> listar() {
        return S.listar();
    }
   
    @GetMapping("/") //mapping default
    public String home(){ 
        return "redirect:/wishlist.html"; // Redireciona para /wishlist.html

    }
 
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Produto p) {
        return S.cadastrar(p);
    }
    
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody Produto p) {
        return S.Alterar(p);
    }

    @DeleteMapping("/remover/{codigo}") //add variable 
    public ResponseEntity<ResponseModel> remover(@PathVariable String codigo) {
        return S.remover(codigo);
    }

}
