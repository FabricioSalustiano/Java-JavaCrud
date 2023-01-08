package br.com.dao;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.javacrud.model.TbCliente;
import br.com.jpautil.JPAUtil;

public class ClienteDAO {
	
	public List<TbCliente> listarClientes() {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("SELECT c FROM "+ TbCliente.class.getSimpleName() + " c");
		List<TbCliente> result = query.getResultList();
		et.commit();
		em.close();
	
		result.sort(Comparator.comparing(TbCliente::getIdCliente));
		return result;
	}
	
	public void salvarCliente(TbCliente entidade) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(entidade);
		et.commit();
		em.close();
	}
	
	public boolean verificaCliente(String cpf) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Query query = em.createQuery("SELECT c.idCliente, c.nomeCliente, c.cpfCliente FROM "+ TbCliente.class.getSimpleName() +" c "
				+ "WHERE c.cpfCliente = :cpf")
				.setParameter("cpf", cpf);
		List<String> result = query.getResultList();
		et.commit();
		em.close();
		
		if(result.size() != 0)
			return true;
		
		return false;
	}
}
