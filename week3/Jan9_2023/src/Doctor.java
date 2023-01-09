public class Doctor extends Human {
	public Doctor(String n, int m){
		super(n,m);
	}
	
	public void workStart() {
		say("일을 시작해 볼까?");
		Guest myGuest = callGuest();
		ask(myGuest);
		calculate(myGuest);
		tellResult(myGuest);
		
	}
	
	public Guest callGuest() {
		this.say("다음 손님 들어오세요!");
		return new Guest("고순필", 44, 155.6, 62.1);
	}
	
	public void ask(Guest g) {
		System.out.print("이름:");
		g.name = g.answer();
		
		System.out.print("키:");
		g.height = g.getDouble();
		if(g.height>3) {
			g.height/=100;
		}
		
		System.out.print("몸무게:");
		g.weight = g.getDouble();
	}
	
	public void calculate(Guest g) {
		g.bmi= g.weight / (g.height * g.height);
	}
	
	public void tellResult(Guest g) {
		System.out.printf("당신의 bmi지수는 %f입니다!\n", g.bmi);
		
	}
	
}
