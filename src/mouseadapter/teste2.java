package mouseadapter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class teste2 {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public teste2(){
      prepararGUI();
   }
   public static void main(String[] args){
      teste2  mouseAdapter = new teste2();  
      mouseAdapter.showMouseAdapterDemo();
   }
   private void prepararGUI(){
      mainFrame = new JFrame("Mouse Adapter");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);        
      statusLabel.setSize(350,100);
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showMouseAdapterDemo(){
      headerLabel.setText("Listener em ação: MouseAdapter");      
      JPanel panel = new JPanel();      
      panel.setBackground(Color.ORANGE);
      panel.setLayout(new FlowLayout());        
      
      panel.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e) {
            statusLabel.setText("Mouse Clicado em: (X: "+e.getX()+", Y: "+e.getY() +")");
         }                
      });
      JLabel msglabel 
         = new JLabel("Teste maroto do Mouse Adapter",JLabel.CENTER);
      
      msglabel.addMouseListener(new MouseAdapter(){
         public void mouseClicked(MouseEvent e) {
            statusLabel.setText("Mouse Clicado em: (X: "+e.getX()+", Y: "+e.getY() +")");
         }                
      });
      panel.add(msglabel);
      controlPanel.add(panel);
      mainFrame.setVisible(true);  
   }
}