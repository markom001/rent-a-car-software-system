/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakupAutomobila;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOPronadjiZakupe extends ApstraktnaSO{

    private ArrayList<ZakupAutomobila> listaZakupa;

    public ArrayList<ZakupAutomobila> getListaZakupa() {
        return listaZakupa;
    }

    public SOPronadjiZakupe() {
        listaZakupa = new ArrayList<>();
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {       
        if (!(odo instanceof ZakupAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }   
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        
        ArrayList<ZakupAutomobila> pronadjenaLista = new ArrayList<>();
        for (OpstiDomenskiObjekat el : lista) {
            pronadjenaLista.add((ZakupAutomobila) el);
        }
        
        ZakupAutomobila zakup = (ZakupAutomobila) odo;
        ArrayList<ZakupAutomobila> listaZaSlanje = new ArrayList<>();
        
        for (ZakupAutomobila z : pronadjenaLista) {
            
            if(z.getMusterija().getImePrezime().toLowerCase().startsWith(zakup.getMusterija().getImePrezime().toLowerCase())){
                listaZaSlanje.add(z);
            }        
        }
        
        listaZakupa = listaZaSlanje;
    }
    
    
    
}
