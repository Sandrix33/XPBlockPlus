package XPBlockPlus.Sandrix.Dev;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import XPBlockPlus.Sandrix.Dev.Config.Config;

public class Event implements Listener{

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if(Config.getEnabled()) {
			
			if(p.hasPermission("xpp.use")) {
				
				String mat = e.getBlock().getType().toString();
				
				if(Config.getItemSettings()) {
					
					if(!(p.getInventory().getItemInMainHand().getItemMeta().getLore() == null)) {
						if(p.getInventory().getItemInMainHand().getItemMeta().getLore().contains(Config.getitemLore())){
							GiveExp(p, mat);
						}
					}
	
				}
				
				else {
					
					GiveExp(p, mat);
					
				}
				
			}
			
		}
		
	}
	
	public void GiveExp(Player p,String mat) {
	
		float multi = 1;
		
		for(int i=0; i<Config.getSizeList();i++) {	
			if(Config.getMatList(i).equals(mat)) {
				for(int k=0; k<Join.getCSizeList();k++) {	
					
					if(Join.getPlayer(k).equals(p.getName())) {
						
						if(Join.getMatCount(p.getName(), k, i) == (Config.getBlockCount(i)-1)) {
							
							Join.resetCount(p.getName(), i, k);
							if(Config.getMultiSettings()) {
								for(int j=0; j<Config.getMSizeList();j++) {
									
									if(p.hasPermission(Config.getMultiList(j))) {
										
										multi = multi + Config.getMultiplier(j);
										
									}
									
								}
							}
							int value = ((int)(Config.getXPList(i) * multi));
							p.giveExp(value);
														
							return;
						}
						else {
							
							
							Join.IncrementCount(p.getName(), i, k);
							
						}
						
					}
				
				}
			}
		}
	
	}
}
