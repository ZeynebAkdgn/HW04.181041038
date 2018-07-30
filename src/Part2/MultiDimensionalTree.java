package Part2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * BinaryTree classından miras alarak yapmadık cünkü binarytreedeki add metotları farklıydı. Rootun veri tipini de farklı
 * yapmak zorunda kaldık.
 */

public class MultiDimensionalTree {
    private Node root;
    private int dimensioncount;

    public MultiDimensionalTree() {
        this.dimensioncount = 3;
    }

    public MultiDimensionalTree(int dimensioncount) {
        this.dimensioncount = dimensioncount;
    }

    public void add(double[] newdata) {
        if (newdata == null) {
            throw new IllegalArgumentException("Data can not be null");   // data null ise hata fırlatılır
        }
        if (newdata.length != dimensioncount) {
            throw new IllegalArgumentException("Dimensioncount is not valid.");
        }
        Node newnode = new Node(newdata);

        if (root == null) { //datanın null olarak gelmediğini varsaydım.
            root = newnode;
        } else {                          //ağaçta bişeyler var
            int depth = 0;
            Node current = root;        //başlangıçta roota bakıcak

            double[] nodedata;              //ağaçtaki nodun datası...
            while (true) {
                nodedata = current.getData();     //currentgetdata bir array..
                if ( newdata[depth] < nodedata [depth]) {       //yenidatanın değeri nodun datasından küçükse sola ekleme.. sol boşsa eklenir
                    if (current.getLeft() == null) {
                        current.setLeft(newnode);             //ağacın solu boşsa oraya koy
                        return;
                    }
                    else {                      //ağacın solu boş olmadığı için solda ilerlemede depth bir artacak
                        depth = (depth +1)%dimensioncount; //derine indikçe modunu almak zorundayız. depth arttıkça dimension
                        //counttan büyük olmaya başlar tekrar ilk boyut karşılaştırması yapabilmek için dimension counta göre mod alınır.

                        current = current.getLeft();            //current sola ilerledi
                    }

                }
                else {              //boyuttaki değer büyük eşitse sağa yerleştir.
                    if (current.getRight() == null) {
                        current.setRight(newnode);      //sağı boşsa yerleşti
                        return;
                    }
                    else {
                        depth = (depth+1)%dimensioncount;
                        current = current.getRight();
                    }

                }

            }

        }
    }



    private void preOrderTraverse(Node node, StringBuilder sb) {

        if (node != null) {         //node nullden farklıysa ağaç üzerinde ilerlemeye çalışır.

            sb.append(node.toString());    //önce data basılır sonra bir alta geçer
            sb.append("\n");
            preOrderTraverse(node.getLeft(), sb);
            preOrderTraverse(node.getRight(), sb);
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb);
        return sb.toString();
    }
}
