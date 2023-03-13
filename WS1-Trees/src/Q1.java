import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;
import dsa.impl.Tree;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        ITree<Character> tree = Tree.createTreeA();


        // num: 1
        Character a = rootElement(tree);
        System.out.println(a);

        // num: 2
        elementChildren(a, tree);

        // num: 3
        int c = findDepth('L', tree);
        System.out.println(c);

        // num: 4 (not good method)
        int d = findTreeHeight(tree);
        System.out.println(d);

        // num: 5
        findAncestors('G', tree);

        // num: 6
        findDescendants('B', tree);

        // num: 7
        findLeaf(tree);

        // num: 8
        boolean h = isEdge('N', 'L', tree);
        System.out.println(h);
        // num: 9
        printList(elementBetween('D', 'N', tree));

        // num: 10
        System.out.println(drawTree(tree));


    }

    public static <T> IPosition<T> getIPosition(ITree<T> tree, T c) {
        IIterator<IPosition<T>> iter = tree.positions();
        IPosition<T> element;
        while (iter.hasNext()) {
            element = iter.next();
            if (element.element() == c) {
                return element;
            }
        }
        return null;
    }

    public static <T> void printList(ArrayList<T> list) {
        int i = 0;
        while (i < list.size()) {
            System.out.print(list.get(i) + " ");
            i += 1;
        }
        System.out.print("\n");
    }

    public static <T> T rootElement(ITree<T> tree) {
        return tree.root().element();
    }

    public static <T> void elementChildren(T ele, ITree<T> tree) {
        IPosition<T> e = getIPosition(tree, ele);
        IIterator<IPosition<T>> b = tree.children(e);
        while (b.hasNext()) {
            System.out.print(b.next().element() + " ");
        }
        System.out.print("\n");
    }



    public static <T> int findDepth(T e, ITree<T> tree) {
        IPosition<T> element = getIPosition(tree, e);
        int depth = 0;
        while (tree.parent(element) != null) {
            element = tree.parent(element);
            depth += 1;
        }
        return depth;
    }

    public static <T> int findTreeHeight(ITree<T> tree) {
        int height = 0;
        if (tree.isEmpty()) {
            return height;
        }
        IIterator<IPosition<T>> list = tree.positions();
        while (list.hasNext()) {
            IPosition<T> ele = list.next();
            int h1 = findDepth(ele.element(), tree);
            if (h1 > height) {
                height = h1;
            }
        }
        return height;
    }

    public static <T> void findAncestors(T e, ITree<T> tree) {
        IPosition<T> ele = getIPosition(tree, e);
        IPosition<T> parent = tree.parent(ele);
        while (parent != null) {
            System.out.print(parent.element() + " ");
            parent = tree.parent(parent);
        }
        System.out.print("\n");
    }

    public static <T> void findDescendants(T e, ITree<T> tree) {
        IPosition<T> ele = getIPosition(tree, e);
        findDescendants(ele, tree);
        System.out.print("\n");
    }

    private static <T> void findDescendants(IPosition<T> c, ITree<T> tree) {
        IIterator<IPosition<T>> iterator = tree.children(c);
        while (iterator.hasNext()) {
            IPosition<T> i = iterator.next();
            System.out.print(i.element() + " ");
            findDescendants(i, tree);
        }
    }

    public static <T> void findLeaf(ITree<T> tree) {
        findLeaf(tree.root(), tree);
        System.out.print("\n");
    }

    private static <T> void findLeaf(IPosition<T> c, ITree<T> tree) {
        IIterator<IPosition<T>> iterator = tree.children(c);
        if (iterator.hasNext() == false) {
            System.out.print(c.element() + " ");
            return;
        }
        while (iterator.hasNext()) {
            c = iterator.next();
            findLeaf(c, tree);
        }

    }

    public static <T> boolean isEdge(T parent, T children, ITree<T> tree) {
        IPosition<T> Parent = getIPosition(tree, parent);
        IPosition<T> Children = getIPosition(tree, children);
        return (tree.parent(Children) == Parent);
    }

    public static <T> ArrayList<T> elementBetween(T a, T b, ITree<T> tree) {
        ArrayList<T> arr = new ArrayList<>();
        IPosition<T> B = getIPosition(tree, b);
        while (tree.parent(B).element() != a) {
            B = tree.parent(B);
            arr.add(0, B.element());
        }
        return arr;
    }


    public static <T> String drawTree(ITree<T> tree) {
        StringBuilder diagram = new StringBuilder();
        buildTreeString(tree, tree.root(), "", "", diagram);
        return diagram.toString();
    }

    public static <T> void buildTreeString(ITree<T> t, IPosition<T> p, String prefix, String childrenPrefix, StringBuilder diagram) {
        diagram.append(prefix);
        diagram.append(p.element());
        diagram.append("\n");
        IIterator<IPosition<T>> it = t.children(p);
        while (it.hasNext()) {
            IPosition<T> nextPos = it.next();
            if (it.hasNext()) {
                buildTreeString(t, nextPos, childrenPrefix + "├── ", childrenPrefix + "│   ", diagram);
            } else {
                buildTreeString(t, nextPos, childrenPrefix + "└── ", childrenPrefix + "    ", diagram);
            }
        }
    }
}


