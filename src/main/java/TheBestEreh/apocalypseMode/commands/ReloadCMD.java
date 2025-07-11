package TheBestEreh.apocalypseMode.commands;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.iridium.iridiumcolorapi.IridiumColorAPI;

public class ReloadCMD implements CommandExecutor {

    private final ApocalypseMode plugin;

    public ReloadCMD(ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (!(player.hasPermission("apocalypsemode.admin.reload"))) {
            player.sendMessage(IridiumColorAPI.process(plugin.getConfig().getString("messages.no-permission")));
            return true;
        }

        player.sendMessage(IridiumColorAPI.process(plugin.getConfig().getString("messages.reload")));
        plugin.reloadConfig();

        return false;
    }
}
