import java.util.Random;

public class Friend {
	static Random brain = new Random();
	int answer;
	
	public int tellAns() {
		if (answer==0) {
			answer = brain.nextInt(10000000)+1;
		}
		return answer;
	}
}
