package creational.factory.sudocode;

public class CourseFactory {
    // actual implementation  is here
    public static Course getCourse(String courseType){
        switch (courseType){
            case "LLD": {
                LLDCourse lldCourse = new LLDCourse();
                lldCourse.createCourse();
                return lldCourse;
            }
            case "HLD": {
                HLDCourse hldCourse = new HLDCourse();
                hldCourse.createCourse();
                return hldCourse;
            }
            default:
                return null;
        }
    }
}
