package br.inatel.labs.labRest.client;

import org.springframework.web.reactive.function.client.WebClient;

import model.Curso;

public class WebClientPostCurso {
	public static void main(String[] args) {
		Curso novoCurso = new Curso();

		novoCurso.setDescricao("Dominando Spring Web");
		novoCurso.setCargaHoraria(80);

		Curso cursoRetornado = WebClient.create("http://localhost:8080").post().uri("/curso").bodyValue(novoCurso)
				.retrieve().bodyToMono(Curso.class).block();

		System.out.println("Curso retornado: ");
		System.out.println(cursoRetornado);
	}
}
