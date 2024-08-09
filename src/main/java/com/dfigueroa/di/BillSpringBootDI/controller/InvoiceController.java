package com.dfigueroa.di.BillSpringBootDI.controller;

import com.dfigueroa.di.BillSpringBootDI.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    Invoice invoice;

    @GetMapping("/invoice")
    public Invoice getInvoice() {
        return invoice;
    }
}
