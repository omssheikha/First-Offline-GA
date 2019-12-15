/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg525.ga1;

import java.util.Random;

/**
 *
 * @author Omar
 */
public class Chromosome
{
    private int[] chromosome;
    private Choices choices;
    private int fitness;
    private boolean valid = false;
    
    public Chromosome(Choices validchoices)
    {
        chromosome = new int[validchoices.getMaxdeadline()];
        choices = validchoices;
        RandmoizeChromosome();
    }

    public boolean isValid()
    {
        return valid;
    }
    
    public int[] getChromosome()
    {
        return chromosome;
    }
    
    public int getGene(int i)
    {
        return chromosome[i];
    }

    public int getFitness()
    {
        return fitness;
    }

    public void setFitness(int fitness)
    {
        this.fitness = fitness;
    }
    
    private void RandmoizeChromosome()
    {
        for(int i = 0; i < chromosome.length; i++)
        {
            chromosome[i] = choices.getRandomChoice(i);
        }
    }
    
    public Chromosome(Chromosome mother, Chromosome father, int point)
    {
        chromosome = new int[mother.getChromosome().length];
        System.arraycopy(mother.getChromosome(), 0, chromosome, 0, point);
        System.arraycopy(father.getChromosome(), point, chromosome, point, chromosome.length - point);
    }

    void mutate(Choices validChoices)
    {
        Random r = new Random();
        int c = r.nextInt(chromosome.length);
        chromosome[c] = choices.getRandomChoice(c);
    }
    
    void checkValidity(int total)
    {
        if(fitness >= total)
            valid = true;
        valid = false;
    }

    
}
