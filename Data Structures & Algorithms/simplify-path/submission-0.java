class Solution {
    public String simplifyPath(String path) {
        
        String[] folders=path.split("/");
        List<String> res = new ArrayList<>();
        for(int i=0;i<folders.length;i++){
            String folder = folders[i];
            if(folder.isEmpty() || folder.equals(".") || (folder.equals("..") && res.isEmpty())) continue;
            else if(folder.equals("..")) res.remove(res.size()-1);
            else res.add(folder);

        }
        StringBuilder sb  = new StringBuilder();
        for(String each:res){
            sb.append("/");
            sb.append(each);
        }
        return sb.length()==0?"/":sb.toString();
    }
}