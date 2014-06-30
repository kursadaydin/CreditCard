package com.kursadaydin;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		CreditCard musteri1 = new CreditCard(1245);
		//set metodlarý;
		musteri1.setCvcNo(123);
		musteri1.setKalanBorc(2850);
		musteri1.setKazanilanBonus(200);
		musteri1.setKullanilabilirLimit(10000);
		musteri1.setSonKullanmaTarihi("30.08.2016");
		//get metodlarý;
		System.out.println("1. müþterinin numarasý :" + CreditCard.getMusteriNo());
		System.out.println("1  müþterinin kart Numarasý : " + musteri1.getKardNo()  );
		System.out.println("1. müþterinin CVC  Numarasý :" + musteri1.getCvcNo() );
		System.out.println("1. müþterinin hesap kesim tarihi :" + musteri1.getHESAP_KESIM_TARIHI() );
		System.out.println("1. müþterinin kartýný son kullanma tarihi :" + musteri1.getSonKullanmaTarihi() );
		System.out.println("1. müþterinin kart extresini son ödeme tarihi :" + musteri1.getSonOdemetarihi() );
		System.out.println("1. müþterinin kazandýðý bonus puanlarý :" + musteri1.getKazanilanBonus() );
		System.out.println("1. müþterinin kullanabilir limiti :" + musteri1.getKullanilabilirLimit() );
		System.out.println("-------------------------------------------------------------------");
		
		
		//Yapýlan harcama sonrasý puan kazanma ve kullanýlabilir limitin yeniden belirlenmesi.....
		musteri1.harcamaYap(3000);
		System.out.println("Harcama sonrasý kullanýlabilir limit : "+musteri1.getKullanilabilirLimit());
		System.out.println("Harcama sonrasý toplam puan :" + musteri1.getKazanilanBonus());
		
		System.out.println("-------------------------------------------------------------------");
		//Yapýlan harcama sonrasý puan kazanma ve kullanýlabilir limitin yeniden belirlenmesi.....
		musteri1.borcOde(2000);
		System.out.println("Ödeme sonrasý kullanýlabilir limit : "+musteri1.getKullanilabilirLimit());
		System.out.println("Ödeme sonrasý kullanýlabilir limitiniz :" + musteri1.getKullanilabilirLimit());
		System.out.println("-------------------------------------------------------------------");
		
		
		//Müþterinin borç ödeme tarihine 5 gün ilave ediliyor.
		System.out.println("Borcunu son ödeme tarihi :" + musteri1.getHESAP_KESIM_TARIHI());
		musteri1.hesapKesimTarihiniOtele(15);
		System.out.println("5 gün ekleme neticesinde borcunu ödeyeceði son tarih  " + musteri1.getSonOdemetarihi()+ " olarak hesaplanmýþtýr.");
		
		
		
		
		
		
		
	}
}
