package com.prasant.spring.app.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Component;

import com.prasant.spring.app.dao.OfferDAO;
import com.prasant.spring.app.model.Offer;

@Component
public class OfferImpl {
	
	@Autowired
	public OfferDAO offerDao;
	
	public void displayOffers() {
		try {
			List<Offer> offers = offerDao.getOffers();
			offers.forEach(offer -> System.out.println(offer));
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Database Connection error : " + e.getMessage());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayOffersByName(String name) {
		try {
			List<Offer> offers = offerDao.getOffersByName(name);
			offers.forEach(offer -> System.out.println("Sue -> " + offer));
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Database Connection error : " + e.getMessage());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteOffer(int id) {
		try {
			boolean result = offerDao.delete(id);
			if (result) {
				System.out.println("Record " + id + " deleted.");
			}
		} catch (CannotGetJdbcConnectionException e) {
			System.out.println("Database Connection error : " + e.getMessage());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createOffer(Offer offer) {
		try {
			if (offerDao.create(offer)) {
				System.out.println("Offer created successfully.");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateOffer(Offer offer) {
		try {
			if (offerDao.update(offer)) {
				System.out.println("Offer updated successfully.");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createOffers(List<Offer> offers) {
		try {
			int[] intArray = offerDao.createOffers(offers);
			System.out.println("\n\nPrinting result");
			for (int i : intArray)
				System.out.println(i);
			System.out.println("\n\n");
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
	public void testTransaction() {
		Offer o1 = new Offer("Dam", "dam@email.com", "Hululu");
		Offer o2 = new Offer(15, "Abc", "abc@email.com", "abc");
		offerDao.testTransactional(o1, o2);
	}

}
