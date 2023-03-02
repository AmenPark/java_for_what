package idkwhatever;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// bigdecimal : new bigdecimal(int) 등으로 기본값 변환가능.
// string은 아래의 것처럼 pattern, format 등을 이용해서 변환가능.
// nextBigdecimal로 스캐너 가능.
// 거꾸로는 Integer.valueOf 등으로 가능.

public class CoffeeInsert {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			System.out.print("커피 이름:");
			InputStream is = Resources.getResourceAsStream("pool.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory sfb = ssfb.build(is);
			ss=sfb.openSession();
			Scanner _in = new Scanner(System.in);
			String name = _in.next();
			System.out.print("가격:");
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator(',');
			symbols.setDecimalSeparator('.');
			String pattern = "#,##0.0#";
			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
			decimalFormat.setParseBigDecimal(true);

			// parse the string
			BigDecimal price = (BigDecimal) decimalFormat.parse(_in.next());
			System.out.println(price);
			Coffee c = new Coffee(name, price);
			int i = ss.insert("coffeemap.insertcoffee", c);
			System.out.println(i);
			ss.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}	finally {
			ss.close();
		}
	}
}
