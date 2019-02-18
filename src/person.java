import java.util.Random;

public class person {
    StringBuilder genes;
    double fitness;
    double normFit;
    public static double mutationRate = 0.01;
    public static String letters = "abcdefghijklmnopqrtsuvwxyz .,!ABCDEFGHIJKLMNOPQRTSUVWXYZ";
    public person(int l)
    {
        Random rdm = new Random();
        genes = new StringBuilder("");
        for(int i=0;i<l;i++)
            genes.append(letters.charAt(rdm.nextInt(letters.length())));
        fitness = 0;
    }
    public person(String s)
    {
        genes = new StringBuilder(s);
        fitness = 0;
    }
    public person cross(person other)
    {
        String res = "";
        res = genes.substring(0,genes.length()/2) + other.genes.substring(genes.length()/2);
        person prs = new person(res);
        return prs;
    }
    public void mutate()
    {
        Random rdm = new Random();
        for(int i=0;i<genes.length();i++)
        {
            if(rdm.nextDouble() < mutationRate)
            {
                char c = letters.charAt(rdm.nextInt(letters.length()));
                genes.replace(i,i+1,c + "");
            }
        }
    }
    public void calcFitness(String goal)
    {
        int res = 0;
        for(int i=0;i<goal.length();i++)
            if(goal.charAt(i) == genes.charAt(i))
                res++;
        this.fitness = 1. * res / goal.length();
    }
    public void update()
    {
        System.out.println("Fitness : " + fitness + " : " + genes);
    }
}
