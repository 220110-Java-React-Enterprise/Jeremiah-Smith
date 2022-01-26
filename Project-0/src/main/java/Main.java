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
    }
}
