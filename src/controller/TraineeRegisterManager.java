package controller;

import model.LessonVO;
import model.TraineeVO;

import java.util.Scanner;

public class TraineeRegisterManager {
    //수강신청리스트
    public void traineeList(){
        Scanner sc = new Scanner(System.in);

        String sd_num;      //학번
        String id;          //아이디
        String pw;          //비밀번호
        String mainMenu;    //메인메뉴
        boolean success = false;

        TraineeDAO td = new TraineeDAO();
        StudentDAO sdao = new StudentDAO();

        System.out.println("수강 신청한 리스트");
        do{
            System.out.print("아이디 : ");
            id = sc.nextLine();
            System.out.print("비밀번호 : ");
            pw = sc.nextLine();
            success = sdao.getStudentLogin(id, pw);

            if(!success){
                System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
                System.out.println("메인 메뉴로 이동(y/n) : ");
                mainMenu = sc.nextLine();
                if(mainMenu.equals("y") || mainMenu.equals("Y")) {
                    return;
                }
                System.out.println();
            }
        } while(!success);

        sd_num = sdao.getStudentNum(id, pw);
        System.out.println();
        System.out.println("수강 신청한 리스트");
        td.getTraineeTotalList(sd_num);
        System.out.println();
    }
    //수강신청관리
    public void traineeRegister(){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        TraineeDAO td =  new TraineeDAO();
        TraineeVO tvo = new TraineeVO();

        LessonDAO ld = new LessonDAO();
        LessonVO lvo = new LessonVO();

        StudentDAO sdao = new StudentDAO();

        String sd_num;      //학번
        String l_abbre;     //과목약어
        String t_section;   //과목구분

        String id;          //아이디
        String pw;          //비밀번호
        String mainMenu;    //메인메뉴

        boolean success = false;

        System.out.println("수강 가능 과목 전체 리스트");
        ld.getLessonTotalList();
        System.out.println();

        System.out.println("수강 신청을 위한 정보 입력");
        do{
            System.out.print("아이디 : ");
            id = sc.nextLine();
            System.out.print("비밀번호 : ");
            pw = sc.nextLine();

            success = sdao.getStudentLogin(id, pw);

            if(!success){
                System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
                System.out.println("메인 메뉴로 이동(y/n) : ");
                mainMenu = sc1.next();
                if(mainMenu.equals("y") || mainMenu.equals("Y")) {
                    return;
                }
                System.out.println();
            }
        } while(!success);

        sd_num = sdao.getStudentNum(id, pw);

        System.out.println("학번 : " + sd_num);
        System.out.print("과목약어(영문 대문자) : ");
        l_abbre = sc.nextLine();
        System.out.print("과목구분(교양,전공,부전공) :");
        t_section = sc.nextLine();

        tvo.setSd_num(sd_num);
        tvo.setL_abbre(l_abbre);
        tvo.setT_section(t_section);

        //수강신청등록
        td.setTraineeRegister(tvo);

        System.out.println();
        System.out.println("수강 신청한 리스트");
        td.getTraineeTotalList(sd_num);
        System.out.println();
    }
    //수강 취소 관리
    public void traineeDelete() {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        TraineeDAO td = new TraineeDAO();
        StudentDAO sdao = new StudentDAO();

        String sd_num;      //학번
        int t_no;           //수강번호
        String id;          //아이디
        String pw;          //비밀번호
        String mainMenu;    //메인메뉴

        boolean success = false;

        System.out.println("수강 취소를 위한 정보 입력");
        do{
            System.out.print("아이디 : ");
            id = sc.nextLine();
            System.out.print("비밀번호 : ");
            pw = sc.nextLine();

            success = sdao.getStudentLogin(id, pw);

            if(!success){
                System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
                System.out.print("메인 메뉴로 이동(y/n) : ");
                mainMenu = sc1.next();
                if(mainMenu.equals("y") || mainMenu.equals("Y")) {
                    return;
                }
                System.out.println();
            }
        } while(!success);

        sd_num = sdao.getStudentNum(id, pw);

        System.out.println();
        System.out.println("수강 신청한 리스트");
        td.getTraineeTotalList(sd_num);
        System.out.println();

        System.out.println("취소할 수강 신청 일련번호 입력");
        System.out.print("일련번호 : ");
        t_no = sc.nextInt();

        td.setTraineeDelete(t_no);

        System.out.println();
        System.out.println("수강 신청 취소 후 리스트");
        td.getTraineeTotalList(sd_num);
        System.out.println();

    }
}
