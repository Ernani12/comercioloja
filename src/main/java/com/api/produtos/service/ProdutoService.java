package com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.produtos.model.Produto;
import com.api.produtos.model.ResponseModel;
import com.api.produtos.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ResponseModel RM;

    @Autowired
    private ProdutoRepository PR;
   //list all products

   public ProdutoService(ProdutoRepository produtoRepository) {
    this.PR = produtoRepository;
}

    public List<Produto> getAllProdutos() {
        return PR.findAll();
    }

    public ResponseEntity<?> getProdutoById(String id) {
        Optional<Produto> optionalProduto = PR.findById(id);
        if (optionalProduto.isPresent()) {
            return new ResponseEntity<Produto>(optionalProduto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseModel>(HttpStatus.NOT_FOUND);
        }
    }
  
    public ResponseEntity<Produto> cadastrar(Produto Produto) {
        if (Produto == null) {
            RM.setMessage("O Produto recebido é nulo");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (Produto.getNome() == null || Produto.getNome().isEmpty()) {
            RM.setMessage("Nome é obrigatório");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (Produto.getPreco() == null || Produto.getPreco() == 0) {
            RM.setMessage("Preço não pode ser 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Produto savedProduto = PR.save(Produto);
        return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
    }


    public ResponseEntity<?> Alterar(Produto p){

        if(p.getNome().equals("")){
            RM.setMessage("Nome é obrigatorio");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }
        else if(p.getPreco()==0){
            RM.setMessage("preco");
            return new ResponseEntity<ResponseModel>(RM, HttpStatus.BAD_REQUEST);
        }else{
            RM.setMessage("FOI CADASTRADO");
            return new  ResponseEntity<Produto>(PR.save(p),HttpStatus.OK);      
        }
        
    }

 
    public ResponseEntity<ResponseModel> remover (String codigo){
       PR.deleteById(codigo);

       RM.setMessage("produto removido");
       return new  ResponseEntity<ResponseModel>(RM,HttpStatus.OK);      
    }
}


