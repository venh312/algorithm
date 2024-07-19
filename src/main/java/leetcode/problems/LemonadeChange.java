package leetcode.problems;

/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

Example 2:
Input: bills = [5,5,10,10,20]
Output: false
Explanation: 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.
*/
class Solution {
    // Runtime: 2 ms, faster than 95.04%
    private static final int LEMONADE_PRICE = 5;
    public boolean lemonadeChange(int[] bills) {
        int[] changeMoneyBox = new int[3];
        int[] priceBox = {20, 10, 5};
    
        for (int bill : bills) {
            int sum = bill - LEMONADE_PRICE;
    
            for (int i = 0; i < priceBox.length; i++) {
                int price = priceBox[i];
                if (sum >= price) {
                    int dollarCnt = sum / price;
                    int haveTwentyCnt = changeMoneyBox[i];
                    if (haveTwentyCnt >= dollarCnt) {
                        changeMoneyBox[i] -= dollarCnt;
                        sum %= price;
                    }
                }
            }
    
            if (sum != 0) return false;
    
            if (bill == 20)
                changeMoneyBox[0]++;
            else if (bill == 10)
                changeMoneyBox[1]++;
            else if (bill == 5)
                changeMoneyBox[2]++;
        }
    
        return true;
    }

  
    // Runtime: 1 ms, faster than 100.00%
    public boolean lemonadeChange2(int[] bills) {
        int fiveCount = 0; // $5 지폐의 개수
        int tenCount = 0;  // $10 지폐의 개수

        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++; // $5 지폐를 받은 경우
            } else if (bill == 10) {
                if (fiveCount > 0) {
                    fiveCount--; // $10 지폐를 받은 경우 $5 지폐로 거슬러줌
                    tenCount++;
                } else {
                    return false; // $5 지폐가 없는 경우
                }
            } else { // bill == 20
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--; // $20 지폐를 받은 경우 $10 지폐와 $5 지폐로 거슬러줌
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3; // $10 지폐가 없는 경우 $5 지폐 3장으로 거슬러줌
                } else {
                    return false; // 거슬러 줄 수 없는 경우
                }
            }
        }

        return true; // 모든 손님에게 정확한 잔돈을 준 경우   
    }
}
