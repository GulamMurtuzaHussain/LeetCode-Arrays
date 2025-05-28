class Solution {
    static void goToEnd(int[] students, int start) {
        int temp = students[start];
        for (int i = start; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }
        students[students.length - 1] = temp;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int sand = 0, start = 0,rotation =0;
        while (sand < sandwiches.length) {
            if(rotation == (students.length-start)) break;
            if (students[start] == sandwiches[sand]) {
                sand++;
                start++;
                rotation = 0;
            } else {
                goToEnd(students, start);
                rotation++;
            }
        }
        return students.length - start;
    }
}
