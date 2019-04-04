package br.com.viniciuspontes.aulaapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.viniciuspontes.aulaapi.domain.Categoria;
import br.com.viniciuspontes.aulaapi.domain.Produto;
import br.com.viniciuspontes.aulaapi.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResources {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping()
	public Page<Produto> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome, Pageable pageable){
		return produtoService.pesquisar(nome, pageable);
	}
	
	
	/*public List<Produto> listar() {
		return produtoService.listarTodas();
		
	}*/
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		Produto obj = produtoService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
@PostMapping
	public ResponseEntity<Void> insert( @RequestBody Produto obj){
	
		obj = produtoService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Produto obj, @PathVariable Integer id){
		
		obj.setId(id);
		obj = produtoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
 
		 produtoService.delete(id);
		 return ResponseEntity.noContent().build();
		
	}
}
