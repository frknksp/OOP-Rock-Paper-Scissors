package rpcgameproject;


public class Kagıt extends Nesneler {


	public Kagıt(double dayaniklilik, double seviyepuani, double nufuz) {
		super();
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.nufuz = nufuz;
		this.nesnetipi = "kagıt";
	}
	
	public Kagıt() {
		super();
		this.nufuz = 2;
		this.nesnetipi = "kagıt";
	}
	
	
double a = 0.2;
	
	public void etkiHesapla(Nesneler n1) {
		if (this.nesnetipi == n1.nesnetipi) {
			int kagıt_etkisi = 1;
			this.durumGuncelle(kagıt_etkisi);
			n1.durumGuncelle(kagıt_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
		}
		
		else if ((this.nesnetipi == "ozelkagıt" && n1.nesnetipi == "kagıt")){
			int ozelkagıt_etkisi = 4;
			int kagıt_etkisi = 1;
			this.durumGuncelle(kagıt_etkisi);
			n1.durumGuncelle(ozelkagıt_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
			
			
		}
		else if ((this.nesnetipi == "kagıt" && n1.nesnetipi == "ozelkagıt")) {
			int ozelkagıt_etkisi = 4;
			int kagıt_etkisi = 1;
			this.durumGuncelle(ozelkagıt_etkisi);
			n1.durumGuncelle(kagıt_etkisi);
			this.seviyePuaniArttir(n1.getDayaniklilik());
			n1.seviyePuaniArttir(this.getDayaniklilik());
		}
		
		else {
			
			double makas_etkisi =  n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc) / 
					((a*this.nufuz*(this.kalinlik == 0 ? 1:this.kalinlik))+ (1-a)*n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik)) ;
			
			double kagıt_etkisi = this.nufuz*(this.kalinlik == 0 ? 1:this.kalinlik) / 
					((a*n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik))+ (1-a)*n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc)) ;
			
			double tas_etkisi = n1.katilik*(n1.sicaklik == 0 ? 1:n1.sicaklik) / 
					((a*n1.keskinlik*(n1.direnc == 0 ? 1:n1.direnc))+ (1-a)*this.nufuz*(this.kalinlik == 0 ? 1:this.kalinlik))  ;
		
		
		
		//this her zaman makas olduğu için diğer durum kontrolü
		if(makas_etkisi == 0) {
				this.durumGuncelle(tas_etkisi);
				n1.durumGuncelle(kagıt_etkisi);
				
		}
		if(tas_etkisi == 0) {
			this.durumGuncelle(makas_etkisi);
			n1.durumGuncelle(kagıt_etkisi);
		
		}
		this.seviyePuaniArttir(n1.getDayaniklilik());
		n1.seviyePuaniArttir(this.getDayaniklilik());
		
		
		}	
		
	}
	
	

}
