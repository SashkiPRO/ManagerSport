package ua.nure.botsula.service;

import net.proselyte.springsecurityapp.model.Contract;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface ContractService {
    Contract findContractById(Long id);
    List<Contract> findAll();
    void save(Contract contract);
    System.out.println();
}
