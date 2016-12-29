public List<Integer> findCommonFriend(int id){
    List<Integer> res = new ArrayList<>();
    int[] friend = getFriend(id);
    for( int i = 0 ; i < friend.length ; i++){
        int[] nextFriend = getFriend(friend[i]);
        for(int j = 0 ; j < nextFriend.length ; j++){
            if( nextFriend[j] != id){
                res.add(nextFriend[j]);
                //if( !map.containsKey(nextFriend[j])) map.put(nextFriend[j],1);
                //else map.put(nextFriend[j],map.get(nextFriend[j])+1);
            }
        }
    }
    return res;
}