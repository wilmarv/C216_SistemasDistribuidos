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
		return em.merge(nc);
	}

	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}

	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra notaCompra = em.find(NotaCompra.class, id);
		notaCompra.getListaNotaCompraItem().size();
		return notaCompra;
	}

	public List<NotaCompra> listarNotaCompra() {
		return em.createQuery("select nc from NotaCompra nc", NotaCompra.class).getResultList();
	}

	// 2. Nota Compra Item

	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		return em.merge(item);
	}

	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}

	public List<NotaCompraItem> listarNotaCompraItem() {
		return em.createQuery("select item from NotaCompraItem item", NotaCompraItem.class).getResultList();
	}

}
