package coding_introduction;

public class IdentifyingSquareNumbers {
    public int solution(int n) {
        int answer = 2;

        for (int i = 1; i <= n; i++) {
            if (i * i == n) {
                answer = 1;
                break;
            }
        }

        return answer;
    }
}