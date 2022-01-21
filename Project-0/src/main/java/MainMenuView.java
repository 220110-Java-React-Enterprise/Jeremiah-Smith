public class MainMenuView extends View{
    public MainMenuView() {
        viewName = "MainMenuView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Main Menu====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Create Account");
        System.out.println("2 - Deposit/Withdraw");
        System.out.println("3 - Display Accounts");
        System.out.println("4 - Logout");
        System.out.println("5 - Quit");

        do {
            viewManager.setValidInputFalse();
            String input = viewManager.getScanner().nextLine();
            switch (input) {
                case "1":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.createAccountViewName);
                    break;
                case "2":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.depositWithdrawViewName);
                    break;
                case "3":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.displayAccountsViewName);
                    break;
                case "4":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.logoutViewName);
                    break;
                case "5":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.quitViewName);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (!viewManager.isValidInput());
    }
}
