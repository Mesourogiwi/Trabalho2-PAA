/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author luskas
 */
public class Huffman {
    private static class Node implements Comparable<Node>
    {
        private final char character;
        private final int frequency;
        private final Node left, right;
        
        Node(char character, int frequency, Node left, Node right)
        {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int compareTo(Node node)
        {
            return(this.frequency - node.frequency);
        }
        
        private boolean leaf()
        {
            if(left == null && right == null) return(true);
            else return(false);
        }
    }
    
    
    public static String codify(String text)
    {
        char[] data = text.toCharArray();
        
        int[] frequency = new int[256];
        for(int i = 0; i < data.length; i++)
        {
            frequency[data[i]]++;
        }
        
        ArrayList<Node> tree = new ArrayList<>();
        for(char i = 0; i < 256; i++)
        {
            if(frequency[i] > 0) tree.add(new Node(i, frequency[i], null, null));
        }
        Collections.sort(tree);
        
        while(tree.size() > 1)
        {
            Node left = tree.get(0);
            tree.remove(0);
            Node right = tree.get(0);
            tree.remove(0);
            tree.add(new Node('\0', left.frequency + right.frequency, left, right));
            Collections.sort(tree);
        }
        
        Node raiz = tree.get(0);
        tree.clear();
        
        String[] st = new String[256];
        table(st, raiz, "");
        
        String output = "";
        for(int i = 0; i < data.length; i++)
        {
            output = output + st[data[i]];
        }
        
        return(output);
    }
    
    private static void table(String[] st, Node raiz, String s)
    {
        if(raiz.leaf() == false)
        {
            table(st, raiz.left, s + '0');
            table(st, raiz.right, s + '1');
        }
        else
        {
            st[raiz.character] = s;
        }
    }
}
