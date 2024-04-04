public class TreeNode {
    private int valor;
    private TreeNode izq;
    private TreeNode der;
    
    public TreeNode(int valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }
    
    public int getVal() {
        return this.valor;
    }
    
    public void setVal(int valor) {
        this.valor = valor;
    }
    
    public TreeNode getLeft() {
        return this.izq;
    }
    
    public void setLeft(TreeNode izq) {
        this.izq = izq;
    }
    
    public TreeNode getRight() {
        return this.der;
    }
    
    public void setRight(TreeNode der) {
        this.der = der;
    }
}