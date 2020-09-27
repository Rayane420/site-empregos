package dao;

import java.util.List;

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
	
	public List<E> listar (Class<E> entidade){
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
		transaction.commit();
		
		return lista;
		
	}
	
	
	/*-------------Método para que seja possível usar o entityManager fora dessa classe-------------*/
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
