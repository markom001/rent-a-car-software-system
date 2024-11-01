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
public class SlobodanTermin implements OpstiDomenskiObjekat {
    
    private int slobodanTerminID;
    private String nazivMeseca;
    private Date datumOd;
    private Date datumDo;

    public SlobodanTermin() {
    }

    public SlobodanTermin(int slobodanTerminID, String nazivMeseca, Date datumOd, Date datumDo) {
        this.slobodanTerminID = slobodanTerminID;
        this.nazivMeseca = nazivMeseca;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }

    public int getSlobodanTerminID() {
        return slobodanTerminID;
    }

    public String getNazivMeseca() {
        return nazivMeseca;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setSlobodanTerminID(int slobodanTerminID) {
        this.slobodanTerminID = slobodanTerminID;
    }

    public void setNazivMeseca(String nazivMeseca) {
        this.nazivMeseca = nazivMeseca;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }  

    @Override
    public String toString() {
        return nazivMeseca;
    }
    
    @Override
    public String tabela() {
        return "slobodantermin";
    }

    @Override
    public String alijas() {
        return "st";
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
            
            SlobodanTermin st = new SlobodanTermin(rs.getInt("slobodanTerminID"), rs.getString("nazivMeseca"), rs.getDate("datumOd"), rs.getDate("datumDo"));
            lista.add(st);           
        }
        rs.close();
        return lista;
    }
    
}
