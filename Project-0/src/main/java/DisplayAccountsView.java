public class DisplayAccountsView extends View{
    public DisplayAccountsView() {
        viewName = "DisplayAccountsView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Accounts====================");
        System.out.println("Accounts for " + DataStore.loggedInUser.getUser_username() + ":");
        for (AccountModel account :
                DataStore.loggedInUserAccounts) {
            System.out.println(account.getAccount_name() + ": $" + account.getAmount());
            System.out.println();
        }

        viewManager.navigate(DataStore.mainMenuViewName);
    }
}
