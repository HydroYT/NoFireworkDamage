package cf.sslyi.nofireworkdamage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NoFireworkDamage extends JavaPlugin implements Listener {
    private DebugCommand debugCommand;



    @Override
    public void onEnable() {
        this.debugCommand = new DebugCommand();

        Bukkit.getLogger().info("Starting.");
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("fireworkdebug")).setExecutor(new DebugCommand());
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Firework) {
            e.setCancelled(true);
            if(debugCommand.isDebugOn()) {
                Bukkit.getLogger().info("[NoFireworkDamage] Stopped " + e.getEntity().getName() + " from getting hurt with a firework.");
            }

        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling.");
    }
}
