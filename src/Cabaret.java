import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer performer)
    {
        if(performers.indexOf(performer) == -1)
        {
            performers.add(performer);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean removePerformer(Performer performer)
    {
        if(performers.indexOf(performer) != -1)
        {
            performers.remove(performer);
            return true;
        } else
        {
            return false;
        }
    }

    public double averagePerformerAge()
    {
        double total = 0;
        for (Performer per: performers) {
            total += per.getAge();
        }
        return total/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> old = new ArrayList<>();
        for (Performer per: performers) {
            if(per.getAge()>= age)
            {
                old.add(per);
            }
        }
        return old;
    }

    public void groupRehearsal()
    {
        for (Performer per: performers) {
            System.out.println("REHEARSAL CALL! " + per.getName());
            if(per instanceof Comedian)
            {
                ((Comedian) per).rehearse(false);
            } else
            {
                per.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer per: performers) {
            System.out.println("Welcome to the cabaret! Next act up… " + per.getName());
            if(per instanceof Dancer)
            {
                ((Dancer) per).pirouette(2);
                ((Dancer) per).perform();
            } else
            {
                per.perform();
            }
        }
    }


}
