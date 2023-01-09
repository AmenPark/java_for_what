import java.sql.Ref;

public class RSPMain {
	public static void main(String[] args) {
//		RSPComputer c = new RSPComputer();
//		c.on();
//		c.startGame();
		
		Refree r = new Refree();
		Player p1 = new Player();
		Player p2 = new Player();
		r.start(p1, p2);
	}
}
