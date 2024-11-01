/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Automobil;
import domen.AutomobilSaTerminom;
import domen.KategorijaVozaca;
import domen.Musterija;
import domen.OpstiDomenskiObjekat;
import domen.Prodavac;
import domen.RacunZakupaAutomobila;
import domen.SlobodanTermin;
import domen.ZakupAutomobila;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import konstante.Operacije;
import konstante.StatusOdgovora;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author mitro
 */
public class KlijentKontroler {
      
    private static KlijentKontroler instance;

    public KlijentKontroler() {
    }
    
    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }
    
    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        
        KlijentskiZahtev kz = new KlijentskiZahtev(operacija, parametar);
        if(Sesija.getInstance().getSoket() == null){
            throw new NullPointerException("Nije moguce pristupiti podacima u bazi zbog konekcije sa serverom");
        }
        
        ObjectOutputStream oos = new ObjectOutputStream(Sesija.getInstance().getSoket().getOutputStream());
        oos.writeObject(kz);
       
        ObjectInputStream ois = new ObjectInputStream(Sesija.getInstance().getSoket().getInputStream());
        ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
        
        if(so.getStatus().equals(StatusOdgovora.Success)){
            return so.getOdgovor();
        } else {
            throw so.getGreska();
        }       
    }
    
    public Prodavac pronadjiProdavca(Prodavac prodavac) throws Exception {
        
        return (Prodavac) posaljiZahtev(Operacije.PRONADJI_PRODAVCA, prodavac);
    }

    public ArrayList<KategorijaVozaca> ucitajListuKategorijaVozaca() throws Exception {
        
        return (ArrayList<KategorijaVozaca>) posaljiZahtev(Operacije.UCITAJ_LISTU_KATEGORIJA_VOZACA, null);
    }
    
    public void zapamtiMusteriju(Musterija musterija) throws Exception {
        
        posaljiZahtev(Operacije.ZAPAMTI_MUSTERIJU, musterija);
    }

    public ArrayList<Musterija> vratiMusterije() throws Exception {
          
        return (ArrayList<Musterija>) posaljiZahtev(Operacije.VRATI_MUSTERIJE, null);       
    }

    public ArrayList<Musterija> pronadjiMusterije(Musterija m) throws Exception {
        
        return (ArrayList<Musterija>) posaljiZahtev(Operacije.PRONADJI_MUSTERIJE, m);
    }

    public Musterija ucitajMusteriju(Musterija m) throws Exception {
        
        return (Musterija) posaljiZahtev(Operacije.UCITAJ_MUSTERIJU, m);
    }

    public void izmeniMusteriju(Musterija musterija) throws Exception {
        
        posaljiZahtev(Operacije.IZMENI_MUSTERIJU, musterija);
    }

    public ArrayList<SlobodanTermin> ucitajListuSlobodnihTermina() throws Exception {
        
        return (ArrayList<SlobodanTermin>) posaljiZahtev(Operacije.UCITAJ_LISTU_SLOBODNIH_TERMINA, null);
    }

    public ArrayList<Automobil> ucitajListuAutomobila() throws Exception {
       
        return (ArrayList<Automobil>) posaljiZahtev(Operacije.UCITAJ_LISTU_AUTOMOBILA, null);      
    }

    public void zapamtiAutoTermin(AutomobilSaTerminom autoTermin) throws Exception {
       
        posaljiZahtev(Operacije.ZAPAMTI_AUTO_TERMIN, autoTermin);        
    }

    public ArrayList<AutomobilSaTerminom> vratiAutoTermine() throws Exception {
        
        return (ArrayList<AutomobilSaTerminom>) posaljiZahtev(Operacije.VRATI_AUTO_TERMINE, null);
    }

    public void zapamtiZakup(ZakupAutomobila zakup) throws Exception {
        
        posaljiZahtev(Operacije.ZAPAMTI_ZAKUP, zakup);
    }

    public ArrayList<ZakupAutomobila> vratiZakupe() throws Exception {
        
       return (ArrayList<ZakupAutomobila>) posaljiZahtev(Operacije.VRATI_ZAKUPE, null); 
    }

    public ArrayList<ZakupAutomobila> pronadjiZakupe(ZakupAutomobila zakup) throws Exception {
        
         return (ArrayList<ZakupAutomobila>) posaljiZahtev(Operacije.PRONADJI_ZAKUPE, zakup);
    }

    public ArrayList<Automobil> pronadjiAutomobile(Automobil auto) throws Exception {
        
        return (ArrayList<Automobil>) posaljiZahtev(Operacije.PRONADJI_AUTOMOBILE, auto);
    }

    public Automobil ucitajAutomobil(Automobil a) throws Exception {
        
        return (Automobil) posaljiZahtev(Operacije.UCITAJ_AUTOMOBIL, a);
    }

    public ZakupAutomobila ucitajZakup(ZakupAutomobila z) throws Exception {
        
        return (ZakupAutomobila) posaljiZahtev(Operacije.UCITAJ_ZAKUP, z);
    }

    public void obrisiZakup(ZakupAutomobila zakup) throws Exception {
        
        posaljiZahtev(Operacije.OBRISI_ZAKUP, zakup);
    }
    
    public RacunZakupaAutomobila vratiRacunZakupa(ZakupAutomobila zakup) throws Exception {
        
        return (RacunZakupaAutomobila) posaljiZahtev(Operacije.VRATI_RACUN_ZAKUPA, zakup);
    }

    public void zapamtiRacunZakupa(ZakupAutomobila zakup) throws Exception {
     
        posaljiZahtev(Operacije.ZAPAMTI_RACUN_ZAKUPA, zakup);
    }  

    public void odjavi(Prodavac prodavac) throws Exception {
        posaljiZahtev(Operacije.ODJAVI, prodavac);
    }
}
