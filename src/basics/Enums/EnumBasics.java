package basics.Enums;

public class EnumBasics {

    public enum Season {
        WINTER,
        SUMMER,
        RAINY
    }

    public static void main(String[] args){
        System.out.println("Learning Enums");

        for (Season s: Season.values()){
            System.out.println(s);
        }

        Season x = Season.RAINY;
        System.out.println("Value of WINTER IS" + Season.valueOf("WINTER"));
        System.out.println("Index of WINTER is " + Season.valueOf("WINTER").ordinal());
    }

}
