package com.test.springprojectcrud.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.springprojectcrud.Model.Produto;
import com.test.springprojectcrud.Model.Exception.ResourceNotFoundException;

@Repository
public class ProdutoRepositoryOld {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoid = 0;

    /**
     * Metodo para retornar uma lista de produtos!
     * 
     * @return Lista de Produtos
     */
    public List<Produto> obterTodos() {
        return produtos;

    }

    /**
     * Metodo que retorna um produto encontrado pelo seu id.
     * 
     * @param id id do produto que sera localizado.
     * @return Retorna um produto caso tenho encontrado.
     */
    public Optional<Produto> obterPorId(Integer id) {

        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * 
     * @param produto para que sera adicionado.
     * @return retorna o produto adicionado.
     */
    public Produto adicionar(Produto produto) {

        ultimoid++;
        produto.setId(ultimoid);
        produtos.add(produto);

        return produto;

    }

    /**
     * Metodo para deletar produto da lista.
     * 
     * @param id produta que sera deletado.
     */
    public void deletar(Integer id) {

        produtos.removeIf(produto -> produto.getId() == id);

    }

    /**
     * Metodo para atualizar o produto.
     * 
     * @param produto produto que sera atualizado.
     * @return Retorna o produto que sera atualizado.
     */
    public Produto atualizar(Produto produto) {

        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto nao encontrado.");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;

    }

}
