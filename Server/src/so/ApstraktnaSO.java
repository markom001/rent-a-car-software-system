/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mitro
 */
public abstract class ApstraktnaSO {
    
    public void template(OpstiDomenskiObjekat odo) throws Exception{
        
        try {
            validate(odo);
            execute(odo);
            commit();
        } catch (Exception e) {
            rollback();
            System.out.println(e.getMessage());
            throw e;
        }    
    }

    protected abstract void validate(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void execute(OpstiDomenskiObjekat odo) throws SQLException;

    private void commit() throws SQLException {
        if(DBBroker.getInstance().getKonekcija() != null){
            DBBroker.getInstance().getKonekcija().commit();
        }
    }

    private void rollback() throws SQLException {
        if(DBBroker.getInstance().getKonekcija() != null){
            DBBroker.getInstance().getKonekcija().rollback();
        }
        
    }   
}
