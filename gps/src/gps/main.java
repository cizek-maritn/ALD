/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gps;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (sc.hasNextLine()) {
        String str=sc.nextLine();
        String[] s = str.split(" ");
        String[] mesta = {"liberec", "ceska-lipa", "chrastava", "new-york", "turnov", "jablonec-nad-nisou"};
        int[][] cas = {
            {999,999, 12, 24, 22, 20}, 
            {999,999, 40, 10, 52,999}, 
            { 12, 40,999, 20,999,999}, 
            { 24, 10, 20,999, 15, 30}, 
            { 22, 52,999, 15,999, 22}, 
            { 20,999,999, 30, 22,999}
        };
        int[][] dalka= {
            {999,999, 10, 35, 26, 20}, 
            {999,999, 47, 30, 67,999}, 
            { 10, 47,999, 14,999,999}, 
            { 35, 30, 14,999, 40, 30}, 
            { 26, 67,999, 40,999, 24}, 
            { 20,999,999, 30, 24,999}
        };
        int start=0; int end=0;
        for (int i=0;i<6;i++) {
            if (mesta[i].equals(s[0])) {
                start=i;
            } else if (mesta[i].equals(s[1])) {
                end=i;
            }
        }
        
        //logika
        int dlen=0; int mlen; int city=-1; int clen=0;
        if (s[2].equals("nejkratsi")) {
            if (dalka[start][end]!=999) {
                mlen=dalka[start][end];
                clen=cas[start][end];
            } else {
                mlen=dalka[start][3]+dalka[3][end];
                clen=cas[start][3]+cas[3][end];
                city=3;
            }
            for (int i=0;i<6;i++) {
                if (dalka[start][i]<mlen) {
                    if (dalka[i][end]+dalka[start][i]<mlen) {
                        city=i;
                        dlen=dalka[i][end]+dalka[start][i];
                        clen=cas[i][end]+cas[start][i];
                    }
                }
            }
            if (dlen==0) {
                dlen=mlen;
            }
        } else {
           if (cas[start][end]!=999) {
                mlen=cas[start][end];
                dlen=dalka[start][end];
            } else {
                mlen=cas[start][3]+cas[3][end];
                dlen=dalka[start][3]+dalka[3][end];
                city=3;
            }
            for (int i=0;i<6;i++) {
                if (cas[start][i]<mlen) {
                    if (cas[i][end]+cas[start][i]<mlen) {
                        city=i;
                        clen=cas[i][end]+cas[start][i];
                        dlen=dalka[i][end]+dalka[start][i];
                    }
                }
            }
            if (clen==0) {
                clen=mlen;
            } 
        }
        //vypis
        String output="("+clen + " min, " + dlen + " km) ";
        if (city==-1) {
            output += mesta[start] + " -> " + mesta[end];
        } else {
            output += mesta[start] + " -> " + mesta[city] + " -> " + mesta[end];
        }
        System.out.println(output);
    }
    }
}
