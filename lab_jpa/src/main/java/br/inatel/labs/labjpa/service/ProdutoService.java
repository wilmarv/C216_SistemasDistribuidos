package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;

@Service
@Transactional
public class ProdutoService {

	@PersistenceContext
	private EntityManager em;

	public Produto salvar(Produto p) {
		return em.merge(p);
	}

	public Produto buscarPeloId(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> listar() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}

	public void remover(Produto p) {
		p = em.merge(p);
		em.remove(p);
	}
}
