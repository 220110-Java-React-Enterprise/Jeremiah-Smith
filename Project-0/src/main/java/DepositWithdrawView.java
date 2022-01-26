import java.sql.SQLException;

public class DepositWithdrawView extends View{
    public DepositWithdrawView() {
        viewName = "DepositWithdrawView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Deposit/Withdraw====================");
        System.out.println("Existing accounts for " + DataStore.loggedInUser.getUser_username() + ":");
        for (AccountModel account :
                DataStore.loggedInUserAccounts) {
            System.out.println(account.getAccount_name() + " - $" + account.getAmount());
        }

        System.out.println();

        do {
            viewManager.setValidInputFalse();

            System.out.println("Enter account name to deposit/withdraw (or press X to return):");
            DataStore.accountNameInput = viewManager.getScanner().nextLine();
            if (DataStore.accountNameInput.equals("X")) {
                viewManager.setValidInputTrue();
                viewManager.navigate(DataStore.mainMenuViewName);
            }
            else {
                System.out.println("Enter deposit amount (insert \"-\" to withdraw):");
                DataStore.amountInput = viewManager.getScanner().nextDouble();
                viewManager.getScanner().nextLine();
                for (AccountModel account :
                        DataStore.loggedInUserAccounts) {
                    if (account.getAccount_name().equals(DataStore.accountNameInput)) {
                        Double newValue = account.getAmount() + DataStore.amountInput;
                        if (newValue < 0) {
                            System.out.println("Invalid amount. Try again.");
                        }
                        else {
                            account.setAmount(newValue);
                            DataStore.accountRepo.update(account);
                            DataStore.accountRepo.storeLoggedInUserAccounts();
                            viewManager.setValidInputTrue();
                            System.out.println("Success. Returning to main menu.");
                            viewManager.navigate(DataStore.mainMenuViewName);
                        }
                    }
                }

                System.out.println("Account not found. Try again.\n");
            }
        } while (!viewManager.isValidInput());
    }
}
