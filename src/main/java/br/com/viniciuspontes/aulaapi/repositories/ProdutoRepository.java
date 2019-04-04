package br.com.viniciuspontes.aulaapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciuspontes.aulaapi.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	public Page<Produto> findByNomeContaining(String nome, Pageable pageable);
}
