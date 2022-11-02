package solid.ConceptAndCoding.OpenClosePrinciple;

import solid.ConceptAndCoding.SingleResponsibilityPrinciple.Invoice;

//public class InvoiceDao {
//    Invoice invoice;
//
//    public InvoiceDao(Invoice invoice) {
//        this.invoice = invoice;
//    }
//
//    public void saveToDb() {
//        // save to DB
//    }
//}
// ^ Live code already taking traffic.

// NOTE: Now lets say we get onre more requirement of savingtofile
public class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb() {
        // save to DB
    }

    public void saveToFile(){
        // save to file
    }

    // FIXME: Violation of OpenClosed principle
    // as you modified a code already running in production thus introducing bugs.
}

// Break it down.
interface InvoiceDaoInterface{
    public void save();
}

class InvoiceDbDao implements InvoiceDaoInterface{

    @Override
    public void save() {
        // save to db.
    }
}

class InvoiceFileDao implements InvoiceDaoInterface{
    @Override
    public void save() {
        // save to file.
    }
}
