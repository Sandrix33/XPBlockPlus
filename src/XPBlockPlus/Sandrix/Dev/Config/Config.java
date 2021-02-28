package XPBlockPlus.Sandrix.Dev.Config;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;

import XPBlockPlus.Sandrix.Dev.Join;
import XPBlockPlus.Sandrix.Dev.Main;

public class Config {

	public static YamlConfiguration config;
	public static File dir = new File("plugins/XPBlockPlus");
	public static File configFile = new File("plugins/XPBlockPlus/config.yml");
	public static boolean plenabled;
	public static String permMessage;
	public static ArrayList<Blocks> blocks = new ArrayList<Blocks>();
	public static boolean multienabled;
	public static ArrayList<Multipliers> multi = new ArrayList<Multipliers>();
	public static String itemLore;
	public static boolean loreenabled;
	public static ArrayList<Integer> cl = new ArrayList<Integer>();
	
	public static void CheckConfig() {
		
		if(!dir.exists()) {
			
			dir.mkdir();
			
		}
		
		if(!configFile.exists()) {
			Main.getPlugin(Main.class).saveResource("config.yml", true);
			
		}
		
		config = YamlConfiguration.loadConfiguration(configFile);
		
	}
	
	public static void Reload() {
		System.out.println("[XPBlockPlus] Reloading config...");
		multi.clear();
		cl.clear();
		blocks.clear();
		CheckConfig();
		loadConfig();
		Join.refreshPlayerCount();
		System.out.println("[XPBlockPlus] Config reloaded!!!");
	}
	

	
	public static void loadConfig() {
		
		System.out.println("[XPBlockPlus] Loading config...");
		plenabled = config.getBoolean("Earnxp");
		
		if(plenabled == false) {
			System.out.println("[XPBlockPlus] Plugin set to false!");
			return;
		}
		
		System.out.println("[XPBlockPlus] Loading messages...");
		permMessage = config.getString("permissionMessage").replaceAll("&", "§");
		
		System.out.println("[XPBlockPlus] Loading item Settings...");
		loreenabled = config.getBoolean("itemWithSpecificLore");
		
		
		if(loreenabled == true) {
			System.out.println("[XPBlockPlus] Loading item Lore...");
			itemLore = config.getString("itemLore").replaceAll("&", "§");	
		}
		
		System.out.println("[XPBlockPlus] Loading Blocks list...");
		for(String block : config.getStringList("Blocks")) {
			
			String mat = block.split(", ")[0];
			int value = Integer.parseInt(block.split(", ")[1]);
			int count = Integer.parseInt(block.split(", ")[2]);
			
			Blocks bl = new Blocks(mat,value, count);
			
			blocks.add(bl);
			cl.add(0);
			
		}
		
		System.out.println("[XPBlockPlus] Loading multipliers...");
		multienabled = config.getBoolean("multipliers");
		
		if(multienabled == true) {
		    
		    for(String s : config.getStringList("list"))
			     multi.add(new Multipliers(s.split(", ")[0], Float.parseFloat(s.split(", ")[1])));
			
		}
		
		System.out.println("[XPBlockPlus] Loading Complete!!");
		
		return;
		
	}

	public static boolean getEnabled() {
		return plenabled;
	}
	
	public static boolean getItemSettings() {
		return loreenabled;
	}
	
	public static String getitemLore() {
		return itemLore;
	}
	
	public static String getMessage() {
		return permMessage;
	}
	
	public static String getMatList(int i) {
		return blocks.get(i).getMat();
	}
	
	public static int getXPList(int i) {
		return blocks.get(i).getXP();
	}
	
	public static int getBlockCount(int i) {
		return blocks.get(i).getCount();
	}
	
	public static int getSizeList() {
		return blocks.size();
	}
	
	public static String getMultiList(int i) {
		return multi.get(i).getPerm();
	}
	
	public static float getMultiplier(int i) {
		return multi.get(i).getValue();
	}
	
	public static int getMSizeList() {
		return multi.size();
	}
	
	public static boolean getMultiSettings() {
		return multienabled;
	}

	public static ArrayList<Integer> getCountList() {
		return cl;
	}
}
