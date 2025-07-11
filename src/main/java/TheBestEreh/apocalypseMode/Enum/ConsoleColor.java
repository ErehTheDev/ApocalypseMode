package TheBestEreh.apocalypseMode.Enum;

public enum ConsoleColor {
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    PURPLE("\u001B[35m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    BRIGHT_BLACK("\u001B[90m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_BLUE("\u001B[94m"),
    BRIGHT_MAGENTA("\u001B[95m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_WHITE("\u001B[97m"),
    GRAY("\u001B[90m"),
    RESET("\u001B[0m"),
    BOLD("\u001B[1m"),
    UNDERLINE("\u001B[4m"),
    ITALIC("\u001B[5m"),
    REVERSE("\u001B[7m");


    private final String color;

    ConsoleColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}