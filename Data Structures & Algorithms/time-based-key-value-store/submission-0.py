import collections
class TimeMap:

    def __init__(self):
        self.store=collections.defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.store[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        res=""
        if key not in self.store:
            return res

        values =self.store[key]
        left=0
        right=len(values)-1
        while left<=right:
            mid=(left+right)//2
            if values[mid][0] == timestamp:
                return values[mid][1]
            elif values[mid][0]<timestamp:
                res=values[mid][1]
                left=mid+1
            else:
                right=mid-1
        return res