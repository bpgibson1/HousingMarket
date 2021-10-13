package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.House;

/**
 * @author Thomas Syvertsen - tjsyvertsen
 * CIS175 - Fall 2021
 * Oct 12, 2021
 */
public class HouseHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("HousingMarket");
	
	public void insertHouse(House toInsert) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toInsert);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateHouse(House toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeHouse(House toRemove) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		House house = em.merge(toRemove);
		em.remove(house);
		em.getTransaction().commit();
		em.close();
	}
	
	public House searchForHouseById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		House found = em.find(House.class, id);
		em.close();
		return found;
	}
	
	public List<House> showAllHouses() {
		EntityManager em = emfactory.createEntityManager();
		List<House> allHouses = em.createQuery("SELECT i FROM House").getResultList();
		return allHouses;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
