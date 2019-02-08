import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(100);

        for(int i = 0;i < 10;i++){
            personList.add(new Person((int)Math.random() * 16, i));
        }
        Iterator<Person> iterator = personList.iterator();
        while(iterator.hasNext()){
            Person temp = iterator.next();
            System.out.println(temp);
            if(temp.id == 5){
                iterator.forEachRemaining(s -> {
                    Person temp2 = iterator.next();
                    System.out.print("ID change from " + temp2.id);
                    temp2.id += 5;
                    System.out.print(" to " + temp2.id + "\n");
                });
            }
        }
        LinkedList<Person> personList2 = new LinkedList<>(personList);
        System.out.println(personList2.peekFirst());
        System.out.println(personList2.peekLast());
        Person p = personList2.poll();
        System.out.println(personList2.peekFirst());
        System.out.println(p);
        ListIterator<Person> descend = personList.listIterator(personList.size()-1);
        while(descend.hasPrevious()){
            System.out.println(descend.previous());
        }
    }
}
