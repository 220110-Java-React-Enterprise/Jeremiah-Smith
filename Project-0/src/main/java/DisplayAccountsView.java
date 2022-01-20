public class DisplayAccountsView extends View{
    public DisplayAccountsView() {
        viewName = "DisplayAccountsView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Main Menu====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Main Menu");
        System.out.println("2 - Logout");
        System.out.println("3 - Quit");

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
                    viewManager.navigate(ViewNameStrings.logoutView);
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
