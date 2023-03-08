/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class lifo {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s; int top=0;
        Map<String, String> zasobnik = new HashMap<>();
        while (!(s=sc.nextLine()).isEmpty()) {
            top++;
            zasobnik.put("n"+top, s);
        }
        System.out.println(top);
    }
    
}
