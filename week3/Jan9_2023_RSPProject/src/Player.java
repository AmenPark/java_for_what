import java.util.Random;
import java.util.Scanner;
/*
 * 
 * @author ME
 * This is annotation for explain how to use.
 *
 */
public class Player {
	int ans;
	boolean user;
/*
 * method uses
 */
	public Player() {
		ans = 0;
		user = false;
	}
	public void fire() {
		if (user) {
			System.out.print("yourChoice:");
			Scanner _in = new Scanner(System.in);
			ans =  _in.nextInt();
			_in.close();
		} else {
			Random _r = new Random();
			ans = _r.nextInt(3)+1;
		}
	}
}
