package exception;

import java.io.IOException;

public class exceptionBasics {
    // NOTE:
    //  Resouces https://www.javatpoint.com/exception-handling-in-java
    // finally - https://www.javatpoint.com/finally-block-in-exception-handling
    // checked exceptions - checked at compiletime (IOException, Socket Exception)
    // unchecked - checked at rntime. (ArithmeticException, Null Pointer, Index out of bound

    // NOTE: keywords
    // try - specified the block where an exception occur
    // catch - if the exception occurs catches it.
    // finally - will always be execute, whether the exception occurs or not.
    // throw - throw an exception explicity
    // throws - always used with function signature. Denotes that this method might throw an exception.

    public static void main(String[] args) {
        // try catch finally
        try {
            System.out.println("Inside try block");
            int data = 25/0;
            System.out.println(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // NOTE: this will always execute
            System.out.println("final block is execute");
        }

        TestThrow.validateAge(19);

        TestThrows testThrows = new TestThrows();
        // for throws - become a checked exception.
        // need to add it in a try catch.
        try {
            testThrows.m();
        } catch (Exception e){
            System.out.println("Exception occured.");
        }
        
        // arithmetic Exception
        int x = 50/0;

        // Null Pointer Exception
        String s = null;
        System.out.println(s.length());
    }
}

class TestThrow{
    // unchecked exception - will be chedked at runtime.
    public static void validateAge(int age){
        if(age < 18){
            throw new ArithmeticException("Person is not eligbilye to vote");
        } else {
            System.out.println("Person is eligible to vote");
        }
    }
}

class TestThrows {
    void m() throws IOException {
        throw new IOException("device doesnt exist");
    }
}

