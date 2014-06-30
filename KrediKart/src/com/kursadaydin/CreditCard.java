package com.kursadaydin;

import java.awt.font.NumericShaper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CreditCard {
	
	private int kardNo;
	private static int musteriNo =0;
	private String sonKullanmaTarihi;
	private int cvcNo;
	private double kazanilanBonus;
	private double kalanBorc;
	//Kullanýlabilir limit 10000;
	private double kullanilabilirLimit;
	// kredi kartý son ödeme tarihi 30.07.2014
	private String sonOdemetarihi;
	
	private final String HESAP_KESIM_TARIHI = "25.07.2014";
	
	public static int getMusteriNo() {
		return musteriNo;
	}

	
	public int getKardNo() {
		return kardNo;
	}

	public void setKardNo(int kardNo) {
		this.kardNo = kardNo;
	}

	public String getSonKullanmaTarihi() {
		return sonKullanmaTarihi;
	}

	public void setSonKullanmaTarihi(String sonKullanmaTarihi) {
		this.sonKullanmaTarihi = sonKullanmaTarihi;
	}

	public int getCvcNo() {
		return cvcNo;
	}

	public void setCvcNo(int cvcNo) {
		this.cvcNo = cvcNo;
	}

	public double getKazanilanBonus() {
		return kazanilanBonus;
	}

	public void setKazanilanBonus(double kazanilanBonus) {
		this.kazanilanBonus = kazanilanBonus;
	}

	public double getKalanBorc() {
		return kalanBorc;
	}

	public void setKalanBorc(double kalanBorc) {
		this.kalanBorc = kalanBorc;
	}

	public double getKullanilabilirLimit() {
		return kullanilabilirLimit;
	}

	public void setKullanilabilirLimit(double kullanilabilirLimit) {
		this.kullanilabilirLimit = kullanilabilirLimit;
	}

	public String getSonOdemetarihi() {
		return sonOdemetarihi;
	}

	public void setSonOdemetarihi(String sonOdemetarihi) {
		this.sonOdemetarihi = sonOdemetarihi;
	}

	public String getHESAP_KESIM_TARIHI() {
		return HESAP_KESIM_TARIHI;
	}

	
	
	
	//Sadece kart ve müþteri numarasý ile nesne üretilen yapýcý....
	public CreditCard(int kardNo) {
		super();
		this.kardNo = kardNo;
		musteriNo++;
	}

	//Ýlgili private alanlarýnýn getter ve setter metodlarý.... 
	
	
	
	//Eðer cari borç tutarý ve yapýlan harcama tutarý 10.000 TL lik limitin üstündeyse hata veriyor.....
	public void harcamaYap(double tutar){
		
		if (getKalanBorc()+tutar<=10000) {
			
			setKalanBorc(getKalanBorc()+tutar);
			setKullanilabilirLimit(getKullanilabilirLimit()-tutar);
			bonusKazan(tutar);
		}
		else {
			System.out.println("Yapmýþ olduðunuz harcama ile toplam borcunuz Kart limiti olan 10.000 TL'nin üzerine çýkmaktadýr.");
			System.out.println("Yapýlan harcamaya izin verilmemektedir.");
		}
		
		
	}
	public void bonusKazan (double tutar) {
		// TODO Auto-generated method stub
		
		
			System.out.print("Lütfen iþlemi yaptýðýnýz kart türünü belirtiniz.....");
			System.out.println("(BONUS için 0'a, MAXIMILES için 1'e ve GOLD için 2'ye basýnýz.....)");
			Scanner sc = new Scanner(System.in);
			int kartTuru =sc.nextInt();
					
				
			if (kartTuru==TypeOfCard.BONUS.getIndexOfCards()) {
				setKazanilanBonus(getKazanilanBonus()+( tutar*TypeOfCard.BONUS.getPuan()));
				}
			else if  (kartTuru==TypeOfCard.MAXIMILES.getIndexOfCards()) {
				setKazanilanBonus(getKazanilanBonus()+( tutar*TypeOfCard.MAXIMILES.getPuan()));
				}
		
			else if (kartTuru==TypeOfCard.GOLD.getIndexOfCards()) {
				setKazanilanBonus(getKazanilanBonus()+( tutar*TypeOfCard.GOLD.getPuan()));
				}
			else {
				System.out.println("Yanlýþ bir giriþ yaptýnýz. Bonus puanýnýz hesaplanmadý..... ");
			}
			
			
		
	}
	// 
	public void borcOde (double tutar){
		// Ödeme yapýlan tutar borc tutarýndan fazla olamaz.....
						
		
		
		if (getKalanBorc()>=tutar) {
			setKalanBorc(getKalanBorc()-tutar);
			setKullanilabilirLimit(getKullanilabilirLimit()+tutar);
			//Kullanýlabilir limit 10.000 TL'yi geçemediði için minimum tutarý almaktadýr.
			Math.min(getKullanilabilirLimit(), 10000);
			System.out.println("Yapmýþ olduðunuz ödeme için teþekkür ederiz.");
			
						}
		else {
			System.out.println("Borcunuzdan fazla ödeme yapmaktasýnýz. Lütfen borcunuza göre ödeme yapýnýz....");
						
			}
			
		}
		
	
	
	public void hesapKesimTarihiniOtele(int gunsayisi){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
 
  
		try {
    	java.util.Date date =formatter.parse(HESAP_KESIM_TARIHI);
        
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	c.add(Calendar.DATE,gunsayisi);
    	//System.out.println(c.get(Calendar.DATE) +"." +(c.get(Calendar.MONTH)+1)+"." + c.get(Calendar.YEAR));
    	setSonOdemetarihi(c.get(Calendar.DATE) +"." +(c.get(Calendar.MONTH)+1)+"." + c.get(Calendar.YEAR));
             
		} catch (ParseException e) {
			e.getMessage();
			
			
 
	}

		
		
		
		
		
		
		
	}

	
	
	
	
	

}
