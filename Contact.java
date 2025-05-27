// MODEL

public class Contact {
    private String name;
    private String surname;
    private int age;

    public Contact(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return name + " " + surname + ", věk:" + age;
    }
}
