
package ui.Controller;

import java.io.IOException;
import ui.View.MainFrame;

public class Controller {
    
    private MainFrame appFrame;
    
    public void start() throws IOException{
        
        appFrame = new MainFrame(this);
        
    }
}
    