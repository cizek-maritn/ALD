/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Dell
 */     
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jmeno=""; String prijmeni=""; char oc='a'; int cislo=0; char obor='a';
        List<student> listAI = new ArrayList();
        List<student> listAVI = new ArrayList();
        List<student> listIT = new ArrayList();
        List<student> listIS = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new FileReader("vstup.html"));
            String str;
            Pattern pat_obor = Pattern.compile("AI|AVI|IS<|IT");
            Pattern pat_oc = Pattern.compile("[MXZ]\\d");
            Pattern pat_jmena = Pattern.compile("\\s[A-Z][a-z]{2,}$");
            while ((str=in.readLine())!=null) {
                Matcher mat_obor = pat_obor.matcher(str);
                Matcher mat_oc = pat_oc.matcher(str);
                Matcher mat_jmena = pat_jmena.matcher(str);
                if (mat_jmena.find()) {
                    if (prijmeni.isBlank()) {
                        prijmeni=str.trim().toUpperCase();
                    } else if (jmeno.isBlank()) {
                        jmeno=str.trim();
                    }
                } else if (mat_oc.find()) {
                    str=str.trim();
                    oc=str.charAt(0);
                    cislo=Integer.parseInt(str.substring(1, 9));
                } else if (mat_obor.find()) {
                    obor=str.trim().charAt(44);
                    student s = new student(jmeno, prijmeni, oc, cislo);
                    switch (obor) {
                        case 'I': listAI.add(s); break;
                        case 'V': listAVI.add(s); break;
                        case 'S': listIS.add(s); break;
                        case 'T': listIT.add(s); break;
                    }
                    prijmeni="";
                    jmeno="";
                }
            }
        } catch (IOException e) {
            System.out.println("nevyslo");
        }
        listAI.sort(new Comp());
        listAVI.sort(new Comp());
        listIS.sort(new Comp());
        listIT.sort(new Comp());
        listAI.sort(new Comp2());
        listAVI.sort(new Comp2());
        listIS.sort(new Comp2());
        listIT.sort(new Comp2());
        //vypis
        System.out.println("AI:");
        int poradi=1; String out="";
        for (student s : listAI) {
                if (poradi<10) {
                    out=" "+poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="AI  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                } else {
                    out=poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="AI  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                }
            
        }
        System.out.println("");
        System.out.println("AVI:");
        poradi=1;
        for (student s : listAVI) {
                if (poradi<10) {
                    out=" "+poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="AVI "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                } else {
                    out=poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="AVI "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                }
            
        }
        System.out.println("");
        System.out.println("IS:");
        poradi=1;
        for (student s : listIS) {
                if (poradi<10) {
                    out=" "+poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="IS  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                } else {
                    out=poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="IS  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                }
            
        }
        System.out.println("");
        System.out.println("IS:");
        poradi=1;
        for (student s : listIT) {
                if (poradi<10) {
                    out=" "+poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="IT  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                } else {
                    out=poradi+": "+s.getPismeno()+" "+s.getPrijmeni()+" "+s.getJmeno();
                    for (int j=0;j<=18-s.getJmeno().length()-s.getPrijmeni().length();j++) {
                        out+=" ";
                    }
                    out+="IT  "+s.getCislo();
                    poradi++;
                    System.out.println(out);
                }
            
        }
    }

    private static class Comp implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            if (o1.getCislo()>o2.getCislo()) return 1;
            else if (o1.getCislo()==o2.getCislo()) return 0;
            else return -1;
        }
        
    }
    
    private static class Comp2 implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            if (o1.getCislo()%2==0 && o2.getCislo()%2==1) return 1;
            else if (o1.getCislo()%2==1 && o2.getCislo()%2==0) return -1;
            else return 0;
        }
        
    }
    
}
