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

public class AutomobilSaTerminom implements OpstiDomenskiObjekat {
    
    private int autoTerminID;
    private int dostupan;
    private SlobodanTermin slobodanTermin;
    private Automobil automobil;

    public AutomobilSaTerminom() {
    }

    public AutomobilSaTerminom(int autoTerminID, int dostupan, SlobodanTermin slobodanTermin, Automobil automobil) {
        this.autoTerminID = autoTerminID;
        this.dostupan = dostupan;
        this.slobodanTermin = slobodanTermin;
        this.automobil = automobil;
    }

    public int getAutoTerminID() {
        return autoTerminID;
    }

    public int getDostupan() {
        return dostupan;
    }

    public SlobodanTermin getSlobodanTermin() {
        return slobodanTermin;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutoTerminID(int autoTerminID) {
        this.autoTerminID = autoTerminID;
    }

    public void setDostupan(int dostupan) {
        this.dostupan = dostupan;
    }

    public void setSlobodanTermin(SlobodanTermin slobodanTermin) {
        this.slobodanTermin = slobodanTermin;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    @Override
    public String tabela() {
        return "automobilsaterminom";
    }

    @Override
    public String alijas() {
        return "ast";
    }

    @Override
    public String spajanje() {
        return "JOIN slobodantermin st ON (st.slobodanTerminID = ast.slobodanTerminID) JOIN automobil a ON (a.automobilID = ast.automobilID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String koloneZaInsert() {
        return "(dostupan, slobodanTerminID, automobilID)";
    }

    @Override
    public String vrednostiZaInsert() {
        return dostupan + "," + slobodanTermin.getSlobodanTerminID() + "," + automobil.getAutomobilID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String id() {
        return "autoTerminID = " + autoTerminID;
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> lista(ResultSet rs) throws SQLException {
        
        
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        
        while (rs.next()) {
            SlobodanTermin slobodanTermin = new SlobodanTermin(rs.getInt("slobodanTerminID"), rs.getString("nazivMeseca"), rs.getDate("datumOd"), rs.getDate("datumDo"));
            Automobil auto = new Automobil(rs.getInt("automobilID"), rs.getString("markaAutomobila"), rs.getDouble("cenaAutomobila"));
            AutomobilSaTerminom autoTermin = new AutomobilSaTerminom(rs.getInt("autoTerminID"), rs.getInt("dostupan"), slobodanTermin, auto);
            lista.add(autoTermin);
        }
        
        rs.close();
        return lista; 
    }  
    
}
