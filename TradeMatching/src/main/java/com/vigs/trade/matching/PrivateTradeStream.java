package com.vigs.trade.matching;

import java.util.Random;

public class PrivateTradeStream extends TradeStream{
	
	private Random rand = new Random();
	
	public PrivateTradeStream(TradeType tradeType, TradeListener tradeListener) {
		super(tradeType, tradeListener);
	}
	
	@Override
	protected int getRandomSize() {
		return rand.nextInt(2)*10;
	}

	@Override
	protected int getRandomPrice() {
		return rand.nextInt(5);
	}
}
