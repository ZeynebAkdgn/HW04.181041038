package Part2;

public class Node {
    private double[] data;
    private Node left;
    private Node right;

    /**
     * koordinat objekti alacak varsayıyoruz.
     * @param dimensions
     */
    public Node (double[] dimensions) {
        this.data = dimensions;
        this.left = null;
        this.right = null;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * data dizisindeki her bir elemanın arasına virgül konularak bir stringde biriktiriliyor.
     * @return
     */
    @Override
    public String toString() {
        String s= "[";
        int i;
        //
        for (i = 0; i<data.length-1; i++){
            s = s+data[i]+",";
        }
        s=s+data[i]+"]";
        return s;
    }

}
