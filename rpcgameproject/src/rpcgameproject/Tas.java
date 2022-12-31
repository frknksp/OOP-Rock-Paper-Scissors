package rpcgameproject;


public class Tas extends Nesneler {

	public Tas(double dayaniklilik, double seviyepuani, double katilik) {
		super();
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.katilik = katilik;
		this.nesnetipi = "tas";
	}
	
	public Tas() {
		super();
		this.katilik = 2;
		this.nesnetipi = "tas";
	}
	
double a = 0.2;
	
	public void etkiHesapla(Nesneler n1) {
		
		if (this.nesnetipi == n1.nesnetipi) {
			int tas_etkisi = 1;
			this.durumGuncelle(tas_etkisi);
			n1.durumGuncelle(tas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
		}
		else if ((this.nesnetipi == "agırtas" && n1.nesnetipi == "tas")){
			int agırtas_etkisi = 4;
			int tas_etkisi = 1;
			this.durumGuncelle(tas_etkisi);
			n1.durumGuncelle(agırtas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
			
		}
		else if ((this.nesnetipi == "tas" && n1.nesnetipi == "agırtas")) {
			int agırtas_etkisi = 4;
			int tas_etkisi = 1;
			this.durumGuncelle(agırtas_etkisi);
			n1.durumGuncelle(tas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
		}
		
		else {
			
		double makas_etkisi =  n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc) / 
				((a*n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik))+ (1-a)*this.katilik*(this.sicaklik == 0 ? 1:this.sicaklik)) ;
		
		double kagıt_etkisi = n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik) / 
				((a*this.katilik*(this.sicaklik == 0 ? 1:this.sicaklik))+ (1-a)*n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc)) ;
		
		double tas_etkisi = this.katilik*(this.sicaklik == 0 ? 1:this.sicaklik) / 
				((a*n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc))+ (1-a)*n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik))  ;
		
		
		//this her zaman taş olduğu için diğer durum kontrolü
		if(makas_etkisi == 0) {
				this.durumGuncelle(kagıt_etkisi);
				n1.durumGuncelle(tas_etkisi);
				
		}
		if(kagıt_etkisi == 0) {
			this.durumGuncelle(makas_etkisi);
			n1.durumGuncelle(tas_etkisi);
		
		}
		this.seviyePuaniArttir(n1.getDayaniklilik());
		n1.seviyePuaniArttir(this.getDayaniklilik());
		
		
		}
		
	
		
	}
	
	
	
}
