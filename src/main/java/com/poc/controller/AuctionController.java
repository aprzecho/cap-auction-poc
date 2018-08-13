package com.poc.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import com.poc.dao.AuctionDAO;
import com.poc.model.Auction;
import com.poc.service.AuctionService;

@ViewScoped
@Named
public class AuctionController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(AuctionController.class.getName());

	private static final long serialVersionUID = 1L;

	@Inject
	private AuctionService auctionService;
	
	@Inject
	private AuctionDAO auctionDAO;	
	
	@Inject @Push(channel="auctionChannel")
	private PushContext auctionChannel;	

	private Auction auction;

	private Integer paramAuctionId;
	
	private Integer nextBid;

	@PostConstruct
	private void init() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		paramAuctionId = Integer.parseInt(params.get("paramAuctionId"));

		auction = auctionService.findOne(paramAuctionId);
		
		LOGGER.info("AuctionController initiated for auctionId=" + auction.getId());
	}
	
	public void changeBid(ActionEvent actionEvent) {		
		LOGGER.info("Bid changed: " + nextBid);
		
		Map<String, Object> message = new HashMap<>();
		message.put("auctionId", auction.getId());
		message.put("nextBid", nextBid);
		
		auctionChannel.send(message);
		
		auction.setCurrentBid(nextBid);
		auctionDAO.update(auction);
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Integer getNextBid() {
		return nextBid;
	}

	public void setNextBid(Integer nextBid) {
		this.nextBid = nextBid;
	}
	
}
