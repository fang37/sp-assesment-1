package com.irfan.grade;

import com.irfan.grade.model.Score;
import com.irfan.grade.model.Student;
import com.irfan.grade.printer.ConsoleGradePrinter;
import com.irfan.grade.printer.TextFileGradePrinter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaProgrammingGradeApplication {

	public static void main(String[] args) throws IOException {
		Integer studentTotal = 0;
		Integer passedStudent = 0;
		Integer notPassedStudent = 0;
		List<Student> students = new ArrayList<>();

//		Scan Input
		System.out.print("Input jumlah mahasiswa : ");
		Scanner scan = new Scanner(System.in);
		studentTotal = scan.nextInt();

//		Loop through student total
		for (int i = 0; i < studentTotal; i++) {
			Student student = new Student();
			Score score = new Score();
			student.setScore(score);

			System.out.println("==================");
			System.out.println("Student number - " + String.valueOf(i+1) );

			System.out.print("Input NIM : ");
			student.setNim(scan.next());

			System.out.print("Input Name : ");
			student.setName(scan.next());

			System.out.print("Nilai Kehadiran : ");
			score.setPresence(scan.nextDouble());

			System.out.print("Nilai Midtest : ");
			score.setMidTest(scan.nextDouble());

			System.out.print("Nilai UAS : ");
			score.setFinalTest(scan.nextDouble());

			student.setScore(score);
			if (student.getScore().isPass()) {
				passedStudent++;
			} else {
				notPassedStudent++;
			}

			students.add(student);
		}

		ConsoleGradePrinter consolePrinter = new ConsoleGradePrinter(students, passedStudent, notPassedStudent);
		consolePrinter.print();

		TextFileGradePrinter filePrinter = new TextFileGradePrinter(students, passedStudent, notPassedStudent);
		filePrinter.print();

	}

}
