package com.kursadaydin;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		CreditCard musteri1 = new CreditCard(1245);
		//set metodlar�;
		musteri1.setCvcNo(123);
		musteri1.setKalanBorc(2850);
		musteri1.setKazanilanBonus(200);
		musteri1.setKullanilabilirLimit(10000);
		musteri1.setSonKullanmaTarihi("30.08.2016");
		//get metodlar�;
		System.out.println("1. m��terinin numaras� :" + CreditCard.getMusteriNo());
		System.out.println("1  m��terinin kart Numaras� : " + musteri1.getKardNo()  );
		System.out.println("1. m��terinin CVC  Numaras� :" + musteri1.getCvcNo() );
		System.out.println("1. m��terinin hesap kesim tarihi :" + musteri1.getHESAP_KESIM_TARIHI() );
		System.out.println("1. m��terinin kart�n� son kullanma tarihi :" + musteri1.getSonKullanmaTarihi() );
		System.out.println("1. m��terinin kart extresini son �deme tarihi :" + musteri1.getSonOdemetarihi() );
		System.out.println("1. m��terinin kazand��� bonus puanlar� :" + musteri1.getKazanilanBonus() );
		System.out.println("1. m��terinin kullanabilir limiti :" + musteri1.getKullanilabilirLimit() );
		System.out.println("-------------------------------------------------------------------");
		
		
		//Yap�lan harcama sonras� puan kazanma ve kullan�labilir limitin yeniden belirlenmesi.....
		musteri1.harcamaYap(3000);
		System.out.println("Harcama sonras� kullan�labilir limit : "+musteri1.getKullanilabilirLimit());
		System.out.println("Harcama sonras� toplam puan :" + musteri1.getKazanilanBonus());
		
		System.out.println("-------------------------------------------------------------------");
		//Yap�lan harcama sonras� puan kazanma ve kullan�labilir limitin yeniden belirlenmesi.....
		musteri1.borcOde(2000);
		System.out.println("�deme sonras� kullan�labilir limit : "+musteri1.getKullanilabilirLimit());
		System.out.println("�deme sonras� kullan�labilir limitiniz :" + musteri1.getKullanilabilirLimit());
		System.out.println("-------------------------------------------------------------------");
		
		
		//M��terinin bor� �deme tarihine 5 g�n ilave ediliyor.
		System.out.println("Borcunu son �deme tarihi :" + musteri1.getHESAP_KESIM_TARIHI());
		musteri1.hesapKesimTarihiniOtele(15);
		System.out.println("5 g�n ekleme neticesinde borcunu �deyece�i son tarih  " + musteri1.getSonOdemetarihi()+ " olarak hesaplanm��t�r.");
		
		
		
		
		
		
		
	}
}
