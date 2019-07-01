package DM;

public class Person {
    private int theBossNumber = -1;
    private int id;
    public Person(int id, int boss){
        theBossNumber = boss;
        this.id = id;
    }

    public int getTheBossNumber() {
        return theBossNumber;
    }

    public int getId() {
        return id;
    }
}
