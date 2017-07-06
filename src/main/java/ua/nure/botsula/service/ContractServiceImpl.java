package ua.nure.botsula.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.botsula.dao.ContractDao;
import ua.nure.botsula.model.Contract;

import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Override
    public Contract findContractById(Long id) {
        return contractDao.findContractById(id);
    }

    @Override
    public List<Contract> findAll() {
        return contractDao.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractDao.save(contract);
    }
}
