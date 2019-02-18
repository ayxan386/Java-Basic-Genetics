import java.util.ArrayList;
import java.util.Random;

public class Population {
    public ArrayList<person> people;
    public String goal;
    public int size;
    public Population(String goal,int size)
    {
        this.size = size;
        this.goal = goal;
        people = new ArrayList<>(this.size);
        for(int i=0;i<this.size;i++)
        {
            people.add(new person(goal.length()));
        }
    }
    public void newPop() {
        ArrayList<person> newpop = new ArrayList<>(this.size);
        for(int i=0;i<this.size;i++)
        {
            person a = choose();
            person b = choose();
            person child = a.cross(b);
            child.mutate();
            newpop.add(child);
        }
        this.people = newpop;
    }
    public person choose()
    {
        Random r = new Random();
        double sum = 0;
        for(person p : people)
        {
            sum+=p.fitness;
        }
        for(person p : people)
        {
            p.normFit = p.fitness / sum;
        }
        double choosen = r.nextDouble();
        for(person p : people)
        {
            if(choosen - p.normFit > 0)
                choosen-=p.normFit;
            else return p;
        }
        return people.get(0);
    }
    public void update()
    {
        for(int i=0;i<this.size;i++)
        {
            person prs = people.get(i);
            prs.calcFitness(this.goal);
            prs.update();
        }
    }
    public double showMax()
    {
        person pmax = people.get(0);
        for(person p : people)
        {
            if(p.fitness > pmax.fitness)
            {
                pmax = p;
            }
        }
        System.out.println("Current champ is ");
        pmax.update();
        return pmax.fitness;
    }
}
