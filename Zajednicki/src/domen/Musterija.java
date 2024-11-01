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
public class Musterija implements OpstiDomenskiObjekat {
    
    private int musterijaID;
    private String imePrezime;
    private Date datumRodjenja;
    private String adresa;
    private KategorijaVozaca kategorijaVozaca;

    public Musterija() {
    }

    public Musterija(int musterijaID, String imePrezime, Date datumRodjenja, String adresa, KategorijaVozaca kategorijaVozaca) {
        this.musterijaID = musterijaID;
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.kategorijaVozaca = kategorijaVozaca;
    }

    public int getMusterijaID() {
        return musterijaID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public KategorijaVozaca getKategorijaVozaca() {
        return kategorijaVozaca;
    }

    public void setMusterijaID(int musterijaID) {
        this.musterijaID = musterijaID;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setKategorijaVozaca(KategorijaVozaca kategorijaVozaca) {
        this.kategorijaVozaca = kategorijaVozaca;
    }

    @Override
    public String toString() {
        return imePrezime;
    }
    
    @Override
    public String tabela() {
        return "musterija";
    }

    @Override
    public String alijas() {
        return "m";
    }

    @Override
    public String spajanje() {
        return "JOIN kategorijavozaca kv ON (kv.kategorijaID = m.kategorijaID) ORDER BY m.musterijaID";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(imePrezime, datumRodjenja, adresa, kategorijaID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imePrezime + "','" + new java.sql.Date(datumRodjenja.getTime()) + "','" + adresa + "'," + kategorijaVozaca.getKategorijaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "imePrezime = '" + imePrezime + "', datumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "', adresa = '" + adresa + "', kategorijaID = " + kategorijaVozaca.getKategorijaID();
    }

    @Override
    public String id() {
        return "musterijaID = " + musterijaID;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> lista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            KategorijaVozaca kv = new KategorijaVozaca(rs.getInt("kategorijaID"), rs.getString("nazivKategorije"));
            Musterija musterija = new Musterija(rs.getInt("musterijaID"), rs.getString("imePrezime"), rs.getDate("datumRodjenja"), rs.getString("adresa"), kv);
            lista.add(musterija);
        }
        
        rs.close();
        return lista;  
    }

    


    
}
