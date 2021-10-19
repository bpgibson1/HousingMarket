/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Oct 5, 2021
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SELLER")
public class Seller {
	
	@Id
	@GeneratedValue
	@Column(name="SELLERID")
	private int sellerId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<House> listOfHouses;
	
	

	/**
	 * 
	 */
	public Seller() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public Seller(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	

	/**
	 * @param firstName
	 * @param lastName
	 * @param listOfHouses
	 */
	public Seller(String firstName, String lastName, List<House> listOfHouses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.listOfHouses = listOfHouses;
	}

	/**
	 * @return the sellerId
	 */
	public int getSellerId() {
		return sellerId;
	}

	/**
	 * @param sellerId the sellerId to set
	 */
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<House> getListOfHouses() {
		return listOfHouses;
	}

	public void setListOfHouses(List<House> listOfHouses) {
		this.listOfHouses = listOfHouses;
	}

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", listOfHouses=" + listOfHouses + "]";
	}
	
}
