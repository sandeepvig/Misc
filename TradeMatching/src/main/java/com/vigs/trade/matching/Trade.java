package com.vigs.trade.matching;

import java.util.Date;

public class Trade {
	
	
	public final int price;
	public final int size;
	public final TradeType tradeType;
	public final Date tradeDateTime;
	
	public Trade(int price, int size, TradeType tradeType, Date tradeDateTime) {
		this.price = price;
		this.size = size;
		this.tradeType = tradeType;
		this.tradeDateTime = tradeDateTime;
	}
	
	public String toString() {
		return "Trade[price: " + this.price + ", size: " + this.size + ", tradeType: " + this.tradeType
				+ ", tradeDateTime: " + this.tradeDateTime + "]";
	}
	
}
