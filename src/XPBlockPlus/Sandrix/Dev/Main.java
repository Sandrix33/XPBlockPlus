package XPBlockPlus.Sandrix.Dev;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import XPBlockPlus.Sandrix.Dev.Config.Config;
import XPBlockPlus.Sandrix.Dev.Config.Reload;

public class Main extends JavaPlugin{
	
	public void onEnable(){
	
		Config.CheckConfig();
		Config.loadConfig();
		Join.refreshPlayerCount();
		Bukkit.getServer().getPluginManager().registerEvents(new Event(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Join(), this);
		getCommand("xpp").setExecutor(new Reload());
		
		
	}
}
