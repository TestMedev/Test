/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.medev.jeudedames;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kaoutar,mouad
 */
public class PionTest {
    
    public PionTest() {
    }

   

    /**
     * Test of deplacer method, of class Pion.
     */
    @org.junit.jupiter.api.Test
    public void testDeplacer() {
        System.out.println("deplacer");
        
        Plateau plateau = new Plateau(); 
        plateau.init();
        Pion pionBlanc = new Pion(new Point2D(1,1), "B");
        //Pion pionNoir = new Pion(new Point2D(6,6), "N"); 
        
        pionBlanc.deplacer(2, 2, plateau);
        assertEquals(2, pionBlanc.getPos().getX()); 
        assertEquals(2, pionBlanc.getPos().getY()); 
        assertEquals("B", plateau.getPlateau()[2][2]);
        assertEquals(".", plateau.getPlateau()[1][1]); 
        
        //deplacement hors plateau
        assertTrue(pionBlanc.deplacementValide(10,7,plateau));
    }

    
    /**
     * Test of prise method, of class Pion.
     */
    @org.junit.jupiter.api.Test
    public void testPrise() {
        System.out.println("prise");
        Plateau plateau = new Plateau();
        plateau.init();
        
        Pion pionBlanc = new Pion(new Point2D(2, 2), "B");
        Pion pionNoir = new Pion(new Point2D(3, 3), "N");

        plateau.getBlancs().add(pionBlanc);
        plateau.getNoirs().add(pionNoir);
        
        pionBlanc.prise(pionNoir, plateau);
        
        assertEquals(4, pionNoir.getPos().getX());
        assertEquals(4, pionNoir.getPos().getY());
        
    }
    
}
