package management;

public class ManagementTree {

    public static void main(String[] str) {
        Employee<Integer, String> tree = new Employee<>(0, "Jerry");
        tree.addChild(0, 1, "Jerry");
        tree.addChild(1, 2, "Philip");
        tree.addChild(2, 3, "David");
        tree.addChild(3, 4, "Alice");
        tree.addChild(3, 5, "Mike");
        tree.addChild(2, 6, "Ken");
        tree.addChild(6, 7, "Peter");
        tree.addChild(2, 8, "Tom");
        tree.addChild(1, 9, "Stacie");
        tree.addChild(4, 10, "John");

        System.out.println(tree.subtreeToString(0));
    }
}
