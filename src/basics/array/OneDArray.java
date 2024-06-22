package basics.array;

class Helper{
    public void array_1(){
        int[] monthDays = new int[12];
        // rest will be zero by default.
        monthDays[0] = 31;
        monthDays[1] = 28;
        monthDays[2] = 31;

        for (int i=0; i<12; i++){
            System.out.println("Days in month "+ i + " " + monthDays[i]);
        }
    }

    public void array_2(){
        int[] monthDays = {31, 28, 31, 30};
        for (int i=0; i<4; i++){
            System.out.println("Days in month "+ i + " " + monthDays[i]);
        }
    }

}
public class OneDArray {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.array_1();
        helper.array_2();
    }
}
