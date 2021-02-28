package XPBlockPlus.Sandrix.Dev.Config;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String s2, String[] s3) {
		if(c.getName().equalsIgnoreCase("xpp")) {
			if(s.hasPermission("xpp.admin")) {
				if(s3.length == 1 && s3[0] != null && s3[0].equalsIgnoreCase("reload")) {
					
					Config.Reload();
					s.sendMessage("§a[XPPlus] Config reloaded!");
					
				}
				else {
					s.sendMessage("§4[XPPlus] Correct usage /xpp reload");
				}
			}
				
			else {
					s.sendMessage(Config.getMessage());
			}
		}
		return false;
	}

}
