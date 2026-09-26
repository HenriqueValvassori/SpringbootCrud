package com.test.springprojectcrud.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springprojectcrud.Model.Produto;
import com.test.springprojectcrud.Repository.ProdutoRepository;
import com.test.springprojectcrud.shared.ProdutoDTO;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos!
     * 
     * @return Lista de Produtos
     */
    public List<ProdutoDTO> obterTodos() {
        return produtoRepository.findAll();
    }

    /**
     * Metodo que retorna um produto encontrado pelo seu id.
     * 
     * @param id id do produto que sera localizado.
     * @return Retorna um produto caso tenho encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    /**
     * Metodo para adicionar produto na lista.
     * 
     * @param produto para que sera adicionado.
     * @return retorna o produto adicionado.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {

        return produtoRepository.save(produtoDto);

    }

    /**
     * Metodo para deletar produto da lista.
     * 
     * @param id produta que sera deletado.
     */
    public void deletar(Integer id) {

        produtoRepository.deleteById(id);

    }

    /**
     * Metodo para atualizar o produto.
     * 
     * @param produto produto que sera atualizado.
     * @return Retorna o produto que sera atualizado.
     */
    public Produto atualizar(Integer id, ProdutoDTO produtoDto) {

        produtoDto.setId(id);

        return produtoRepository.save(produtoDto);

    }

}
