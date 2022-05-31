package com.example.ex5json201;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String ident;
    private String nom;
    private String ville;
    private String naissance;
    private double noteFr;
    private double noteHist;
    private double noteMath;
    private double notePhys;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public double getNoteFr() {
        return noteFr;
    }

    public void setNoteFr(double noteFr) {
        this.noteFr = noteFr;
    }

    public double getNoteHist() {
        return noteHist;
    }

    public void setNoteHist(double noteHist) {
        this.noteHist = noteHist;
    }

    public double getNoteMath() {
        return noteMath;
    }

    public void setNoteMath(double noteMath) {
        this.noteMath = noteMath;
    }

    public double getNotePhys() {
        return notePhys;
    }

    public void setNotePhys(double notePhys) {
        this.notePhys = notePhys;
    }
}
