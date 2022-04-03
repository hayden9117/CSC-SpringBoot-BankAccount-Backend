package bankaccount.account;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class BankAccount {
    // all variable instantiations for Bank account class
    Integer id;
    String userName;
    String password;
    String firstName;
    String lastName;
    int accountID;
    double balance;

    // defult contructor which is utilized for creating an instance of class bank
    // account
    public BankAccount() {

    }

    // constructor for BankAccount Class
    public BankAccount(Integer id, String userName, String password,
            String firstName, String lastName, int accountID) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
    }
    // List of getters and setters for all variables associated with the BankAccount
    // Class

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

}
