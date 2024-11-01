/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Automobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mitro
 */
public class ModelTabeleAutomobila extends AbstractTableModel{

    private ArrayList<Automobil> listaAutomobila;
    private String[] kolone = {"Marka automobila", "Cena automobila"};
    
    public ModelTabeleAutomobila(){
        
        listaAutomobila = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listaAutomobila.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Automobil auto = listaAutomobila.get(rowIndex);
        switch(columnIndex){
            
            case 0: return auto.getMarkaAutomobila();
            case 1: return auto.getCenaAutomobila() + " $";
            default: return "";            
        }   
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Automobil> getListaAutomobila() {
        return listaAutomobila;
    }
    
    public void dodajAutomobil(Automobil auto){
        listaAutomobila.add(auto);
        fireTableDataChanged();
    }
    
    public void izbrisi(int red){
        listaAutomobila.remove(red);
        fireTableDataChanged();
    }
    
    public boolean postoji(Automobil auto){
       
        for (Automobil automobil : listaAutomobila) {
            if(automobil.getAutomobilID() == auto.getAutomobilID()){
                return true;
            }
        }
        return false;
    }
    
}
