package br.com.viniciuspontes.aulaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaapiApplication{

	//@Autowired
	//private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AulaapiApplication.class, args);
	}

	/* @Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Tobias");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
}*/

}

