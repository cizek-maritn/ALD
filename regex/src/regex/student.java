/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regex;

/**
 *
 * @author Dell
 */
public class student {
    private final String jmeno;
    private final String prijmeni;
    private final char pismeno;
    private final int cislo;

    public student(String jmeno, String prijmeni, char pismeno, int cislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.pismeno = pismeno;
        this.cislo = cislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public char getPismeno() {
        return pismeno;
    }

    public int getCislo() {
        return cislo;
    }
    
    
}
