package creational.factory.tutorialsPoint;

public class PlanFactory {
    public static Plan getPlan(String planType){
        switch (planType){
            case "commercial":
                return new CommercialPlan();
            case "residential":
                return new ResidentalPlan();
            default:
                return null;
        }
    }
}
