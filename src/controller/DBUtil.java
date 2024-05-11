package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    public static Connection makeConnection() throws FileNotFoundException, IOException {
        // 오라클 데이터베이스 정보(주소,유저,패스워드)
        String filePath = "/Users/rak/Documents/IntelliJ/UniversityRegisterCourses/src/db.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");


        // 오라클 데이타베이스 객체 참조변수
        Connection con = null;

        // oracle jdbc library class load
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("데이터베이스 드라이버 로드 성공");
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("데이터베이스 접속 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 드라이버 로드 실패");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패");
        }
        return con;
    }
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Connection con = makeConnection();
//	}

}
