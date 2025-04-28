package com.epf.Assets;

public class Zombies {
    private String nom;
    private int PV;
    private double APS;
    private int dmg_Atk;
    private double Vit;
    private String chemin_image;
    private int IDMap;

    public Zombies(String nom, int PV, double APS, int dmg_Atk, double Vit, String chemin_image, int IDMap) {
        this.nom = nom;
        this.PV = PV;
        this.APS = APS;
        this.dmg_Atk = dmg_Atk;
        this.Vit = Vit;
        this.chemin_image = chemin_image;
        this.IDMap = IDMap;
    }

    public Zombies() {
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

    public double getVit() {return Vit;}
    public void setVit(double Vit) {this.Vit = Vit;}

    public String getChemin_image() {return chemin_image;}
    public void setChemin_image(String chemin_image) {this.chemin_image = chemin_image;}

    public int getIDMap() {return IDMap;}
    public void setIDMap(int IDMap) {this.IDMap = IDMap;}
}
