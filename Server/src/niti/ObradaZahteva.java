/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import db.DBBroker;
import domen.Automobil;
import domen.AutomobilSaTerminom;
import domen.KategorijaVozaca;
import domen.Musterija;
import domen.Prodavac;
import domen.RacunZakupaAutomobila;
import domen.SlobodanTermin;
import domen.ZakupAutomobila;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import konstante.StatusOdgovora;
import logika.ServerKontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author mitro
 */
public class ObradaZahteva extends Thread {

    private Socket soket;

    public ObradaZahteva(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {

        while (!isInterrupted()) {

            try {
                ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
                KlijentskiZahtev kz = (KlijentskiZahtev) ois.readObject();
                ServerskiOdgovor so = obradiZahtev(kz);
                ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
                oos.writeObject(so);
                
            } catch (Exception e) {
                System.out.println("Klijent je prekinuo sa radom");
                break;
            }
        }
    }

    private ServerskiOdgovor obradiZahtev(KlijentskiZahtev kz) {

        ServerskiOdgovor so = new ServerskiOdgovor();
        so.setStatus(StatusOdgovora.Success);
        

        try {
            switch (kz.getOperacija()) {
        
                case Operacije.PRONADJI_PRODAVCA:
                    
                    Prodavac prodavac = ServerKontroler.getInstance().pronadjiProdavca((Prodavac) kz.getParametar());
                    so.setOdgovor(prodavac);
                    if(so.getOdgovor() == null){
                        throw new Exception("Pogrešni kredencijali za prijavu!");
                    } 
                   
                    break;
                
                case Operacije.UCITAJ_LISTU_KATEGORIJA_VOZACA:
                    
                    ArrayList<KategorijaVozaca> listaKategorija = ServerKontroler.getInstance().ucitajListuKategorijaVozaca();
                    so.setOdgovor(listaKategorija);                    
                    break;
                
                case Operacije.ZAPAMTI_MUSTERIJU:
                    
                    ServerKontroler.getInstance().zapamtiMusteriju((Musterija) kz.getParametar());                    
                    break;
                                     
                case Operacije.VRATI_MUSTERIJE:
                    
                    ArrayList<Musterija> listaMusterija = ServerKontroler.getInstance().vratiMusterije();
                    so.setOdgovor(listaMusterija);                   
                    break;
                    
                case Operacije.PRONADJI_MUSTERIJE:
                    
                    ArrayList<Musterija> listaPronadjenihMusterija = ServerKontroler.getInstance().pronadjiMusterije((Musterija) kz.getParametar());
                    so.setOdgovor(listaPronadjenihMusterija);                    
                    break;
                    
                case Operacije.UCITAJ_MUSTERIJU:
                    
                    Musterija musterija = ServerKontroler.getInstance().ucitajMusteriju((Musterija) kz.getParametar());
                    so.setOdgovor(musterija);
                    break;                   
                    
                case Operacije.IZMENI_MUSTERIJU:
                    
                    ServerKontroler.getInstance().izmeniMusteriju((Musterija) kz.getParametar());                    
                    break;
                    
                case Operacije.UCITAJ_LISTU_SLOBODNIH_TERMINA:
                    
                    ArrayList<SlobodanTermin> listaSlobodnihTermina = ServerKontroler.getInstance().ucitajListuSlobodnihTermina();
                    so.setOdgovor(listaSlobodnihTermina);
                    break;
                    
                case Operacije.UCITAJ_LISTU_AUTOMOBILA:
                    
                    ArrayList<Automobil> listaAutomobila = ServerKontroler.getInstance().ucitajListuAutomobila();
                    so.setOdgovor(listaAutomobila);
                    break;                  
                    
                case Operacije.ZAPAMTI_AUTO_TERMIN:
                    
                    ServerKontroler.getInstance().zapamtiAutoTermin((AutomobilSaTerminom) kz.getParametar());                   
                    break;
                    
                case Operacije.VRATI_AUTO_TERMINE:
                    
                    ArrayList<AutomobilSaTerminom> listaAutoTermina = ServerKontroler.getInstance().vratiAutoTermine();
                    so.setOdgovor(listaAutoTermina);                   
                    break;
                    
                case Operacije.ZAPAMTI_ZAKUP:
                    
                    ServerKontroler.getInstance().zapamtiZakup((ZakupAutomobila) kz.getParametar());                  
                    break;
                    
                case Operacije.VRATI_ZAKUPE:
                    
                    ArrayList<ZakupAutomobila> listaZakupa = ServerKontroler.getInstance().vratiZakupe();
                    so.setOdgovor(listaZakupa);
                    break;
                    
                case Operacije.PRONADJI_ZAKUPE:
                    
                    ArrayList<ZakupAutomobila> listaPronadjenihZakupa = ServerKontroler.getInstance().pronadjiZakupe((ZakupAutomobila) kz.getParametar());
                    so.setOdgovor(listaPronadjenihZakupa);
                    break;
                    
                case Operacije.PRONADJI_AUTOMOBILE:
                    
                    ArrayList<Automobil> listaPronadjenihAutomobila = ServerKontroler.getInstance().pronadjiAutomobile((Automobil) kz.getParametar());
                    so.setOdgovor(listaPronadjenihAutomobila);
                    break;
                   
                case Operacije.UCITAJ_AUTOMOBIL:
                    
                    Automobil automobil = ServerKontroler.getInstance().ucitajAutomobil((Automobil) kz.getParametar());
                    so.setOdgovor(automobil);
                    break;
                    
                case Operacije.UCITAJ_ZAKUP:
                    
                    ZakupAutomobila zakup = ServerKontroler.getInstance().ucitajZakup((ZakupAutomobila) kz.getParametar());
                    so.setOdgovor(zakup);
                    break;
                    
                case Operacije.OBRISI_ZAKUP:
                    
                    ServerKontroler.getInstance().obrisiZakup((ZakupAutomobila) kz.getParametar());            
                    break;
                    
                case Operacije.VRATI_RACUN_ZAKUPA:
                    
                    RacunZakupaAutomobila racun = ServerKontroler.getInstance().vratiRacunZakupa((ZakupAutomobila) kz.getParametar());
                    so.setOdgovor(racun);                   
                    break;
                    
                case Operacije.ZAPAMTI_RACUN_ZAKUPA:
                    
                    ServerKontroler.getInstance().zapamtiRacunZakupa((ZakupAutomobila) kz.getParametar());                   
                    break;
                    
                case Operacije.ODJAVI:
                    
                    ServerKontroler.getInstance().odjavi((Prodavac) kz.getParametar());
                    break;
                    
                default:
                    System.out.println("GreŠka!");                   
            }

        } catch (Exception e) {
            so.setGreska(e);
            so.setStatus(StatusOdgovora.Error);
        }

        
        return so;
    }

}
