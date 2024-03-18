public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public void setLeft(TreeNode nodo){
        left=nodo;
    }

    public void setRight(TreeNode nodo){
        right=nodo;
    }

    public int getVal(){
        return val;
    }

    public void setVal(int valor){
        val=valor;
    }
}