package rpcgameproject;

public class UstaMakas extends Makas{

	public UstaMakas(double dayaniklilik, double seviyepuani, double keskinlik, double direnc) {
		super();
		this.dayaniklilik = dayaniklilik;
		this.seviyepuani = seviyepuani;
		this.keskinlik = keskinlik;
		this.direnc = direnc;
		this.nesnetipi = "ustamakas";
	}

	public UstaMakas() {
		super();
		this.direnc = 2;
		this.nesnetipi = "ustamakas";
	}

	
}
