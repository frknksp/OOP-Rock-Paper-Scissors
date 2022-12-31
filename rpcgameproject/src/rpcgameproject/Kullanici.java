package rpcgameproject;


import java.util.Scanner;

public class Kullanici extends Oyuncu{

	public Kullanici(int oyuncuID, String oyuncuAdi, int skor) {
		super(oyuncuID, oyuncuAdi, skor);
	}

	public Kullanici() {
		super("Kullanici");
	}

	@Override
	
	public void skorGoster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nesneSec() {
		Scanner myObj = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
		
		System.out.print("secim giriniz 1-tas, 2-kagıt, 3-makas");
		boolean CorrectInput = true;
		int secim = myObj.nextInt();
		while(CorrectInput)
		{
			
		      if(secim < 1 || secim > 3)
		      {
		           System.out.println("\nYanlıs giris. Lutfen 1 ve 3 arasında sayi giriniz");
		           secim = myObj.nextInt();    
		      }
		      else
		    	  CorrectInput = false;
		      if (secim == 1) {
					Nesneler t1 = new Tas();	
					nesneListesi.add(t1);
				}
				if (secim == 2) {
					Nesneler k1 = new Kagıt();	
					nesneListesi.add(k1);
				}
				if (secim == 3) {
					Nesneler m1 = new Makas();
					nesneListesi.add(m1);
				}
		 }
		}
		
	
	}
	
	public Nesneler listedenRandomSec() {
		/*if ( this.nesneListesi.size() == 0) {
			return -1;
		}*/
		boolean CorrectInputsecim = true;
		Scanner myObj = new Scanner(System.in);
		
		//System.out.println("secilebilecek objeler: " +this.nesneListesi);
		System.out.println("Secilebilecek nesneler:  (yanında bulunan sayıyı giriniz)");
		/*for(Nesneler nesneturu: this.nesneListesi) {
			System.out.print(nesneturu.nesnetipi+" ");
		}*/
		for (int i = 0; i < this.nesneListesi.size(); i++) {
			System.out.print(Integer.toString(i) + "-"+ this.nesneListesi.get(i).nesnetipi + " ");
		}
		
			Nesneler nesnesecimi = this.nesneListesi.get(myObj.nextInt());
			while (this.secilenNesneListesi.contains(nesnesecimi)) {
				
				 //System.out.println("secilebilecek objeler: " +this.nesneListesi);
				System.out.println("aynı nesne tekrardan secilemez");
				System.out.println("Secilebilecek nesneler:  (yanında bulunan sayıyı giriniz)");
				for (int i = 0; i < this.nesneListesi.size(); i++) {
					System.out.print(Integer.toString(i) + "-"+ this.nesneListesi.get(i).nesnetipi + " ");
				}
				 
				 nesnesecimi = this.nesneListesi.get(myObj.nextInt());
				
			}
				this.secilenNesneListesi.add(nesnesecimi);
				
		return 	nesnesecimi;	
	}
	
	

	
}
