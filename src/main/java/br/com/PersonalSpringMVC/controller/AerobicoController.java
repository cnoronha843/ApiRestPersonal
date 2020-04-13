package br.com.PersonalSpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PersonalSpringMVC.model.service.AerobicoService;
import br.com.PersonalSpringMVC.negocio.Aerobico;

@RestController
@RequestMapping("/api/aerobico")
public class AerobicoController {

	@Autowired
	private AerobicoService service;
	
	@RequestMapping
	public List<Aerobico> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Aerobico> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir(@RequestBody Aerobico aerobico) {
		service.incluir(aerobico);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}


	public AerobicoService getService() {
		return service;
	}
	public void setService(AerobicoService service) {
		this.service = service;
	}
}