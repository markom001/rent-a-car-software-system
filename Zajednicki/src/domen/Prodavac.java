/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class Prodavac implements OpstiDomenskiObjekat {
    
    private int prodavacID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public Prodavac() {
    }

    public Prodavac(int prodavacID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.prodavacID = prodavacID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getProdavacID() {
        return prodavacID;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setProdavacID(int prodavacID) {
        this.prodavacID = prodavacID;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
       return ime + " " + prezime;
    }  
    
    @Override
    public String tabela() {
        return "prodavac";
    }

    @Override
    public String alijas() {
        return "pr";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> lista(ResultSet rs) throws SQLException {
        
       ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            Prodavac pr = new Prodavac(rs.getInt("prodavacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            lista.add(pr);
        }
        
        rs.close();
        return lista;     
    }
    
}
