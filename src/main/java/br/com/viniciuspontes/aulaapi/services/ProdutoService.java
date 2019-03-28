package br.com.viniciuspontes.aulaapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viniciuspontes.aulaapi.domain.Produto;
import br.com.viniciuspontes.aulaapi.repositories.ProdutoRepository;
import br.com.viniciuspontes.aulaapi.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ! Id:" + id +
				"Tipo: " + Produto.class.getName()
				));
				
	}
     
	public Produto insert(Produto obj) {
		obj.setId(null);
		return produtoRepository.save(obj);
		
	}

    public Produto update(Produto obj) {
    	find(obj.getId());
    	return produtoRepository.save(obj);
    	
    }
	
    public void delete(Integer id) {
    	find(id);
    	produtoRepository.deleteById(id);
    }
}
