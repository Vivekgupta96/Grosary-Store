package com.masai.GroceryStore;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buyer_Table")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BID")
	private int buyerId;

	@Column(name = "Buyer_Name")
	private String Name;

	@Column(name = "Buyer_Email")
	private String email;

	@Column(name = "Buyer_MobileNo")
	private long mobileNo;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Store> stores = new HashSet<>();

	public Buyer(String name, String email, long mobileNo, Set<Store> stores) {
		super();
		Name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.stores = stores;
	}


	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Set<Store> getStores() {
		return stores;
	}


	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}


	@Override
	public String toString() {
		return String.format("Buyer [buyerId=%s, Name=%s, email=%s, mobileNo=%s, stores=%s]", buyerId, Name, email,
				mobileNo, stores);
	}

	// constructors, getters and setters

	
	
	
}
