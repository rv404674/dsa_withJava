package creational.factory.sudocode;

public class ClientCode {
    public static void main(String[] args) {
        Course hldCourse = CourseFactory.getCourse("HLD");
        Course lldCourse = CourseFactory.getCourse("LLD");

        System.out.println("HLD Couse");
        System.out.println(hldCourse.courseName);

        System.out.println("LLD Couse");
        System.out.println(lldCourse.courseName);
    }
}
