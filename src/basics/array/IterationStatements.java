package basics.array;

public class IterationStatements {
    public static void allTheIterationStatements(){
        int n=10;
        while(n>0){
            System.out.println(n);
            n--;
        }

        for(int i=0, x=10; i<10; i++){
            System.out.println(i+x);
        }
    }

    public static void forEachVersion(){
        int[] array1  = {1,2,3,4,5,6,7,8,9,10};
        int sum=0;
        for(int i=0; i<array1.length; i++){
            sum += array1[i];
        }
        System.out.println(sum);

        int sum2=0;
        for(int i: array1)
            sum2 += i;
        System.out.println(sum2);

        sum2=0;
        for(var x: array1)
            sum2+=x;

        System.out.println(sum2);
    }

    public static void main(String[] args){

    }
}
