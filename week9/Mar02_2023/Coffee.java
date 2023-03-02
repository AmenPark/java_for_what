package idkwhatever;

import java.math.BigDecimal;

// mybatis와 연동하기 위해서? 1. db column명과 동일한 member variable 명.
// OracleDB 기준으로 number은 정수와 실수를 겸하기 때문에 BigDecimal로 쓴다. mysql은 int같은 자료형이 있어서 그거 쓰면 됨.
// date는 java.util.date이다. sql꺼 안씀.
public class Coffee {
	private String name;
	private BigDecimal price;
	public Coffee(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
