import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JLabel lcaLabel;
    private JLabel levelLabel;
    private BinaryTree tree;

    public Main() {
        tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        frame = new JFrame("Binary Tree LCA Finder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel n1Label = new JLabel("Enter Node 1: ");
        JTextField n1Field = new JTextField(5);
        JLabel n2Label = new JLabel("Enter Node 2: ");
        JTextField n2Field = new JTextField(5);
        JButton findButton = new JButton("Find LCA");
        lcaLabel = new JLabel();
        levelLabel = new JLabel();

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1 = Integer.parseInt(n1Field.getText());
                int n2 = Integer.parseInt(n2Field.getText());
                Node lca = tree.findLCA(n1, n2);
                lcaLabel.setText("LCA of " + n1 + " and " + n2 + " is " + lca.data);
                int level = tree.getLevel(tree.root, n1, 1);
                levelLabel.setText("Level of node " + n1 + " is: " + level);
            }
        });

        frame.add(n1Label);
        frame.add(n1Field);
        frame.add(n2Label);
        frame.add(n2Field);
        frame.add(findButton);
        frame.add(lcaLabel);
        frame.add(levelLabel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}