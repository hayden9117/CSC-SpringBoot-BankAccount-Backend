package bankaccount.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    // My bank account service is where the majority of my bussiness logic is done
    Object[] display;
    // made an array of accounts, wanted to utilize mySql for a database but didnt
    // have time, currently about half done
    private List<BankAccount> bankaccounts = new ArrayList<>(
            Arrays.asList(
                    new BankAccount(1, "rhayden0", "password", "Richie", "Hayden", 12345),
                    new BankAccount(2, "msith0", "password", "Mike", "Smith", 34567),
                    new BankAccount(3, "tberry0", "password", "Taylor", "Berry", 54354)));
    // made an array of checking accounts, checking accounts are tied by account ID
    private List<CheckingAccount> checkingaccounts = new ArrayList<>(
            Arrays.asList(
                    new CheckingAccount(12345, 0.00, true),
                    new CheckingAccount(34567, 0.00, true),
                    new CheckingAccount(54354, 0.00, false)));

    // all methods are calling the getter's and setter's in my Bank Account and
    // CheckingAccount Class.

    // getAll methods are useful if logged in as admin
    public List<BankAccount> getAllBankAccounts() {
        return bankaccounts;
    }

    public List<CheckingAccount> getAllCheckingAccounts() {
        return checkingaccounts;
    }

    // only sends back data to the frontend if account is associated with a id
    public BankAccount getBankAccount(Integer id) {
        return bankaccounts.stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }

    public CheckingAccount getCheckingAccount(Integer accountID) {
        return checkingaccounts.stream().filter(a -> a.getAccountID().equals(accountID)).findFirst().get();
    }

    // creates bank account
    public void createAccount(BankAccount bankAccount) {
        bankaccounts.add(bankAccount);
    }
    // updates properites of bank account

    public void updateAccount(Integer id, BankAccount bankAccount) {
        for (int i = 0; i < bankaccounts.size(); i++) {
            BankAccount a = bankaccounts.get(i);
            if (a.getId().equals(id)) {
                bankaccounts.set(i, bankAccount);
                return;
            }
        }
    }

    public void deleteAccount(Integer id) {
        bankaccounts.removeIf(a -> a.getId().equals(id));
    }
    // only adds balance associated with a users ID

    public void depositBalance(Integer accountID, JsonNode deposit) {

        double balance;
        for (int i = 0; i < checkingaccounts.size(); i++) {
            CheckingAccount a = checkingaccounts.get(i);
            if (a.getAccountID().equals(accountID)) {
                System.out.println(deposit);
                balance = a.getBalance();
                a.setBalance(balance, deposit.asDouble());

            }
        }

    }

    // only removes balance associated with a users ID
    public void withdrawBalance(Integer accountID, JsonNode withdrawal) {
        boolean overDraft;
        double balance;
        for (int i = 0; i < checkingaccounts.size(); i++) {
            CheckingAccount a = checkingaccounts.get(i);
            if (a.getAccountID().equals(accountID)) {
                System.out.println(withdrawal);
                overDraft = a.getOverDraft();
                System.out.println(overDraft);
                balance = a.getBalance();
                a.withdrawal(balance, withdrawal.asDouble(), overDraft);

            }
        }

    }

    public Object[] getAccounts(Integer accountID) {
        String userName;
        String firstName;
        String lastName;
        Double balance;
        boolean overDraft;
        for (int i = 0; i < checkingaccounts.size(); i++) {
            for (int j = 0; j < checkingaccounts.size(); j++) {
                CheckingAccount a = checkingaccounts.get(i);
                BankAccount b = bankaccounts.get(j);
                if (a.getAccountID().equals(accountID) && b.getAccountID().equals(accountID)) {

                    userName = b.getUserName();
                    firstName = b.getFirstName();
                    lastName = b.getLastName();
                    balance = a.getBalance();
                    overDraft = a.getOverDraft();
                    display = a.displayAccount(userName, firstName, lastName, accountID, balance, overDraft);
                }
            }
        }
        System.out.println(display);
        return display;
    }

}