/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald_lifo;

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
        String s; int top=0; String su; char[] c;
        Map<String, String> zasobnik = new HashMap<>();
        while (sc.hasNextLine()) {
            s=sc.nextLine();
            su="";
            top++;
            c=s.toCharArray();
            if (c.length>1) {
                c[0]=Character.toUpperCase(c[0]);
                for (int i=0; i<s.length()-1; i++) {
                    if (Character.isSpaceChar(c[i+1])) {
                        c[i+2]=Character.toUpperCase(c[i+2]);
                    }
                    su+=c[i];
                }
                su+=c[s.length()-1];
                zasobnik.put("n"+top, su);
            }
            
        }
        for (int i=top;i>0;i--) {
            System.out.println(zasobnik.get("n"+i));
        }
        
    }
    
}
