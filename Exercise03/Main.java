
public class Main {
    public static void main(String[] args) throws Exception{
        //in danh sach ng cos do tuoi tu a->b 
        System.out.println("danh sach so nguoi co do tuoi theo yeu cau tim kiem la:");
        DemoPerson.showPeopleByAge_20to30(20, 40);
        System.out.println("---------------------------------------------");

        //   Tuổi trung bình của tất cả mọi người
        System.out.println("Tuổi trung bình của tất cả mọi người la: " + DemoPerson.averageAge());
        System.out.println("---------------------------------------------");

        //   Tuổi trung bình theo từng quốc tịch
        System.out.println("Tuổi trung bình theo từng nuoc:");
        DemoPerson.averageAgeByNationality();
    }
}
