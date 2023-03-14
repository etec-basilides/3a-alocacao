package br.gov.sp.etec.alocacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.etec.alocacao.model.Carro;

@RestController
public class CarroController { 
	
	@GetMapping("listar-carros")
	public List<Carro> listarCarros(){
		Carro c1 = new Carro();
		c1.setId(1L);
		c1.setCor("amarelo");
		c1.setModelo("HB20");
		c1.setPlaca("ABC-1234");
		c1.setChassi(123455666790L);
		
		Carro c2 = new Carro();
		c2.setId(2L);
		c2.setCor("verde");
		c2.setModelo("Corsa");
		c2.setPlaca("CBA-1234");
		c2.setChassi(123455666710L);
		
		List carros = new ArrayList<Carro>();
		
		carros.add(c1);
		carros.add(c2);
		return carros;		
	}

}
