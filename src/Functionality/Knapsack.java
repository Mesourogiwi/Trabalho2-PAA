/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

/**
 *
 * @author luskas
 */
public class Knapsack {
    private int value;
    private boolean type;
    
    public Knapsack(){
        this.value = 0;
        this.type = false;
    }
    public int getValue() {
        return value;
    }

    public boolean isType() {
        return type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setType(boolean type) {
        this.type = type;
    } 
}
