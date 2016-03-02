public class Solution {
    public int rob(TreeNode root) {
        return robSub(root);
    }
    
    public int robSub(TreeNode root) {
        if(root == null)
            return 0;
            
        int count = root.val;
        int count2 = 0;
        
        if(root.left!=null) {
            if(root.left.left!=null)
                count += robSub(root.left.left);
            
            if(root.left.right!=null)
                 count += robSub(root.left.right);
            
            count2+=robSub(root.left);
        }
        
        
        if(root.right!=null) {
            if(root.right.left!=null)
                count += robSub(root.right.left);
                
            if(root.right.right!=null)
                count += robSub(root.right.right);
                
            count2+=robSub(root.right);
        }
        
        return Math.max(count, count2);
    }
}