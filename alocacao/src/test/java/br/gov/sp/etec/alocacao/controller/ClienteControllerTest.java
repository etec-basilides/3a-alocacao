package br.gov.sp.etec.alocacao.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.gov.sp.etec.alocacao.model.Cliente;
import br.gov.sp.etec.alocacao.repository.ClienteRepository;

@SpringBootTest
public class ClienteControllerTest {
	
	@InjectMocks
	ClienteController controller;
	
	@Mock
	ClienteRepository repository;
	
	Cliente cliente;
	@BeforeEach
	public void setup(){
		cliente = new Cliente();
		cliente.setCpf("123");
	}
	
	@Test
	public void testClientes() {
	
		Mockito.when(repository.findAll()).thenReturn(List.of(cliente));
		List<Cliente> clientes = controller.clientes();
		assertNotNull(clientes);
	}

	@Test
	public void testAdicionarCliente() {
		Mockito.when(repository.save(any(Cliente.class))).thenReturn(cliente);
		Cliente c = controller.adicionarCliente(new Cliente());
		assertEquals("1235", c.getCpf());
	}
	
	
	
	
	@PostMapping("adicionar-cliente")
	public Cliente adicionarCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
}
