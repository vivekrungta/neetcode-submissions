class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
    int[] res = new int[n];
    int[][] combined = new int[n][3];

    for (int i = 0; i < n; i++) {
        combined[i] = new int[]{tasks[i][0], tasks[i][1], i};
    }

    Arrays.sort(combined,
        (a, b) -> Integer.compare(a[0], b[0]));

    // Order by processing time, then original index.
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        a[0] == b[0]
            ? Integer.compare(a[1], b[1])
            : Integer.compare(a[0], b[0])
    );

    int j = 0;
    int i = 0;
    long t = 0;

    while (i < n) {
        if (pq.isEmpty() && j < n) {
            t = Math.max(t, combined[j][0]);
        }

        while (j < n && combined[j][0] <= t) {
            pq.offer(new int[]{combined[j][1], combined[j][2]});
            j++;
        }

        int[] popped = pq.poll();
        res[i++] = popped[1];
        t += popped[0];
    }

    return res;

    }
}