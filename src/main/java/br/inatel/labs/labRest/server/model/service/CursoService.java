package br.inatel.labs.labRest.server.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.labs.labRest.server.model.Curso;

/**
 * Serviço com método de negócio para curso
 * 
 * @author wilmar
 *
 */

@Service
public class CursoService {

	private List<Curso> listaDeCursos = new ArrayList<>();

	@PostConstruct
	private void setup() {
		Curso curso1 = new Curso(1L, "Rest com Spring Boot", 20);
		Curso curso2 = new Curso(2L, "Programação Java 11", 80);
		Curso curso3 = new Curso(3L, "Dominando a IDE Eclipse", 120);

		listaDeCursos.add(curso1);
		listaDeCursos.add(curso2);
		listaDeCursos.add(curso3);
	}

	public List<Curso> pesquisarCurso() {
		return listaDeCursos;
	}

	public Optional<Curso> buscarCursoPeloId(Long cursoId) {
		Optional<Curso> opCurso = listaDeCursos.stream().filter(c -> c.getId().equals(cursoId)).findFirst();
		return opCurso;
	}

	public Curso criarCurso(Curso curso) {
		Long id = new Random().nextLong();
		curso.setId(id);
		listaDeCursos.add(curso);
		return curso;
	}

	public void atualizarCurso(Curso curso) {
		listaDeCursos.remove(curso);
		listaDeCursos.add(curso);
	}

	public void removerCursoPeloId(Curso cursoASerRemovico) {
		listaDeCursos.remove(cursoASerRemovico);
	}
	
	
	/**
	 * Pesquisa cursos pelo fragmento da descrição
	 * @param fragDescricao
	 * @return
	 */

	public List<Curso> pesquisarCursoPeloFragDescricao(String fragDescricao) {
		if (Objects.isNull(fragDescricao) || fragDescricao.isBlank()) {
			return List.of();
		}

		List<Curso> listaDeCursosEncontrados = listaDeCursos.stream()
				.filter(c -> c.getDescricao().trim().toLowerCase().contains(fragDescricao.trim().toLowerCase()))
				.collect(Collectors.toList());
		return listaDeCursosEncontrados;
	}
}
