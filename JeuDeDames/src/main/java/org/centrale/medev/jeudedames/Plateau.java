/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.jeudedames;

import java.util.ArrayList;

/**
 *
 * @author kaou,mou
 */
public class Plateau {
    /**Attributs de la classe
     * 
     * plateau : un tableau de dimension 10x10
     */
    private final int size=10;
    private String[][] plateau;
    private ArrayList<Pion> blancs;
    private ArrayList<Pion> noirs;

    public int getSize() {
        return size;
    }

    public String[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(String[][] plateau) {
        this.plateau = plateau;
    }

    public ArrayList<Pion> getBlancs() {
        return blancs;
    }

    public void setBlancs(ArrayList<Pion> blancs) {
        this.blancs = blancs;
    }

    public ArrayList<Pion> getNoirs() {
        return noirs;
    }

    public void setNoirs(ArrayList<Pion> noirs) {
        this.noirs = noirs;
    }
    
    
    public Plateau() {
        plateau = new String[size][size];
        blancs = new ArrayList<>();
        noirs = new ArrayList<>();
    }
    
    /**Initialisation du plateau
     * Dans cette méthode on initialise la plateau
     * Les positions vides sur le plateau sont présentées par "."
     */
    public void init(){
        //plateau initialisé avec des "." signifiant des positions non occupées
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                plateau[i][j]=".";
            }
        }
        
        //on remplisse la plateau avec nos pion
        for(int i=1; i<5; i++){
            for(int j=0; j<=9; j=j+2){
                blancs.add(new Pion(new Point2D(i,j+(i%2)),"B"));
                plateau[i-1][j+(i%2)]="B";
                
                noirs.add(new Pion(new Point2D(9-i,9-j-(i%2)),"N"));
                plateau[9-i+1][9-j-(i%2)]="N";
            }
        }
    }
    
    
    /**
     * Cette méthode affiche notre plateau
     */
    public void afficher(){
        System.out.println("Affichage du plateau :");
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(plateau[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    
    
    
}
