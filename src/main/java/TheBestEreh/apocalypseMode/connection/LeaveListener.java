package TheBestEreh.apocalypseMode.connection;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    private final ApocalypseMode plugin;

    public LeaveListener(ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        e.setQuitMessage(null);

        Bukkit.broadcastMessage(IridiumColorAPI.process(plugin.getConfig().getString("connection.player-leave")).replace("%player%", e.getPlayer().getDisplayName()));
    }

}
