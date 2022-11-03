package solid.MediumBlog;


// BLOG - https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97
public class SingleResponsibilityPrinciple {
    // a class should have only one reason to change
}

class BankService{
    public long withDraw(){
        // withdraw amoutn
        return 0;
    }

    public void printPassBook(){
        // update transaction info in passbook
    }

    public void sendOTP(String medium){
        if(medium.equals("email")){
            // write email related logic
            // use JavaMailSender APi
        }
    }
}

// FIXME: violation of S as BankService has 3 reasons to change.
// printPassBook() - can be done in multiple ways
// sendOTP() - later on we can use sms, whatsapp as well.

class NewBankService {
    public long withDraw() {
        return 0;
    }
}

class PrinterService {
    public void printPassBook(){
        // update transaction in passBook
    }
}


class NotifyService{
    public void sendOTP(String mediujm){
        // send Notif
    }
}

// NOTE: each service has only one responsibilyt to perform.
