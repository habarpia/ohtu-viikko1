
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void varastossaOnAlkusaldo(){
        Varasto uusi = new Varasto(10, 5);
        
        // varaston saldoksi pitäisi tulla 5
        assertEquals(5, uusi.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusNollaJosAnnetaanNegatiivinenLukuKonstruktorissa(){
        Varasto uusi = new Varasto(-1);
        
        // varaston tilavuudeksi pitäisi tulla 0
        assertEquals(0, uusi.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanLaittaaLiikaa(){
        varasto.lisaaVarastoon(1000);
        
        // varaston saldon pitäisi olla tilavuus
        assertEquals(varasto.getTilavuus(), varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanOttaaNegatiivinenMaara(){
        
        // pitäisi saada 0
        assertEquals(0, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }
    
    @Test
    public void yritetaanOttaaLiikaa(){
        varasto.lisaaVarastoon(5);
        
        // pitäisi saada 5
        assertEquals(5, varasto.otaVarastosta(10), vertailuTarkkuus);
    }
    @Test
    public void annetaanAlkuSaldoMuttaTilavuusNegatiivinen(){
        Varasto uusi = new Varasto(-1, 5);
        
        // Tilavuuden pitäisi olla 0
        assertEquals(0, uusi.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void annetaanNegatiivinenAlkusaldo(){
        Varasto uusi = new Varasto(10, -1);
        
        // Saldon pitäisi olla 0
        assertEquals(0, uusi.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaaNegatiivinenMaara(){
        varasto.lisaaVarastoon(-1);
        
        // Saldon pitäisi olla 0
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringOikein(){
        // Tulostuksen pitäisi olla "saldo = 0, vielä tilaa 10".
       assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
}
