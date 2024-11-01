/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.RacunZakupaAutomobila;
import java.sql.SQLException;

/**
 *
 * @author mitro
 */
public class SOZapamtiRacunZakupa extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof RacunZakupaAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }  
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        DBBroker.getInstance().insert(odo);
    }
    
}
