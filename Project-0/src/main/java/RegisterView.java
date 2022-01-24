import java.sql.SQLException;

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
                System.out.println("Enter desired password:");
                DataStore.passwordInput = viewManager.getScanner().nextLine();

                try {
                    UserModel userModel = new UserModel(null, DataStore.usernameInput, DataStore.passwordInput);
                    DataStore.loggedInUser = DataStore.userRepo.create(userModel);

                    viewManager.setValidInputTrue();
                    System.out.println("Success. Returning to start screen.");
                    viewManager.navigate(DataStore.logoutViewName);
                } catch (SQLException e) {
                    System.out.println("Invalid username. Try again");
                }
            }
        } while (!viewManager.isValidInput());
    }
}
