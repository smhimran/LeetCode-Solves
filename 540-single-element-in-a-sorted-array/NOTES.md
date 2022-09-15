Before the expected element each numbers first instance will be in even index, and second instance will be in odd index.
After the expected element, each numbers first instance will be in odd index, and second element will be in even index.
This is because the expected number will split the array in half. Binary search over the array on these two conditions to find the expected mid.