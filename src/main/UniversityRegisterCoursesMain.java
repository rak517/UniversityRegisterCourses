package main;

import controller.LessonRegisterManager;
import controller.StudentRegisterManager;
import controller.SubjectRegisterManager;
import controller.TraineeRegisterManager;
import view.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UniversityRegisterCoursesMain {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int choiceNum = 0;
        boolean quit = false;

        while (!quit) {
            try {
                MenuViewer.mainMenuView();
                choiceNum = MenuViewer.sc.nextInt();
                sc.nextLine();

                switch (choiceNum) {
                    case MENU_CHOICE.SUBJECT:
                        subjectMenu();
                        break;
                    case MENU_CHOICE.STUDENT:
                        studentMenu();
                        break;
                    case MENU_CHOICE.LESSON:
                        lessonMenu();
                        break;
                    case MENU_CHOICE.TRAINEE:
                        traineeMenu();
                        break;
                    case MENU_CHOICE.EXIT:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("해당 메뉴 번호만 입력하세요.");
                }
            } catch (Exception e) {
                System.out.println("\n입력에 오류가 있습니다. \n프로그램을 다시 시작하세요.");
                return;
            }

        }

    }

    //수강 신청 메뉴
    public static void traineeMenu() {
        int choice = 0;

        TraineeRegisterManager traineeManager = new TraineeRegisterManager();
        MenuViewer.traineeMenuView();
        choice = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();

        switch (choice) {
            case TRAINEE_CHOICE.LIST:
                System.out.println("");
                traineeManager.traineeList();
                break;
            case TRAINEE_CHOICE.INSERT:
                System.out.println("");
                traineeManager.traineeRegister();
                break;
            case TRAINEE_CHOICE.UPDATE:
                System.out.println("");
                traineeManager.traineeDelete();
                break;
            case TRAINEE_CHOICE.MAIN:
                return;
            default:
                System.out.println("해당 메뉴 번호만 입력하세요.");
        }
    }

    // 학과 메뉴
    public static void subjectMenu() {
        int choice = 0;
        SubjectRegisterManager subjectManager = new SubjectRegisterManager();
        MenuViewer.subjectMenuView();
        choice = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();

        switch (choice) {
            case SUBJECT_CHOICE.LIST:
                System.out.println("");
                subjectManager.subjectList();
                break;
            case SUBJECT_CHOICE.INSERT:
                System.out.println("");
                subjectManager.subjectRegistr();
                break;
            case SUBJECT_CHOICE.UPDATE:
                System.out.println("");
                subjectManager.subjectUpdate();
                break;
            case SUBJECT_CHOICE.DELETE:
                System.out.println("");
                subjectManager.subjectDelete();
            case SUBJECT_CHOICE.MAIN:
                return;
            default:
                System.out.println("해당 메뉴 번호만 입력하세요.");
        }
    }

    //학생 메뉴
    public static void studentMenu() {
        int choice = 0;
        StudentRegisterManager studentManager = new StudentRegisterManager();
        MenuViewer.studentMenuView();
        choice = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();

        switch (choice) {
            case STUDENT_CHOICE.INSERT:
                System.out.println("");
                studentManager.studentRegister();
                break;
            case STUDENT_CHOICE.UPDATE:
                System.out.println("");
                studentManager.studentUpdate();
                break;
            case STUDENT_CHOICE.LIST:
                System.out.println("");
                studentManager.studentTotalList();
                break;
            case STUDENT_CHOICE.MAIN:
                return;
            default:
                System.out.println("해당 메뉴 번호만 입력하세요.");
        }
    }

    //과목 메뉴
    public static void lessonMenu() {
        int choice = 0;
        LessonRegisterManager lessonManager = new LessonRegisterManager();
        MenuViewer.lessonMenuView();
        choice = MenuViewer.sc.nextInt();
        MenuViewer.sc.nextLine();

        switch (choice) {
            case LESSON_CHOICE.LIST:
                System.out.println("");
                lessonManager.lessonList();
                break;
            case LESSON_CHOICE.INSERT:
                System.out.println("");
                lessonManager.lessonRegister();
                break;
            case LESSON_CHOICE.UPDATE:
                System.out.println("");
                lessonManager.lessonUpdate();
                break;
            case LESSON_CHOICE.DELETE:
                System.out.println("");
                lessonManager.lessonDelete();
                break;
            case LESSON_CHOICE.MAIN:
                return;
            default:
                System.out.println("해당 메뉴 번호만 입력하세요.");
        }
    }
}
