/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Oct 5, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SELLER")
public class Seller {
	
	@Id
	@GeneratedValue
	@Column(name="SELLERID")
	private int sellerId;
	
	@Column(name="HOUSEID")
	private int houseId;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;

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
	 * @return the houseId
	 */
	public int getHouseId() {
		return houseId;
	}

	/**
	 * @param houseId the houseId to set
	 */
	public void setHouseId(int houseId) {
		this.houseId = houseId;
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

	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", houseId=" + houseId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
	
}
