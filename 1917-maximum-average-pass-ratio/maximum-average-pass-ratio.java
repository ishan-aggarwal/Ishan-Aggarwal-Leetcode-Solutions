
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0], a[0])
        );

        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            maxHeap.offer(new double[]{inc, pass, total});
        }

        while (extraStudents > 0) {
            double[] current = maxHeap.poll();
            double pass = current[1] + 1;
            double total = current[2] + 1;
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            maxHeap.offer(new double[]{inc, pass, total});
            extraStudents--;
        }

        // Calculate the final average pass ratio
        double totalPassRatio = 0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int passes = (int) current[1];
            int totalStudents = (int) current[2];
            totalPassRatio += (double) passes / totalStudents;
        }

        return totalPassRatio / classes.length;
    }
}