package rpcgameproject;

public class OzelKagıt extends Kagıt{


	public OzelKagıt(double dayaniklilik, double seviyepuani ,double nufuz, double kalinlik) {
		super();
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.nufuz = nufuz;
		this.kalinlik = kalinlik;
		this.nesnetipi = "ozelkagıt";
	}

	public OzelKagıt() {
		super();
		this.kalinlik = 2;
		this.nesnetipi = "ozelkagıt";
	}
	
}
