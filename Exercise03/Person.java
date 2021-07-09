public class Person {
    private String name;
    private String nationality;
    private int age;


    public Person() {}

    public Person(String name, String nationality, int age){
        this.name = name;
        this.nationality = nationality;
   

    public Person(String name, String email, String job, String gender, String city, int salary, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.job = job;
        this.gender = gender;
        this.city = city;
        this.salary = salary;
        this.birthdate = birthdate;
    }     this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
  public String toString() {
    return "Name: " + name + ", Nationality: " + nationality +  ", Age: " + age;
    
  }
    
}
