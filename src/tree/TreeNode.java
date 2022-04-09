package tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }

    public void insert(int newVal) {
        if (newVal < this.val) {
            if (this.left == null) {
                this.left = new TreeNode(newVal);
            } else {
                this.left.insert(newVal);
            }
        } else {
            if (newVal > this.val) {
                if (this.right == null) {
                    this.right = new TreeNode(newVal);
                } else {
                    this.right.insert(newVal);
                }
            }
        }
    }

    public void printInOrder() {
        if (this == null) return;
        if (this.left != null) {
            this.left.printInOrder();
        }
        System.out.print(this.val +" ");
        if (this.right != null) {
            this.right.printInOrder();

        }

    }
}
