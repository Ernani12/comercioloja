package com.api.produtos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.api.produtos.model.Produto;
import com.api.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;



@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService PS;


    public ProdutoController(ProdutoService ProdutoService) {
        this.PS = ProdutoService;
    }

    @GetMapping("/")
    public String home() { 
        return "redirect:/wishlist"; // Redireciona para o controlador de wishlist
    }

    @GetMapping("/wishlist")
    public String getWishlist(Model model) {
        model.addAttribute("produtos", PS.getAllProdutos());
        return "wishlist"; // Retorna a view wishlist.html
    }


    @PostMapping("/cadastrarProduto")
    public ResponseEntity<?> cadastrar(@RequestBody Produto p) {
        return PS.cadastrar(p);
    }
     
    @PutMapping("/alterarProduto")
    public ResponseEntity<?> alterar(@RequestBody Produto p) {
        return PS.Alterar(p);
    }

    @DeleteMapping("/removerProduto/{ProdutoId}")
    public void removerProduto(@PathVariable String ProdutoId) {
        PS.remover(ProdutoId);
    }


}
