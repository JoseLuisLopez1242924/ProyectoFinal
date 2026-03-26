package proyectofinal;
import VISUAL.Login;
public class ProyectoFinal {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login().setVisible(true);
        }
    });
    }
    
}
