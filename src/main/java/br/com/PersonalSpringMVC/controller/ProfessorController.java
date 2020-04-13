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

import br.com.PersonalSpringMVC.model.service.ProfessorService;
import br.com.PersonalSpringMVC.negocio.Professor;


@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService service;
	
	@RequestMapping
	public List<Professor> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Professor> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir(@RequestBody Professor professor) {
		service.incluir(professor);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}


	public ProfessorService getService() {
		return service;
	}
	public void setService(ProfessorService service) {
		this.service = service;
	}
}