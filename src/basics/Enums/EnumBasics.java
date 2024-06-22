package basics.Enums;

public class EnumBasics {

    public enum Season {
        WINTER,
        SUMMER,
        RAINY
    }

    // More Practical Prod UseCase.
    public enum BookingStatus {
        COMPLETED("COMPLETED"),
        IN_TRANSIT("IN_TRANSIT"),
        UPCOMING("UPCOMING");

        private final String value;

        BookingStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args){
        System.out.println("Learning Enums");

        for (Season s: Season.values()){
            System.out.println(s);
        }

        Season x = Season.RAINY;
        System.out.println("Value of WINTER IS" + Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is " + Season.valueOf("WINTER").ordinal());

        BookingStatus completedBooking = BookingStatus.COMPLETED;
        System.out.println(completedBooking.getValue());
    }

}
