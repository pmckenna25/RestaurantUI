
package ui.View;

import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import ui.Model.ComTableModel;
import ui.Model.Stuff;


public class SidePane extends JPanel{
    
    Stuff[] stuff;
    private ComTableModel stuffList;
    JLabel header;
    JTable table;

    public SidePane(Stuff[] stuff, String name){
        header = new JLabel(name);
        this.setLayout(new BorderLayout());
        this.stuff = stuff;
        DefaultListSelectionModel listSelect = new DefaultListSelectionModel();
        listSelect.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        stuffList = new ComTableModel(Arrays.asList(stuff));
        table = new JTable(stuffList);
        table.setSelectionModel(listSelect);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(header, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
    }

    public JTable getTable() {
        return table;
    }
               
    
}
