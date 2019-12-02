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
public class Items {
    private int weight;
    private int value;
    private float result;
    
    public Items(int weight, int value, float result) {
        this.weight = weight;
        this.value = value;
        this.result = result;
    }
    public Items(){}

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
