package com.masai.GroceryStore;

import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Seller_table")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SID")
	private int sellerId;
	
	@Column(name="Seller_Name")
	private String sellerName;
	
	@Column(name="Seller_Experience")
	private int yearOfExperience;
	
	
	
	@Column(name="Seller_EmailAddress")
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "seller")
    private Set<Store> stores = new HashSet<>();

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Seller(String sellerName, int yearOfExperience, String email, Set<Store> stores) {
		super();
		this.sellerName = sellerName;
		this.yearOfExperience = yearOfExperience;
		this.email = email;
		this.stores = stores;
	}



	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	
}
