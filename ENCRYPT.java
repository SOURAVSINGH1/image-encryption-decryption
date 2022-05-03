

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ENCRYPT{

    public static void Encrypt(int key)
    {

        JFileChooser fileChooser=new JFileChooser("C:\\Users\\nicky\\OneDrive\\Desktop\\project5THsem");
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        
        //taking file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "image encrypted");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
       

        JFrame f=new JFrame();
        f.setTitle("ImageEncryption");
        f.setSize(300,200);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Roboto",Font.BOLD,25);
        
        
       //creating button
        
        JButton button=new JButton();
        button.setText("ENCRYPT");
        button.setBackground(Color.CYAN);
        button.setFont(font);
        button.setPreferredSize(new Dimension(160, 50));
        
        JButton button1=new JButton();
        button1.setText("KEY");
        button1.setFont(font);
        button1.setBackground(Color.CYAN);
        button1.setPreferredSize(new Dimension(160, 50));


        //creating text field

        JTextField textField=new JTextField(10);
        textField.setFont(font);
        
      
        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            Encrypt(temp);
        });

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.add(button1);
        f.setVisible(true);

    }
}
