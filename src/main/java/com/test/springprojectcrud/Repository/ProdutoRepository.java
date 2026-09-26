package com.test.springprojectcrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.springprojectcrud.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
