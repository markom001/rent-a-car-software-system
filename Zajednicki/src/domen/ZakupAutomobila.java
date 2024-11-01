/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mitro
 */
public class ZakupAutomobila implements OpstiDomenskiObjekat {
    
    private int zakupID;
    private Date datumZakupa;
    private Prodavac prodavac;
    private Musterija musterija;
    private AutomobilSaTerminom automobilSaTerminom;

    public ZakupAutomobila() {
    }

    public ZakupAutomobila(int zakupID, Date datumZakupa, Prodavac prodavac, Musterija musterija, AutomobilSaTerminom automobilSaTerminom) {
        this.zakupID = zakupID;
        this.datumZakupa = datumZakupa;
        this.prodavac = prodavac;
        this.musterija = musterija;
        this.automobilSaTerminom = automobilSaTerminom;
    }

    public int getZakupID() {
        return zakupID;
    }

    public Date getDatumZakupa() {
        return datumZakupa;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public Musterija getMusterija() {
        return musterija;
    }

    public AutomobilSaTerminom getAutomobilSaTerminom() {
        return automobilSaTerminom;
    }

    public void setZakupID(int zakupID) {
        this.zakupID = zakupID;
    }

    public void setDatumZakupa(Date datumZakupa) {
        this.datumZakupa = datumZakupa;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public void setMusterija(Musterija musterija) {
        this.musterija = musterija;
    }

    public void setAutomobilSaTerminom(AutomobilSaTerminom automobilSaTerminom) {
        this.automobilSaTerminom = automobilSaTerminom;
    }  

    @Override
    public String tabela() {
        return "zakupautomobila";
    }

    @Override
    public String alijas() {
        return "za";
    }

    @Override
    public String spajanje() {
        return "JOIN automobilsaterminom ast ON (ast.autoTerminID = za.autoTerminID) JOIN musterija m ON (m.musterijaID = za.musterijaID) JOIN prodavac pr ON (pr.prodavacID = za.prodavacID) ORDER BY za.zakupID";       
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(datumZakupa, prodavacID, musterijaID, autoTerminID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumZakupa.getTime()) + "'," + prodavac.getProdavacID() + "," + musterija.getMusterijaID() + "," + automobilSaTerminom.getAutoTerminID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "zakupID = " + zakupID;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> lista(ResultSet rs) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
    
        while(rs.next()){
            
            Prodavac pr = new Prodavac(rs.getInt("prodavacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("korisnickoIme"), rs.getString("lozinka"));
            Musterija mu = new Musterija(rs.getInt("musterijaID"), rs.getString("imePrezime"), rs.getDate("datumRodjenja"), rs.getString("adresa"), null);
            AutomobilSaTerminom at = new AutomobilSaTerminom(rs.getInt("autoTerminID"), rs.getInt("dostupan"), null, null);
            ZakupAutomobila zakup = new ZakupAutomobila(rs.getInt("zakupID"), rs.getDate("datumZakupa"), pr, mu, at);
            lista.add(zakup);                   
        }
        
        rs.close();
        return lista;
    }
}
