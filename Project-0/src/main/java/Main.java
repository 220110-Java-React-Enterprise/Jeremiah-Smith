import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ViewManager viewManager = ViewManager.getViewManager();

        viewManager.registerView(new LogoutView());
        viewManager.registerView(new LoginView());
        viewManager.registerView(new RegisterView());
        viewManager.registerView(new MainMenuView());
        viewManager.registerView(new CreateAccountView());
        viewManager.registerView(new DepositWithdrawView());
        viewManager.registerView(new DisplayAccountsView());
        viewManager.registerView(new QuitView());

        viewManager.navigate(DataStore.logoutViewName);

        while (viewManager.isRunning()) {
            viewManager.render();
        }

        // P0 CRUD Tests

//        System.out.println("Testing CRUD on users table (create/read only)");
//

//        Scanner sc = new Scanner(System.in);
//        String inputString, inputString2;
//        Double intputDouble;
//        UserRepo userRepo = new UserRepo();
//        AccountRepo accountRepo = new AccountRepo();
//
//        System.out.println("enter new username");
//        inputString = sc.nextLine();
//        System.out.println("enter password");
//        inputString2 = sc.nextLine();
//
//        UserModel userModel = new UserModel(null, inputString, inputString2);
//
//        // create the model w/o the auto generated id
//        // send it to the repo
//        // store the repo created row in DataStore, with the auto generated id
//
//        DataStore.loggedInUser = userRepo.create(userModel);

//        System.out.println("new user information: " + DataStore.loggedInUser.getUser_username() + ", " +
//                DataStore.loggedInUser.getUser_password() + ", " + DataStore.loggedInUser.getUser_id());






//        System.out.println("Creating users...");
//
//        UserModel testuser1 = new UserModel(null, "testusername1", "testpassword1");
//        UserModel testuser2 = new UserModel(null, "testusername2", "testpassword2");
//        UserModel testuser3 = new UserModel(null, "testusername3", "testpassword3");
//
//        UserRepo userRepo = new UserRepo();
//        userRepo.create(testuser1);
//        userRepo.create(testuser2);
//        userRepo.create(testuser3);
//
//        System.out.println("Enter name of profile you wish to login to");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//
//        DataStore.loggedInUser = userRepo.read(input);
//
//        System.out.println("login success");
//        System.out.println("Enter name of account you wish to create");
//        input = sc.nextLine();
//
//        DataStore.selectedAccount = new AccountModel(null, DataStore.loggedInUser.getUser_id(), input, 0.00);
//
//        AccountRepo accountRepo = new AccountRepo();
//        accountRepo.create(DataStore.selectedAccount);
//
//        System.out.println("account creation success");
//        System.out.println("Enter amount you wish to deposit");
//        Double moneyInput = sc.nextDouble();
//        DataStore.selectedAccount.setAmount(moneyInput);
//        accountRepo.update(DataStore.selectedAccount);
//
//        System.out.println("Enter amount you wish to withdraw");
//        moneyInput = sc.nextDouble();
//        DataStore.selectedAccount.setAmount(moneyInput);
//        accountRepo.update(DataStore.selectedAccount);
//
//        Scanner sc = new Scanner(System.in);
//        //sc.nextLine();
//
//        System.out.println("Reading users...");
//
//        System.out.println("User with id 1: ");
//        UserModel queriedUser = userRepo.read(1);
//        System.out.println("username: " + queriedUser.getUser_username() + ", password: " + queriedUser.getUser_password());
//
//        //sc.nextLine();
//
//        System.out.println("User with username \"testusername2\"");
//        queriedUser = userRepo.read("testusername2");
//        System.out.println("username: " + queriedUser.getUser_username() + ", password: " + queriedUser.getUser_password());
//
//        System.out.println("Enter username: ");
//        String usernameInput = sc.nextLine();
//        System.out.println("Enter password: ");
//        String passwordInput = sc.nextLine();
//        queriedUser = userRepo.read(usernameInput);
//        if (usernameInput.equals(queriedUser.getUser_username())) {
//            if (passwordInput.equals(queriedUser.getUser_password())) {
//                System.out.println("username and password match! login success!");
//                DataStore.loggedInUser = queriedUser;
//            }
//        }
//        else {
//            System.out.println("login failed, username/password not matching or not in records");
//        }
    }
}
