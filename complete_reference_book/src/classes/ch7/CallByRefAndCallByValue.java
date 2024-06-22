package classes.ch7;

class Test{

    int a,b;
    Test() {
        System.out.println("Empty");
    }

    Test(int a, int b){
        this.a = a;
        this.b = b;
    }

    /**
     * NOTE: Call by Value.
     * In case of primitive types, Java uses call by value.
     * In call by value, a copy of the method params will be made and then will be sent to the method..
     * Thus the original arguements will remain unchanged
     */
    void add(int a, int b) {
        a = a+10;
        b = b+10;
    }

    /**
     * NOTE: Call by Reference
     * In case of Non primitive Types. call by Reference is used.
     * In call by reference, a reference (pointer) to the original object is sending.
     * Thus any change to the object, will affect the original object.
     */
    void add(Test test){
        test.a += 10;
        test.b += 10;
    }

}


public class CallByRefAndCallByValue {

    public static void main(String args[]){
        int a = 10, b = 10;
        Test test = new Test();
        System.out.println("Before method" + a + " " + b);
        test.add(a, b);
        System.out.println("After method" + a + " " + b);

        Test test2 = new Test(10,10);
        System.out.println("Before method" + 10 + " " + 10);
        test2.add(test2);
        System.out.println("After method" + test2.a + " " + test2.b);




    }
}
