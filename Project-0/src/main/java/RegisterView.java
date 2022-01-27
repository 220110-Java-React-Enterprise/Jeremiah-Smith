public class RegisterView extends View{
    public RegisterView() {
        viewName = "RegisterView";
        viewManager = ViewManager.getViewManager();
    }

    // go to start screen if register success
    // otherwise try again
    @Override
    public void renderView() {
        System.out.println("====================Register====================");
        do {
            viewManager.setValidInputFalse();

            System.out.println("Enter desired username (or press 1 to return):");
            DataStore.usernameInput = viewManager.getScanner().nextLine();
            if (DataStore.usernameInput.equals("1")) {
                viewManager.setValidInputTrue();
                viewManager.navigate(DataStore.logoutViewName);
            }
            else {
                boolean duplicateUsernameFound = false;

                DataStore.userRepo.storeAllUsernames();
                for (String username :
                        DataStore.usernames) {
                    if (DataStore.usernameInput.equals(username)) {
                        duplicateUsernameFound = true;
                    }
                }

                if (!duplicateUsernameFound) {
                    System.out.println("Enter desired password:");
                    DataStore.passwordInput = viewManager.getScanner().nextLine();
                    UserModel userModel = new UserModel(null, DataStore.usernameInput, DataStore.passwordInput);
                    DataStore.loggedInUser = DataStore.userRepo.create(userModel);

                    viewManager.setValidInputTrue();
                    System.out.println("Success. Returning to start screen.");
                    viewManager.navigate(DataStore.logoutViewName);
                }
                else {
                    System.out.println("Username already exists. Try again.\n");
                }
            }
        } while (!viewManager.isValidInput());
    }
}
