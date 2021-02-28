package XPBlockPlus.Sandrix.Dev.Config;

public class Multipliers {

	String perm;
	float xp;
	
	public Multipliers(String perm, float value){
		
		this.perm = perm;
		this.xp = value;
		
	}
	
	public String getPerm() {
		return perm;
	}
	
	public float getValue() {
		return xp;
	}
	
}
