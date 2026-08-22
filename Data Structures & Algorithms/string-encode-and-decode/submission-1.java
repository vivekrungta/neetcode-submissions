class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("/");
            sb.append(str);

        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int start=0;
        while(start<str.length()){
            int index = str.indexOf("/",start);
            int len = Integer.valueOf(str.substring(start,index));
            start=index+len+1;
            res.add(str.substring(index+1,start));
        }
        return res;
    }
}
