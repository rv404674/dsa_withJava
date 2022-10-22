package creational.factory.gfg;

public abstract class Notification {
    public void getInfo(){
        System.out.println("Part of the notifications engine");
    }

    public abstract void notifyUser();
}
