public class LogoutView extends View{
    public LogoutView() {
        viewName = "LogoutView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Login====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Quit");

        do {
            viewManager.setValidInputFalse();
            String input = viewManager.getScanner().nextLine();
            switch (input) {
                case "1":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(ViewNameStrings.loginView);
                    break;
                case "2":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(ViewNameStrings.registerView);
                    break;
                case "3":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(ViewNameStrings.quitView);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (!viewManager.isValidInput());
    }
}
