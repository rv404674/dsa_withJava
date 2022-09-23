package classes;

class Box {
    int height;
    int width;
    int length;

    // Constructor for the Box
    // use to auto initialize the object upon creation.
    Box(){
        this.height = 10;
        this.width = 20;
        this.length = 30;
    }

    // Parametrized constructor meant for overloading.
    // this prevents namespace collision.
    // this always point to the current object from which the method was invoked.
    Box(int height, int width, int length){
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public int volume() {
        return this.height * this.width * this.length;
    }
}

public class BoxDemo {
    public static void main(String[] args){
        Box box = new Box();
        Box box1 = new Box(50,50,50);
        System.out.println(box.volume());
        System.out.println(box1.volume());
    }
}
