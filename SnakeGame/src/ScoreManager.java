// **********************************************************************************
// Title: Modded Snake game
// Author: Johan Torres-Medina
// Course Section: CMIS201-ONL1 (Seidel) Spring 2024
// File: SnakeGame
// Description: This is a simple game made into a complex and more challenging for user.
// This has a modern take to what snake game used to be.
// **********************************************************************************
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoreManager {
    private List<Integer> scores;

    public ScoreManager() {
        scores = new ArrayList<>();
    }

    public void addScore(int score) {
        scores.add(score);
    }

    public List<Integer> getSortedScores() {
        //  copy of the scores list
        List<Integer> sortedScores = new ArrayList<>(scores);

        // Sorting the scores in descending order
        Collections.sort(sortedScores, Collections.reverseOrder());

        return sortedScores;
    }


}
