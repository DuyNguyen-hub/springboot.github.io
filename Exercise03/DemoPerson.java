import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DemoPerson {
    public static ArrayList<Person> people = 
    new ArrayList<>(List.of(
    new Person("Vinh", "Vietnam", 28),
    new Person("Lan", "Vietnam", 24),
    new Person("John", "USA", 27),
    new Person("Lee", "China", 67),
    new Person("Kim", "Korea", 22),
    new Person("Long", "Vietnam", 18),
    new Person("Jungho", "Korea", 19),
    new Person("Tian", "China", 20),
    new Person("Clara", "USA", 40),
    new Person("Mikura", "Japan", 27),
    new Person("Sony", "Japan", 29),
    new Person("Xiang", "China", 78),
    new Person("Peter", "France", 18),
    new Person("Haloy", "Malaysia", 20),
    new Person("Magie", "Malaysia", 32)
    ));

//   Lọc người từ độ tuổi 20 -> 30
  
public static void showPeopleByAge_20to30(int ageStart, int ageEnd){
        people.stream()
            .filter(p -> p.getAge() >= ageStart && p.getAge() <= ageEnd)
            .forEach(System.out::println);
      }



//   Tuổi trung bình của tất cả mọi người
     
public static int averageAge(){
    Integer result = people.stream()
                                .mapToInt(a -> a.getAge())
                                .reduce(0, (a, b) -> a + b);

    return result / people.size();
}


//   Tuổi trung bình theo từng quốc tịch
public static  void averageAgeByNationality() {
    
    Set<String> nationalityList = people.stream()
        .map(s -> s.getNationality())
        .collect(Collectors.toSet());
       // System.out.println(nationalityList);
       for (String item : nationalityList) {
           Integer result = 
                            people.stream()
                            .filter(p -> p.getNationality().equals(item))
                            .mapToInt(s -> s.getAge())
                            .reduce(0, (a, b) -> a + b);
                  System.out.println(item +  ": " + result/sumsPeopleByNationality(item));  
                            
       }
  } 

  //ham tinh va tra ve tong  so nguoi cung nationality
  public static int sumsPeopleByNationality(String nationality) {
    return (int) people.stream()
                      .filter(p -> p.getNationality().equals(nationality))
                      .count();
}         
  

}
