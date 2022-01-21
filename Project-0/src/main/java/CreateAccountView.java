public class CreateAccountView extends View{
    public CreateAccountView() {
        viewName = "CreateAccountView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Main Menu====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Main Menu");

        do {
            viewManager.setValidInputFalse();
            String input = viewManager.getScanner().nextLine();
            switch (input) {
                case "1":
                    viewManager.setValidInputTrue();
                    viewManager.navigate(DataStore.mainMenuViewName);
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (!viewManager.isValidInput());
    }
}
