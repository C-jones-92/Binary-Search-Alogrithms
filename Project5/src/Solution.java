import java.util.ArrayList;
import java.util.List;

class Solution {
	List<List<Integer>> answer = new ArrayList<List<Integer>>();
    List<Integer> level = new ArrayList<Integer>();
    int count = 0;
    int limit = (int) Math.pow(2, count);
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        printlevel(root);
        return answer;
        
        
    }
    
    void printlevel(TreeNode root) {
    	int h = height(root);
    	for(int i = 1; i <= h;i++) {
    		traverse(root, i);
    		answer.add(level);
    		level.clear();
    	}
    }
    
    int height(TreeNode root) {
    	if(root == null) return 0;
    	else
    	{
    		int lheight = height(root.left);
    		int rheight = height(root.right);
    		
    		if(lheight > rheight) {
    			return lheight +1;
    		}
    		else return rheight +1;
    	}
    }
    public void traverse(TreeNode node, int lev) {
    	
    	if(node == null)
    		return;
    	
    	if(lev == 1)
    		level.add(node.val);
    	
    	else if(lev > 1) {
    		traverse(node.left, lev -1);
    		traverse(node.right, lev -1);
    	}
    	
    }
}