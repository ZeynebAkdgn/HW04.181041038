package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralBinaryTree<E> extends BinaryTree<E> {
    //public TreeNode<E> root;

    /**
     * Ağaçda hiçbir eleman olmadığı vurgulandı.
     */
    public GeneralBinaryTree() {
        setRoot(null);
    }

    /**
     * Bu metot parametre olarak gelen parentı binary treede arar bulur ve varsa childı son child olarak ekler. Ekleyebilirse
     * geriye true döndürür. Ekleyemezse false döndürür. Eğer parent ağaçta yok ise, geriye false döndürür.
     * Eğer ağaç boş ise parent ağacın rootu yapılır ve child bu parenta eklenir.
     * Eğer ağaç boş parent nullden farklı ve child null ise sadece parent root node olarak ağaca eklenir.
     *
     * @param parent : childın ekleneceği parent
     * @param child  : parenta eklenecek child.
     * @return : ekleme başarılı olursa true, başarısız olursa false döner.
     */
    public boolean add(E parent, E child) {


        if (parent == null) {  // eklenemediği durumda false döner
            return false;
        }

        if (getRoot() == null) {
            if (child == null) {  // başlangıçta child olmadan bir parent eklenmek istenirse --> özel durum
                TreeNode<E> parentNode = new TreeNode<>(parent); // new ile yeni bir TreeNode objeckti oluşturuluyor.gelen parentı data olarak koyduk

                setRoot(parentNode);
            } else {
                TreeNode<E> parentNode = new TreeNode<>(parent);
                TreeNode<E> childNode = new TreeNode<>(child);

                parentNode.setFirstchild(childNode);
                setRoot(parentNode);
            }
            return true;
        } else {
            TreeNode<E> parentfound = levelOrderSearch(parent); //bu ağaçta levelordersearch metoduyla parenti ara
            if (parentfound != null) {
                TreeNode<E> childNode = new TreeNode<>(child);
                if (parentfound.getFirstchild() == null) {
                    parentfound.setFirstchild(childNode);
                } else {
                    TreeNode<E> firstchild = parentfound.getFirstchild();
                    TreeNode<E> currentsibling = firstchild;
                    while (currentsibling.getNextsibling() != null) {
                        currentsibling = currentsibling.getNextsibling();
                    }
                    currentsibling.setNextsibling(childNode); // son kardeşin sonuna yeni kardeş ekleniyor.
                }
                return true;
            } else {
                return false;
            }

        }

    }

    /**
     * İtemı arar ve bulursa gönderir. Kuyruk yapısı kullanmak amacıyla LinkedList oluşturuldu.
     * @param item
     * @return
     */
    public TreeNode<E> levelOrderSearch(E item) {
        LinkedList<TreeNode<E>> q = new LinkedList<>();    //
        //q.addLast();
        //q.removeFirst();


        TreeNode<E> n;
        TreeNode<E> currentsibling;

        if (getRoot() == null) {
            return null;
        }


        if (getRoot().getData().equals(item)) {                      //rootun datasına  bakılır
            return getRoot();
        }
        q.addLast(getRoot());  //Başlangıçta gelen node rootumuz. İlk nodu kuyruğa konulur.


        while (!q.isEmpty()) {    //kuyruk boş olmadığı sürece
            n = q.removeFirst();

            if (n.getFirstchild() != null) {
                n = n.getFirstchild();   //1.chılda ulaştık


                if (n.getData().equals(item)) {
                    return n;
                }
                q.addLast(n);
                currentsibling = n;
                while (currentsibling.getNextsibling() != null) {
                    currentsibling = currentsibling.getNextsibling();


                    if (currentsibling.getData().equals(item)) {
                        return currentsibling;
                    }
                    q.addLast(currentsibling);     //bulamadıysa ekledi
                }

            }
        }

        return null;
    }

    public TreeNode<E> postOrderSearch(E item) {

        /**
         * postOrderSearch (): Traverse a node before traversing its subtrees starting from the root node.
         * Search for the item during traversal. Return the Node reference if the item is in the tree and null if it is not
         * in the tree.
         *
         */
        return postOrderSearch(getRoot(), item);  //recursive olan metodu çağıracak. Metot overloading oluyor.


    }

    /**
     * Recursive yapıldı.Item sol ağaçta aranır. Nodun datası itema eşit mi kontrol edilir. Aradığımız datanın nodu return edilir.
     * @param node
     * @param item: ağaçta aranır
     * @return
     */
    private TreeNode<E> postOrderSearch(TreeNode<E> node, E item) {

        if (node != null) {

            TreeNode<E> searchresult = postOrderSearch(node.getFirstchild(), item);
            if (searchresult != null) {
                return searchresult;
            }

            if (node.getData().equals(item)) {
                return node; //aradığım data bu nodeda
            }

            searchresult = postOrderSearch(node.getNextsibling(), item); // datayı nextsiblingde ara..
            return searchresult;

        } else {
            return null;
        }


    }

    private void preOrderTraverse(TreeNode<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("    "); //String builder sonuna boşluk
        }
        if (node == null) {
            sb.append("\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.getFirstchild(), depth + 1, sb);
            preOrderTraverse(node.getNextsibling(), depth, sb);
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(getRoot(), 1, sb);
        return sb.toString();
    }


}
