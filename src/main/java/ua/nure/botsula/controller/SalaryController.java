package ua.nure.botsula.controller;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.botsula.model.*;
import ua.nure.botsula.service.*;
import ua.nure.botsula.util.EventPropertiesEditor;
import ua.nure.botsula.util.SalaryContainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr on 15.06.2017.
 */
@Controller
public class SalaryController {
    @Autowired
    private UserService userService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private AwardService awardService;
    @Autowired
    private PenaltyService penaltyService;
    @Autowired
    private EventPropertiesEditor propertiesEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
          binder.registerCustomEditor(User.class, propertiesEditor);
     }


    @RequestMapping(value = "pay_salary", method = RequestMethod.GET)
    public String paySalary(Model model)
    {
        List<User> users= userService.findAll();
        List<Salary> salaries= new ArrayList<>();
        for(User user:users){
            if(user.getContract()!=null){
                Salary salary = new Salary();
                salary.setAmount(user.getContract().getSalary());
                salary.setDate(new DateTime());
                salary.setUser(user);
                for(Award award: user.getAwards()){
                    if (award.getStatus().equals("ACTIVE")){
                        salary.setAmount(salary.getAmount()+award.getAmount());
                    }
                }
                for(Penalty penalty: user.getPenalties()){
                    if (penalty.getStatus().equals("ACTIVE")){
                        double amount = salary.getAmount();
                        amount-=penalty.getAmount();
                        salary.setAmount(amount);
                    }
                }
                salaries.add(salary);
            }
        }
        double total = 0;
        for(Salary salary:salaries){
            total+=salary.getAmount();
        }
        SalaryContainer container = new SalaryContainer();
        container.setSalaryList(salaries);
        model.addAttribute("container",container );
        model.addAttribute("total", total);
        return "economist/pay_salary";
    }
    @RequestMapping(value = "pay_salary", method = RequestMethod.POST)
    public String commitSalary(Model model, @ModelAttribute("container") SalaryContainer container){
        for(Salary s:container.getSalaryList()){
            System.out.print(s.getAmount()+"" +s.getUser());

        }
        List<User> users= userService.findAll();
        for(User user:users){
            if(user.getContract()!=null){
                for (Award award:user.getAwards()){
                    if(award.getStatus().equals("ACTIVE")){
                        award.setStatus("DISABLE");
                        award.setDate(new DateTime());
                        awardService.save(award);
                    }
                }
                for (Penalty penalty:user.getPenalties()){
                    if(penalty.getStatus().equals("ACTIVE")){
                        penalty.setStatus("DISABLE");
                        penalty.setDate(new DateTime());
                        penaltyService.save(penalty);
                    }
                }

            }
                  }
        List<Salary> salaries = new ArrayList<>();
        for (Salary salary:container.getSalaryList()){
            salary.setDate(new DateTime());
            salaries.add(salary);

        }
        double total = 0;
        for(Salary salary:container.getSalaryList()){
            total+=salary.getAmount();
        }
        System.out.print(total+"SALARY");
         salaryService.save(salaries);
          BankAccount bankAccount = bankAccountService.findAll().get(0);
         bankAccount.setAmount(bankAccount.getAmount()-total);
         bankAccount.setDate(new DateTime());
         bankAccountService.save(bankAccount);


        return "redirect:/bank_state";
    }

}
