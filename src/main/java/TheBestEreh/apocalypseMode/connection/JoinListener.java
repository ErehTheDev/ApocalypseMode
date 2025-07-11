package TheBestEreh.apocalypseMode.connection;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.iridium.iridiumcolorapi.IridiumColorAPI;

public class JoinListener implements Listener {

    private final ApocalypseMode plugin;

    public JoinListener(ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);

        Player player = (Player) e.getPlayer();
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        Bukkit.broadcastMessage(IridiumColorAPI.process(plugin.getConfig().getString("connection.player-join")).replace("%player%", player.getDisplayName()));
    }

}
