package com.irfan.grade.model;

import com.irfan.grade.model.Score;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class ScoreTest {

    @Test
    void getFinalScore_shouldReturnFinalScore_whenInvoked() {
        double presence = 90.0;
        double midTest = 85.0;
        double finalTest = 70.0;
        double expectedResult = (0.2 * presence) + (0.4 * midTest) + (0.4 * finalTest);

        Score score = Score.builder()
                .presence(presence)
                .midTest(midTest)
                .finalTest(finalTest)
                .build();

        Double actualResult = score.getFinalScore();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void getGrading_shouldReturnGrading_whenInvoked() {
        double presence = 90.0;
        double midTest = 85.0;
        double finalTest = 70.0;
        String expectedResult = "B";

        Score score = Score.builder()
                .presence(presence)
                .midTest(midTest)
                .finalTest(finalTest)
                .build();

        String actualResult = score.getGrading();

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPass_shouldReturnTrue_whenGradingPass() {
        double presence = 90.0;
        double midTest = 85.0;
        double finalTest = 70.0;

        Score score = Score.builder()
                .presence(presence)
                .midTest(midTest)
                .finalTest(finalTest)
                .build();

        boolean result = score.isPass();

        log.info(score.getGrading());
        Assertions.assertTrue(result);
    }

    @Test
    void isPass_shouldReturnFalse_whenGradingDoesNotPass() {
        double presence = 70;
        double midTest = 50;
        double finalTest = 60;

        Score score = Score.builder()
                .presence(presence)
                .midTest(midTest)
                .finalTest(finalTest)
                .build();

        boolean result = score.isPass();

        log.info(score.getGrading());
        Assertions.assertFalse(result);
    }
}
