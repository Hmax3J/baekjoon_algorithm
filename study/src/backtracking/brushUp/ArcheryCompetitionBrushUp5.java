package backtracking.brushUp;

import java.util.Arrays;

public class ArcheryCompetitionBrushUp5 {
    private static int max;
    private static int[] answer;
    private static int[] apeach;

    private static int getScore(int[] ryan) {
        int score = 0;
        for (int i = 0; i <= 10; i++) {
            if (ryan[i] + apeach[i] > 0) {
                score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
            }
        }
        return score;
    }

    private static void calculateDiff(int[] ryan) {
        int score = getScore(ryan);
        if (max < score) {
            max = score;
            answer = ryan.clone();
        } else if (max > 0 && max == score) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] != ryan[i]) {
                    if (answer[i] <= ryan[i]) {
                        answer = ryan.clone();
                    }
                    break;
                }
            }
        }
    }

    private static void backtrack(int n, int idx, int[] ryan) {
        if (n == 0) {
            calculateDiff(ryan);
            return;
        }

        for (int i = idx; i <= 10; i++) {
            int cnt = Math.min(n, apeach[i] + 1);
            ryan[i] = cnt;
            backtrack(n - cnt, i + 1, ryan);
            ryan[i] = 0;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        apeach = info;
        max = 0;
        backtrack(n, 0, new int[11]);

        int[] a = {-1};
        String minus = Arrays.toString(a);
        String answerR = Arrays.toString(answer);

        System.out.println(max == 0 ? minus : answerR);
    }
}
