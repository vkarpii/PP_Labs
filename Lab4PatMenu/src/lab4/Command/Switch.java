package lab4.Command;

public class Switch {
    private final Command choiceMenuCommand;
    private final Command accountMenuCommand;
    private final Command createMenuCommand;


    public Switch(Command choiceMenuCommand, Command accountMenuCommand, Command createMenuCommand) {
        this.choiceMenuCommand = choiceMenuCommand;
        this.accountMenuCommand = accountMenuCommand;
        this.createMenuCommand = createMenuCommand;
    }

    public void choiceMenuCommand() {
        choiceMenuCommand.execute();
    }
    public void accountMenuCommand(){
        accountMenuCommand.execute();
    }
    public void createMenuCommand(){
        createMenuCommand.execute();
    }
}
