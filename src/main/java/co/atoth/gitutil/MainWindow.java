package co.atoth.gitutil;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MainWindow {

	private static final String NO_VALUE_LVL = "<none>";
	private JFrame frmGitUtil;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmGitUtil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmGitUtil = new JFrame();
		frmGitUtil.setTitle("Git Util");
		frmGitUtil.setBounds(100, 100, 450, 300);
		frmGitUtil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel rootPanel = new JPanel();
		rootPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frmGitUtil.getContentPane().add(rootPanel, BorderLayout.CENTER);
		GridBagLayout gbl_rootPanel = new GridBagLayout();
		gbl_rootPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_rootPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_rootPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_rootPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		rootPanel.setLayout(gbl_rootPanel);
		
		JLabel lblFile = new JLabel("File:");
		GridBagConstraints gbc_lblFile = new GridBagConstraints();
		gbc_lblFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblFile.anchor = GridBagConstraints.WEST;
		gbc_lblFile.gridx = 0;
		gbc_lblFile.gridy = 0;
		rootPanel.add(lblFile, gbc_lblFile);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		rootPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
	            int returnValue = fileChooser.showOpenDialog(null);
	            if (returnValue == JFileChooser.APPROVE_OPTION) {
	              File selectedFile = fileChooser.getSelectedFile();
	              System.out.println(selectedFile.getName());
	            } 
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 0);
		gbc_btnBrowse.gridx = 2;
		gbc_btnBrowse.gridy = 0;
		rootPanel.add(btnBrowse, gbc_btnBrowse);
		
		JLabel lblGitRoot = new JLabel("Git root:");
		GridBagConstraints gbc_lblGitRoot = new GridBagConstraints();
		gbc_lblGitRoot.anchor = GridBagConstraints.WEST;
		gbc_lblGitRoot.insets = new Insets(0, 0, 5, 5);
		gbc_lblGitRoot.gridx = 0;
		gbc_lblGitRoot.gridy = 1;
		rootPanel.add(lblGitRoot, gbc_lblGitRoot);
		
		JLabel lblGitRootValue = new JLabel(NO_VALUE_LVL);
		GridBagConstraints gbc_lblGitRootValue = new GridBagConstraints();
		gbc_lblGitRootValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblGitRootValue.gridwidth = 2;
		gbc_lblGitRootValue.anchor = GridBagConstraints.WEST;
		gbc_lblGitRootValue.gridx = 1;
		gbc_lblGitRootValue.gridy = 1;
		rootPanel.add(lblGitRootValue, gbc_lblGitRootValue);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		rootPanel.add(scrollPane, gbc_scrollPane);
		
		JList<String> listBranches = new JList<String>();
		listBranches.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"one", "two", "three"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPane.setViewportView(listBranches);
		
		JLabel lblSelectedBranches = new JLabel("Selected:");
		GridBagConstraints gbc_lblSelectedBranches = new GridBagConstraints();
		gbc_lblSelectedBranches.anchor = GridBagConstraints.WEST;
		gbc_lblSelectedBranches.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectedBranches.gridx = 0;
		gbc_lblSelectedBranches.gridy = 3;
		rootPanel.add(lblSelectedBranches, gbc_lblSelectedBranches);
		
		JLabel lblSelectedBranchesValue = new JLabel(NO_VALUE_LVL);
		GridBagConstraints gbc_lblSelectedBranchesValue = new GridBagConstraints();
		gbc_lblSelectedBranchesValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelectedBranchesValue.anchor = GridBagConstraints.WEST;
		gbc_lblSelectedBranchesValue.gridwidth = 2;
		gbc_lblSelectedBranchesValue.gridx = 1;
		gbc_lblSelectedBranchesValue.gridy = 3;
		rootPanel.add(lblSelectedBranchesValue, gbc_lblSelectedBranchesValue);
		
		JButton btnApply = new JButton("Apply");
		GridBagConstraints gbc_btnApply = new GridBagConstraints();
		gbc_btnApply.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnApply.gridx = 2;
		gbc_btnApply.gridy = 4;
		rootPanel.add(btnApply, gbc_btnApply);
		
		
	}

}
