package com.vigs.trade.matching;

import java.util.Random;

public class PublicTradeStream extends TradeStream{

	private Random rand = new Random();
	
	public PublicTradeStream(TradeType tradeType, TradeListener tradeListener) {
		super(tradeType, tradeListener);
	}
	
	@Override
	protected int getRandomSize() {
		return rand.nextInt(2)*100;
	}

	@Override
	protected int getRandomPrice() {
		return rand.nextInt(5);
	}

}
