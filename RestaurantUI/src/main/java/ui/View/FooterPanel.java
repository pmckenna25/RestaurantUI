package ui.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import ui.Model.ComTableModel;
import ui.Model.Order;
import ui.Model.Stuff;

public class FooterPanel extends JPanel {

    private ComTableModel model;
    List<Stuff> selected;
    JButton order;
    JButton cancel;
    JTextField total;
    JPanel southpane;
    static Gson gson;
    private String name;
    private static int orderNumber;
    
    public FooterPanel(List<Stuff> selected, String name, TableFrame frame) {
        super(new BorderLayout());
        this.name = name;
        total = new JTextField("Total: ");
        total.setEditable(false);
        this.selected = selected;
        gson = new GsonBuilder().create();
        ++orderNumber;

        Action actionOrder = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order orders = new Order(getName(), selected, orderNumber);
                try (Writer writer = new OutputStreamWriter(new FileOutputStream("Order Number "+orderNumber+".json"), "UTF-8")) {
                    gson.toJson(orders, writer);
                    JOptionPane.showMessageDialog(null, "The order for "+getName()+" has been placed");
                    frame.dispose();
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }   
        };
        Action actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Cancelling Order");
                    --orderNumber;
                    frame.dispose();
            }   
        };

        cancel = new JButton("Cancel");
        order = new JButton("Order");
        order.addActionListener(actionOrder);
        cancel.addActionListener(actionCancel);
        southpane = new JPanel();
        southpane.add(order, BorderLayout.WEST);
        southpane.add(cancel, BorderLayout.EAST);

        model = new ComTableModel(selected);
        JTable table = new JTable(model);
        this.add(total, BorderLayout.CENTER);
        this.add(table, BorderLayout.NORTH);
        this.add(southpane, BorderLayout.SOUTH);
    }

    public ComTableModel getModel() {
        return model;
    }

    public List<Stuff> getSelected() {
        return selected;
    }

    void addToList(Stuff v) {

        if (model.getStuff().size() < 26) {
            model.addValue(v);
            model.fireTableDataChanged();
            setTotal(model.getStuff());
        } else {
            JOptionPane.showMessageDialog(null, "You cannot order any more items!");
        }
    }

    void setTotal(List<Stuff> stuff) {
        float sum = 0;
        for (Stuff s : stuff) {
            sum += s.getPrice();
        }
        total.setText(String.format("Total: £%.2f", sum));
    }

    public String getName() {
        return name;
    }
    
}
