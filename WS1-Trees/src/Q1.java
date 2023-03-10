import dsa.iface.IIterator;
import dsa.iface.IPosition;
import dsa.iface.ITree;
import dsa.impl.Tree;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        ITree<Character> tree = Tree.createTreeA();


        // num: 1
        Character a = root_element(tree);
        System.out.println(a);

        // num: 2
        root_children(tree);

        // num: 3
        int c = find_depth('L', tree);
        System.out.println(c);

        // num: 4 (not good method)
        int d = find_tree_height(tree);
        System.out.println(d);

        // num: 5
        find_ancestors('G', tree);

        // num: 6
        find_descendants('B', tree);

        // num: 7
        find_leaf(tree);

        // num: 8

        // num: 9

        // num: 10


    }

    public static IPosition<Character> get_IPosition(ITree<Character> tree, Character c) {
        IIterator<IPosition<Character>> iter = tree.positions();
        IPosition<Character> element;
        while (iter.hasNext()) {
            element = iter.next();
            if (element.element() == c) {
                return element;
            }
        }
        return null;
    }

    public static void print_list(ArrayList<Character> list) {

    }

    public static Character root_element(ITree<Character> tree) {
        return tree.root().element();
    }

    public static void root_children(ITree<Character> tree) {
        IIterator<IPosition<Character>> b = tree.children(tree.root());
        while (b.hasNext()) {
            System.out.print(b.next().element() + " ");
        }
        System.out.print("\n");
    }



    public static int find_depth(Character e, ITree<Character> tree) {
        IPosition<Character> element = get_IPosition(tree, e);
        int depth = 0;
        while (tree.parent(element) != null) {
            element = tree.parent(element);
            depth += 1;
        }
        return depth;
    }

    public static int find_tree_height(ITree<Character> tree) {
        int height = 0;
        if (tree.isEmpty()) {
            return height;
        }
        IIterator<IPosition<Character>> list = tree.positions();
        while (list.hasNext()) {
            IPosition<Character> ele = list.next();
            int h1 = find_depth(ele.element(), tree);
            if (h1 > height) {
                height = h1;
            }
        }
        return height;
    }

    public static void find_ancestors(Character e, ITree<Character> tree) {
        IPosition<Character> ele = get_IPosition(tree, e);
        IPosition<Character> parent = tree.parent(ele);
        while (parent != null) {
            System.out.print(parent.element() + " ");
            parent = tree.parent(parent);
        }
        System.out.print("\n");
    }

    public static void find_descendants(Character e, ITree<Character> tree) {
        IPosition<Character> ele = get_IPosition(tree, e);
        find_descendants(ele, tree);
        System.out.print("\n");
    }

    private static void find_descendants(IPosition<Character> c, ITree<Character> tree) {
        IIterator<IPosition<Character>> iterator = tree.children(c);
        while (iterator.hasNext()) {
            IPosition<Character> i = iterator.next();
            System.out.print(i.element() + " ");
            find_descendants(i, tree);
        }
    }

    public static void find_leaf(ITree<Character> tree) {
        find_leaf(tree.root(), tree);
        System.out.print("\n");
    }

    private static void find_leaf(IPosition<Character> c, ITree<Character> tree) {
        IIterator<IPosition<Character>> iterator = tree.children(c);
        if (iterator.hasNext() == false) {
            System.out.print(c.element() + " ");
            return;
        }
        while (iterator.hasNext()) {
            c = iterator.next();
            find_leaf(c, tree);
        }

    }

    public static void
}


