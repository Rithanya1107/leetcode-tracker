# Last updated: 7/20/2026, 10:22:43 AM
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs):
        groups = defaultdict(list)

        for word in strs:
            # Sort the characters to create a unique key
            key = ''.join(sorted(word))
            groups[key].append(word)

        return list(groups.values())
        