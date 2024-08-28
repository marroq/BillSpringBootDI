package com.dfigueroa.di.BillSpringBootDI.controller;

import com.dfigueroa.di.BillSpringBootDI.model.Invoice;
import com.dfigueroa.di.BillSpringBootDI.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices")
    public List<Invoice> getInvoice() {
        return invoiceService.getInvoices();
    }

    @GetMapping("/invoice")
    public Invoice getInvoice(@RequestParam String clientName) {
        return invoiceService.getInvoiceByName(clientName);
    }
}
