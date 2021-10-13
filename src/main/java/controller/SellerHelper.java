/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Oct 12, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Seller;

public class SellerHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ResipesDatabaseProject");
	
	public void insertNewSeller(Seller s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Seller> getSellers(){
		EntityManager em = emfactory.createEntityManager();
		List<Seller> allSellers = em.createQuery("SELECT d FROM SELLER d").getResultList();
		return allSellers;
	}
	
	public Seller searchForSellerById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Seller found = em.find(Seller.class, tempId);
		em.close();
		return found;
	}

	
	public void deleteSeller(Seller sToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Seller> typedQuery = em.createQuery("SELECT d FROM SELLER d WHERE d.SellerId= :selectedId", Seller.class);
		typedQuery.setParameter("selectedId", sToDelete.getSellerId());
		
		typedQuery.setMaxResults(1);
		
		Seller result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateSeller(Seller sToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(sToEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
