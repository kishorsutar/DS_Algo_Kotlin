package com.kishor.kotlin.ds

import java.util.Comparator

import java.util.Arrays

import java.util.PriorityQueue


internal class Solution {
    fun minMeetingRooms(times: List<List<Int>>): Int {

        // Check for the base case. If there are no intervals, return 0
        if (times.size == 0) {
            return 0
        }

        // Min heap
        val allocator = PriorityQueue<Int>()
        val intervals = times.toMutableList().sortedWith(kotlin.Comparator {a, b -> a[0].compareTo(b[0])} )
        allocator.add(intervals[0][1])

        // Iterate over remaining intervals
        for (i in 1 until intervals.size) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll()
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1])
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size
    }
}