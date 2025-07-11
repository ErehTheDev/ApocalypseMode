package TheBestEreh.apocalypseMode.listener.events;

import TheBestEreh.apocalypseMode.ApocalypseMode;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ZombieLootListener implements Listener {

    private final ApocalypseMode plugin;

    public ZombieLootListener(ApocalypseMode plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {

        LivingEntity entity = e.getEntity();
        ItemStack sangue = new ItemStack(Material.REDSTONE, plugin.getConfig().getInt("items.blood.amount"));
        ItemMeta sangueMeta = sangue.getItemMeta();
        sangueMeta.setDisplayName(IridiumColorAPI.process(plugin.getConfig().getString("items.blood.name")));
        sangue.setItemMeta(sangueMeta);

        if (entity instanceof Zombie) {
            e.getDrops().add(new ItemStack(Material.BONE, plugin.getConfig().getInt("items.bone.amount"))); // Devo verificare se funziona
            e.getDrops().add(sangue);
        }
    }
}
