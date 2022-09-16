Binary search.
If we find the target in mid, we just return mid.
Otherwise, we check if the left is less than the mid. It means the array is sorted in the left side. Then we just check if the target should be between left and mid, then we'll discard the right half. If not, we'll discard the left half.
If the left greater than mid, it means the array is not sorted in left, it is right. Again we check if the target should be between right and mid, then we discard the left half. Else, we discard the right half.