package controller;

import model.LessonVO;

import java.util.Scanner;

public class LessonRegisterManager {
    //과목 목록
    public void lessonList() {
        LessonDAO ldao = new LessonDAO();
        System.out.println("과목 전체 리스트");
        ldao.getLessonTotalList();
        System.out.println();
    }
    //과목 등록 관리
    public void lessonRegister () {
        Scanner sc = new Scanner(System.in);

        LessonDAO ld = new LessonDAO();
        LessonVO lvo = new LessonVO();

        String l_abbre;         //과목 약어
        String l_name;          //과목명

        System.out.println("과목 전체 리스트");
        ld.getLessonTotalList();
        System.out.println();

        System.out.println("과목 정보 입력");
        System.out.print("과목약어 : ");
        l_abbre = sc.nextLine();
        System.out.println("과목명");
        l_name = sc.nextLine();

        lvo.setL_abbre(l_abbre);
        lvo.setL_name(l_name);

        ld.setLessonRegister(lvo);

        System.out.println();
        System.out.println("과목 전체 리스트");
        ld.getLessonTotalList();
        System.out.println();
    }
    //과목 수정 관리
    public void lessonUpdate() {
        Scanner sc = new Scanner(System.in);

        LessonDAO ld = new LessonDAO();
        LessonVO lvo = new LessonVO();

        int l_no;       //수정할 과명 일련번호
        String l_abbre; //수정할 과목약어
        String l_name;  //수정할 과목명

        System.out.println("수정할 과목 일련번호 입력");
        System.out.print("일련번호 : ");
        l_no = sc.nextInt();

        System.out.println();
        System.out.println("새로운 정보 모두 입력");
        System.out.print("과목약어 :");
        l_abbre = sc.nextLine();
        System.out.print("과목명 : ");
        l_name = sc.nextLine();

        lvo.setNo(l_no);
        lvo.setL_abbre(l_abbre);
        lvo.setL_name(l_name);

        ld.setLessonUpdate(lvo);

        System.out.println();
        System.out.println("과목 전체 리스트");
        ld.getLessonTotalList();
        System.out.println();
    }
    //과목 삭제 관리
    public void lessonDelete() {
        Scanner sc = new Scanner(System.in);

        LessonDAO ld = new LessonDAO();
        LessonVO lvo = new LessonVO();

        int l_no; //삭제할 과목 번호

        System.out.println("과목 전체 리스트(사용중인 과목 삭제 불가)");
        ld.getLessonTotalList();
        System.out.println();

        System.out.println("삭제할 과목 일련번호 입력");
        System.out.print("일련번호 : ");
        l_no = sc.nextInt();

        ld.getLessonTotalList();

        System.out.println();
        System.out.println("학과 전체 리스트");
        ld.getLessonTotalList();
        System.out.println();
    }
}
