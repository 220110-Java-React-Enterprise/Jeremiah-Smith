import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ViewManager viewManager = ViewManager.getViewManager();
//
//        viewManager.registerView(new LogoutView());
//        viewManager.registerView(new LoginView());
//        viewManager.registerView(new RegisterView());
//        viewManager.registerView(new MainMenuView());
//        viewManager.registerView(new CreateAccountView());
//        viewManager.registerView(new DepositWithdrawView());
//        viewManager.registerView(new DisplayAccountsView());
//        viewManager.registerView(new QuitView());
//
//        viewManager.navigate(ViewNames.logoutView);
//
//        while (viewManager.isRunning()) {
//            viewManager.render();
//        }

        System.out.println("Testing CRUD on users table (create/read only)");

        System.out.println("Creating users...");

        UserModel testuser1 = new UserModel(null, "testusername1", "testpassword1");
        UserModel testuser2 = new UserModel(null, "testusername2", "testpassword2");
        UserModel testuser3 = new UserModel(null, "testusername3", "testpassword3");

        UserRepo userRepo = new UserRepo();
        userRepo.create(testuser1);
        userRepo.create(testuser2);
        userRepo.create(testuser3);

        Scanner sc = new Scanner(System.in);
        //sc.nextLine();

        System.out.println("Reading users...");

        System.out.println("User with id 1: ");
        DataStore.loggedInUser = userRepo.read(1);
        System.out.println("username: " + DataStore.loggedInUser.getUser_username() + ", password: " + DataStore.loggedInUser.getUser_password());

        //sc.nextLine();

        System.out.println("User with username \"testusername2\"");
        DataStore.loggedInUser = userRepo.read("testusername2");
        System.out.println("username: " + DataStore.loggedInUser.getUser_username() + ", password: " + DataStore.loggedInUser.getUser_password());

        System.out.println("Enter username: ");
        String usernameInput = sc.nextLine();
        System.out.println("Enter password: ");
        String passwordInput = sc.nextLine();
        DataStore.loggedInUser = userRepo.read(usernameInput);
        if (usernameInput.equals(DataStore.loggedInUser.getUser_username())) {
            if (passwordInput.equals(DataStore.loggedInUser.getUser_password())) {
                System.out.println("username and password match! login success!");
            }
        }
        else {
            System.out.println("login failed, username/password not matching or not in records");
        }
    }
}
