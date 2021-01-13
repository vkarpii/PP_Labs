package lab4.Command;

public class accountMenuCommand implements Command{
    private Menu menu;

    public accountMenuCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.accountMenu();
    }
}
