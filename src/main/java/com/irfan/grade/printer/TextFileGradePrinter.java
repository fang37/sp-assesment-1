package com.irfan.grade.printer;

import com.irfan.grade.model.Student;
import lombok.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextFileGradePrinter implements GradePrinter {
    @Setter
    private List<Student> students = new ArrayList<>();

    @Setter
    private Integer passedStudent;

    @Setter
    private Integer notPassedStudent;
    @Override
    public void print() throws IOException {
        FileWriter fileWriter = new FileWriter("nilai-pemrograman-java.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("===================================================%n");
        printWriter.printf(" %-3s  %-10s  %-12s  %-10s  %-5s %n", "No", "NIM", "Nama", "Nilai Akhir", "Grade");
        printWriter.printf("===================================================%n");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            printWriter.printf(" %-3d  %-10s  %-12s  %10.0f  %5s %n", i+1, student.getNim(), student.getName(), student.getScore().getFinalScore(), student.getScore().getGrading());
        }

        printWriter.printf("===================================================%n");
        printWriter.printf("Jumlah Mahasiswa : %-3s  %n", students.size());
        printWriter.printf("Jumlah Mahasiswa yg Lulus : %-3s  %n", passedStudent);
        printWriter.printf("Jumlah Mahasiswa yg tidak Lulus : %-3s  %n", notPassedStudent);
        printWriter.printf("===================================================%n");

        printWriter.close();
    }
}
