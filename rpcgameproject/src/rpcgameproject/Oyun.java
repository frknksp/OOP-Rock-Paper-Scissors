package rpcgameproject;


import java.util.Scanner;

public class Oyun {

	public static void main(String[] args) {
		
		int maxtursayisi = 100;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1- Bilgisayar vs Kullanıcı");
		System.out.println("2- Bilgisayar vs Bilgisayar");
		System.out.print("Secim yapınız (1 veya 2): ");
		int modsecim = scanner.nextInt();

		switch (modsecim) {
		case 1: {
			
			Bilgisayar b1 = new Bilgisayar();
			Kullanici k1 = new Kullanici();
			b1.nesneSec();
			k1.nesneSec();
			savas(b1, k1, maxtursayisi);
			break;
		}
		case 2: {
			
			Bilgisayar b1 = new Bilgisayar();
			Bilgisayar b2 = new Bilgisayar();
			b1.nesneSec();
			b2.nesneSec();
			savas(b1, b2, maxtursayisi);
			break;
		}
		default:
			System.out.println("Hatalı secim");;
		}
		

		
	}
	
	static void savas(Oyuncu o1, Oyuncu o2, int maxtursayisi) {
		for(Nesneler nesneturu: o1.nesneListesi) {
			System.out.print(nesneturu.nesnetipi+" ");
		}
		System.out.println();
		for(Nesneler nesneturu: o2.nesneListesi) {
			System.out.print(nesneturu.nesnetipi+" ");
		}
		System.out.println();  
		//System.out.println(o1.nesneListesi);
		//System.out.println(o2.nesneListesi);
		int tursayisi = 0;
		
		while(tursayisi <= maxtursayisi) {
				System.out.println("****************************** " +tursayisi + ". tur ******************************");
				
				
				if (o1.nesneListesi.size() == 0 ) {
					System.out.println("oyuncu 1 kazandı");
					break;
				}
				if (o2.nesneListesi.size() == 0 ) {
					System.out.println("Oyuncu 2 kazandı");
					break;
				}
				
				if (tursayisi == maxtursayisi) {
					int b1toplamdayaniklilik = 0;
					int b2toplamdayaniklilik = 0;
					for (int i = 0; i < o1.nesneListesi.size(); i++) {
						b1toplamdayaniklilik += o1.nesneListesi.get(i).getDayaniklilik();
					}
					for (int i = 0; i < o2.nesneListesi.size(); i++) {
						b2toplamdayaniklilik += o2.nesneListesi.get(i).getDayaniklilik();
					}
					if (b1toplamdayaniklilik > b2toplamdayaniklilik) {
						System.out.println("oyuncu 1 kazandi");
						break;
						
					}
					else {
						System.out.println("Oyuncu 2 kazandi");
						break;
					}
				}
			
				Nesneler b1secilen = o1.listedenRandomSec();
			
				Nesneler b2secilen = o2.listedenRandomSec();
				
		
				b1secilen.etkiHesapla(b2secilen);
				//System.out.println("------------------------------------------------------------------");
				System.out.println("oyuncu 1) " + b1secilen.nesnetipi+" -> "+b1secilen.nesnePuaniGoster());
				System.out.println("Oyuncu 2) " + b2secilen.nesnetipi+" -> "+b2secilen.nesnePuaniGoster());
				//System.out.println("------------------------------------------------------------------");

				if (b1secilen.getDayaniklilik() <= 0) {
					
					
					//System.out.println("o1'den kırılan nesne listeden çıkarıldı "+ b1secilen.nesnetipi + " vs "+b2secilen.nesnetipi);
					
					o1.nesneListesi.remove(b1secilen);
					o1.secilenNesneListesi.remove(b1secilen);
					//System.out.println("Yeni nesne listesi " +o1.nesneListesi);
					
				}
				if (b2secilen.getDayaniklilik() <= 0) {
					
					
					//System.out.println("o2'den kırılan nesne listeden çıkarıldı "+ b1secilen.nesnetipi + " vs "+b2secilen.nesnetipi);
					o2.nesneListesi.remove(b2secilen);
					o1.secilenNesneListesi.remove(b2secilen);
					//System.out.println("Yeni nesne listesi "+ o2.nesneListesi);
					
				}
				
				
				if (b1secilen.getSeviyepuani() > 30 && (b1secilen.nesnetipi == "makas" || b1secilen.nesnetipi == "kagıt" || b1secilen.nesnetipi == "tas" )) {
					//System.out.println("");
					//System.out.println("seviye puanı 30+ terfi edildi");
					//System.out.println(o1.nesneListesi);
					
					if (b1secilen.nesnetipi == "tas") {
						Nesneler agır1 = new AgırTas();
						o1.nesneListesi.add(agır1);

					}
					if (b1secilen.nesnetipi == "kagıt") {
						Nesneler ozel1 = new OzelKagıt();
						o1.nesneListesi.add(ozel1);

						
					}
					if (b1secilen.nesnetipi == "makas") {
						Nesneler usta1 = new UstaMakas();
						o1.nesneListesi.add(usta1);

					}
					
						o1.nesneListesi.remove(b1secilen);


					
				}
				if (b2secilen.getSeviyepuani() > 30 && (b2secilen.nesnetipi == "makas" || b2secilen.nesnetipi == "kagıt" || b2secilen.nesnetipi == "tas" )) {
					//System.out.println("");
					//System.out.println("seviye puanı 30+ terfi edildi");
					//System.out.println(o2.nesneListesi);
					
					if (b2secilen.nesnetipi == "tas") {
						Nesneler agır1 = new AgırTas();
						o2.nesneListesi.add(agır1);

					}
					if (b2secilen.nesnetipi == "kagıt") {
						Nesneler ozel1 = new OzelKagıt();
						o2.nesneListesi.add(ozel1);

						
					}
					if (b2secilen.nesnetipi == "makas") {
						Nesneler usta1 = new UstaMakas();
						o2.nesneListesi.add(usta1);

					}
					
						o1.nesneListesi.remove(b2secilen);       
					
				}
				
				
					
				if (o1.secilenNesneListesi.size() >= o1.nesneListesi.size() ) {
					o1.secilenNesneListesi.clear();
					//System.out.println("o1 secilen nesne indexleri listesi sıfırlandı");

				}
				if (o2.secilenNesneListesi.size() >= o2.nesneListesi.size()) {
					o2.secilenNesneListesi.clear();
					//System.out.println("o2 secilen nesne indexleri listesi sıfırlandı");
				} 
			
				tursayisi++;
				
		}
		
	}

	
}


