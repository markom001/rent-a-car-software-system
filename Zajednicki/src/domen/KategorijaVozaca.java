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

public class KategorijaVozaca implements OpstiDomenskiObjekat {
    
    private int kategorijaID;
    private String nazivKategorije;

    public KategorijaVozaca() {
    }

    public KategorijaVozaca(int kategorijaID, String nazivKategorije) {
        this.kategorijaID = kategorijaID;
        this.nazivKategorije = nazivKategorije;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setKategorijaID(int kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }

    @Override
    public String tabela() {
        return "kategorijavozaca";
    }

    @Override
    public String alijas() {
        return "kv";
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
        
        while(rs.next()){
            KategorijaVozaca kv = new KategorijaVozaca(rs.getInt("kategorijaID"), rs.getString("nazivKategorije"));
            lista.add(kv);
        }
        
        rs.close();
        return lista;
    }
    
    
    
    
}
