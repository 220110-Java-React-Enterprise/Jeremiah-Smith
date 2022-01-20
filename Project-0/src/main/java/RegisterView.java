public class RegisterView extends View{
    public RegisterView() {
        viewName = "RegisterView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("====================Register====================");
        System.out.println("Choose one of the following:");
        System.out.println("1 - Login");
        System.out.println("2 - Register");

        do {
            viewManager.setValidInputFalse();
            String input = viewManager.getScanner().nextLine();
            switch (input) {
                case "1":
                    viewManager.setValidInputTrue();
                    viewManager.navigate("LoginView");
                    break;
                case "2":
                    viewManager.setValidInputTrue();
                    viewManager.navigate("RegisterView");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (!viewManager.isValidInput());
    }
}
