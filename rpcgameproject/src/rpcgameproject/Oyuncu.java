package rpcgameproject;

import java.util.ArrayList;
import java.util.List;

public abstract class Oyuncu {

	public int oyuncuID;
	public String oyuncuAdi;
	public int skor;
	
	List<Nesneler> nesneListesi ; 			// oyuncuların elinde bulunan nesneler
	List<Nesneler> secilenNesneListesi ; 	// oyuncuların seçtikleri nesnelerin indexleri
	
	public static int currentid = 1;
	
	public Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {
		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
		this.skor = skor;
	}
	
	public Oyuncu(String isim) {
		this.oyuncuID = currentid;
		currentid++;
		this.oyuncuAdi = isim +this.oyuncuID;
		this.skor = 0;	
		
		this.nesneListesi = new ArrayList<Nesneler>();
		
		this.secilenNesneListesi = new ArrayList<Nesneler>(); 
		
	}

	public int getOyuncuID() {
		return oyuncuID;
	}

	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}

	public String getOyuncuAdi() {
		return oyuncuAdi;
	}

	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}

	public int getSkor() {
		return skor;
	}

	public void setSkor(int skor) {
		this.skor = skor;
	}
	
	
	
	public abstract void skorGoster();
	
	public abstract void nesneSec();

	protected abstract Nesneler listedenRandomSec();
}
