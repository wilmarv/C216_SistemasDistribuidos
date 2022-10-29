package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Fornecedor;

@Service
@Transactional
public class FornecedorService {

	@PersistenceContext
	private EntityManager em;

	public Fornecedor salvar(Fornecedor f) {
		return em.merge(f);
	}

	public Fornecedor buscarPeloId(Long id) {
		return em.find(Fornecedor.class, id);
	}

	public List<Fornecedor> listar() {
		return em.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
	}

	public void remover(Fornecedor f) {
		f = em.merge(f);
		em.remove(f);
	}
}
