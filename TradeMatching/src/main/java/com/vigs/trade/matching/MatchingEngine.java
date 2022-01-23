package com.vigs.trade.matching;

import java.util.HashMap;

public class MatchingEngine implements TradeListener, Runnable{
	
	private HashMap<TradeKey, Trade> publicTrades = new HashMap<TradeKey, Trade>();
	private HashMap<TradeKey, Trade> privateTrades = new HashMap<TradeKey, Trade>();
	private HashMap<TradeKey, Trade> matchedTrades = new HashMap<TradeKey, Trade>();
	
	public MatchingEngine() {
	}
	
	public void start() {
		new PublicTradeStream(TradeType.PUBLIC, this);
		new PublicTradeStream(TradeType.PRIVATE, this);
	}
	
	public void onTrade(Trade trade) {
		TradeKey key = new TradeKey(trade.price, trade.tradeDateTime);
		if(trade.tradeType == TradeType.PUBLIC) {
			publicTrades.put(key, trade);
		}else if(trade.tradeType == TradeType.PRIVATE){
			privateTrades.put(key, trade);
			
			if(publicTrades.containsKey(trade.price)) {
				synchronized (matchedTrades) {
					matchedTrades.put(key, trade);					
				}
			}
		}
	}
	
	public void run() {
		while(true) {
			try {
				synchronized (matchedTrades) {
					System.out.println(matchedTrades);
					matchedTrades.clear();
				}
				Thread.sleep(2000);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]) {
		new MatchingEngine().start();
	}



}
