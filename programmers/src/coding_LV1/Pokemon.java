package coding_LV1;

import java.util.*;

public class Pokemon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            set.add(nums[i]);

        }

        return set.size() >= nums.length / 2 ? nums.length / 2 : set.size();
    }
}