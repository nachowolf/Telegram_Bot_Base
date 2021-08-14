package bot.commander.commands;

import bot.exceptions.InvalidCommandException;

public enum Command {
    START,
    KNOCK_KNOCK_JOKE,
    HELP,
    VOID;

    private String description;

    public static Command getCommand(String value) throws InvalidCommandException {
        for (Command c : values()) {
            if (c.toString().equalsIgnoreCase(value)) {
                return c;
            }
        }
        VOID.description = "Input: '" + value + "' is not a valid command.";
        throw new InvalidCommandException("Input: '/" + value + "' is not a valid command.");
    }

    public String getDescription() {
        return description;
    }


}
