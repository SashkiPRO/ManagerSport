package ua.nure.botsula.controller;

import net.proselyte.springsecurityapp.enums.AwardType;
import net.proselyte.springsecurityapp.model.*;
import net.proselyte.springsecurityapp.service.*;
import net.proselyte.springsecurityapp.util.EmployeePropertiesEditor;
import net.proselyte.springsecurityapp.util.EventPropertiesEditor;
import net.proselyte.springsecurityapp.util.SalaryPropertiesEditor;
import net.proselyte.springsecurityapp.validator.PasswordValidator;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandr on 14.06.2017.
 */
@Controller
public class EconomistController {
    @Autowired
    private UserService userService;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ReplenishmentService replenishmentService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeePropertiesEditor employeePropertiesEditor;
    @Autowired
    private PenaltyService penaltyService;
    @Autowired
    private PasswordValidator passwordValidator;
    @Autowired
    private AwardService awardService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private SalaryPropertiesEditor salaryPropertiesEditor;
    @Autowired
    private EventPropertiesEditor propertiesEditor;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    //    binder.registerCustomEditor(User.class, propertiesEditor);
        binder.registerCustomEditor(Salary.class, this.salaryPropertiesEditor);
       binder.registerCustomEditor(User.class, this.employeePropertiesEditor);
    }

    @RequestMapping(value = "economist_cabinet")
    public String economistCabinet(Model model) {
        return "economist/economist_info";
    }

    @RequestMapping(value = "bank_state")
    public String bankState(Model model) {
        BankAccount bankAccount = bankAccountService.findAll().get(0);
        model.addAttribute("bank", bankAccount);
        return "economist/bank_state";
    }

    @RequestMapping("replenishment_view")
    public String replenishmentView(Model model) {
        List<Replenishment> replenishments = replenishmentService.findAll();
        model.addAttribute("replenishments", replenishments);
        return "economist/replenisment_view";
    }

    @RequestMapping(value = "add_replenishment", method = RequestMethod.GET)
    public String addReplenishment(Model model) {
        model.addAttribute("replenishment", new Replenishment());
        return "economist/add_replenishment";
    }

    @RequestMapping(value = "add_replenishment", method = RequestMethod.POST)
    public String commitReplenishment(Model model, @ModelAttribute Replenishment replenishment, @ModelAttribute MultipartFile file) {

        try {
            replenishment.setImage(file.getBytes());
        } catch (IOException ex) {
            System.out.print("File empty");
        }
        replenishment.setDate(new DateTime(new Date()));
        replenishmentService.save(replenishment);
        BankAccount bankAccount = bankAccountService.findAll().get(0);
        bankAccount.setAmount(bankAccount.getAmount() + replenishment.getAmount());
        bankAccount.setDate(new DateTime());
        bankAccountService.save(bankAccount);
        return "redirect:/add_replenishment?succses=true";
    }

    @RequestMapping(value = "add_contract", method = RequestMethod.GET)
    public String addContract(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newContract", new Contract());
        return "economist/add_contract";
    }

    @RequestMapping(value = "add_contract", method = RequestMethod.POST)
    public String commitContract(Model model, @ModelAttribute Contract newContract, @ModelAttribute MultipartFile file) {
        try {
            newContract.setDocument(file.getBytes());
        } catch (IOException ex) {
            System.out.print("File empty");
        }
        contractService.save(newContract);
        return "redirect:/add_contract?success=true";
    }

    @RequestMapping(value = "add_penalty", method = RequestMethod.GET)
    public String addPenalty(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newPenalty", new Penalty());
        return "economist/add_penalty";
    }

    @RequestMapping(value = "add_penalty", method = RequestMethod.POST)
    public String commitPenalty(Model model, @ModelAttribute Penalty newPenalty) {
        newPenalty.setDate(new DateTime());
        newPenalty.setStatus(AwardType.ACTIVE.toString());
        penaltyService.save(newPenalty);
        return "redirect:/add_penalty?succsses=true";
    }

    @RequestMapping(value = "penalty_list")
    public String penaltyList(Model model) {
        List<Penalty> penalties = penaltyService.findAll();
        model.addAttribute("penalties", penalties);
        return "economist/penalty_list";
    }


    @RequestMapping(value = "add_award", method = RequestMethod.GET)
    public String addAward(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("newAward", new Award());
        return "economist/add_award";
    }

    @RequestMapping(value = "add_award", method = RequestMethod.POST)
    public String commitAward(Model model, @ModelAttribute Award newAward) {
        newAward.setDate(new DateTime());
        newAward.setStatus(AwardType.ACTIVE.toString());
        awardService.save(newAward);
        return "redirect:/add_penalty?succsses=true";
    }

    @RequestMapping(value = "award_list")
    public String awardList(Model model) {
        List<Award> awards = awardService.findAll();
        model.addAttribute("awards", awards);
        return "economist/award_list";
    }
    @RequestMapping(value = "add_payment", method = RequestMethod.GET)
    public String addPayment(Model model){
        model.addAttribute("payment", new Payment());
        return "economist/add_payment";
    }
    @RequestMapping(value = "add_payment", method = RequestMethod.POST)
    public String commitPayment(Model model, @ModelAttribute Payment payment, @ModelAttribute MultipartFile file){
        try {
            payment.setImage(file.getBytes());
        } catch (IOException ex) {
            System.out.print("File empty");
        }
        payment.setDate(new DateTime());
        paymentService.save(payment);
        BankAccount bankAccount = bankAccountService.findAll().get(0);
        bankAccount.setAmount(bankAccount.getAmount()-payment.getAmount());
        bankAccount.setDate(new DateTime());
        bankAccountService.save(bankAccount);
     return "redirect:/add_payment?success=true";
    }
    @RequestMapping(value = "payments_list")
    public String paymentsList(Model model){

        List<Payment> payments = paymentService.findAll();
        model.addAttribute("payments", payments);
        return "economist/payments_list";
    }
    @RequestMapping(value = "view_users")
    public String viewEmployees(Model model){
        model.addAttribute("users", userService.findAll());
        return "economist/all_employees";
    }

    @RequestMapping(value = "view_contract", params = {"id"})
    public String viewContract(Model model, @RequestParam(value = "id")Long id){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "economist/view_contract";
    }

    @RequestMapping(value = "edit_contract", method = RequestMethod.GET, params = {"id"})
    public String editContract(Model model, @RequestParam(value = "id") Long id){
        Contract contract = contractService.findContractById(id);
        model.addAttribute("contract", contract);
        return "economist/edit_contract";
    }
    @RequestMapping(value = "edit_contract", method = RequestMethod.POST)
    public String commitContractChange(Model model, @ModelAttribute Contract contract){
        contract.setDateStart(new DateTime());
        contractService.save(contract);
        StringBuilder path = new StringBuilder();
        path.append("redirect:/edit_contract?id=");
        path.append(contract.getId());
        return path.toString().trim();
    }
    @RequestMapping(value = "edit_economist", method = RequestMethod.GET)
    public String editAdmin(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        User editUser= userService.findByLogin(user.getLogin());
        model.addAttribute("editUser", editUser);
        return "economist/edit_economist";
    }
    @RequestMapping(value = "edit_economist", method = RequestMethod.POST)
    public String updateAdmin(Model model, @ModelAttribute("editUser") User editUser, HttpSession session){
        User userUpdate = (User) session.getAttribute("User");
        User user = userService.findById(userUpdate.getId());
        user.setFirstName(editUser.getFirstName());
        user.setLastName(editUser.getLastName());
        user.setBirthDate(editUser.getBirthDate());
        System.out.print(user.getPassword());
        userService.update(user);

        System.out.print(editUser.getBirthDate()+editUser.getFirstName());
        return "redirect:/economist_cabinet";
    }
    @RequestMapping(value = "change_password_economist", method = RequestMethod.GET)
    public String changePassword(Model model){
        model.addAttribute("newUser", new User());
        return "economist/change_password";
    }
    @RequestMapping(value = "change_password_economist", method = RequestMethod.POST)
    public String commitChangePassword(Model model, @ModelAttribute("newUser") User newUser, HttpSession session,BindingResult bindingResult){

        passwordValidator.validate(newUser, bindingResult);
        if(bindingResult.hasErrors()){
            return "coach/change_password";
        }
        User user =(User)session.getAttribute("User");
        user.setPassword(newUser.getNewPassword());
        userService.save(user);
        return "redirect:/economist_cabinet";
    }
    @RequestMapping(value = "edit_avatar_economist", method = RequestMethod.GET)
    public String editAvatar(Model model){
        return "economist/edit_avatar";
    }
    @RequestMapping(value = "edit_avatar_economist", method = RequestMethod.POST)
    public String saveAdminAvatar(Model model, @ModelAttribute MultipartFile file, HttpSession session){
        User user =(User)session.getAttribute("User");
        try {
            user.setImage(file.getBytes());
        }catch (IOException ex){
            System.out.print("File empty");
        }
        userService.update(user);
        return "redirect:/economist_cabinet";
    }

}