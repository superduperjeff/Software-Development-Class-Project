
import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;


public class OntologyJTree extends JTree {
	
	public ArrayList<TreeNode> items = new ArrayList<TreeNode>();

	public OntologyJTree() {
		// TODO Auto-generated constructor stub
	}

	public OntologyJTree(Object[] value) {
		super(value);
		// TODO Auto-generated constructor stub
	
	}
	public OntologyJTree(TreeNode value) {
		super(value);
		items.add(value);
		this.setToggleClickCount(2);
		// TODO Auto-generated constructor stub
	
	}
	
	public ArrayList<TreeNode> getTreeNodes() {
		return items;
	}
	


}

