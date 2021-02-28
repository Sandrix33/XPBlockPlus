package XPBlockPlus.Sandrix.Dev.Config;

import java.util.ArrayList;

public class PlayerList {
	
	String name;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public PlayerList(String name, ArrayList<Integer> list) {
		
		this.name = name;
		this.list = list;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	public ArrayList<Integer> getList(){
		
		return this.list;
		
	}
	
	public void setList(ArrayList<Integer> list){
	
		this.list = list;
		
	}

}
