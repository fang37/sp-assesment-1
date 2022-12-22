package com.irfan.grade.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private Double presence;
    private Double midTest;
    private Double finalTest;

    public Double getFinalScore() {
//      Nilai Akhir = (0.2 * nilai kehadiran) + (0.4 * nilai midtest ) + (0.4 * nilai UAS)
        return (0.2 * presence) + (0.4 * midTest) + (0.4 * finalTest);
    }

    public String getGrading() {
        return Grade.getGrade(getFinalScore()).getGrade();
    }

    public boolean isPass() {
        if (List.of("A", "B", "C").contains(getGrading())) {
            return true;
        }
        return false;
    }

}
