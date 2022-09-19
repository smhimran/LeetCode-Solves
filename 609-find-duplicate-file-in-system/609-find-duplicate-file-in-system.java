class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> filesWithContent = new HashMap<>();
        
        for (String path: paths) {
            String[] splitted = path.split(" ");
            
            for (int i = 1; i < splitted.length; i++) {
                String[] file = splitted[i].split("\\(");
                String content = file[1].substring(0, file[1].length() - 1);
                
                String fileName = splitted[0] + "/" + file[0];                
                
                if (filesWithContent.containsKey(content)) {
                    filesWithContent.get(content).add(fileName);
                } else {
                    List<String> files = new ArrayList<>();
                    files.add(fileName);
                    filesWithContent.put(content, files);
                }
            }
        }
        
        List<List<String>> listToReturn = new ArrayList<>();
        
        for (List<String> list: filesWithContent.values()) {
            if (list.size() > 1) {
                listToReturn.add(list);
            }
        }
        
        return listToReturn;
    }
}