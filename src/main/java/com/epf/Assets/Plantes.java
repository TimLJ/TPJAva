package com.epf.Assets;

public class Plantes {
    private String nom;
    private int PV;
    private double APS;
    private int dmg_Atk;
    private int cout;
    private double SunPS;
    private String effet;
    private String chemin_image;

    public Plantes (String nom, int PV,double APS,int dmg_Atk, int cout, double SunPS, String effet, String chemin_image) {
        this.nom = nom;
        this.PV = PV;
        this.APS = APS;
        this.dmg_Atk = dmg_Atk;
        this.cout = cout;
        this.SunPS = SunPS;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    public Plantes() {
        //Constructeur vide
    }


    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getPV() {return PV;}
    public void setPV(int PV) {this.PV = PV;}

    public double getAPS() {return APS;}
    public void setAPS(double APS) {this.APS = APS;}

    public int getDmg_Atk() {return dmg_Atk;}
    public void setDmg_Atk(int Dmg_Atk) {this.dmg_Atk = Dmg_Atk;}

    public int getCout() {return cout;}
    public void setCout(int Ct) {this.cout = Ct;}

    public double getSunPS() {return SunPS;}
    public void setSunPS(double SPS) {this.SunPS = SPS;}

    public String getEffet() {return effet;}
    public void setEffet(String effet) {this.effet = effet;}

    public String getChemin_image() {return chemin_image;}
    public void setChemin_image(String chemin_image) {this.chemin_image = chemin_image;}




}
