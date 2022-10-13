package br.inatel.labs.labRest.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import model.Curso;
import reactor.core.publisher.Flux;

public class WebClientGetCurso {

	public static void main(String[] args) {
		List<Curso> listaCurso = new ArrayList();

		Flux<Curso> fluxCurso = WebClient.create("http://localhost:8080").get().uri("/curso").retrieve()
				.bodyToFlux(Curso.class);

		fluxCurso.subscribe(c -> listaCurso.add(c));

		fluxCurso.blockLast();

		System.out.println("lista de curso: ");
		System.out.println(listaCurso);
	}
}
