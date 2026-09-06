class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        i, j = 0, len(numbers) - 1

        while i < j:
            curSum = numbers[i] + numbers[j]
            if curSum > target:
                j -= 1
            elif curSum < target:
                i += 1
            else:
                return [i + 1, j + 1]
        return []