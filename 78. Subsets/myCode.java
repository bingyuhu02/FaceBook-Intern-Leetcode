class myCode {
    public static void main (String[] args) throws java.lang.Exception {
        int[] tes = {1,2,3};
        myCode sol = new myCode();
        List<List<Integer>> result = new ArrayList<>(sol.subsets(tes));
        for( List<Integer> list : result){
            for( int i = 0 ; i < list.size(); i++){
                System.out.print(list.get(i) + ",");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        for(int i : nums){
            List<List<Integer>> nextRes = new ArrayList<>();
            for(List<Integer> oldList :res){
                List<Integer> newList = new ArrayList<>(oldList);
                newList.add(i);
                nextRes.add(newList);
            }
            res.addAll(nextRes);
        }
        return res;
    }
}
