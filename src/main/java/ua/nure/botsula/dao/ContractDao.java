package ua.nure.botsula.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.nure.botsula.model.Contract;

/**
 * Created by Alexandr on 14.06.2017.
 */
public interface ContractDao extends JpaRepository<Contract, Long> {
   Contract findContractById(Long id);
}
