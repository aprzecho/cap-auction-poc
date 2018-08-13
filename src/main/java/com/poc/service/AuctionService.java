package com.poc.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.poc.dao.AuctionDAO;
import com.poc.model.Auction;

@ApplicationScoped
public class AuctionService {
	
	@Inject
	AuctionDAO auctionDAO;

	public List<Auction> getAuctions() {
		return auctionDAO.getAllAuctions();
	}
	
	public Auction findOne(Integer auctionId) {
		return auctionDAO.findOne(auctionId);
	}
	
}
