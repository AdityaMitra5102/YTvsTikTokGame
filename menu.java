import java.io.*;
import java.awt.event.*;
import javax.swing.*;
public class menu implements ActionListener
{
    JFrame fr1=new JFrame("Menu");
    JLabel l1=new JLabel("----------------------------YouTube vs TikTok----------------------------");
    JLabel l2a=new JLabel("------------------------------------Target : ");
    JLabel l2b=new JLabel(" kills------------------------------------");
    JLabel l4=new JLabel("Select Level Here:");
    JComboBox lev=new JComboBox(new String[]{"Standard", "Bahut tez ho rahe ho!"});
    JLabel l3=new JLabel("<html><br>Rule 1: Hitting Amir Siddiqui, you earm Rs. 200 from the sweet shop. <br> Rule 2: Earn as fast as you can. <br> Rule 3. Enjoy!</html>");
    JButton b1=new JButton("Start game");
    JTextField kill=new JTextField(3);
    JPanel p=new JPanel();
    menu()
    {
        kill.setText("10");
        p.add(l1);
        p.add(l2a);
        p.add(kill);
        p.add(l2b);
        p.add(l4);
        p.add(lev);
        p.add(l3);
        p.add(b1);

        fr1.add(p);
        fr1.setSize(500,300);
        fr1.setResizable(false);
        fr1.setVisible(true);
        b1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            fr1.setVisible(false);
            if(e.getSource()==b1)
            {
                int kls=Integer.parseInt(kill.getText());
                int tm=((String)lev.getSelectedItem()).equals("Standard")?700:150;
                PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("GameData.svdata")));
                pw.println(kls+" "+tm);
                pw.flush();
                pw.close();
                Process ec=Runtime.getRuntime().exec("sht1.bat");

            }

        }
        catch(Exception excep)
        {}
    }

    public static void main(String args[])
    {
        new menu();
    }
}
