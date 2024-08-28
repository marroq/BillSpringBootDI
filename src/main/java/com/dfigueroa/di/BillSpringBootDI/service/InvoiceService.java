package com.dfigueroa.di.BillSpringBootDI.service;

import com.dfigueroa.di.BillSpringBootDI.model.Invoice;

import java.util.List;

public interface InvoiceService {

    public List<Invoice> getInvoices();

    public Invoice getInvoiceByName(String name);
}
