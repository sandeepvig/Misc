package com.vigs.trade.matching;

import java.time.Instant;
import java.util.Date;

public abstract class TradeStream implements Runnable{
	
	private TradeType tradeType;
	private TradeListener tradeListener;
	
	public TradeStream(TradeType tradeType, TradeListener tradeListener) {
		this.tradeType = tradeType;
		this.tradeListener = tradeListener;
		
		Thread t = new Thread(this, tradeType+"-Thread");
		t.start();
	}
	
	public void run() {
		while(true){
			try {
				Trade trade = new Trade(getRandomPrice(), getRandomSize(), this.tradeType, Date.from(Instant.now()));
				tradeListener.onTrade(trade);
				System.out.println(trade);
				Thread.sleep(100);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	protected abstract int getRandomSize();
	
	protected abstract int getRandomPrice();

}
