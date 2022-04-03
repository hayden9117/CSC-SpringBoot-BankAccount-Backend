package bankaccount.account;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// frontend set to port 300, enabled the orgin to this for development 
// use on my local machine.
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BankAccountController {
    // my Bank Account controller is where i map the path to recieve Data from the
    // front end.
    @JsonProperty("deposit")
    private JsonNode deposit;

    @JsonProperty("withdrawal")
    private JsonNode withdrawal;
    // Utilized AutoWire in order to inject objects into BankAccountService
    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping("/BankAccounts")
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllBankAccounts();

    }

    @RequestMapping("/CheckingAccounts")
    public List<CheckingAccount> getAllCheckingAccounts() {
        return bankAccountService.getAllCheckingAccounts();

    }

    @RequestMapping("/BankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable Integer id) {
        return bankAccountService.getBankAccount(id);
    }

    @RequestMapping("/CheckingAccounts/{accountID}")
    public CheckingAccount getCheckingAccount(@PathVariable Integer accountID) {
        return bankAccountService.getCheckingAccount(accountID);

    }

    @RequestMapping("/CheckingAccounts/summary/{accountID}")
    public Object[] getAccounts(@PathVariable Integer accountID) {
        return bankAccountService.getAccounts(accountID);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/BankAccounts")
    public void createAccount(@RequestBody BankAccount bankAccount) {
        bankAccountService.createAccount(bankAccount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/CheckingAccounts/{accountID}")
    public void depositBalance(@PathVariable Integer accountID,
            @RequestBody JsonNode deposit) {
        bankAccountService.depositBalance(accountID, deposit);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/CheckingAccounts/withdrawal/{accountID}")
    public void withdrawBalance(@PathVariable Integer accountID,
            @RequestBody JsonNode withdrawal) {
        bankAccountService.withdrawBalance(accountID, withdrawal);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/BankAccounts/{id}")
    public void updateAccount(@PathVariable Integer id, @RequestBody BankAccount bankAccount) {
        bankAccountService.updateAccount(id, bankAccount);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/BankAccounts/{id}")
    public void deleteAccount(@PathVariable Integer id) {
        bankAccountService.deleteAccount(id);
    }
}
