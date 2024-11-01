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
public class Automobil implements OpstiDomenskiObjekat {
    
    private int automobilID;
    private String markaAutomobila;
    private double cenaAutomobila;

    public Automobil() {
    }

    public Automobil(int automobilID, String markaAutomobila, double cenaAutomobila) {
        this.automobilID = automobilID;
        this.markaAutomobila = markaAutomobila;
        this.cenaAutomobila = cenaAutomobila;
    }

    public int getAutomobilID() {
        return automobilID;
    }

    public String getMarkaAutomobila() {
        return markaAutomobila;
    }

    public double getCenaAutomobila() {
        return cenaAutomobila;
    }

    public void setAutomobilID(int automobilID) {
        this.automobilID = automobilID;
    }

    public void setMarkaAutomobila(String markaAutomobila) {
        this.markaAutomobila = markaAutomobila;
    }

    public void setCenaAutomobila(double cenaAutomobila) {
        this.cenaAutomobila = cenaAutomobila;
    }

    @Override
    public String toString() {
        return markaAutomobila;
    }
    
    @Override
    public String tabela() {
        return "automobil";
    }

    @Override
    public String alijas() {
       return "a";
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
        return "(markaAutomobila, cenaAutomobila)";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + markaAutomobila + "'," + cenaAutomobila;
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
            Automobil auto = new Automobil(rs.getInt("automobilID"), rs.getString("markaAutomobila"), rs.getDouble("cenaAutomobila"));
            lista.add(auto);
        }
        
        rs.close();
        return lista;
    }
    
}
