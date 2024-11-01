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
public class RacunZakupaAutomobila implements OpstiDomenskiObjekat {
    
    private int racunID;
    private Date datumIzdavanja;
    private ZakupAutomobila zakupAutomobila;

    public RacunZakupaAutomobila() {
    }

    public RacunZakupaAutomobila(int racunID, Date datumIzdavanja, ZakupAutomobila zakupAutomobila) {
        this.racunID = racunID;
        this.datumIzdavanja = datumIzdavanja;
        this.zakupAutomobila = zakupAutomobila;
    }

    public int getRacunID() {
        return racunID;
    }

    public Date getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public ZakupAutomobila getZakupAutomobila() {
        return zakupAutomobila;
    }

    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public void setDatumIzdavanja(Date datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }    

    public void setZakupAutomobila(ZakupAutomobila zakupAutomobila) {
        this.zakupAutomobila = zakupAutomobila;
    }

    @Override
    public String tabela() {
        return "racunzakupaautomobila";
    }

    @Override
    public String alijas() {
        return "rza";
    }

    @Override
    public String spajanje() {
        return "JOIN zakupautomobila za ON (za.zakupID = rza.zakupID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(datumIzdavanja, zakupID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumIzdavanja.getTime()) + "', " + zakupAutomobila.getZakupID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "zakupID = " + zakupAutomobila.getZakupID();
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> lista(ResultSet rs) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            
            ZakupAutomobila za = new ZakupAutomobila(rs.getInt("zakupID"), rs.getDate("datumZakupa"), null, null, null);
            RacunZakupaAutomobila rza = new RacunZakupaAutomobila(rs.getInt("racunID"), rs.getDate("datumIzdavanja"), za);            
            lista.add(rza);
        }      
        rs.close();
        return lista;    
    }

}
    
