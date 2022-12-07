class RandomizedSet {
    private final Set<Integer> values;
    private final Random random = new Random();
    private List<Integer> list;
    private boolean changed;

    public RandomizedSet() {
        values = new HashSet<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (!values.contains(val)) {
            values.add(val);
            changed = true;
            return true;
        }

        return false;
    }
    
    public boolean remove(int val) {
        if (values.contains(val)) {
            values.remove(val);
            changed = true;
            return true;
        }

        return false;
    }
    
    public int getRandom() {
        if (changed) {
            list = new ArrayList<>(values);
            changed = false;
        }

        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */