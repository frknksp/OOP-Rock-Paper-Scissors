package rpcgameproject;


public class Makas extends Nesneler {

	public Makas(double dayaniklilik, double seviyepuani, double keskinlik) {
		super();
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.keskinlik = keskinlik;
		this.nesnetipi = "makas";
	}
	
	public Makas() {
		super();
		this.keskinlik = 2;
		this.nesnetipi = "makas";
	}
	
double a = 0.2;
	
	public void etkiHesapla(Nesneler n1) {
		if (this.nesnetipi == n1.nesnetipi) {
			int makas_etkisi = 1;
			this.durumGuncelle(makas_etkisi);
			n1.durumGuncelle(makas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
		}
		else if ((this.nesnetipi == "ustamakas" && n1.nesnetipi == "makas")){
			int ustamakas_etkisi = 4;
			int makas_etkisi = 1;
			this.durumGuncelle(makas_etkisi);
			n1.durumGuncelle(ustamakas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
			
		}
		else if ((this.nesnetipi == "makas" && n1.nesnetipi == "ustamakas")) {
			int ustamakas_etkisi = 4;
			int makas_etkisi = 1;
			this.durumGuncelle(ustamakas_etkisi);
			n1.durumGuncelle(makas_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
		}
		
		
		
		else {
			
			double makas_etkisi =  this.keskinlik*(this.direnc == 0 ? 1:this.direnc) / 
					((a*n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik))+ (1-a)*n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik)) ;
			
			double kagıt_etkisi = n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik) / 
					((a*n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik))+ (1-a)*this.keskinlik*(this.direnc == 0 ? 1:this.direnc)) ;
			
			double tas_etkisi = n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik) / 
					((a*this.keskinlik*(this.direnc == 0 ? 1:this.direnc))+ (1-a)*n1.nufuz*(n1.kalinlik == 0 ? 1:n1.kalinlik))  ;
		
			
		//this her zaman makas olduğu için diğer durum kontrolü
		if(tas_etkisi == 0) {
				this.durumGuncelle(kagıt_etkisi);
				n1.durumGuncelle(makas_etkisi);
				
		}
		if(kagıt_etkisi == 0) {
			this.durumGuncelle(tas_etkisi);
			n1.durumGuncelle(makas_etkisi);
		
		}
		this.seviyePuaniArttir(n1.getDayaniklilik());
		n1.seviyePuaniArttir(this.getDayaniklilik());
		
		
		}
		
	}

	
}
