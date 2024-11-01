/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.Musterija;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mitro
 */
public class SOPronadjiMusterije extends ApstraktnaSO{

    ArrayList<Musterija> listaMusterija;

    public SOPronadjiMusterije() {
        listaMusterija = new ArrayList<>();
    }

    public ArrayList<Musterija> getListaMusterija() {
        return listaMusterija;
    } 
    
    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Musterija)) {
            throw new Exception("Nevalidan objekat!");
        } 
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ArrayList<OpstiDomenskiObjekat> lista = DBBroker.getInstance().select(odo);
        ArrayList<Musterija> pronadjenaLista = new ArrayList<>();
        for (OpstiDomenskiObjekat el : lista) {
            pronadjenaLista.add((Musterija) el);
        }
        
        Musterija m = (Musterija) odo;
        ArrayList<Musterija> listaZaSlanje = new ArrayList<>();
        
        for (Musterija mp : pronadjenaLista) {
            if(mp.getImePrezime().toLowerCase().startsWith(m.getImePrezime().toLowerCase())){
                listaZaSlanje.add(mp);
            }
        }
        
        listaMusterija = listaZaSlanje;
    }
    
    
}
