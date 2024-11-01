/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AutomobilSaTerminom;
import domen.OpstiDomenskiObjekat;
import domen.RacunZakupaAutomobila;
import domen.ZakupAutomobila;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author mitro
 */
public class SOObrisiZakup extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof ZakupAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        
        ZakupAutomobila zakup = (ZakupAutomobila) odo;
        RacunZakupaAutomobila racun = new RacunZakupaAutomobila(-1, new Date(), zakup);
        AutomobilSaTerminom autoTermin = new AutomobilSaTerminom(zakup.getAutomobilSaTerminom().getAutoTerminID(), 0, null, null);
        DBBroker.getInstance().delete(autoTermin);
        DBBroker.getInstance().delete(racun);
        DBBroker.getInstance().delete(zakup);  
    }
    
}
