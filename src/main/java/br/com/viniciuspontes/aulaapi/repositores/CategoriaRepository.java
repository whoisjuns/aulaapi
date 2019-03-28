package br.com.viniciuspontes.aulaapi.repositores;

import java.util.Optional;

import br.com.viniciuspontes.aulaapi.domain.Categoria;

public interface CategoriaRepository {

	Optional<Categoria> findById(Integer id);

}
