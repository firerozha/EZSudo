package Commands;

import Main.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandEZSudoReload implements CommandExecutor {
    private Main plugin;

    public CommandEZSudoReload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("ezsudo.reload")) {
            plugin.reloadConfig();
            sender.sendMessage("The config file has been reloaded.");

        } else {
            sender.sendMessage(plugin.noperm);
        }






        return true;
    }
}
