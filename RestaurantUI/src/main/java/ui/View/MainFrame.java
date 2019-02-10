package ui.View;

import java.io.IOException;
import javax.swing.JFrame;
import ui.Controller.Controller;



public class MainFrame extends JFrame {
    
    private final PanelTables basePanel;
    
    public MainFrame(Controller baseController) throws IOException{
    
        basePanel = new PanelTables(baseController);
        setupFrame();
    }
    
    private void setupFrame(){
    
        this.setContentPane(basePanel);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
