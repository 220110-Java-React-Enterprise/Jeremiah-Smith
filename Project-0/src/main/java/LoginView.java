public class LoginView extends View{
    public LoginView() {
        viewName = "LoginView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Login====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Main Menu (Login success)");
        System.out.println("2 - Register");

        do {
            viewManager.setValidInputFalse();
            String input = viewManager.getScanner().nextLine();
            switch (input) {
                case "1":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(ViewNameStrings.mainMenuView);
                    break;
                case "2":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(ViewNameStrings.registerView);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (!viewManager.isValidInput());
    }
}
