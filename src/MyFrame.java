import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener
{
    private JPanel noord,zuid;
    private JLabel lab1, lab2, lab3;
    private JTextField tf1, tf2;
    private JButton toon;
    private int uren, mins;
    private String uur, min;
    private boolean uitz1 = false, uitz2 = false, pm = false;
    // uitz1 = rekenuitzondering	uitz2 = positieuitzondering

    public MyFrame()
    {
        setLayout(new BorderLayout());

        noord = new JPanel();
        noord.setLayout(new FlowLayout());
        noord.setPreferredSize(new Dimension(350,30));
        lab1 = new JLabel("Tijd in uren : minuten ");
        noord.add(lab1);
        tf1 = new JTextField(2);
        noord.add(tf1);
        lab2 = new JLabel(":");
        noord.add(lab2);
        tf2 = new JTextField(2);
        noord.add(tf2);
        add(noord, BorderLayout.NORTH);

        lab3 = new JLabel("Voer tijd in...");
        lab3.setHorizontalAlignment(JLabel.CENTER);
        add(lab3, BorderLayout.CENTER);

        zuid = new JPanel();
        zuid.setPreferredSize(new Dimension(100,30));
        toon = new JButton("Verwerk");
        zuid.add(toon);
        toon.addActionListener(this);
        add(zuid, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public boolean check()
    {
        boolean b = false;
        if(uren >= 0 && uren <= 23)
        {
            if (mins >= 0 && mins <= 59)
            {
                b = true;
            }
        }
        return b;
    }

    public void urenConv()
    {
        String s = tf1.getText();
        uren = Integer.parseInt(s);

        if (uitz1 == true)
        {
            pm();
            uren++;

            if(uren == 24)
            {
                uren = 0;
            }
        }

        else
        {
            pm();
        }

        switch(uren)
        {
            case 0 : uur = "twaalf";break;
            case 1 : uur = "een" ;	break;
            case 2 : uur = "twee";	break;
            case 3 : uur = "drie";	break;
            case 4 : uur = "vier";	break;
            case 5 : uur = "vijf";	break;
            case 6 : uur = "zes" ;	break;
            case 7 : uur = "zeven";	break;
            case 8 : uur = "acht";	break;
            case 9 : uur = "negen";	break;
            case 10 : uur = "tien";	break;
            case 11 : uur = "elf";	break;
            case 12 : uur = "twaalf";break;
            case 13 : uur = "een"; break;
            case 14 : uur = "twee"; break;
            case 15 : uur = "drie"; break;
            case 16 : uur = "vier"; break;
            case 17 : uur = "vijf"; break;
            case 18 : uur = "zes"; break;
            case 19 : uur = "zeven"; break;
            case 20 : uur = "acht"; break;
            case 21 : uur = "negen"; break;
            case 22 : uur = "tien"; break;
            case 23 : uur = "elf" ; break;
            default : uur = "ongeldige invoer"; break;
        }
    }

    public void minConv()
    {
        String s = tf2.getText();
        mins = Integer.parseInt(s);

        if (mins <= 7 )
        {
            uitz2 = true;
            min = "uur" ;
        }

        if (mins >= 8 && mins <= 22)
        {
            min = " kwart over";
        }

        if (mins >=23 && mins <= 37)
        {
            uitz1 = true;
            min = "half";
        }

        if (mins >= 38 && mins <= 52)
        {
            uitz1 = true;
            min = "kwart voor";
        }

        if (mins >= 53)
        {
            uitz1 = true;
            uitz2 = true;
            min = "uur";
        }
    }

    public boolean pm()
    {
        if(uren >= 12)
        {
            pm = true;
        }
        return pm;
    }

    public String drukTijdAf()
    {
        String hulp = "";
        if (pm == true)
        {
            hulp = " p.m.";
        }
        else
        {
            hulp = " a.m.";
        }

        String s = "De tijd is : ";

        if(min.equals("ongeldige invoer") || uur.equals("ongeldige invoer"))
        {
            s = s + "ongeldige invoer";
            return s;
        }

        else if(uitz2 == true)
        {
            s = s + uur + " " + min + hulp ;
            return s;
        }

        else
        {
            s = s + min + " " + uur + hulp ;
            return s;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        uren = 0;
        mins = 0;
        uitz1 = false;
        uitz2 = false;
        pm = false;

        check();
        if (check() == true)
        {
            minConv();
            urenConv();
            lab3.setText(drukTijdAf());
        }
    }

    public static void main(String[] arg)
    {
        MyFrame mf = new MyFrame();
    }
}
