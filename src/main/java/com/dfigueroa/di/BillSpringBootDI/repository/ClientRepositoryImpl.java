package com.dfigueroa.di.BillSpringBootDI.repository;

import com.dfigueroa.di.BillSpringBootDI.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private List<Client> clients;

    @Override
    public List<Client> getAllClients() {
        clients = Arrays.asList(
                new Client("Lot","Katla"),
                new Client("Edvin","Vanja"),
                new Client("Hasdrubal","Yara")
        );

        return  clients;
    }
}
