package com.prasant.spring.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prasant.spring.app.beans.Test;
import com.prasant.spring.app.config.AppConfig;
import com.prasant.spring.app.dao.OfferDAO;
import com.prasant.spring.app.impl.OfferImpl;
import com.prasant.spring.app.model.Offer;

public class App {

	public static void main(String[] args) {
		//ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);		
		ApplicationContext context = new ClassPathXmlApplicationContext("xml/beans.xml");
		
		OfferImpl impl =  (OfferImpl) context.getBean("offerImpl");
		
		/*Offer offer = new Offer(6, "Hanumaan", "hanumaan@gods.com", "I love flying");
		impl.updateOffer(offer);*/
		
		//CREATE OFFER
		//impl.createOffer(createOfferObj());
		
		// DELETE OFFER
		//impl.deleteOffer(4);
		
		/*List<Offer> offers = new ArrayList<>();
		offers.add(new Offer("Abc", "abc@email.com", "abc"));
		offers.add(new Offer("Pqr", "pqr@email.com", "pqr"));
		offers.add(new Offer("Xyz", "xyz@email.com", "xyz"));
		impl.createOffers(offers);*/
		
		impl.testTransaction();
		impl.displayOffers();
		
		//DISPALY OFFER BY NAME
		//impl.displayOffersByName("Sue");
		
		
		//((AnnotationConfigApplicationContext)context).close();
		((ClassPathXmlApplicationContext)context).close();		
	}
	
	public static Offer createOfferObj() {
		return new Offer("Shaktimaan", "shaktimaan@gita.com", "I wanna rock with somebody");
	}

}
