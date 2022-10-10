package br.inatel.labs.labRest.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.labs.labRest.server.model.Curso;
import br.inatel.labs.labRest.server.model.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping
	public List<Curso> listar() {
		List<Curso> listaCursos = service.pesquisarCurso();
		return listaCursos;
	}

}
