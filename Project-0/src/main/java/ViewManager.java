import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private boolean running, validInput;
    private final Scanner scanner;

    CustomArrayList<View> viewList;
    View nextView;

    private ViewManager() {
        running = true;
        scanner = new Scanner(System.in);
        viewList = new CustomArrayList<>();
    }

    public static ViewManager getViewManager() {
        if (viewManager == null) {
            viewManager = new ViewManager();
        }

        return viewManager;
    }

    public void navigate(String destination) {
        for (View view: viewList) {
            if (view.viewName.equals(destination)) {
                nextView = view;
            }
        }
    }

    public void registerView(View view) {
        viewList.add(view);
    }

    public void render() {
        nextView.renderView();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void quit() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public boolean isValidInput() {
        return validInput;
    }

    public void setValidInputFalse() {
        validInput = false;
    }

    public void setValidInputTrue() {
        validInput = true;
    }
}
