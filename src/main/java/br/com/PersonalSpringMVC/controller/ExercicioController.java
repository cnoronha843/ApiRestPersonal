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

import br.com.PersonalSpringMVC.model.service.ExercicioService;
import br.com.PersonalSpringMVC.negocio.Exercicio;

@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {

	@Autowired
	private ExercicioService service;
	
	@RequestMapping
	public List<Exercicio> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Exercicio> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir(@RequestBody Exercicio exercicio) {
		service.incluir(exercicio);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

	public ExercicioService getService() {
		return service;
	}
	public void setService(ExercicioService service) {
		this.service = service;
	}
}