/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.KategorijaVozaca;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOUcitajListuKategorijaVozaca extends ApstraktnaSO {

    private ArrayList<KategorijaVozaca> listaKategorija;

    public ArrayList<KategorijaVozaca> getListaKategorija() {
        return listaKategorija;
    }  

    public SOUcitajListuKategorijaVozaca() {
        listaKategorija = new ArrayList<>();
    }
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof KategorijaVozaca)){
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        for (OpstiDomenskiObjekat kv : lista) {
            listaKategorija.add((KategorijaVozaca) kv);
        }       
    }
    
    
    
    
}
