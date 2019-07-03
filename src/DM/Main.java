package DM;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private ArrayList<Person> persons = new ArrayList<>();
    static private ArrayList<Integer> loops = new ArrayList<>();
    static private int numOfPeople;
    private static int answer;

    public static void main(String[] args) {
        input();
        solve();
        outPut();
    }

    public static void input(){
        Scanner input = new Scanner(System.in);
        numOfPeople = input.nextInt();
        for(int i=0; i<numOfPeople; i++){
            int boss = input.nextInt();
            persons.add(new Person(i+1,boss));
        }
        input.close();
    }

    public static void solve(){
        ArrayList<Person> personArrayList = new ArrayList<>(persons);
        while (personArrayList.size()>0){
            ArrayList<Person> loop = new ArrayList<>();
            Person person = personArrayList.get(0);
            while (true){
                if(loop.contains(person)){
                    int index = loop.indexOf(person);
                    loops.add(loop.size()-index);
                    break; //
                }
                if(!personArrayList.contains(person)){
                    break;
                }
                personArrayList.remove(person);
                loop.add(person);
                if(person.getTheBossNumber() == -1){
                    break;
                }
                person = persons.get(person.getTheBossNumber()-1);
            }
            loop.clear();
        }
    }

    public static void outPut(){
        if(persons.size()<3){
            System.out.print(persons.size());
            answer = persons.size();
        }else{
            for(Integer i : loops){
                if(i>3 && i%3==2){
                    System.out.print(5);
                    answer = 5;
                    return;
                }else if(i>3 && i%3==1){
                    System.out.print(4);
                    answer = 4;
                    return;
                }
            }
            System.out.print(3);
            answer = 3;
            return;
        }
    }
}