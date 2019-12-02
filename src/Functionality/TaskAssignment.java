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
public class TaskAssignment {
    private int solutionBestValue;
    private int[] localSolution;
    private boolean hasSolution;
    private int[] finalSolution;
    
    public TaskAssignment(int tableLenght){
        this.solutionBestValue = 0;
        this.localSolution = new int[tableLenght];
        this.hasSolution = false;
        this.finalSolution = new int[tableLenght];
    }
    
    private void copySolution(){
        for(int i=0;i<localSolution.length;i++){
            finalSolution[i] = localSolution[i];
        }
    }
    
    public int[] optimization(int table[][]){
        calculusOptimization(table, 0, 0);
        return finalSolution;
    }
    
    private boolean isFreePerson(int max,int personIndex){
        for(int j=0; j<max;j++){
            if(this.localSolution[j] == personIndex){
                return false;
            }
        }
        return true;
    }
    
    public int getBestSolutionValue(){
        return solutionBestValue;
    }
    
    private void calculusOptimization(int table[][],int i, int currentSolution){
        if(i >= this.finalSolution.length){
            copySolution();
            this.hasSolution = true;
            this.solutionBestValue = currentSolution;
            return;
        }
        
        for(int j=0;j< this.finalSolution.length;j++){
            if(hasSolution == false || 
                currentSolution + table[j][i] < this.solutionBestValue){
                
                if(this.isFreePerson(i,j)){
                    localSolution[i] = j;
                    calculusOptimization(table, i+1, currentSolution + table[j][i]);
                }     
            }
        }
    }
    
    
}
