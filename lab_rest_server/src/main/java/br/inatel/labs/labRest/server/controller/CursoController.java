package br.inatel.labs.labRest.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.labs.labRest.server.model.Curso;
import br.inatel.labs.labRest.server.model.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService service;

	@GetMapping("/{id}")
	public Curso buscar(@PathVariable("id") Long cursoId) {
		Optional<Curso> opCurso = service.buscarCursoPeloId(cursoId);

		if (opCurso.isPresent()) {
			return opCurso.get();
		} else {
			String message = String.format("Nenhum curso Encontrado com id %s", cursoId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
		}
	}

	@GetMapping
	public List<Curso> listar() {
		List<Curso> listaCursos = service.pesquisarCurso();
		return listaCursos;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso criar(@RequestBody Curso curso) {
		Curso cursoCriado = service.criarCurso(curso);
		return cursoCriado;
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void atualizarCurso(@RequestBody Curso curso) {
		service.atualizarCurso(curso);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("id") Long cursoIdParaRemover) {

		Optional<Curso> opCurso = service.buscarCursoPeloId(cursoIdParaRemover);

		if (opCurso.isEmpty()) {
			String message = String.format("Curso com id %s não encontrado! ", cursoIdParaRemover);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
		} else {
			Curso cursoASerRemovido = opCurso.get();
			service.removerCursoPeloId(cursoASerRemovido);
		}
	}

	@GetMapping("/pesquisa")
	public List<Curso> listarPeloFragDescricao(@RequestParam("descricao") String fragDescricao) {
		List<Curso> cursosEncontrados = service.pesquisarCursoPeloFragDescricao(fragDescricao);
		return cursosEncontrados;
	}

}
