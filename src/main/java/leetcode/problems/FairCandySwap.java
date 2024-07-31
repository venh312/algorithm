package leetcode.problems;

/*
Alice and Bob have a different total number of candies.
You are given two integer arrays aliceSizes and bobSizes
where aliceSizes[i] is the number of candies of the ith box of candy that Alice has
and bobSizes[j] is the number of candies of the jth box of candy that Bob has.
앨리스와 밥의 총 사탕 수는 다릅니다.
당신에게는 두 개의 정수 배열 앨리스 크기와 밥 크기가 주어집니다.
여기서 앨리스 크기[i]는 앨리스가 가지고 있는 i번째 사탕 상자의 사탕 수이고,
밥 크기[j]는 밥이 가지고 있는 j번째 사탕 상자의 사탕 수입니다.

Since they are friends, they would like to exchange one candy box each so that after the exchange,
they both have the same total amount of candy.
The total amount of candy a person has is the sum of the number of candies in each box they have.
그들은 친구이기 때문에, 교환 후에 그들 둘 다 같은 양의 사탕을 가지도록 각각 하나의 사탕 상자를 교환하기를 원합니다.
한 사람이 가지고 있는 사탕의 총 양은 그들이 가지고 있는 각각의 상자 안에 있는 사탕의 양의 합입니다.

Return an integer array answer where answer[0] is the number of candies in the box that Alice
must exchange, and answer[1] is the number of candies in the box that Bob must exchange.
If there are multiple answers, you may return any one of them.
It is guaranteed that at least one answer exists.
정수 배열의 답을 반환하라. 여기서 답[0]은 앨리스가 교환해야 하는 상자 안의 사탕 수이고,
답[1]은 밥이 교환해야 하는 상자 안의 사탕 수이다. 답이 여러 개일 경우, 당신은 그 중 하나를 반환할 수 있습니다.
적어도 하나의 답이 존재한다는 것은 보장됩니다

Example 1:
Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]

Example 2:
Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]

Example 3:
Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]
*/
class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumAlice = 0;
        int sumBob = 0;

        for (int candy : aliceSizes) {
            sumAlice += candy;
        }

        for (int candy : bobSizes) {
            sumBob += candy;
        }

        /*
        두 사람의 총 사탕 수 차이를 2로 나눈 값 (targetDiff)을 계산합니다.
        이 값은 한 사람의 상자에서 targetDiff 만큼의 사탕을 줄이고 다른 사람의 상자에서 같은 양을 추가해야 한다는 것을 의미합니다.
         */
        int targetDiff = (sumAlice - sumBob) / 2;
        System.out.println("sum : " + (sumAlice - sumBob));
        System.out.println("targetDiff : " + targetDiff);

        Set<Integer> bobSet = new HashSet<>();
        for (int candy : bobSizes) {
            bobSet.add(candy);
        }

        for (int aliceCandy : aliceSizes) {
            if (bobSet.contains(aliceCandy - targetDiff)) {
                return new int[]{aliceCandy, aliceCandy - targetDiff};
            }
        }

        return new int[]{};
    }
}
