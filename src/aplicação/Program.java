
package aplicação;
import gui.GUI;
public class Program {
    public static void main(String[] args) {
        try {
           // Menu m = new Menu();
           // m.menu();
           GUI gui = new GUI();
           gui.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("erro ao executar programa");
            e.printStackTrace();
        }
   
    }
    
    
}
