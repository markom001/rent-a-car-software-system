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
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.Date;
import so.SOIzmeniMusteriju;
import so.SOObrisiZakup;
import so.SOPronadjiAutomobile;
import so.SOPronadjiMusterije;
import so.SOPronadjiProdavca;
import so.SOPronadjiZakupe;
import so.SOUcitajAutomobil;
import so.SOUcitajListuAutomobila;
import so.SOUcitajListuKategorijaVozaca;
import so.SOUcitajListuSlobodnihTermina;
import so.SOUcitajMusteriju;
import so.SOUcitajZakup;
import so.SOVratiAutoTermine;
import so.SOVratiMusterije;
import so.SOVratiRacunZakupa;
import so.SOVratiZakupe;
import so.SOZapamtiAutoTermin;
import so.SOZapamtiMusteriju;
import so.SOZapamtiRacunZakupa;
import so.SOZapamtiZakup;

/**
 *
 * @author mitro
 */
public class ServerKontroler {
    
    private static ServerKontroler instance;
    private ArrayList<Prodavac> listaProdavaca;
    ServerskaForma sf;
    
    public ArrayList<Prodavac> getListaProdavaca() {
        return listaProdavaca;
    }

    public void setListaProdavaca(ArrayList<Prodavac> listaProdavaca) {
        this.listaProdavaca = listaProdavaca;
    }
    
    public void dodajUListu(Prodavac p){
        listaProdavaca.add(p);
        sf.popuniKombo(listaProdavaca);
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }
   
    public boolean postojiUListi(Prodavac prodavac){
        for (Prodavac p : listaProdavaca) {
            if(prodavac.getKorisnickoIme().equals(p.getKorisnickoIme()) && prodavac.getLozinka().equals(p.getLozinka())){
                return true;
            }
        }
        return false;
    }

    private ServerKontroler() {
        listaProdavaca = new ArrayList<>();
        sf = new ServerskaForma();
    }

    public static ServerKontroler getInstance() {
        if(instance == null){
            instance = new ServerKontroler();
        }
        return instance;
    }

    public Prodavac pronadjiProdavca(Prodavac prodavac) throws Exception {
        
        SOPronadjiProdavca so = new SOPronadjiProdavca();
        so.template(prodavac);
        return so.getProdavac();
    }

    public ArrayList<KategorijaVozaca> ucitajListuKategorijaVozaca() throws Exception {
        
        SOUcitajListuKategorijaVozaca so = new SOUcitajListuKategorijaVozaca();
        so.template(new KategorijaVozaca());
        return so.getListaKategorija();
    }

    public void zapamtiMusteriju(Musterija musterija) throws Exception {
        SOZapamtiMusteriju so = new SOZapamtiMusteriju();
        so.template(musterija);     
    }

    public ArrayList<Musterija> vratiMusterije() throws Exception {
        SOVratiMusterije so = new SOVratiMusterije();
        so.template(new Musterija());
        return so.getListaMusterija();
    }

    public ArrayList<Musterija> pronadjiMusterije(Musterija musterija) throws Exception {
        SOPronadjiMusterije so = new SOPronadjiMusterije();
        so.template(musterija);
        return so.getListaMusterija();
    }

    public Musterija ucitajMusteriju(Musterija musterija) throws Exception {
        SOUcitajMusteriju so = new SOUcitajMusteriju();
        so.template(musterija);
        return so.getMusterija();
    }

    public void izmeniMusteriju(Musterija musterija) throws Exception {       
        SOIzmeniMusteriju so = new SOIzmeniMusteriju();
        so.template(musterija);
    }

    public ArrayList<SlobodanTermin> ucitajListuSlobodnihTermina() throws Exception {
        SOUcitajListuSlobodnihTermina so = new SOUcitajListuSlobodnihTermina();
        so.template(new SlobodanTermin());
        return so.getListaSlobodnihTermina();
    }

    public ArrayList<Automobil> ucitajListuAutomobila() throws Exception {
        SOUcitajListuAutomobila so = new SOUcitajListuAutomobila();
        so.template(new Automobil());
        return so.getListaAutomobila();
    }

    public void zapamtiAutoTermin(AutomobilSaTerminom automobilSaTerminom) throws Exception {
        SOZapamtiAutoTermin so = new SOZapamtiAutoTermin();
        so.template(automobilSaTerminom);
    }

    public ArrayList<AutomobilSaTerminom> vratiAutoTermine() throws Exception {
        SOVratiAutoTermine so = new SOVratiAutoTermine();
        so.template(new AutomobilSaTerminom());
        return so.getListaAutoTermina();
    }

    public void zapamtiZakup(ZakupAutomobila zakupAutomobila) throws Exception {
        SOZapamtiZakup so = new SOZapamtiZakup();
        so.template(zakupAutomobila);
    }

    public ArrayList<ZakupAutomobila> vratiZakupe() throws Exception {
        SOVratiZakupe so = new SOVratiZakupe();
        so.template(new ZakupAutomobila());
        return so.getListaZakupa();
    }

    public ArrayList<ZakupAutomobila> pronadjiZakupe(ZakupAutomobila zakupAutomobila) throws Exception {
        SOPronadjiZakupe so = new SOPronadjiZakupe();
        so.template(zakupAutomobila);
        return so.getListaZakupa();
    }

    public ArrayList<Automobil> pronadjiAutomobile(Automobil automobil) throws Exception {
        SOPronadjiAutomobile so = new SOPronadjiAutomobile();
        so.template(automobil);
        return so.getListaAutomobila();
    }

    public Automobil ucitajAutomobil(Automobil automobil) throws Exception {
        SOUcitajAutomobil so = new SOUcitajAutomobil();
        so.template(automobil);
        return so.getAutomobil();
    }

    public ZakupAutomobila ucitajZakup(ZakupAutomobila zakupAutomobila) throws Exception {
        SOUcitajZakup so = new SOUcitajZakup();
        so.template(zakupAutomobila);
        return so.getZakup();
    }

    public void obrisiZakup(ZakupAutomobila zakupAutomobila) throws Exception {
        SOObrisiZakup so = new SOObrisiZakup();
        so.template(zakupAutomobila);
    }

    public RacunZakupaAutomobila vratiRacunZakupa(ZakupAutomobila zakupAutomobila) throws Exception {
        
        SOVratiRacunZakupa so = new SOVratiRacunZakupa();
        RacunZakupaAutomobila racun = new RacunZakupaAutomobila();
        racun.setZakupAutomobila(zakupAutomobila);
        so.template(racun);
        return so.getRacun();
    }

    public void zapamtiRacunZakupa(ZakupAutomobila zakupAutomobila) throws Exception {
        
        SOZapamtiRacunZakupa so = new SOZapamtiRacunZakupa();
        RacunZakupaAutomobila racun = new RacunZakupaAutomobila();
        racun.setZakupAutomobila(zakupAutomobila);
        racun.setDatumIzdavanja(new Date());
        so.template(racun);      
    }      

    public void odjavi(Prodavac prodavac) {
        for(int i = 0; i < listaProdavaca.size(); i++){
            if(prodavac.getIme().equals(listaProdavaca.get(i).getIme()) && prodavac.getPrezime().equals(listaProdavaca.get(i).getPrezime())){
                listaProdavaca.remove(i);
            }
        }
        sf.popuniKombo(listaProdavaca);
    }
}
