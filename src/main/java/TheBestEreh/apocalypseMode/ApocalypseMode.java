package TheBestEreh.apocalypseMode;

import TheBestEreh.apocalypseMode.Enum.ConsoleColor;
import TheBestEreh.apocalypseMode.commands.ReloadCMD;
import TheBestEreh.apocalypseMode.listener.events.ZombieInfectListener;
import TheBestEreh.apocalypseMode.connection.JoinListener;
import TheBestEreh.apocalypseMode.connection.LeaveListener;
import TheBestEreh.apocalypseMode.listener.events.ZombieLootListener;
import TheBestEreh.apocalypseMode.listener.player.DeathMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class ApocalypseMode extends JavaPlugin {

    @Override
    public void onEnable() {

        if (getServer().getPluginManager().getPlugin("LuckPerms") == null) {
            getLogger().warning(ConsoleColor.BRIGHT_RED + "LuckPerms plugin is not available");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        System.out.println(ConsoleColor.BRIGHT_GREEN + " █████╗  ███╗   ███╗");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "██╔══██╗ ████╗ ████║");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "███████║ ██╔████╔██║");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "██╔══██║ ██║╚██╔╝██║");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "██║  ██║ ██║ ╚═╝ ██║");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "╚═╝  ╚═╝ ╚═╝     ╚═╝");
        System.out.println(" ");
        System.out.println(ConsoleColor.BRIGHT_GREEN + "Plugin 'ApocalypseMode' successfully enabled..");
        System.out.println(ConsoleColor.BRIGHT_MAGENTA + "Please remember to leave a review on Spigot!");

        saveDefaultConfig();
        LoadCommands();
        LoadEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void LoadCommands() {
        this.getCommand("apocalypsereload").setExecutor(new ReloadCMD(this));
    }

    private void LoadEvents() {
        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new LeaveListener(this), this);
        this.getServer().getPluginManager().registerEvents(new ZombieInfectListener(this), this);
        this.getServer().getPluginManager().registerEvents(new ZombieLootListener(this), this);
        this.getServer().getPluginManager().registerEvents(new DeathMessage(this), this);
    }
}
