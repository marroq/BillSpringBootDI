package com.dfigueroa.di.BillSpringBootDI.service;

import com.dfigueroa.di.BillSpringBootDI.model.Client;
import com.dfigueroa.di.BillSpringBootDI.repository.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepositoryImpl clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }
}
