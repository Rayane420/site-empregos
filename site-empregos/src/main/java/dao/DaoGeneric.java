package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.siteempregos.HibernateUtil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin(); //iniciando
		entityManager.persist(entidade); //persistindo a entidade
		transaction.commit(); //salvando no banco de dados
	}
	
	public E pesquisar (E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E e = (E) entityManager.find(entidade.getClass(), id);
		
		return e;
		
	}
	
}
