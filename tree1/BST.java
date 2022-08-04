public class BST {
    private class Node{
        private int data;
        private Node left, right;
    }

    private Node root;

    public BST(){
    }

    public boolean contains(int value){
        return get(value) != null;
    }

    public Node get(int key){
        Node curr = root;
        while(curr.data != key){
            if(key > curr.data){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
            if(curr == null) return null;
        }
        return curr;
    }


    public void insert(int key){
        Node p = new Node(); //insert node
        p.data = key;

        if(root == null){
            root = p;
        }
        else {
            new Node();
            Node parent;
            Node curr = root;
            while (true) {
                parent = curr;
                if (key > curr.data) {
                    curr = curr.right;
                    if (curr == null) {
                        parent.right = p;
                        return;
                    }
                } else if(key < curr.data){
                    curr = curr.left;
                    if (curr == null) {
                        parent.left = p;
                        return;
                    }
                } else{
                    return ;
                }
            }
        }
    }

    public void delete(int key){
        Node curr;
        while(true){
            curr = get(key);
            if(curr == null){
                return ;
            };
            if(curr.left == null && curr.right == null){
                curr = null;
            } else if (curr.left != null && curr.right != null) {
                Node replacement = getLeftMax(curr);
                curr.data = replacement.data;
                resetparent(replacement,null);
            } else if (curr.left != null) {
                Node replacement = getLeftMax(curr);
                curr.data = replacement.data;
                resetparent(replacement,null);
            } else{
                Node replacement = getRightMin(curr);
                curr.data = replacement.data;
                resetparent(replacement,null);
            }

        }
    }

    private void resetparent(Node replacement,Node newParent) {
        Node curr = root;
        while(curr != null &&replacement.data != curr.data ){
            if(replacement.data > curr.data){
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }

        }
        return curr;
    }

    private Node getRightMin(Node curr) {
        if(curr.left != null){
            return getRightMin(curr.left);
        } else if (curr.right != null) {
            return getRightMin(curr.right);
        }
        return curr;
    }

    private Node getLeftMax(Node curr) {
        if(curr.right != null){
            return getLeftMax(curr.right);
        } else if (curr.left != null) {
            return getLeftMax(curr.left);
        }
        return curr;
    }

    public void preOrder(Node root)
    { // 前序遍历,"中左右"
        if (root != null)
        {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root)
    { // 中序遍历,"左中右"
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(Node root)
    { // 后序遍历,"左右中"
        if (root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void traverse(int traverseType)
    {    // 选择以何种方式遍历
        switch (traverseType) {
            case 1 -> {
                System.out.print("preOrder traversal ");
                preOrder(root);
                System.out.println();
            }
            case 2 -> {
                System.out.print("inOrder traversal ");
                inOrder(root);
                System.out.println();
            }
            case 3 -> {
                System.out.print("postOrder traversal ");
                postOrder(root);
                System.out.println();
            }
        }
    }



    public static void main(String[] args) {
        BST test = new BST();
        int max = 25;
        test.insert(12);
        test.insert(8);
        test.insert(4);
        test.insert(3);
        test.insert(4);
        test.insert(5);
        test.insert(6);
        test.insert(7);
        test.insert(1);
        test.insert(9);
        test.insert(10);
        test.insert(11);
        test.insert(13);
        test.insert(14);
        test.insert(15);
        test.delete(3);
        test.delete(2);
        test.delete(12);
        test.traverse(2);
    }
}
