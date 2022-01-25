import java.sql.SQLException;

public class CreateAccountView extends View{
    public CreateAccountView() {
        viewName = "CreateAccountView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Create Account====================");

        do {
            viewManager.setValidInputFalse();

            System.out.println("Enter desired account name (or press 1 to return):");
            DataStore.accountNameInput = viewManager.getScanner().nextLine();
            if (DataStore.accountNameInput.equals("1")) {
                viewManager.setValidInputTrue();
                viewManager.navigate(DataStore.mainMenuViewName);
            }
            else {
                System.out.println("Enter desired starting amount:");
                DataStore.amountInput = viewManager.getScanner().nextDouble();
                viewManager.getScanner().nextLine();
                if (DataStore.amountInput < 0) {
                    System.out.println("Invalid amount. Try again.");
                }
                else {
                    try {
                        AccountModel accountModel = new AccountModel(null, DataStore.loggedInUser.getUser_id(), DataStore.accountNameInput, DataStore.amountInput);
                        DataStore.loggedInUserAccounts.add(DataStore.accountRepo.create(accountModel));

                        viewManager.setValidInputTrue();
                        System.out.println("Success. Returning to main menu.");
                        viewManager.navigate(DataStore.mainMenuViewName);
                    } catch (SQLException e) {
                        System.out.println("Duplicate account name. Try again.");
                    }
                }
            }
        } while (!viewManager.isValidInput());
    }
}
