package cf.sslyi.nofireworkdamage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DebugCommand implements CommandExecutor {
    private boolean isDebugEnabled;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("nofireworkdamage.debug")) {
            sender.sendMessage("You do not have permissions to use this command.");
            return true;
        }
       if(isDebugOn() == true) {
           disableDebug();
           sender.sendMessage("Disabled debugging mode");
       } else {
           enableDebug();
           sender.sendMessage("Enabled debugging mode.");
       }



        return true;

    }

    public void enableDebug() {
        this.isDebugEnabled = true;
    }

    public void disableDebug() {
        this.isDebugEnabled = false;
    }
    public boolean isDebugOn() {
        return isDebugEnabled;
    }
    }

