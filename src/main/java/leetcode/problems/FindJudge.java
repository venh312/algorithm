/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
*/
class FindJudge {
    public int findJudge(int n, int[][] trust) {
        // 특별한 경우 처리: 사람이 1명일 때
        if (n == 1) {
            return 1; // 단 한 사람이면 그 사람이 판사입니다.
        }

        // 사람마다 신뢰를 받은 횟수와 신뢰한 횟수를 저장할 맵을 생성합니다.
        Map<Integer, Integer> trustCounts = new HashMap<>();
        
        // 신뢰하는 사람과 신뢰받는 사람을 처리합니다.
        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            
            // a는 신뢰를 하는 사람
            trustCounts.put(a, trustCounts.getOrDefault(a, 0) - 1);
            // b는 신뢰를 받는 사람
            trustCounts.put(b, trustCounts.getOrDefault(b, 0) + 1);
        }
        
        // 판사 후보를 찾습니다. 판사는 (n - 1)번 신뢰를 받은 사람입니다.
        for (Map.Entry<Integer, Integer> entry : trustCounts.entrySet()) {
            if (entry.getValue() == n - 1) {
                return entry.getKey();
            }
        }
        
        // 판사가 존재하지 않는 경우 -1을 반환합니다.
        return -1;
    }
}
