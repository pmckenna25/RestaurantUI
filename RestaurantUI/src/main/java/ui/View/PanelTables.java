package ui.View;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import ui.Controller.Controller;


public class PanelTables extends JPanel {
    
    private final Controller baseController;
    private final JButton table1;
    private final JButton table2;
    private final JButton table3;
    private final JButton table4;
    private final JButton table5;
    private final JButton table6;
    private List<Integer> numbers;
    
    public PanelTables(Controller baseController) throws IOException{
        numbers = new ArrayList<>();
        for(int i = 1; i <= 500; i++){

            numbers.add(i);
        }
        this.baseController = baseController;
        this.table1 = new JButton("Table One");
        this.table2 = new JButton("Table Two");
        this.table3 = new JButton("Table Three");
        this.table4 = new JButton("Table Four");
        this.table5 = new JButton("Table Five");
        this.table6 = new JButton("Table Six");
        
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TableFrame fresh = new TableFrame(((JButton) e.getSource()).getText());
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        table1.addActionListener(action);
        table2.addActionListener(action);
        table3.addActionListener(action);
        table4.addActionListener(action);
        table5.addActionListener(action);
        table6.addActionListener(action);
        table1.setPreferredSize(new Dimension(100,100));
        table2.setPreferredSize(new Dimension(100,100));
        table3.setPreferredSize(new Dimension(100,100));
        table4.setPreferredSize(new Dimension(100,100));
        table5.setPreferredSize(new Dimension(100,100));
        table6.setPreferredSize(new Dimension(100,100));      
        this.add(table1);
        this.add(table2);
        this.add(table3);
        this.add(table4);
        this.add(table5);
        this.add(table6);
 
    }

    public int takeOrderNumber(){

        int number = numbers.get(0);
        numbers.remove(0);
        return number;
    }
}
