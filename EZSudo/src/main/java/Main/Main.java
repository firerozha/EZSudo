package Main;

import Commands.CommandEZSudoReload;
import Commands.CommandMasssay;
import Commands.CommandSudo;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public String noperm = ChatColor.translateAlternateColorCodes('&', getConfig().getString("noperm"));

    @Override
    public void onEnable() {
        // COMMANDS
        getCommand("ezsudoreload").setExecutor(new CommandEZSudoReload(this));
        getCommand("sudo").setExecutor(new CommandSudo(this));
        getCommand("masssay").setExecutor(new CommandMasssay(this));



        // CONFIG
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }
}
