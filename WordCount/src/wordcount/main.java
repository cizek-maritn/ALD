/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package wordcount;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class main {
    private static final Scanner sc = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public static void main(String[] args) {
        String current; int all=0; String last=""; int n=0;
        List<word> word_list = new ArrayList();
        List<phrase> phrase_list = new ArrayList();
        boolean add;
        while (sc.hasNext()) {
            current=sc.next();
            add=true;
            all++;
            current=current.toLowerCase();
            word w = new word(current);
            //slova do word_listu
            for (int i=0;i<word_list.size();i++) {
                word temp=word_list.get(i);
                if (temp.getWord().equals(current)) {
                    add=false;
                    n=i;
                    break;
                }
            }
            if (!add) {
                word_list.get(n).increment();
            } else {
                word_list.add(w);
            }
            //fraze do phrase listu
            add=true;
            if (all>1) {
                phrase p=new phrase(last, current);
                for (int i=0;i<phrase_list.size();i++) {
                    phrase var=phrase_list.get(i);
                    if (var.getWord1().equals(last) && var.getWord2().equals(current)) {
                        add=false;
                        n=i;
                        break;
                    }
                }
                if (!add) {
                    phrase_list.get(n).increment();
                } else {
                    phrase_list.add(p);
                }
            }            
            last=current;
        }
        
        word_list.sort(new WordComp());
        phrase_list.sort(new PhraseComp());
        
        //vypis
        System.out.println("Word Frequency:");
        for (int i=0;i<15;i++) {
            word tmp=word_list.get(i);
            String s=" - " + tmp.getWord();
            for (int j=0;j<12-tmp.getWord().length();j++) {
                s=s+" ";
            }
            String a = df.format((tmp.getCount()/(double) all)*100);
            a=a.replaceFirst(",", ".");
            s=s+" " +a+"% (" + tmp.getCount() + ")";
            System.out.println(s);
        }
        System.out.println("Phrase Frequency:");
        for (int i=0;i<15;i++) {
            phrase tmp=phrase_list.get(i);
            String s=" - " + tmp.getWord1() + " " + tmp.getWord2();
            for (int j=0;j<20-tmp.getWord1().length()-1-tmp.getWord2().length();j++) {
                s=s+" ";
            }
            String a = df.format((tmp.getCount()/(double) all)*100);
            a=a.replaceFirst(",", ".");
            s=s+" "+a+"% (" + tmp.getCount() + ")";
            System.out.println(s);
        }
    }
    
    private static class WordComp implements Comparator<word> {
        @Override
        public int compare(word o1, word o2) {
            if (o1.getCount()>o2.getCount()) return -1;
            else if (o1.getCount()==o2.getCount()) return 0;
            else return 1;
        }
        
    }
    
    private static class PhraseComp implements Comparator<phrase> {
        @Override
        public int compare(phrase o1, phrase o2) {
            if (o1.getCount()>o2.getCount()) return -1;
            else if (o1.getCount()==o2.getCount()) return 0;
            else return 1;
        }
        
    }
}
