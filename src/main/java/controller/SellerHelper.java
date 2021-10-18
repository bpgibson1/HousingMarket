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

import model.Seller;

public class SellerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HousingMarket");

	public void insertSeller(Seller seller) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(seller);
		em.getTransaction().commit();
		em.close();
	}

	public void removeSeller(Seller seller) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Seller toRemove = em.merge(seller);
		em.remove(toRemove);
		em.getTransaction().commit();
		em.close();
	}

	public void updateSeller(Seller toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public Seller searchForSellerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Seller found = em.find(Seller.class, idToEdit);
		em.close();
		return found;
	}

	public List<Seller> showAllSellers() {
		EntityManager em = emfactory.createEntityManager();
		List<Seller> allItems = em.createQuery("SELECT i FROM Seller i").getResultList();
		return allItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
