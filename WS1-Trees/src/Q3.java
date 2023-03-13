import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;
import dsa.impl.Tree;

import java.awt.image.BandedSampleModel;

public class Q3 {
   public static <T> void main( String[] args ) {
      ITree<String> tree = Tree.createTreeC();

      // write your code to answer Question 3 here...

      //Q1: Which is stored in the root position?
      System.out.println(Q1.rootElement(tree));

      //Q2: What are stored in the internal positions?
      internalEle(tree, tree.root());
      System.out.print("\n");

      //Q3: How many descendants does the position that stores “cs016/” have?
      IPosition<String> pos = Q1.getIPosition(tree, "cs016/");
      int size = Q2.size(tree, pos);
      System.out.println(size);

      //Q4: How many ancestors does the position that stores “cs016/” have?
      int ancestors = countAncestors("cs016/", tree);
      System.out.println(ancestors);

      //Q5: What are the siblings of the position that stores “homeworks/”?
      Q2.findSiblings("homeworks/", tree);

      //Q6: Which positions are in the subtree rooted at the position that stores “projects/”?
      Q1.findDescendants(Q1.getIPosition(tree, "projects/"), tree);

      //Q7: What is the depth of position that stores “papers/”?
      int depth = Q1.findDepth("papers/", tree);

      //Q8: What is the height of the tree?
      int height = Q1.findTreeHeight(tree);

      //Q9: Based on the code you have used to explore the tree contents and structure,
      //can you draw a diagram to show the structure of the tree?
      System.out.println(Q1.drawTree(tree));

   }

   public static <T> void internalEle(ITree<T> tree, IPosition<T> p) {
      IIterator<IPosition<T>> iterator = tree.children(p);
      if (tree.isInternal(p)) {
         System.out.print(p.element() + ", ");
      }
      while (iterator.hasNext()) {
         internalEle(tree, iterator.next());
      }
   }

   public static <T> int countAncestors(T e, ITree<T> tree) {
      IPosition<T> ele = Q1.getIPosition(tree, e);
      IPosition<T> parent = tree.parent(ele);
      int count = 0;
      while (parent != null) {
         count += 1;
         parent = tree.parent(parent);
      }
      return count;
   }


}
