package bankaccount.account;

public class CheckingAccount extends BankAccount {
    // Extended a CHecking account class, this is a nice featurebecause i can now
    // have multiple checking accounts per bank account owner.

    double deposit;
    double withdrawal;
    boolean overDraft;

    CheckingAccount() {

    }

    CheckingAccount(int accountID, Double balance, boolean overDraft) {
        super();
        this.accountID = accountID;
        this.balance = balance;
        this.overDraft = overDraft;
    }

    public double getDeposit(double deposit) {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public boolean getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(boolean overDraft) {
        this.overDraft = overDraft;
    }

    public void setBalance(double balance, double deposit) {

        balance = balance + deposit;
        this.balance = balance;
    }

    public void withdrawal(double balance, double withdrawal, boolean overDraft) {
        if (balance >= withdrawal) {

            balance = balance - withdrawal;
            this.balance = balance;
        }
        if (overDraft) {
            withdrawal = withdrawal + 30;
            balance = balance - withdrawal;
            this.balance = balance;
        }
    }

    // utilizes the Bank Account class to get shared objects, methos is called in
    // service file
    public Object[] displayAccount(String userName,
            String firstName, String lastName, int accountID, Double balance, boolean overDraft) {
        Object[] account = new Object[5];
        account[0] = userName;
        account[1] = firstName;
        account[2] = lastName;
        account[3] = balance;
        account[4] = overDraft;

        return account;

    }

}
