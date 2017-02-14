package view;

import model.TimeConverter;
import model.TimeValidator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimeConverterFrame extends JFrame implements ActionListener
{
    private JLabel converterOutput;
    private JTextField hoursField, minutesField;

    private TimeConverterFrame() {
        setLayout(new BorderLayout());

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());
        north.setPreferredSize(new Dimension(350,30));
        JLabel description = new JLabel("Tijd in uren : minuten ");
        north.add(description);
        hoursField = new JTextField(2);
        north.add(hoursField);
        JLabel colon = new JLabel(":");
        north.add(colon);
        minutesField = new JTextField(2);
        north.add(minutesField);
        add(north, BorderLayout.NORTH);

        converterOutput = new JLabel("Voer tijd in...");
        converterOutput.setHorizontalAlignment(JLabel.CENTER);
        add(converterOutput, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(100,30));
        JButton convertButton = new JButton("Verwerk");
        south.add(convertButton);
        convertButton.addActionListener(this);
        add(south, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setOutputLabel(String data) {
        converterOutput.setText(data);
    }

    private int parse(String input) {
        return Integer.parseInt(input);
    }

    public void actionPerformed(ActionEvent e) {
        int amountOfHours = parse(hoursField.getText());
        int amountOfMinutes = parse(minutesField.getText());
        TimeValidator validator = new TimeValidator(amountOfHours, amountOfMinutes);

        if (validator.runValidations()) {
            TimeConverter converter = new TimeConverter(amountOfHours, amountOfMinutes);
            String output = converter.convertTimeToString();
            setOutputLabel(output);
        } else {
            setOutputLabel("Ongeldige input");
        }
    }

    public static void main(String[] arg)
    {
        TimeConverterFrame mf = new TimeConverterFrame();
    }
}
