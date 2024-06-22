package creational.factory.sudocode;

public class HLDCourse extends Course{

    @Override
    public void createCourse() {
        this.courseName = "Sudocode HLD Course";
        this.creatorName = "Ankita";
        this.coursetype = COURSETYPE.HLD;
    }

    public String getInfo(){
        return (this.courseName + this.creatorName + this.coursetype);
    }
}
