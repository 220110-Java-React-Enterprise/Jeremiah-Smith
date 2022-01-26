public class DisplayAccountsView extends View{
    public DisplayAccountsView() {
        viewName = "DisplayAccountsView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Accounts====================");
        System.out.println("Existing accounts for " + DataStore.loggedInUser.getUser_username() + ":");
        for (AccountModel account :
                DataStore.loggedInUserAccounts) {
            System.out.println(account.getAccount_name() + " - $" + account.getAmount());
        }

        viewManager.navigate(DataStore.mainMenuViewName);
    }
}
