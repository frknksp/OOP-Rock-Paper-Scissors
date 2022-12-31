package rpcgameproject;

import java.util.Random;

public class Bilgisayar extends Oyuncu {
	
	public Bilgisayar(int oyuncuID, String oyuncuAdi, int skor) {
		super(oyuncuID, oyuncuAdi, skor);
	}
	
	public Bilgisayar() {
		super("bilgisayar");	
	}

	
	
	Random randomGenerator = new Random();
	public void nesneSec() {
		
		for (int i = 0; i < 5; i++) {
			
			int rand = new Random().nextInt(3)+1;

			
			if (rand == 1) {		
				Nesneler t1 = new Tas();
				nesneListesi.add(t1);	
			}
			if (rand == 2) {
				Nesneler k1 = new Kagıt();	
				nesneListesi.add(k1);
			}
			if (rand == 3) {
				Nesneler m1 = new Makas();
				nesneListesi.add(m1);
			}
			
		}
	}
	

	@Override
	public void skorGoster() {
		// TODO Auto-generated method stub
		
	}
	
	public Nesneler listedenRandomSec() {
		/*if ( this.nesneListesi.size() == 0) {
			return -1;
		}*/
			Random randomizer = new Random();
			Nesneler randomnesne = this.nesneListesi.get(randomizer.nextInt(nesneListesi.size()));
			
			while (this.secilenNesneListesi.contains(randomnesne)) {
				 randomnesne = this.nesneListesi.get(randomizer.nextInt(nesneListesi.size()));
			}
				this.secilenNesneListesi.add(randomnesne);
				
				
		return 	randomnesne;	
	}
	
	
}
