/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Automobil;
import domen.AutomobilSaTerminom;
import domen.SlobodanTermin;
import domen.ZakupAutomobila;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logika.KlijentKontroler;

/**
 *
 * @author mitro
 */
public class ModelTabeleZakupa extends AbstractTableModel{

    private ArrayList<ZakupAutomobila> listaZakupa;
    private String[] kolone = {"Mušterija", "Marka automobila", "Datum od", "Datum do", "Datum zakupa"};
    
    public ModelTabeleZakupa() throws Exception{
        listaZakupa = KlijentKontroler.getInstance().vratiZakupe();
    }
    
    public ModelTabeleZakupa(ArrayList<ZakupAutomobila> listaZakupa){
        this.listaZakupa = listaZakupa;
    }  
    
    @Override
    public int getRowCount() {
        return listaZakupa.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        ZakupAutomobila zakup = listaZakupa.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        ArrayList<AutomobilSaTerminom> listaAutoTermina = new ArrayList<>();
        AutomobilSaTerminom autoTermin = null;
        ArrayList<Automobil> listaAutomobila = new ArrayList<>();
        Automobil auto = null;
        ArrayList<SlobodanTermin> listaTermina = new ArrayList<>();
        SlobodanTermin termin = null;
        
        try {
            listaAutoTermina = KlijentKontroler.getInstance().vratiAutoTermine();
            listaAutomobila = KlijentKontroler.getInstance().ucitajListuAutomobila();
            listaTermina = KlijentKontroler.getInstance().ucitajListuSlobodnihTermina();           
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleZakupa.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        for (AutomobilSaTerminom at : listaAutoTermina) {
            if(at.getAutoTerminID() == zakup.getAutomobilSaTerminom().getAutoTerminID()){
                autoTermin = at;
            }
        }
        
        if(autoTermin != null){
            for(Automobil a : listaAutomobila){
                if(a.getAutomobilID() == autoTermin.getAutomobil().getAutomobilID()){
                    auto = a;
                }
            }
             for(SlobodanTermin st : listaTermina){
                if(st.getSlobodanTerminID() == autoTermin.getSlobodanTermin().getSlobodanTerminID()){
                termin = st;
                }
             }
        } 
        
        switch(columnIndex){
            
            case 0: return zakup.getMusterija().getImePrezime();
            case 1: return (auto != null) ? auto.getMarkaAutomobila() : "";
            case 2: return (termin != null) ? sdf.format(termin.getDatumOd()) : "";
            case 3: return (termin != null) ? sdf.format(termin.getDatumDo()) : "";
            case 4: return sdf.format(zakup.getDatumZakupa());
            default: return "";            
        }       
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
   
    public ZakupAutomobila getZakup(int red){
        return listaZakupa.get(red);
    }
    
}
