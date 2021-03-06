package com.kishor.kotlin.algo.algorithms.graph

class LowestCommonAncestor {

    class AncestralTree(name: Char) {
        val name = name
        var ancestor: AncestralTree? = null
    }

    fun getYoungestCommonAncestor(
        topAncestor: AncestralTree,
        descendantOne: AncestralTree,
        descendantTwo: AncestralTree
    ): AncestralTree? {

        val depthOne = getDepth(descendantOne, topAncestor)
        val depthTwo = getDepth(descendantTwo, topAncestor)
        if (depthOne > depthTwo) {
            return backTrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo)
        } else {
            return backTrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne)
        }
    }

    fun getDepth(start: AncestralTree, topAncestor: AncestralTree): Int {
        var descendant: AncestralTree? = start
        var depth = 0
        while (descendant != topAncestor) {
            depth++
            descendant = descendant!!.ancestor
        }
        return depth
    }

    fun backTrackAncestralTree(
        lowerDescendant: AncestralTree,
        higherDescendant: AncestralTree,
        diffStart: Int
    ): AncestralTree? {
        var lower: AncestralTree? = lowerDescendant
        var higher: AncestralTree? = higherDescendant
        var diff = diffStart
        while (diff > 0) {
            lower = lower!!.ancestor
            diff--
        }
        while (lower != higher) {
            lower = lower!!.ancestor
            higher = higher!!.ancestor
        }
        return lower
    }

}