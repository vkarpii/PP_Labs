package lab4.Command;

public class choiceMenuCommand implements Command{
    private Menu menu;

    public choiceMenuCommand(Menu menu){
        this.menu = menu;
    }

    @Override
    public void execute(){
        menu.choiceMenu();
    }
}
