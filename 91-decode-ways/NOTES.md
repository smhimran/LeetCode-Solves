Dynamic Programming.
For each non zero character:
`dp[i] = dp[i - 1]`
For zero, `dp[i] = 0`
If we can make a valid number with previous character: `dp[i] += dp[i - 2]`
​