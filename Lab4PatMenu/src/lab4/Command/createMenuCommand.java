package lab4.Command;

public class createMenuCommand implements Command{
    private Menu menu;

    public createMenuCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.createMenu();
    }
}
