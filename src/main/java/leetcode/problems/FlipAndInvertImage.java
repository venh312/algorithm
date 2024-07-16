package leetcode.problems;

/*
Given an n x n binary matrix image, flip the image horizontally, then invert it,
and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].

Example 1:
Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
*/
class FlipAndInvertImage {
    // Runtime: 0 ms, faster than 100.00%
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int y = 0; y < image[i].length / 2; y++) {
                int temp = image[i][y];
                int tailIndex= image[i].length-1-y;
                image[i][y] = image[i][tailIndex] ^ 1;
                image[i][tailIndex] = temp ^ 1;
            }
            if (image[i].length % 2 != 0) {
                int middleIndex = image[i].length / 2;
                image[i][middleIndex] = image[i][middleIndex] ^ 1;
            }
        }
        return image;
    }
}
