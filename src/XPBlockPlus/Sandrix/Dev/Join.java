package XPBlockPlus.Sandrix.Dev;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import XPBlockPlus.Sandrix.Dev.Config.Config;
import XPBlockPlus.Sandrix.Dev.Config.PlayerList;
public class Join implements Listener{

    static ArrayList<PlayerList> l= new ArrayList<PlayerList>();
    
	boolean trov;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		trov = false;
		for(int k=0; k<getCSizeList();k++) {	
		
			if(getPlayer(k).equals(e.getPlayer().getName())) {
				trov = true;
			}
			
		}
		
		if(trov == false) {
			String name = e.getPlayer().getName();
			
			PlayerList pl = new PlayerList(name, Config.getCountList());
			l.add(pl);
			
		}
		else {
			return;
		}
	}
	
	public static void refreshPlayerCount() {
		
		l.clear();
		
		for(Player player : Bukkit.getOnlinePlayers()){
			String name = player.getPlayer().getName();
			
			PlayerList pl = new PlayerList(name, Config.getCountList());
			l.add(pl);
			
		}
		
	}
	
	public static int getCSizeList() {
		return l.size();
	}
	
	public static String getPlayer(int i) {
		return l.get(i).getName();
		
	}
	
	public static int getMatCount(String name,int i, int j) {
		
		return l.get(i).getList().get(j);
		
	}
	
	public static void resetCount(String name, int i, int j) {
		
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.addAll(Config.getCountList());
		
		c.set(i, 0);
		
		l.get(j).setList(c);
		
	}
	
	public static void IncrementCount(String name,int i, int j) {
	
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.addAll(Config.getCountList());
		
		c.set(i, c.get(i)+1);
		
		l.get(j).setList(c);
		
	}
	
}
