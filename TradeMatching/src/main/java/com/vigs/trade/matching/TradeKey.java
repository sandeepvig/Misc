package com.vigs.trade.matching;

import java.util.Date;

public class TradeKey {
	public final int price;
	public final Date tradeDateTime;
	
	public TradeKey(int price, Date tradeDateTime) {
		this.price = price;
		this.tradeDateTime = tradeDateTime;
	}
}
