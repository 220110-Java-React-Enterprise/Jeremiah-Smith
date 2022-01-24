public class QuitView extends View{
    public QuitView() {
        viewName = "QuitView";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        DataStore.clearData();
        System.out.println("Goodbye.");
        viewManager.quit();
    }
}
