package com.kursadaydin;

public enum TypeOfCard {
	BONUS ("Bonus",0,0.01),
	MAXIMILES("MaxiMiles",1,0.02),
	GOLD("Gold",2,0.015);
	
	private String cardNames;
	private int IndexOfCards;
	private double puan;

	
	private TypeOfCard(String cardNames, int indexOfCards, double puan) {
		this.cardNames = cardNames;
		IndexOfCards = indexOfCards;
		this.puan = puan;
	}



	public int getIndexOfCards() {
		return IndexOfCards;
	}



	public double getPuan() {
		return puan;
	}



	public String getCardNames() {
		return cardNames;
	}
	
	
	
	

}
