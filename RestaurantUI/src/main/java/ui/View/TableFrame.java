package ui.View;

import java.io.IOException;
import javax.swing.JFrame;


public class TableFrame extends JFrame{
   
    private final Panel basePanel;
    private String name;
    
    
    public TableFrame(String name) throws IOException{
        
        basePanel = new Panel(name, this);
        this.name =name;
        setupFrame();
    }
    
   
    private void setupFrame(){
        
        //this.setTitle();
        this.setContentPane(basePanel);
        this.setSize(915,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
