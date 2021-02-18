package com.kishor.ds

class UnionFind(size: Int = 0) {
    var numOfComponents = 0
    var sz: IntArray
    var id: IntArray

    init {
        if (size <= 0) throw IllegalArgumentException("Size should be greater than 0")

        numOfComponents = size
        sz = IntArray(size) { 0 }
        id = IntArray(size) { 0 }

        for (i in 0 until size) {
            id[i] = i
            sz[i] = 1
        }
    }

    fun find(p: Int): Int {
        var tempP = p
        var root = tempP
        while (root != id[root]) {
            root = id[root]
        }

        while (tempP != root) {
            var next = id[tempP]
            id[tempP] = root
            tempP = next
        }

        return root
    }

    fun connected(p: Int, q: Int): Boolean {
        return find(p) == find(q)
    }

    fun unify(p: Int, q: Int) {
        if (connected(p, q)) return

        val root1 = find(p)
        val root2 = find(q)

        if (sz[root1] < sz[root2]) {
            sz[root2] += sz[root1]
            id[root1] = root2
        } else {
            sz[root1] += sz[root2]
            id[root2] = root1
            numOfComponents--
        }
    }

}
