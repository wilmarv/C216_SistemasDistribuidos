package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {

	@PersistenceContext
	private EntityManager em;

	// 1.Nota Compra
	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		em.merge(nc);
		return nc;
	}

	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}

	public List<NotaCompra> listarNotaCompra() {
		return em.createQuery("select nc from NotaCompra nc", NotaCompra.class).getResultList();
	}

	// 2. Nota Compra Item

	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		em.merge(item);
		return item;
	}

	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}

	public List<NotaCompraItem> listarNotaCompraItem() {
		return em.createQuery("select item from NotaCompra item", NotaCompraItem.class).getResultList();
	}

}
