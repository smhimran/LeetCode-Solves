DP
Sort the jobs by end time. For each job we have three choices. We can either take the previous best time, start from current job, or take current job and the best one that ended before current job can start.
​
**Time:** O(n)
**Space:** O(n)