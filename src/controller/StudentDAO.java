package controller;

import model.StudentVO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    //학생등록
    public void setStudentRegister(StudentVO svo) {
        String sql = "insert into student values(student_seq.nextval,?,?,?,?,?,?,?,?,?, sysdate)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, svo.getSd_num());
            pstmt.setString(2, svo.getSd_name());
            pstmt.setString(3, svo.getSd_id());
            pstmt.setString(4, svo.getSd_passwd());
            pstmt.setString(5, svo.getS_num());
            pstmt.setString(6, svo.getSd_birthday());
            pstmt.setString(7, svo.getSd_phone());
            pstmt.setString(8, svo.getSd_address());
            pstmt.setString(9, svo.getSd_email());

            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println(svo.getSd_name() + "학생 등록 완료.");
                System.out.println("학생 등록 성공!!!");
            } else {
                System.out.println("학생 등록 실패!!!");
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }

    }

    //학생정보수정
    public void setStudentUpdate(StudentVO svo) {
        String sql = "update student set sd_passwd=?, sd_phone=?, sd_address=?, sd_email=? where sd_num=?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, svo.getSd_passwd());
            pstmt.setString(2, svo.getSd_phone());
            pstmt.setString(3, svo.getSd_address());
            pstmt.setString(4, svo.getSd_email());
            pstmt.setString(5, svo.getSd_num());

            int i = pstmt.executeUpdate();

            if (i == 1) {
                System.out.println(svo.getSd_num() + " : 학생 정보 수정");
                System.out.println("학생 정보 수정 성공!!!");
            } else {
                System.out.println("학생 정보 수정 실패!!!");
            }
        } catch (SQLException e) {
            System.out.println("e=[" + e + "]");
        } catch (Exception e) {
            System.out.println("e=[" + e + "]");
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
    }

    //동일 학과 학생 일련번호
    public String getStudentCount(String subjectNum) {
        String sql = "select LPAD(count(*)+1, 4, '0') as studentCount from student where s_num = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String serialNumber = "";

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, subjectNum);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                serialNumber = rs.getString("studentCount");
            }
        } catch (SQLException se) {
            System.out.println(se);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException see) {
            }
        }
        return serialNumber;
    }

    //학생 아이디 중복 체크
    public boolean getStudentIdOverlap(String idOverlap) {
        String sql = "select * from student where sd_id= ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean idOverlapResult = false;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, idOverlap);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                idOverlapResult = true; //중복된 아이디가 있다.
            }
        } catch (SQLException e) {
            System.out.println("e=[" + e + "]");
        } catch (Exception e) {
            System.out.println("e=[" + e + "]");
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return idOverlapResult;
    }

    //학생 로그인
    public boolean getStudentLogin(String id, String pw) {
        String sql = "select * from student where sd_id = ? and sd_passwd = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                loginSuccess = true; //로그인 성공
            }
        } catch (SQLException e) {
            System.out.println("e=[" + e + "]");
        } catch (Exception e) {
            System.out.println("e=[" + e + "]");
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return loginSuccess;
    }

    //학생번호
    public String getStudentNum(String id, String pw) {
        String sql = "select sd_num from student where sd_id = ? and sd_passwd = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sd_num = "";

        try {
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            if (rs.next()) {
                sd_num = rs.getString("sd_num");
            }
        } catch (SQLException e) {
            System.out.println("e=[" + e + "]");
        } catch (Exception e) {
            System.out.println("e=[" + e + "]");
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
        return sd_num;
    }
    //학생 정보
    public void getStudent(String id, String pw) {
        String sql = "select * from student where sd_id = ? and sd_passwd = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentVO svo = null;

        try{
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();

            System.out.println("일련번호\t학생번호\t\t성명\t아이디\t\t비밀번호\t\t학과\t\t생년월일\t\t전화번호\t\t주소\t\t\t이메일" +
                    "\t\t\t등록일자");

            if (rs.next()){
                svo = new StudentVO();
                svo.setNo(rs.getInt("no"));
                svo.setSd_num(rs.getString("sd_num"));
                svo.setSd_name(rs.getString("sd_name"));
                svo.setSd_id(rs.getString("sd_id"));
                svo.setSd_passwd(rs.getString("sd_passwd"));
                svo.setS_num(rs.getString("s_num"));
                svo.setSd_birthday(rs.getString("sd_birthday"));
                svo.setSd_phone(rs.getString("sd_phone"));
                svo.setSd_address(rs.getString("sd_address"));
                svo.setSd_email(rs.getString("sd_email"));
                svo.setSd_date(rs.getDate("sd_date") + "");
                System.out.println(svo.getNo() + "\t" + svo.getSd_num() + "\t" + svo.getSd_name() + "\t" +
                        svo.getSd_id() + "\t" + svo.getSd_passwd() + "\t" + svo.getS_num() + "\t\t" + svo.getSd_birthday() + "\t" +
                        svo.getSd_phone() + "\t" + svo.getSd_address() + "\t" + svo.getSd_email() + "\t" + svo.getSd_date());
            }
        } catch (SQLException e){
            System.out.println("e=[" + e + "]");
        } catch (Exception e) {
            System.out.println("e=[" + e + "]");
        } finally {
            try{
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }
    }

    //학생전체목록
    public void getStudentTotalList(){
        String sql = "select st.no as no, sd_num, sd_name, sd_id, sd_passwd, su.s_name as s_num, sd_birthday, sd_phone, sd_address," +
                "sd_email, sd_date from STUDENT st, SUBJECT su where st.s_num = su.s_num order by no";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentVO svo = null;

        try{
            con = DBUtil.makeConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("일련번호\t학생번호\t\t성명\t아이디\t\t비밀번호\t\t학과\t\t생년월일\t\t전화번호\t\t주소\t\t\t이메일" +
                    "\t\t\t등록일자");

            while(rs.next()){
                svo = new StudentVO();
                svo.setNo(rs.getInt("no"));
                svo.setSd_num(rs.getString("sd_num"));
                svo.setSd_name(rs.getString("sd_name"));
                svo.setSd_id(rs.getString("sd_id"));
                svo.setSd_passwd(rs.getString("sd_passwd"));
                svo.setS_num(rs.getString("s_num"));
                svo.setSd_birthday(rs.getString("sd_birthday"));
                svo.setSd_phone(rs.getString("sd_phone"));
                svo.setSd_address(rs.getString("sd_address"));
                svo.setSd_email(rs.getString("sd_email"));
                svo.setSd_date(rs.getDate("sd_date") + "");

                System.out.println(svo.getNo() + "\t" + svo.getSd_num() + "\t" + svo.getSd_name() + "\t" +
                        svo.getSd_id() + "\t" + svo.getSd_passwd() + "\t" + svo.getS_num() + "\t\t" + svo.getSd_birthday() + "\t" +
                        svo.getSd_phone() + "\t" + svo.getSd_address() + "\t" + svo.getSd_email() + "\t" + svo.getSd_date());
            }
        } catch (SQLException e){
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
            }
        }

    }
}
