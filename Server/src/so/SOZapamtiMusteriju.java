/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.Musterija;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;

/**
 *
 * @author mitro
 */
public class SOZapamtiMusteriju extends ApstraktnaSO{

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Musterija)) {
            throw new Exception("Nevalidan objekat!");
        }
    }

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws SQLException {
        DBBroker.getInstance().insert(odo);
    }
    
}
