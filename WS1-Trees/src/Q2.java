import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;
import dsa.impl.Tree;

public class Q2 {
   public static void main( String[] args ) {
      ITree<Character> tree = Tree.createTreeB();

      // write your code to answer Question 2 here...
      //Q1: What is the height of the tree?
      int hight = Q1.findTreeHeight(tree);
      System.out.println(hight);

      //Q2: What is the depth of the position that stores D?
      int depth = Q1.findDepth('D', tree);
      System.out.println(depth);

      //Q3: List the elements stored in the children of the position that stores B
      Q1.elementChildren('B', tree);

      //Q4: List the elements stored in any siblings of the position that stores D
      findSiblings('D', tree);

      //Q5: List the elements that are stored at external positions
      Q1.findLeaf(tree);

      //Q6: What is the parent of the position that stores A?
      parentEle(tree, 'A');

      //Q7: List the ancestors of the position that stores E
      Q1.findAncestors('E', tree);

      //Q8: What is the size of the tree?
      int size = size(tree, tree.root());
      System.out.println(size);

      //Q9: Based on the code you have used to explore the tree contents and structure,
      //can you draw a diagram to show the structure of the tree?
      System.out.println(Q1.drawTree(tree));

   }

   public static <T> void findSiblings(T c, ITree<T> tree) {
      IPosition<T> ele = Q1.getIPosition(tree, c);
      IPosition<T> parent = tree.parent(ele);
      IIterator<IPosition<T>> iterator = tree.children(parent);
      while (iterator.hasNext()) {
         IPosition<T> i = iterator.next();
         if (i.element() != c) {
            System.out.print(i.element() + " ");
         }
      }
      System.out.print("\n");
   }


   public static <T> int size(ITree<T> tree, IPosition<T> ele) {
      IIterator<IPosition<T>> iterator = tree.children(ele);
      if (tree.isExternal(ele)) {
         return 1;
      }
      int count = 1;
      while (iterator.hasNext()) {
         count += size(tree, iterator.next());
      }
      return count;
   }

   public static <T> void parentEle(ITree<T> tree, T c) {
      IPosition<T> position = Q1.getIPosition(tree, c);
      if (tree.isRoot(position)) {
         System.out.println(c + " is the root of the tree, it doesn't have parent value.");
      } else {
         IPosition<T> parent = tree.parent(position);
         System.out.println(parent.element() + "is the parent of " + c);
      }
   }


}
