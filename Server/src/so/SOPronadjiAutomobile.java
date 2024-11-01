/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOPronadjiAutomobile extends ApstraktnaSO{

    
    private ArrayList<Automobil> listaAutomobila;

    public ArrayList<Automobil> getListaAutomobila() {
        return listaAutomobila;
    }

    public SOPronadjiAutomobile() {
        listaAutomobila = new ArrayList<>();
    }  
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {     
        if (!(odo instanceof Automobil)) {
            throw new Exception("Nevalidan objekat!");
        } 
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<Automobil> pronadjenaLista = new ArrayList<>();
        for (OpstiDomenskiObjekat el : lista) {
            pronadjenaLista.add((Automobil) el);
        }
        
        Automobil auto = (Automobil) odo;
        ArrayList<Automobil> listaZaSlanje = new ArrayList<>();
        
        for (Automobil a : pronadjenaLista) {
            if(a.getMarkaAutomobila().toLowerCase().startsWith(auto.getMarkaAutomobila().toLowerCase())){
                listaZaSlanje.add(a);
            }
        }
        
        listaAutomobila = listaZaSlanje;
    }
    
    
}
