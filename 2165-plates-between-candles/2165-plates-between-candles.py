class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        results = []
        plates = []
        candles = []

        candle_found = False
        plate_count = 0

        for index, i in enumerate(s):
            if i == "|":
                candle_found = True
                candles.append(index)

            elif candle_found:
                plate_count += 1

            plates.append(plate_count)

        for left, right in queries:
            previous_of_right = self.find_previous_candle(right, candles)
            next_of_left = self.find_next_candle(left, candles)

            if previous_of_right <= next_of_left:
                results.append(0)
                continue

            results.append(plates[previous_of_right] - plates[next_of_left])

        return results

    def find_next_candle(self, start: int, candles: List[int]) -> int:
        for candle in candles:
            if candle >= start:
                return candle
        return len(candles)

    def find_previous_candle(self, start: int, candles: List[int]) -> int:
        for candle in reversed(candles):
            if candle <= start:
                return candle
        return 0
