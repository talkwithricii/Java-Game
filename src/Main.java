import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        System.out.println("BSIT Game Starting...");
        JFrame frame = new JFrame("1000 Years War");

        GamePanel panel = new GamePanel(); 
        frame.add(panel); 

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
