class Solution {
    public String destCity(List<List<String>> paths) {
        ArrayList<String> from = new ArrayList();
        ArrayList<String> to = new ArrayList();
        
        for(int i = 0; i<paths.size(); i++) {
            from.add(paths.get(i).get(0));
            to.add(paths.get(i).get(1));
        }
        
        to.removeAll(from);
        return to.get(0);
    }
}