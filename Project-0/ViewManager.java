import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private boolean running;
    private final Scanner scanner;

    CustomListInterface<View> viewList;
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


}
