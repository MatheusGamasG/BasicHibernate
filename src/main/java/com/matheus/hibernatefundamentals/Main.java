package com.matheus.hibernatefundamentals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import airport.Airport;
import airport.Passenger;
import airport.Ticket;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.matheus.hibernatefundamentals");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Airport airport = new Airport(1, "Afonso Pena");
		Passenger john = new Passenger(1, "John Smith");
		john.setAirport(airport);
		Passenger matheus = new Passenger(2, "Matheus Gamas");
		matheus.setAirport(airport);
		airport.setPassengers(matheus);
		airport.setPassengers(john);
		Ticket ticket1 = new Ticket(1, "AA1234");
		ticket1.setPassenger(john);
		Ticket ticket2 = new Ticket(2, "BB5678");
		ticket2.setPassenger(john);
		john.setTickets(ticket1);
		john.setTickets(ticket2);
		Ticket ticket3 = new Ticket(3, "CC9101");
		ticket3.setPassenger(matheus);
		matheus.setTickets(ticket3);
		
		em.persist(airport);
		em.persist(john);
		em.persist(matheus);
		em.persist(ticket1);
		em.persist(ticket2);
		em.persist(ticket3);
		
		em.getTransaction().commit();
		em.close();
	}

}
