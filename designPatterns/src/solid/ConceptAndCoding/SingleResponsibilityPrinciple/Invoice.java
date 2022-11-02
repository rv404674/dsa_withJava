package solid.ConceptAndCoding.SingleResponsibilityPrinciple;

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return (marker.price) * quantity;
    }

    public void printInvoice(){
        // print the invoice
    }

    public void saveToDb(){
        // save the data to DB
    }
}

// FIXME: THIS IS A VIOLATION OF SRP as
// calculateTotal() - what if you need to add gst
// printInvoice() - printing can vary
// saveToDB() - you need to save it to file
// NOTE: So basically there are three reasons to change.

// NOTE: Soln break it down into multiple files
class NewInvoice {
    private Marker marker;
    private int quantity;

    public NewInvoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal(){
        return (marker.price) * quantity;
    }
}

class InvoiceDao{
    Invoice invoice;

    public InvoiceDao(Invoice invoice){
        this.invoice = invoice;
    }

    public void saveToDb(){
        // save into db
    }
}

class InvoicePrinter{
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }
    public void printInvoice(){
        // print the invoice
    }
}

// NOTE: now every class just have one reason to change.