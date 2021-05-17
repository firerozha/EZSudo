package Commands;

import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandMasssay implements CommandExecutor {

    private Main plugin;

    public CommandMasssay(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("ezsudo.masssay")) {
            if(args.length < 1) {
                sender.sendMessage(ChatColor.GOLD + "Missing arguments! " + ChatColor.RED + "/masssay <message>");
            } else {
                String msg = String.join(" ", args);
                        if (msg.startsWith("/")) {
                            if (sender.hasPermission("ezsudo.masssay.command")) {

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            if(!all.hasPermission("ezsudo.masssay.exempt")) {
                                                all.chat(msg);
                                            }
                                        }
                                    }
                                }.runTaskLater(this.plugin, plugin.getConfig().getInt("delay"));

                            } else {
                                sender.sendMessage(plugin.noperm);
                            }
                        } else {
                            if (sender.hasPermission("ezsudo.masssay.message")) {

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            if(!all.hasPermission("ezsudo.masssay.exempt")) {
                                                all.chat(msg);
                                            }
                                        }
                                    }
                                }.runTaskLater(this.plugin, plugin.getConfig().getInt("delay"));

                            } else {
                                sender.sendMessage(plugin.noperm);
                            }
                        }

            }
        } else {
            sender.sendMessage(plugin.noperm);
        }






        return true;
    }
}
