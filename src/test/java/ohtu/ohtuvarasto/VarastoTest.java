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

    /*
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
    OHTU TESTIT BEGIN
     */
    //TESTATAAN ERI KONSTRUKTOREILLA
    @Test
    public void negatiivinenTilavuusLuoKayttoKelvottomanVaraston() {
        varasto = new Varasto(-1);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void negatiivinenTilavuusKuormitetulleKonstruktorilleEiToimi() {
        varasto = new Varasto(-1, 0);
        assertEquals(0, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void toimivaPuoliTyhjaVarasto() {
        varasto = new Varasto(10, 5);
        assertEquals(5, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void kuormitetunVarastonAlkuSaldoEiVoiOllaNegatiivinen() {
        varasto = new Varasto(10, -100);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastostaEiVoiOttaaLiikaa() {
        varasto.otaVarastosta(15);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastostaEiVoiOttaaOlematonta() {
        assertEquals(0, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }

    @Test
    public void varastoEiPursuaYli() {
        varasto.lisaaVarastoon(50);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonSaldoEiKasvaJosLisataanNegatiivinenMaaraSaldoa() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastonMerkkiJonoEsitysToimii() {
        varasto.lisaaVarastoon(3);
        assertEquals("saldo = " + 3.0 + ", vielä tilaa " + 7.0, varasto.toString());
    }

    /*
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
    OHTU TESTIT END
     */
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    /*
    PILATAAN TESTI Tehtävään 10
    Korjattu seuraavaan kohtaan
    */
    @Test
    public void lisaysLisaaSaldoaPILATTU() {
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

}
