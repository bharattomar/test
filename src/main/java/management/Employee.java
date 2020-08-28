package management;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Employee<Integer, Object> {
    private final HashMap<Integer, Node<Integer, Object>> map = new HashMap<>();
    private final Node<Integer, Object> root;

    public Employee(Integer id, Object value) {
        root = new Node<>(id, value);
        map.put(id, root);
    }

    public void addChild(Integer parentId, Integer id, Object name) {
        Node<Integer, Object> parent = map.get(parentId);
        Node<Integer, Object> child = new Node<>(id, name);
        parent.children.add(child);
        map.put(id, child);
    }

    public Object getById(Integer id) {
        return map.get(id).value;
    }

    public String subtreeToString(Integer id) {
        return map.get(id).toString();
    }

    private static class Node<Integer, Object> {
        private final Integer id;
        private final Object value;
        private final ArrayList<Node<Integer, Object>> children = new ArrayList<>();

        private Node(Integer id, Object value) {
            this.id = id;
            this.value = value;
        }

        private void print(int depth, PrintWriter pw) {
            for (int i = 0; i < depth; i++) {
                pw.print("->");
            }
            pw.println(value);
            for (Node<Integer, Object> child : children) {
                child.print(depth + 1, pw);
            }
        }

        @Override
        public String toString() {
            StringWriter writer = new StringWriter();
            print(0, new PrintWriter(writer));
            return writer.toString();
        }
    }
}
