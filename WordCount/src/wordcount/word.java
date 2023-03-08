/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordcount;

//ukladani slov a poctu vyskytu
public class word implements Comparable<word>{
    private final String word;
    private int count=1;

    public word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
    
    public void increment() {
        count++;
    }

    @Override
    public int compareTo(word o) {
        if (count>o.count) return 1;
        else if (count==o.count) return 0;
        else return -1;
    }
    
    
}
