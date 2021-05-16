package Commands;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSudo implements CommandExecutor {

    private Main plugin;

    public CommandSudo(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("ezsudo.sudo")) {
            if(args.length < 2) {
                sender.sendMessage(ChatColor.GOLD + "Missing arguments! " + ChatColor.RED + "/sudo <player> <message>");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target == null) {
                    sender.sendMessage(ChatColor.RED + "Target is offline!");
                    return true;
                } else {
                    if (target.hasPermission("ezsudo.sudo.exempt") && !(sender instanceof ConsoleCommandSender)) {
                        sender.sendMessage(ChatColor.RED + "Player is exempt.");
                    } else {
                        if (args[1].startsWith("/")) {
                            if (sender.hasPermission("ezsudo.sudo.command")) {
                                target.chat(args[1]);
                            } else {
                                sender.sendMessage(plugin.noperm);
                            }
                        } else {
                            if (sender.hasPermission("ezsudo.sudo.message")) {
                                target.chat(args[1]);
                            } else {
                                sender.sendMessage(plugin.noperm);
                            }
                        }

                    }
                }
            }
        } else {
            sender.sendMessage(plugin.noperm);
        }






        return true;
    }
}
