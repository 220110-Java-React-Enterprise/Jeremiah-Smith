// p0 storage data
public class DataStore {
    public static String loginViewName = "LoginView";
    public static String registerViewName = "RegisterView";
    public static String logoutViewName = "LogoutView";
    public static String mainMenuViewName = "MainMenuView";
    public static String createAccountViewName = "CreateAccountView";
    public static String depositWithdrawViewName = "DepositWithdrawView";
    public static String displayAccountsViewName = "DisplayAccountsView";
    public static String quitViewName = "QuitView";

    public static UserModel loggedInUser;
    public static CustomArrayList<AccountModel> loggedInUserAccounts;
    public static AccountModel selectedAccount;

    public static UserRepo userRepo = new UserRepo();
    public static AccountRepo accountRepo = new AccountRepo();

    public static String usernameInput, passwordInput;
    public static Double amountInput;

    public static void clearData() {
        loggedInUser = null;
        loggedInUserAccounts = null;
        selectedAccount = null;
    }
}
