/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg525.ga1;

import java.util.ArrayList;

/**
 *
 * @author Omar
 */
public class Ga1
{

    static ArrayList<Task> tasks;
            
    public static void main(String[] args)
    {
        fillArrylist();
        double bestDegredation = 1;
        while(true)
        {
            Genetic g = new Genetic(tasks, bestDegredation);
            g.StartGA();
            if(g.isValid())
                bestDegredation-= 0.05;
            else
                break;
        }
        System.out.println("best degredation reached is " + bestDegredation);
        
    }

    private static void fillArrylist()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
