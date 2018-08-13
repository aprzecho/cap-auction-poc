package com.poc.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.poc.model.Auction;

@ApplicationScoped
public class AuctionDAO {

	@PersistenceContext(unitName="kghmPocPU")
	private EntityManager em;

	public List<Auction> getAllAuctions() {
		return em.createQuery("SELECT a FROM Auction a", Auction.class).getResultList();
	}

	public Auction findOne(int auctionId) {
		return em.find(Auction.class, auctionId);
	}
	
	@Transactional
	public void update(Auction auction) {
		em.merge(auction);
	}
}
