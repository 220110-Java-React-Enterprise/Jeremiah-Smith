import java.sql.SQLException;
import java.util.InputMismatchException;

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
                boolean duplicateAccountNameFound = false;

                for (AccountModel account :
                        DataStore.loggedInUserAccounts) {
                    if (account.getAccount_name().equals(DataStore.accountNameInput)) {
                        duplicateAccountNameFound = true;
                    }
                }

                if (!duplicateAccountNameFound) {
                    System.out.println("Enter desired starting amount:");

                    try {
                        DataStore.amountInput = viewManager.getScanner().nextDouble();
                        viewManager.getScanner().nextLine();
                        if (DataStore.amountInput < 0) {
                            System.out.println("Invalid amount. Try again.\n");
                        }
                        else {
                            AccountModel accountModel = new AccountModel(null, DataStore.loggedInUser.getUser_id(), DataStore.accountNameInput, DataStore.amountInput);
                            DataStore.accountRepo.create(accountModel);
                            DataStore.accountRepo.storeLoggedInUserAccounts();
                            viewManager.setValidInputTrue();
                            System.out.println("Success. Returning to main menu.");
                            viewManager.navigate(DataStore.mainMenuViewName);
                        }
                    }
                    catch (InputMismatchException e) {
                        viewManager.getScanner().nextLine();
                        System.out.println("Invalid entry. Try again.\n");
                    }
                }
                else {
                    System.out.println("Duplicate account name found. Try again.\n");
                }
//                System.out.println("Enter desired starting amount:");
//
//                try {
//                    DataStore.amountInput = viewManager.getScanner().nextDouble();
//                    viewManager.getScanner().nextLine();
//                    if (DataStore.amountInput < 0) {
//                        System.out.println("Invalid amount. Try again.\n");
//                    }
//                    else {
//                        try {
//                            AccountModel accountModel = new AccountModel(null, DataStore.loggedInUser.getUser_id(), DataStore.accountNameInput, DataStore.amountInput);
//                            DataStore.accountRepo.create(accountModel);
//                            DataStore.accountRepo.storeLoggedInUserAccounts();
//                            viewManager.setValidInputTrue();
//                            System.out.println("Success. Returning to main menu.");
//                            viewManager.navigate(DataStore.mainMenuViewName);
//                        } catch (SQLException e) {
//                            System.out.println("Duplicate account name. Try again.\n");
//                        }
//                    }
//                }
//                catch (InputMismatchException e) {
//                    viewManager.getScanner().nextLine();
//                    System.out.println("Invalid entry. Try again.\n");
//                }
            }
        } while (!viewManager.isValidInput());
    }
}
