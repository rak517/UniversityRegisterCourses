package controller;

import model.StudentVO;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StudentRegisterManager {

    //학생 정보등록
    public void studentRegister() {
        Scanner sc = new Scanner(System.in);
        SubjectDAO sdao = new SubjectDAO();
        StudentDAO sd = new StudentDAO();
        StudentVO svo = new StudentVO();

        String sd_num;                  //학번
        String sd_name;                 //이름
        String sd_id;                   //아이디
        String sd_passwd;               //비밀번호
        String s_num;                   //학과번호
        String sd_birthday;             //생년월일
        String sd_phone;                //핸드폰번호
        String sd_address;              //주소
        String sd_email;                //이메일
        boolean id_check;               //아이디체크
        String year;                    //년도

        System.out.println("학생 정보 입력");
        System.out.println("성명 : ");
        sd_name = sc.nextLine();

        do {
            System.out.print("아이디(8자 이상 12자 이내) : ");
            sd_id = sc.nextLine();
            id_check = sd.getStudentIdOverlap(sd_id);
            if (id_check) {
                System.out.println("중복된 아이디입니다. 다시 입력하세요");
            }
        }while (id_check);
        System.out.print("비밀번호(12자 이내 : )");
        sd_passwd = sc.nextLine();

        sdao.getSubjectTotalList();;

        System.out.print("학과번호 : ");
        s_num = sc.nextLine();

        //학생번호는 8자리로 생성한다. (연도2자리+학과2자리+일련번호 - ex)06010001
        SimpleDateFormat sdf = new SimpleDateFormat("yy");


    }


}
