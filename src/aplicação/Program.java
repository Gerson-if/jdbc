
package aplicação;

public class Program {
    public static void main(String[] args) {
        try {
            Menu m = new Menu();
            m.menu();
            
        } catch (Exception e) {
            System.out.println("erro ao executar programa");
            e.printStackTrace();
        }
   
    }
    
    
}
