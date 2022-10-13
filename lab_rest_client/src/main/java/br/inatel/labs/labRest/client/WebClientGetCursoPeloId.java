package br.inatel.labs.labRest.client;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import model.Curso;
import reactor.core.publisher.Mono;

public class WebClientGetCursoPeloId {
	public static void main(String[] args) {
		try {
			Mono<Curso> monoCurso = WebClient.create("http://localhost:8080").get().uri("/curso/9").retrieve()
					.bodyToMono(Curso.class);

			monoCurso.subscribe();
			Curso curso = monoCurso.block();

			System.out.println("Curso encontrado: ");
			System.out.println(curso);
		} catch (WebClientResponseException e) {
			System.out.println("Erro aconteceu: ");
			System.out.println(e.getStatusCode());
			System.out.println(e.getMessage());
		}
	}
}
