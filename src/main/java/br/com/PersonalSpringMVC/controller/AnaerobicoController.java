package br.com.PersonalSpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PersonalSpringMVC.model.service.AnaerobicoService;
import br.com.PersonalSpringMVC.negocio.Anaerobico;

@RestController
@RequestMapping("/api/anaerobico")
public class AnaerobicoController {

	@Autowired
	private AnaerobicoService service;
	
	@RequestMapping
	public List<Anaerobico> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Anaerobico> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir(@RequestBody Anaerobico anaerobico) {
		service.incluir(anaerobico);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

	public AnaerobicoService getService() {
		return service;
	}
	public void setService(AnaerobicoService service) {
		this.service = service;
	}
}