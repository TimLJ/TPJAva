package com.epf.Assets;

public class Plantes {
    private String nom;
    private int PV;
    private int APS;
    private int dmg_Atk;
    private int cout;
    private int SunPS;
    private String effet;
    private String chemin_image;

    public Plantes (String nom, int PV,int APS,int dmg_Atk, int cout, int SunPS, String effet, String chemin_image) {
        this.nom = nom;
        this.PV = PV;
        this.APS = APS;
        this.dmg_Atk = dmg_Atk;
        this.cout = cout;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    public Plantes() {

    }


    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    public int getPV() {return PV;}
    public void setPV(int PV) {this.PV = PV;}

    public int getAPS() {return APS;}
    public void setAPS(int APS) {this.APS = APS;}

    public int getDmg_Atk() {return dmg_Atk;}
    public void setDmg_Atk() {this.dmg_Atk = dmg_Atk;}

    public int getCout() {return cout;}
    public void setCout() {this.cout = cout;}

    public int getSunPS() {return SunPS;}
    public void setSunPS() {this.SunPS = SunPS;}

    public String getEffet() {return effet;}
    public void setEffet(String effet) {this.effet = effet;}

    public String getChemin_image() {return chemin_image;}
    public void setChemin_image(String chemin_image) {this.chemin_image = chemin_image;}




}
