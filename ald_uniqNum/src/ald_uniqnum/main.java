/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ald_uniqnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class main {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String s=""; int arr_num=1; int max_len=0;
        
        Map<String, int[]> arrays = new HashMap<>();
        //nacitani
        while (sc.hasNextLine()) {
            s=sc.nextLine();
            String[] str=s.split(",");
            
            int[] ints = new int[str.length];
            
            for (int i=0;i<str.length;i++) {
                ints[i]=Integer.parseInt(str[i]);
                
            }
            arrays.put("arr"+arr_num, ints);
            arr_num++;
            max_len=max_len+ints.length;
            
        }
        //zpracovani
        int top=0; //vrchol pole
        boolean add=true;
        int[][] m = new int[max_len][2];
        
        for (int i=1;i<arr_num;i++) {
            int[] temp=arrays.get("arr"+i);
            for (int j=0;j<temp.length;j++) {
                
                for (int k=0;k<top;k++) {
                    if (m[k][0]==temp[j]) {
                        add=false;
                        m[k][1]++;
                    }
                }
                if (add) {
                    m[top][0]=temp[j];
                    m[top][1]=1;
                    top++;
                } else {
                    add=true;
                }
            }
        }
        //vypis
        String all="all: "; String multi=">1x: "; String once="=1x: ";
        for (int i=0;i<top;i++) {
            all=all+m[i][0]+",";
            if (m[i][1]>1) {
                multi=multi+m[i][0]+",";
            } else {
                once=once+m[i][0]+",";
            }
        }
        all=all.substring(0,all.length()-1);
        multi=multi.substring(0, multi.length()-1);
        once=once.substring(0, once.length()-1);
        System.out.println(all);
        System.out.println(multi);
        System.out.println(once);
    }
    
}
