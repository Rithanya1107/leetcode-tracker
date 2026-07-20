# Last updated: 7/20/2026, 10:22:33 AM
class Solution:
    def merge(self, intervals):
        # Sort intervals by start time
        intervals.sort(key=lambda x: x[0])

        merged = []

        for interval in intervals:
            # If merged is empty or no overlap
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                # Merge overlapping intervals
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged