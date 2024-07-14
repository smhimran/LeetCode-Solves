class Solution:
    def distanceFromOrigin(self, a) -> int:
        return (a[0] * a[0]) + (a[1] * a[1])

    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        return sorted(points, key= lambda x : self.distanceFromOrigin(x))[:k]
        