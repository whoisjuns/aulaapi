
package br.com.viniciuspontes.aulaapi.resources;

import java.net.URI;

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
import br.com.viniciuspontes.aulaapi.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping()
	public Page<Categoria> pesquisar(@RequestParam(required = false, defaultValue = "%") String nome, Pageable pageable){
		return categoriaService.pesquisar(nome, pageable);
	}
	
	/*public List<Categoria> listar() {
		return categoriaService.listarTodas();
		
	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = categoriaService.find(id);
		
		
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Void> insert( @RequestBody Categoria obj) {
		
		obj = categoriaService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
			
	}
     
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id){
	
		obj.setId(id);
		obj = categoriaService.update(obj);
		return ResponseEntity.noContent().build();
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
}
