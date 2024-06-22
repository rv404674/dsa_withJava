package solid.ConceptAndCoding.DependencyInversionPrinciple;

public class Main {
    // D - Dependency Inversion Principles
    // NOTE: - class should depend on concrete classes rather than interface.
}

class WiredKeyBoard {

}

class WiredMouse {

}

// FIXME: Violation of D
// we are using concrete classes instead of depending on interface.
// What if in future we want Bluetooth Keyboard instead of Wired Keybouar.
class MacBook{
    private final WiredKeyBoard keyBoard;
    private final WiredMouse mouse;

    public MacBook() {
        this.keyBoard = new WiredKeyBoard();
        this.mouse = new WiredMouse();
    }
}

// NOTE: Solution.
interface Mouse{
    void movePosition();
}

interface Keyboard{
    void type();
}

// Now you can pass any keyboard you want.
class MacbookNew{
    private final Keyboard keyboard;
    private final Mouse mouse;

    public MacbookNew(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}


