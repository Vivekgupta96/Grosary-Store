package com.masai.dao;

import com.masai.Exception.SellerException;
import com.masai.Exception.StoreException;
import com.masai.GroceryStore.Buyer;
import com.masai.GroceryStore.Seller;
import com.masai.GroceryStore.Store;

import java.util.List;
import java.util.Set;



import com.Connection.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.PersistenceException;

public class ShoppingDaoImpl implements ShoppingDao {

	// **********************************************************************************
	@Override
	public void addStoreDb(Store st) throws SellerException, StoreException {

		EntityManager em = EMUtils.getConnection();
		try {

			em.getTransaction().begin();
			em.persist(st);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			throw new StoreException("Error Happen Try letter");

		} finally {
			em.close();
		}

	}

	@Override
	public void addSellerDb(Seller st) throws SellerException, StoreException {

		EntityManager em = EMUtils.getConnection();
		try {

			em.getTransaction().begin();
			em.persist(st);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			throw new StoreException("Error Happen Try letter");

		} finally {
			em.close();
		}

	}

	@Override
	public void registerByerToStoreDb(Buyer by, int Storeid) throws SellerException, StoreException {
		EntityManager em = EMUtils.getConnection();

		try {
			em.getTransaction().begin();
			Store st = em.find(Store.class, Storeid);
			if (st != null) {
				st.getBuyers().add(by);
				by.getStores().add(st);
				em.persist(st);
				em.persist(by);

			} else {
				throw new StoreException("store not found");
			}
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			throw new StoreException("Error Happen Try letter");

		} finally {
			em.close();
		}

	}

	@Override
	public void assignSellerStoredb(int sellerId, int storeId) throws SellerException, StoreException {
		EntityManager em = EMUtils.getConnection();

		try {
			em.getTransaction().begin();
			Store st = em.find(Store.class, storeId);
			Seller se=em.find(Seller.class,sellerId);
			if(st==null) {
				throw new StoreException("store not found");
			}
			if(se==null) {
				throw new StoreException("seller not found");
			}
			st.setSeller(se);
			se.getStores().add(st);
			em.persist(se);
			em.getTransaction().commit();

		} catch (PersistenceException e) {
			throw new StoreException("Error Happen Try letter");

		} finally {
			em.close();
		}

	}

	@Override
	public Set<Buyer> buyerList(String storeName) throws SellerException, StoreException {
		Set<Buyer> rs=null;
		EntityManager em=null;
		try {
		 em = EMUtils.getConnection();
		
		String query="Select B.storeId from Store B where B.storeName=:n";
		Query qq=em.createQuery(query);
		qq.setParameter("n", storeName);
		
	    List<Integer> storeIds = qq.getResultList();
		if(storeIds.size()==0) {
			throw new StoreException("Store not found");
		}
		Store st = em.find(Store.class, storeIds.get(0));
		Set<Buyer> res=st.getBuyers();
		rs=res;
		}catch(PersistenceException e) {
			
		}
		finally {
			em.close();
		}
		
		return rs;
	}

}
