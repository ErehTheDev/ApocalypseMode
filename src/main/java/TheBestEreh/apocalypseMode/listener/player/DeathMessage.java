package TheBestEreh.apocalypseMode.listener.player;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessage implements Listener {

    private final ApocalypseMode plugin;

    public DeathMessage(ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity();

        if (player.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) player.getLastDamageCause();

            if (damageEvent.getDamager() instanceof Zombie) {
                e.setDeathMessage(IridiumColorAPI.process(plugin.getConfig().getString("death-messages.zombie").replace("%player%", player.getName())));

                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    player1.playSound(player1.getLocation(), Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, 1, 2);
                }
            }

            if (damageEvent.getDamager() instanceof Arrow) {
                Arrow arrow = (Arrow) damageEvent.getDamager();
                if (arrow.getShooter() instanceof Skeleton) {
                    e.setDeathMessage(IridiumColorAPI.process(plugin.getConfig().getString("death-messages.skeleton").replace("%player%", player.getName())));

                    for (Player player1 : Bukkit.getOnlinePlayers()) {
                        player1.playSound(player1.getLocation(), Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, 1, 2);
                    }
                }
            }

            if (damageEvent.getDamager() instanceof Spider) {
                e.setDeathMessage(IridiumColorAPI.process(plugin.getConfig().getString("death-messages.spider").replace("%player%", player.getName())));
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    player1.playSound(player1.getLocation(), Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, 1, 2);
                }
            }

            if (damageEvent.getDamager() instanceof Creeper) {
                e.setDeathMessage(IridiumColorAPI.process(plugin.getConfig().getString("death-messages.creeper").replace("%player%", player.getName())));
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    player1.playSound(player1.getLocation(), Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, 1, 2);
                }
            }

            if (damageEvent.getDamager() instanceof Phantom) {
                e.setDeathMessage(IridiumColorAPI.process(plugin.getConfig().getString("death-messages.phantom").replace("%player%", player.getName())));
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    player1.playSound(player1.getLocation(), Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, 1, 2);
                }
            }
        }
    }
}


