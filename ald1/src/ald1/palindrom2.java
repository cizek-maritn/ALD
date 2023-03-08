/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class palindrom2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String cislo; int len; boolean carry; long result; int temp; boolean smaller;
        while (!"-1".equals(cislo=input.nextLine())) {
            carry=false; smaller=false;
            len = String.valueOf(cislo).length();
            int[] num = new int[len];
            int[] pal = new int[len+1];
            for (int i=0;i<len;i++) {
                num[i]=Integer.parseInt(cislo.substring(len-i-1, len-i));
            }
            //jednociferna cisla
            if (len==1) {
                temp=Integer.parseInt(cislo)+1;
                if (temp==10) result=11;
                else result=temp;
                System.out.println(result);
            //viceciferna cisla
            } else {
                for (int i=0;i<len/2;i++) {
                    if (num[i]>num[len-i-1] && smaller) {
                        smaller=false;
                    } else if (num[i]<num[len-i-1]) {
                        smaller=true;
                    }
                }
                if (smaller) {
                    if (len%2==1) {
                        for (int i=0;i<=len/2;i++) {
                            pal[i]=num[len-i-1];
                            pal[len-i-1]=pal[i];
                        }
                    } else {
                        for (int i=0;i<len/2;i++) {
                            pal[i]=num[len-i-1];
                            pal[len-i-1]=pal[i];
                        }
                    }
                } else {
                    if (len%2==1) {
                        for (int i=0;i<=len/2;i++) {
                            pal[i]=num[len-i-1];
                            pal[len-i-1]=pal[i];
                        }
                        pal[len/2]++;
                    } else {
                        for (int i=0;i<len/2;i++) {
                            pal[i]=num[len-i-1];
                            pal[len-i-1]=pal[i];
                        }
                        pal[len/2]++;
                        pal[len/2-1]++;
                    }
                }
                //eliminace 10
                for (int i=len/2;i>=0;i--) {
                    if (pal[i]>=10 && i!=0) {
                        pal[i]=0;
                        pal[i-1]++;
                    } else if (pal[i]>=10 && i==0) {
                        pal[i]=1;
                        carry=true;
                    }
                }
                //mirroring pro zvysenej rad
                if (carry) {
                    for (int i=0;i<=len/2;i++) {
                        pal[len-i]=pal[i];
                    }
                }
                //tvorba vypisu z array
                String s="";
                for (int i=0;i<=len;i++) {
                    if (!(pal[len]==0 && i==len)) {
                        s+=pal[i];
                    }
                }
                System.out.println(s);
            }
        }
    }
    
}