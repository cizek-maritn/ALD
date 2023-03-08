/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald1;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Ald1 {

    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println(1/2);
        int n=input.nextInt();
        for (int i=0;i<n;i++) {
            System.out.println("Hello world!");
        }
        int b; int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        while ((b=input.nextInt())!=42) {
            System.out.println(b);
        }
        System.out.println(min);
        System.out.println(max);
    }
    
}
