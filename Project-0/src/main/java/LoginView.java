public class LoginView extends View{
    public LoginView() {
        viewName = "LoginView";
        viewManager = ViewManager.getViewManager();
    }

    // go to main menu if login success
    // otherwise try again or register
    @Override
    public void renderView() {
        System.out.println("====================Login====================");
        do {
            viewManager.setValidInputFalse();

            System.out.println("Enter username (or press 1 to return):");
            DataStore.usernameInput = viewManager.getScanner().nextLine();
            if (DataStore.usernameInput.equals("1")) {
                viewManager.setValidInputTrue();
                viewManager.navigate(DataStore.logoutViewName);
            }
            else {
                UserModel temp = DataStore.userRepo.read(DataStore.usernameInput);

                System.out.println("Enter password:");
                DataStore.passwordInput = viewManager.getScanner().nextLine();
                if (DataStore.passwordInput.equals(temp.getUser_password())) {
                    DataStore.loggedInUser = temp;
                    DataStore.accountRepo.storeLoggedInUserAccounts();
                    viewManager.setValidInputTrue();
                    System.out.println("Login Success.");
                    viewManager.navigate(DataStore.mainMenuViewName);
                }
                else {
                    System.out.println("Username/Password not found. Try again.\n");
                }
            }
        } while (!viewManager.isValidInput());
    }
}
