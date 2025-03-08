func minimumRecolors(blocks string, k int) int {
    numberOfWhiteBlocks := 0
    minimumNumberOfWhiteBlocks := 0

    left := 0
    right := 0

    for ; right < k; right++ {
        if blocks[right] == 'W' {
            numberOfWhiteBlocks++
            minimumNumberOfWhiteBlocks++
        }
    }

    for right < len(blocks) {
        if blocks[left] == 'W' {
            numberOfWhiteBlocks--
        }

        if blocks[right] == 'W' {
            numberOfWhiteBlocks++
        }

        left++
        right++

        minimumNumberOfWhiteBlocks = min(minimumNumberOfWhiteBlocks, numberOfWhiteBlocks)
    }

    return minimumNumberOfWhiteBlocks
}