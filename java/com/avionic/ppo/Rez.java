package com.avionic.ppo;

public class Rez {
	private String Ln;
	private  String Lp;
	private String K;
	private String fullCode;
	private String kontur;
	
	public Rez(String fullCode, String Ln, String Lp, String K, String kontur) { 
		
	this.fullCode= fullCode;
	this.Ln=Ln;
	this.Lp=Lp;
	this.K=K;
	this.kontur=kontur;
	}
	
	public String getfullCode() {
        return this.fullCode;
    }

    public void setfullCode(String fullCode) {
        this.fullCode = fullCode;
    }
	public String getLn() {
        return this.Ln;
    }

    public void setLn(String Ln) {
        this.Ln = Ln;
    }
	public String getLp() {
        return this.Lp;
    }

    public void setLp(String Lp) {
        this.Lp = Lp;
    }
	public String getK() {
        return this.K;
    }

    public void setK(String K) {
        this.K = K;
    }
	public String getKontur() {
        return this.kontur;
    }

    public void setKontur(String K) {
        this.kontur = kontur;
    }
}
