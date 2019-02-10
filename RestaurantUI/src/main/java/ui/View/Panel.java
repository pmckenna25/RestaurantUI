package ui.View;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ui.Model.FoodAndDrinkMenus;
import ui.Model.Stuff;

public class Panel extends JPanel {

    
    private final SidePane westPane;
    private final SidePane eastPane;
    private final FooterPanel southPane;
    private final FoodAndDrinkMenus menu;
    private final List<Stuff> selected;
    private final List<Stuff> searchList;
    private String name;

    public Panel(String name, TableFrame frame) throws IOException {
        
        this.name = name;
        selected = new LinkedList<Stuff>();
        searchList = new LinkedList<Stuff>();
        this.menu = new FoodAndDrinkMenus();
        this.setLayout(new BorderLayout());
        
        searchList.addAll(Arrays.asList(menu.getDrinks()));
        searchList.addAll(Arrays.asList(menu.getFood()));
        southPane = new FooterPanel(selected, name, frame);
        westPane = new SidePane(menu.getDrinks(), "Drinks");
        eastPane = new SidePane(menu.getFood(), "Food");
        listenToTable(westPane.getTable());
        listenToTable(eastPane.getTable());
        this.add(westPane, BorderLayout.WEST);
        this.add(eastPane, BorderLayout.EAST);
        this.add(southPane, BorderLayout.SOUTH);
      
    }

    private void listenToTable(JTable table){
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == true) {
                    for (Stuff stuff : searchList) {
                        if (stuff.getName().equals(table.getValueAt(table.getSelectedRow(), 0).toString())) {
                            southPane.addToList(stuff);
                            //westPane.getTable().getSelectionModel().clearSelection();
                        }
                    }
                }
            }
        });
    }
}
