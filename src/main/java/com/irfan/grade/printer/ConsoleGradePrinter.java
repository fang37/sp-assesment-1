package com.irfan.grade.printer;

import com.irfan.grade.model.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsoleGradePrinter implements GradePrinter {

    @Setter
    private List<Student> students = new ArrayList<>();

    @Setter
    private Integer passedStudent;

    @Setter
    private Integer notPassedStudent;

    @Override
    public void print() {
        System.out.printf("===================================================%n");
        System.out.printf(" %-3s  %-10s  %-12s  %-10s  %-5s %n", "No", "NIM", "Nama", "Nilai Akhir", "Grade");
        System.out.printf("===================================================%n");

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.printf(" %-3d  %-10s  %-12s  %10.0f  %5s %n", i+1, student.getNim(), student.getName(), student.getScore().getFinalScore(), student.getScore().getGrading());
        }
        System.out.printf("===================================================%n");
        System.out.printf("Jumlah Mahasiswa : %-3s  %n", students.size());
        System.out.printf("Jumlah Mahasiswa yg Lulus : %-3s  %n", passedStudent);
        System.out.printf("Jumlah Mahasiswa yg tidak Lulus : %-3s  %n", notPassedStudent);
        System.out.printf("===================================================%n");
    }
}
