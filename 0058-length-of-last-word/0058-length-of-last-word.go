import "strings"

func lengthOfLastWord(s string) int {
    words := strings.Split(strings.Trim(s, " "), " ")
    return len(words[len(words) - 1])
}
