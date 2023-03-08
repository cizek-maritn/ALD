/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald_cv1;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Ald_cv1 {

    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n=2000;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        for (int i=0; i<n;i++) {
            arr1[i]=i;
            arr2[i]=n-i;
            if (i%2==0) {
                arr3[i/2]=i;
            } else {
                arr3[(n-1)-(i/2)]=i;
            }
        }
        //linearni
        long start = System.nanoTime();
        long finish=0; double result;
        int k=1859;
        for (int a : arr1) {
            if (a==k) { finish=System.nanoTime();
            
            }
        }
        result = (finish-start)/1000000000.;
        System.out.println("linear = " + result);
        //lin, log, kub, kvadr
        start=System.nanoTime();
        for (int a : arr1) {
            for (int b : arr2) {
                if (b==a && a==k) {
                    finish=System.nanoTime();
                    
                }
            }
        }
        result = (finish-start)/1000000000.;
        System.out.println("quadratic = " + result);
        
        start=System.nanoTime();
        for (int a : arr1) {
            for (int b : arr2) {
                for (int c : arr3) {
                    if (b==a && a==k && a==c) {
                    finish=System.nanoTime();
                    
                    }
                }
            }
        }
        result = (finish-start)/1000000000.;
        System.out.println("cubic = " + result);
        
        start = System.nanoTime();
        int q=n/2;
        for (int i=0; i<n/2;i++) {
            if (arr1[q]==k) { finish=System.nanoTime(); break;
            } else {
                if (arr1[q]>k) {
                    q-=(n-q)/2;
                } else {
                    q+=((n-q)/2);
                }
            }
        }
        result = (finish-start)/1000000000.;
        System.out.println("N/2? = " + result);
    }
    
}
