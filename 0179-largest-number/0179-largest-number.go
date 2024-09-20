func compare(a, b string) bool {
	return a+b > b+a
}

func largestNumber(nums []int) string {
	strNums := make([]string, len(nums))
	for i, num := range nums {
		strNums[i] = fmt.Sprintf("%d", num)
	}

	sort.Slice(strNums, func(i, j int) bool {
		return compare(strNums[i], strNums[j])
	})

	if strNums[0] == "0" {
		return "0"
	}

	return strings.Join(strNums, "")
}