package creational.factory.sudocode;

public class LLDCourse extends Course {
    @Override
    public void createCourse() {
        this.courseName = "Microsoft LLD COuse";
        this.creatorName = "Rahul";
        this.coursetype = COURSETYPE.LLD;
    }

    public String getInfo(){
        return (this.courseName + this.creatorName + this.coursetype);
    }
}
