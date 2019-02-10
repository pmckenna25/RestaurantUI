
package ui.Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ComTableModel extends AbstractTableModel{
   
    List<Stuff> stuff;
    
    
    public ComTableModel(List<Stuff> stuff){
        this.stuff = stuff;
    }

    @Override
    public Class getColumnClass(int col) {
        return String.class;
    }
    
    @Override
    public int getRowCount() {
        if(stuff.size()< 25){
            return stuff.size();
        }else{
            return 25;
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int r, int c) {
        Stuff rowStuff = stuff.get(r);
        if(c == 0){
            return rowStuff.getName();
        }else if(c == 1){
            return rowStuff.getCategory();
        }else{
            return String.format("£%.2f",rowStuff.getPrice());
        }
    }

    @Override
    public String getColumnName(int col) {
        String[] titles = {"Name", "Category", "Price"};
        return titles[col];
    }
    
    public void addValue(Stuff v) {
        stuff.add(v);        
    }

    public List<Stuff> getStuff() {
        return stuff;
    }
}
