/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.ZakupAutomobila;
import java.sql.SQLException;

/**
 *
 * @author mitro
 */
public class SOZapamtiZakup extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof ZakupAutomobila)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        DBBroker.getInstance().insert(odo);
    }
    
    
    
}
