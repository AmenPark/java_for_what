
public class Referee {
	int ans;
	int count;
	int guess;
	Friend f;
	User u;
	public void start(Friend f, User u) {
		this.f = f;
		this.u = u;
		askGameAns();
		
	}
	private void askGameAns() {
		ans = f.tellAns();
	}
	private void askGuess() {
		guess = u.tell();
	}
	
	
	private void judge() {
		
	}
}
