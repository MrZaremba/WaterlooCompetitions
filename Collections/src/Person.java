public class Person{
    int age;
    int id;

    Person(int age, int id){
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person other = (Person)obj;
            if(id == other.id) return true;
        }
        return false;
    }
    /*
    3 Conditions
    1. Must be consistent and return same integer unless information used in equals(Object method) has changed.
    2. If two Objects are equal, according to the equals(Object) method, then hashCode() method must
    produce the same integer
    3. If two Objects are unequal, according to the equals(object) method, it is not necessary
    the integer value produced by hashCode() method on each of the two Objects
    will be distinct.  It can be the same but producing the distinct integer on each of the two objects is better for
    improving performance hashed based collections
     */
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
