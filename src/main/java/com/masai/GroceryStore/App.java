package com.masai.GroceryStore;

import java.util.Scanner;
import java.util.*;

import com.masai.Exception.SellerException;
import com.masai.Exception.StoreException;
import com.masai.dao.*;

public class App {


	private static void ListOfBuyersByStoreName(Scanner sc) {
		System.out.println("Enter Store Name");
		String storeName=sc.next();
		ShoppingDao sdao=new ShoppingDaoImpl();
		try {
			Set<Buyer> res=sdao.buyerList(storeName);
			System.out.println("Buyer List");
			
			for(Buyer bb:res) {
				System.out.println(bb.getName());
			}
		} catch (SellerException |StoreException e) {
			e.printStackTrace();
		} 
	}

	private static void assignSellerStore(Scanner sc) {
		System.out.println("Enter storeId");
		int storeId=sc.nextInt();
		
		System.out.println("Enter Seller Id");
		int sellerId=sc.nextInt();
		
		

		ShoppingDao sdao=new ShoppingDaoImpl();
		
		try {
			sdao.assignSellerStoredb(sellerId,storeId);
			System.out.println("sellerassigned to store Succesfully");
		} catch (SellerException |StoreException e) {
			e.printStackTrace();
		} 

	}

	private static void registerBuyerUsingStoreId(Scanner sc) {
		System.out.println("Enter Buyer Name");
		String BuyerName=sc.next();
		
		System.out.println("Enter Buyer Email");
		String BuyerEmail=sc.next();
		
		System.out.println("Enter Buyer Mobile Number");
		Long BuyerMobile=sc.nextLong();
		
		System.out.println("Enter storeId");
		int storeId=sc.nextInt();
		
		Buyer by=new Buyer();
		by.setName(BuyerName);
		by.setEmail(BuyerEmail);
		by.setMobileNo(BuyerMobile);
		

		ShoppingDao sdao=new ShoppingDaoImpl();
		
		try {
			sdao.registerByerToStoreDb(by,storeId);
			System.out.println("Seller Added Succesfully");
		} catch (SellerException |StoreException e) {
			e.printStackTrace();
		} 


	}

	private static void registerSeller(Scanner sc) {
		System.out.println("Enter Seller Name");
		String SellerName=sc.next();
		
		System.out.println("Enter Seller Experience");
		int sellerExper=sc.nextInt();
		
		
		System.out.println("Enter seller Email");
		String sellerEmail=sc.next();
		
		Seller st=new Seller();
		st.setSellerName(SellerName);
		st.setYearOfExperience(sellerExper);
		st.setEmail(sellerEmail);
		
		
		ShoppingDao sdao=new ShoppingDaoImpl();
		
		try {
			sdao.addSellerDb(st);
			System.out.println("Seller Added Succesfully");
		} catch (SellerException |StoreException e) {
			e.printStackTrace();
		} 


	}

	private static void AddStore(Scanner sc) {
		
		System.out.println("Enter Store Name");
		String storeName=sc.next();
		System.out.println("Enter Store Location");
		String StoreLocation=sc.next();
		
		Store st=new Store();
		st.setStoreName(storeName);
		st.setLocation(StoreLocation);
		
		ShoppingDao sdao=new ShoppingDaoImpl();
		
		try {
			sdao.addStoreDb(st);
			System.out.println("Seller Added Succesfully");
		} catch (SellerException |StoreException e) {
			e.printStackTrace();
		} 
	}
	
	
	//**********************************************************************************
	private static void menu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("1  :Add Store");
		System.out.println("2  :Register Seller");
		System.out.println("3  :Register Buyer TO STORE Using StoreId");
		System.out.println("4  :Assign Seller to  Store");
		System.out.println("5  :List Of Buyers By Store Name");
		System.out.println("6  :Exit from System");
		int choice = -1;
		choice=sc.nextInt();

		switch (choice) {
		case 1:
			AddStore(sc);
			menu();
			break;
		case 2:
			registerSeller(sc);
			menu();
			break;
		case 3:
			registerBuyerUsingStoreId(sc);
			menu();
			break;
		case 4:
			assignSellerStore(sc);
			menu();
			break;
		case 5:
			ListOfBuyersByStoreName(sc);
			menu();
			break;

		case 6:
			System.out.println("thanks you");
			break;

		default:
			System.out.println("Invalid Input Selection, Please Select the Valid Input");
			System.out.println("------------------------------------------------------");
			menu();

		}

	}
	//**********************************************************************************
	public static void main(String[] args) {
		System.out.println("-----------------------------------");
		System.out.println("Welcomr to Grocery store");
		System.out.println("-----------------------------------");
		menu();

	}

}
