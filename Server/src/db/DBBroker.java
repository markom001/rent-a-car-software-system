/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mitro
 */
public class DBBroker {
    
    private static DBBroker instance;
    private static Connection konekcija;

    public DBBroker() {
         
    }
    
    public void poveziSe() throws SQLException, FileNotFoundException {
        
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            konekcija = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("pass"));
            if(konekcija != null){
                konekcija.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            throw new SQLException("Server ne može da se poveže sa bazom");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Server ne može da se poveže sa bazom");
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static DBBroker getInstance() {
        if(instance == null){
            instance = new DBBroker();
        }
        return instance;
    }

    public Connection getKonekcija() {
        return konekcija;
    }
    
    public ArrayList<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat odo) throws SQLException {
        
        String upit = "SELECT * FROM " + odo.tabela() +  " "  + odo.alijas() + " " + odo.spajanje();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.lista(rs);       
    }
    
    public PreparedStatement insert(OpstiDomenskiObjekat odo) throws SQLException{
        
        String upit = "INSERT INTO " + odo.tabela() + " " + odo.koloneZaInsert() + " VALUES(" + odo.vrednostiZaInsert() + ")";
        System.out.println("Upit: " + upit);
        PreparedStatement ps = konekcija.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }
    
    public void update(OpstiDomenskiObjekat odo) throws SQLException{
        
        String upit = "UPDATE " + odo.tabela() + " SET " + odo.vrednostiZaUpdate() + " WHERE " + odo.id();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);       
    }
    
    public void delete(OpstiDomenskiObjekat odo) throws SQLException{
        
        String upit = "DELETE FROM " + odo.tabela() + " WHERE " + odo.id();
        System.out.println("Upit: " + upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);    
    }
    
}
