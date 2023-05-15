package com.masai.dao;

import java.util.Set;

import com.masai.Exception.SellerException;
import com.masai.Exception.StoreException;
import com.masai.GroceryStore.Buyer;
import com.masai.GroceryStore.Seller;
import com.masai.GroceryStore.Store;

public interface ShoppingDao {

	void addStoreDb(Store st) throws SellerException,StoreException;

	void addSellerDb(Seller st)throws SellerException,StoreException;

	void registerByerToStoreDb(Buyer by, int storeId)throws SellerException,StoreException;

	void assignSellerStoredb(int sellerId, int storeId)throws SellerException,StoreException;

	Set<Buyer> buyerList(String storeName)throws SellerException,StoreException;

}
