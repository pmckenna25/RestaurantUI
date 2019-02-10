
package ui.Controller;

import java.io.IOException;
import ui.Model.MakeStarterJSONs;

public class Runner {
    
    
    /**
     * Main starter method
     * @param args 
     */
    public static void main(String[] args) throws IOException{
        
        MakeStarterJSONs freshJSONs = new MakeStarterJSONs();
        Controller base = new Controller();
        base.start();
    }
}
