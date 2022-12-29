class Solution {
    public int[] getOrder(int[][] taskArray) {
        List<Task> tasks = new ArrayList<>();
        List<Integer> taskOrder = new ArrayList<>();
        PriorityQueue<Task> queue = new PriorityQueue<>((a, b) -> {
            if (a.getProcessingTime() == b.getProcessingTime()) 
                return a.getIndex() - b.getIndex();
            return a.getProcessingTime() - b.getProcessingTime();
        });

        for (int i = 0; i < taskArray.length; i++) {
            Task task = new Task(i, taskArray[i][0], taskArray[i][1]);
            tasks.add(task);
        }

        Collections.sort(tasks, (a, b) -> {
            if (a.getEnqueueTime() == b.getEnqueueTime()) {
                return a.getProcessingTime() - b.getProcessingTime();
            }
            return a.getEnqueueTime() - b.getEnqueueTime();
        });
        
        int currentTime = tasks.get(0).getEnqueueTime();
        int currentIndex = 1;

        queue.add(tasks.get(0));

        while (!queue.isEmpty() || currentIndex < tasks.size()) {
            if (!queue.isEmpty()) {
                Task currentTask = queue.poll();
                currentTime += currentTask.getProcessingTime();
                taskOrder.add(currentTask.getIndex());
            } else {
                currentTime = tasks.get(currentIndex).getEnqueueTime();
            }

            while (currentIndex < tasks.size()) {
                Task task = tasks.get(currentIndex);

                if (task.getEnqueueTime() > currentTime) {
                    break;
                }

                queue.add(task);
                currentIndex++;
            }   
        }

        return taskOrder.stream().mapToInt(i -> i).toArray();
    }
}

class Task {
    private int index;
    private int enqueueTime;
    private int processingTime;

    public Task(int index, int enqueueTime, int processingTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }

    public int getIndex() {
        return index;
    }

    public int getEnqueueTime() {
        return enqueueTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }
}