package com.kishor.kotlin.algo.dp

fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    if (d > n) return -1
    val arr = Array(d + 1) { IntArray(n + 1) }
    arr[1][0] = jobDifficulty[0]
    for (i in 1..n) {
        arr[1][i] = Math.max(jobDifficulty[i - 1], arr[1][i - 1])
    }
    for (k in 2..d) {
        for (i in 2..n) {
            var min = Int.MAX_VALUE
            var max = 0
            for (j in i - 1 downTo k - 1) { // j >= k-1 because just like d<=n
                //,we can not break in more than we have
                max = Math.max(max, jobDifficulty[j])
                min = Math.min(min, arr[k - 1][j] + max)
            }
            arr[k][i] = min
        }
    }
    // for(int[] a: arr){
    //     System.out.println(Arrays.toString(a));
    // }
    return if (arr[d][n] == Int.MAX_VALUE) -1 else arr[d][n]
}