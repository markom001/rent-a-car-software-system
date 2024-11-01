/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Automobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logika.KlijentKontroler;

/**
 *
 * @author mitro
 */
public class ModelTabeleInformacija extends AbstractTableModel{

    private ArrayList<Automobil> listaAutomobila;
    private String[] kolone = {"Marka automobila"};
    
    public ModelTabeleInformacija() throws Exception{
        listaAutomobila = KlijentKontroler.getInstance().ucitajListuAutomobila();
    }
    
    public ModelTabeleInformacija(ArrayList<Automobil> listaAutomobila){
        this.listaAutomobila = listaAutomobila;
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
    
    public Automobil getAutomobil(int red){
        return listaAutomobila.get(red);
    }
   
}
