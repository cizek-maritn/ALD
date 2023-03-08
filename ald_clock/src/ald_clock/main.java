/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald_clock;

import java.util.Scanner;

public class main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s; String output=""; int h3=0; int m3=0; int s3=0;
        while (!((s=sc.nextLine()).equals("---"))) {
            boolean broken=false;
            if (!s.equals("-")) {
                //nacteni
                String str1=s;
                String trash=sc.nextLine();
                String str3=sc.nextLine();
                String[] c1=str1.split(":");
                String[] c3=str3.split(":");
                //uprava
                c1[1]=c1[1].trim();
                c3[1]=c3[1].trim();
                if (c3[1].equals("broken")) broken=true;
                //hodnoty v hodinach
                int h1=Integer.parseInt(c1[1]);
                int m1=Integer.parseInt(c1[2]);
                int s1=Integer.parseInt(c1[3]);
                if (h1>=12) {
                    h1=h1-12;
                }
                m1=m1/5;
                s1=s1/5;
                if (!broken) {
                    h3=Integer.parseInt(c3[1]);
                    m3=Integer.parseInt(c3[2]);
                    s3=Integer.parseInt(c3[3]);
                    if (h3>=12) {
                        h3=h3-12;
                    }
                    m3=m3/5;
                    s3=s3/5;
                }
                //logika
                if (broken) {
                    if (h1==m1 && h1==s1) {
                        output+="1";
                    } else {
                        output +="7";
                    }
                } else if (h3==m3 && h3==s3) {
                    output+="3";
                } else if (h3!=0 && m3!=0 && s3!=0) {
                    output+="2";
                } else if (h3!=3 && m3!=3 && s3!=3) {
                    output+="0";
                } else if (h3!=m3 && h3!=s3 && m3!=s3) {
                    if (h1!=6 && m1!=6 && s1!=6) {
                        output+="6";
                    } else {
                        output +="8";
                    }
                } else {
                    if (h1!=6 && m1!=6 && s1!=6) {
                        output+="5";
                    } else if (h1!=9 && m1!=9 && s1!=9) {
                        output+="4";
                    } else {
                        output+="9";
                    }
                }
            }
            
        }
        System.out.println(output);
    }
    
}
