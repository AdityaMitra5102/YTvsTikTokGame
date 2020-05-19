import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class mouse implements ActionListener
{
    JButton arr[]=new JButton[64];
    int pos=-1;
    JFrame fr=new JFrame("YouTube vs TikTok");
    JPanel pan=new JPanel();
    JTextField ar=new JTextField(30);
    int c=0;
    JButton ext=new JButton("EXIT GAME");
    Data dt=null;
    mouse(Data ob)
    {
        dt=ob;
        pan.add(new JLabel(dt.heading));
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new JButton();
            arr[i].setPreferredSize(new Dimension(50,50));
            pan.add(arr[i]);
            arr[i].addActionListener(this);
        }
        ar.setEditable(false);
        pan.add(ar);
        fr.setSize(500,550);
        fr.setResizable(false);
        fr.add(pan);
        fr.setVisible(true);
        cursor();
        ext.addActionListener(this);
        pan.add(ext);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==ext)
        {
            System.exit(0);
        }
        try
        {
            JButton jb=(JButton) e.getSource();
            if(jb==arr[pos])
            {
                c+=1;
                ar.setText("Earnings: "+(Integer.toString(c*200)));
                //System.out.println("Added");
                swap();
                if(c==Teacher.kills)
                {
                    fr.setVisible(false);
                    Process ec=Runtime.getRuntime().exec("over.bat");
                    ec.waitFor();
                    
                }
            }
        }
        catch(Exception excep){}
    }

    public void work()
    {
        while(true)
        {
            swap();
        }
    }

    public void swap()
    {
        try
        {
            int p=(int)(Math.random()*63);
            //System.out.println(p);

            pos=p;
            for(int i=0;i<arr.length;i++)
            {
                arr[i].setText("");
                arr[i].setIcon(new ImageIcon("img1.png"));

            }
            arr[pos].setIcon(new ImageIcon(dt.imgPath));
            Thread.sleep(dt.time);
        }
        catch(Exception excep){}
    }

    public void cursor()
    {
        try
        {
            fr.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("download.png").getImage(),new Point(0,0),"Hammer"));;
        }
        catch(Exception excep)
        {}
    }

    public static void main1()
    {
        new mouse(Teacher.amir).work();
    }
}