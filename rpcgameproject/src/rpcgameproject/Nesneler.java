package rpcgameproject;

public abstract class Nesneler {
	
	public double dayaniklilik;
	public double seviyepuani;
	public double katilik ;
	public double nufuz ;
	public double keskinlik ;
	public double sicaklik ;
	public double kalinlik ;
	public double direnc ;
	
	public String nesnetipi = "";

	
	public Nesneler(double dayaniklilik, double seviyepuani, double katilik, double nufuz, double keskinlik,
			double sicaklik, double kalinlik, double direnc, String nesnetipi) {
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.katilik = katilik;
		this.nufuz = nufuz;
		this.keskinlik = keskinlik;
		this.sicaklik = sicaklik;
		this.kalinlik = kalinlik;
		this.direnc = direnc;
		this.nesnetipi = nesnetipi;
	}
	
	public Nesneler() { 			// default constructor
		this.dayaniklilik = 20;
		this.seviyepuani = 0;	
	}

	public double getDayaniklilik() {
		return dayaniklilik;
	}

	public void setDayaniklilik(double dayaniklilik) {
		this.dayaniklilik = dayaniklilik;
	}

	public double getSeviyepuani() {
		return seviyepuani;
	}

	public void setSeviyepuani(double seviyepuani) {
		this.seviyepuani = seviyepuani;
	}

	public double getKatilik() {
		return katilik;
	}

	public void setKatilik(double katilik) {
		this.katilik = katilik;
	}

	public double getNufuz() {
		return nufuz;
	}

	public void setNufuz(double nufuz) {
		this.nufuz = nufuz;
	}

	public double getKeskinlik() {
		return keskinlik;
	}

	public void setKeskinlik(double keskinlik) {
		this.keskinlik = keskinlik;
	}

	public double getSicaklik() {
		return sicaklik;
	}

	public void setSicaklik(double sicaklik) {
		this.sicaklik = sicaklik;
	}

	public double getKalinlik() {
		return kalinlik;
	}

	public void setKalinlik(double kalinlik) {
		this.kalinlik = kalinlik;
	}

	public double getDirenc() {
		return direnc;
	}

	public void setDirenc(double direnc) {
		this.direnc = direnc;
	}

	public String getNesnetipi() {
		return nesnetipi;
	}

	public void setNesnetipi(String nesnetipi) {
		this.nesnetipi = nesnetipi;
	}
	
	
	
	public String nesnePuaniGoster() {
		return "Dayaniklilik: " + dayaniklilik + " Seviye Puani: " + seviyepuani;
	}
	
	public void durumGuncelle(double etki) {
		
		this.setDayaniklilik(this.getDayaniklilik() - etki);
		
	}
	
	public void seviyePuaniArttir(double rakipdayaniklilik) {
		if (rakipdayaniklilik <= 0 && this.getDayaniklilik() > 0) {
			this.setSeviyepuani(this.getSeviyepuani()+20);
		}
		
	}
	
	protected abstract void etkiHesapla(Nesneler n1);
	
}
