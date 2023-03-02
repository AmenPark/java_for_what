package idkwhatever;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myjava {

	public static void main(String[] args) {
		SqlSession ss;
		//connection을 대체하는것이 바로 sqlSession.
		try {
			InputStream is = Resources.getResourceAsStream("pool.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			List<Coffee> l = ss.selectList("coffeemap.coffeeselectbyname");
			for(Coffee c:l) {
				System.out.println(c.getName());
				System.out.println(c.getPrice());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
