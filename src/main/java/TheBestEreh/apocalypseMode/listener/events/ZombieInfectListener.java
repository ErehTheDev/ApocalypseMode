package TheBestEreh.apocalypseMode.listener.events;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class ZombieInfectListener implements Listener {

    private final ApocalypseMode plugin;

    private final Random random = new Random();

    public ZombieInfectListener (ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent e)  {

        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        if (!(e.getDamager() instanceof Zombie)) {
            return;
        }

        int infectionChance = plugin.getConfig().getInt("infection.chance");
        int roll = this.random.nextInt(100);

        if (roll <= infectionChance) {
            ((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, plugin.getConfig().getInt("infection.duration.slow") * 20, 1));
            ((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, plugin.getConfig().getInt("infection.duration.confusion") * 20, 2));
        }
    }
}
