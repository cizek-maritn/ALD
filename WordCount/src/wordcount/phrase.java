/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordcount;

//ukladani frazi a poctu vyskytu
public class phrase implements Comparable<phrase>{
    private final String word1;
    private final String word2;
    private int count=1;

    public phrase(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    public String getWord1() {
        return word1;
    }

    public String getWord2() {
        return word2;
    }

    public int getCount() {
        return count;
    }
    
    public void increment() {
        count++;
    }

    @Override
    public int compareTo(phrase o) {
        if (count>o.count) return 1;
        else if (count==o.count) return 0;
        else return -1;    
    }
}
