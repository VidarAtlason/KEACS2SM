package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;

import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MainWindow extends JFrame
{
    private JTable table;

    public MainWindow()
    {
	this.setTitle("MainWindow");
	this.setSize(new Dimension(800, 600));
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	getContentPane().add(tabbedPane, BorderLayout.CENTER);

	JPanel cottages = new JPanel();
	tabbedPane.addTab("Cottages", null, cottages, null);
	cottages.setLayout(null);

	JPanel panel = new JPanel();
	panel.setBounds(0, 467, 779, 66);
	cottages.add(panel);
	panel.setLayout(new BorderLayout(0, 0));

	JPanel panel_1 = new JPanel();
	panel.add(panel_1, BorderLayout.NORTH);

	JButton btnAdd = new JButton("Add");
	panel_1.add(btnAdd);

	JButton btnEdit = new JButton("Edit");
	panel_1.add(btnEdit);

	JButton btnOther = new JButton("...");
	panel_1.add(btnOther);

	JPanel panel_2 = new JPanel();
	panel.add(panel_2, BorderLayout.SOUTH);
	panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	JButton btnNewButton = new JButton("Exit");
	panel_2.add(btnNewButton);

	table = new JTable()
	{
	    public boolean isCellEditable(int row, int column)
	    {
		return false;
	    }

	};
	table.setFillsViewportHeight(true);
	table.setCellSelectionEnabled(true);
	table.setRowSelectionAllowed(false);
	table.setColumnSelectionAllowed(false);
	table.setBounds(-36, 11, 825, 252);
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane.setBounds(0, 0, 779, 456);
	cottages.add(scrollPane);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public JTable getTable()
    {
	return this.table;
    }

    public void addMouseAdapterToTable(MouseAdapter adapter)
    {
	table.addMouseListener(adapter);
    }
}
