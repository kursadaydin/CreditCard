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
	//Kullan�labilir limit 10000;
	private double kullanilabilirLimit;
	// kredi kart� son �deme tarihi 30.07.2014
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

	
	
	
	//Sadece kart ve m��teri numaras� ile nesne �retilen yap�c�....
	public CreditCard(int kardNo) {
		super();
		this.kardNo = kardNo;
		musteriNo++;
	}

	//�lgili private alanlar�n�n getter ve setter metodlar�.... 
	
	
	
	//E�er cari bor� tutar� ve yap�lan harcama tutar� 10.000 TL lik limitin �st�ndeyse hata veriyor.....
	public void harcamaYap(double tutar){
		
		if (getKalanBorc()+tutar<=10000) {
			
			setKalanBorc(getKalanBorc()+tutar);
			setKullanilabilirLimit(getKullanilabilirLimit()-tutar);
			bonusKazan(tutar);
		}
		else {
			System.out.println("Yapm�� oldu�unuz harcama ile toplam borcunuz Kart limiti olan 10.000 TL'nin �zerine ��kmaktad�r.");
			System.out.println("Yap�lan harcamaya izin verilmemektedir.");
		}
		
		
	}
	public void bonusKazan (double tutar) {
		// TODO Auto-generated method stub
		
		
			System.out.print("L�tfen i�lemi yapt���n�z kart t�r�n� belirtiniz.....");
			System.out.println("(BONUS i�in 0'a, MAXIMILES i�in 1'e ve GOLD i�in 2'ye bas�n�z.....)");
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
				System.out.println("Yanl�� bir giri� yapt�n�z. Bonus puan�n�z hesaplanmad�..... ");
			}
			
			
		
	}
	// 
	public void borcOde (double tutar){
		// �deme yap�lan tutar borc tutar�ndan fazla olamaz.....
						
		
		
		if (getKalanBorc()>=tutar) {
			setKalanBorc(getKalanBorc()-tutar);
			setKullanilabilirLimit(getKullanilabilirLimit()+tutar);
			//Kullan�labilir limit 10.000 TL'yi ge�emedi�i i�in minimum tutar� almaktad�r.
			Math.min(getKullanilabilirLimit(), 10000);
			System.out.println("Yapm�� oldu�unuz �deme i�in te�ekk�r ederiz.");
			
						}
		else {
			System.out.println("Borcunuzdan fazla �deme yapmaktas�n�z. L�tfen borcunuza g�re �deme yap�n�z....");
						
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
