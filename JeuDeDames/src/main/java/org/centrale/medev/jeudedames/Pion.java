/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.medev.jeudedames;

import static java.lang.Math.sqrt;

/**
 * Class Pion
 * @author kaou,mou
 */
public class Pion {
    //Attributs de la classe
    /**
     * pos : position du pion dans le plateau
     * type : type du pion (blanc, noir, dame blanc, dame noir)
     */
    private Point2D pos;
    private String type;
    

    public Pion(Point2D pos, String type) {
        this.pos = pos;
        this.type = type;
    }
    
    public Pion(){
        
    }
    
    /**
     * méthode de déplacement du pion
     * @param x
     * @param y
     * @param p
     */
    public void deplacer(int x, int y, Plateau p){
        if(x<p.getSize() && y<p.getSize() ){
            p.getPlateau()[this.pos.getX()][this.pos.getY()]=".";
            p.getPlateau()[x][y]=type;

            this.pos.setX(x);
            this.pos.setY(y);
        }
        else{
            System.out.println("Déplacement non autorisé !");
        }  
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    /**
     * méthode de déplacement du pion
     * @param p : pion
     * @param pl : plateau dans lequel on joue
     */
    public void prise(Pion p, Plateau pl){
        if(this.pos.distance(p.pos)>sqrt(2) && this.type.charAt(0)==p.type.charAt(0)){
            System.out.println("Prise impossible pour ce pion");
        }
        else{
            Point2D new_pos = new Point2D(2*(p.pos.getX()-this.pos.getX()),2*(p.pos.getX()-this.pos.getX())); 
            if(!pl.getPlateau()[new_pos.getX()][new_pos.getY()].equals(".")){
                System.out.println("Prise impossible pour ce pion");
            }
            else{
                p.pos.setX(new_pos.getX());
                p.pos.setY(new_pos.getY());
            }
        }
    }
    
    public boolean deplacementValide(int x, int y, Plateau p) {
        
        if (x < 0 || y < 0 || x >= p.getSize() || y >= p.getSize()) return false;
        
        int val1 = Math.abs(x - this.pos.getX());
        
        int val2 = Math.abs(y - this.pos.getY());
        
        if (val1 != val2) return false;
        
        if (!p.getPlateau()[x][y].equals(".")) return false;
        if (this.type.equals("B") && x <= this.pos.getX()) return false;
        if (this.type.equals("N") && x >= this.pos.getX()) return false;
       return true;
    }
    
    
    
}
