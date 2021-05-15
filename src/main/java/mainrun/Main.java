package mainrun;

import repository.StudentDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        studentDao.getAll().forEach(System.out::println);

        System.out.println("Nhập id sinh viên: ");
        int student_id = new Scanner(System.in).nextInt();
        System.out.println(studentDao.findById(student_id));
    }
}
