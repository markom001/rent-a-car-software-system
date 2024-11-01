/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domen.Musterija;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import logika.KlijentKontroler;

/**
 *
 * @author mitro
 */
public class ModelTabeleMusterija extends AbstractTableModel{

    private ArrayList<Musterija> listaMusterija;
    private String[] kolone = {"Ime i prezime", "Datum rodjenja", "Adresa", "Kategorija vozača"};
    
    public ModelTabeleMusterija() throws Exception {
        listaMusterija = KlijentKontroler.getInstance().vratiMusterije();
    }    

    public ModelTabeleMusterija(ArrayList<Musterija> listaPronadjenih) {
        listaMusterija = listaPronadjenih;
    }
    
    @Override
    public int getRowCount() {
        return listaMusterija.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Musterija m = listaMusterija.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        
        switch(columnIndex){
            
            case 0: return m.getImePrezime();
            case 1: return sdf.format(m.getDatumRodjenja());
            case 2: return m.getAdresa();
            case 3: return m.getKategorijaVozaca();
            
            default: return "";           
        }       
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public Musterija getMusterija(int red) {
        return listaMusterija.get(red);
    }
    
    
    
}
