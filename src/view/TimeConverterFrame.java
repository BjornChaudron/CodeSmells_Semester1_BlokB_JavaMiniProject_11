// Move refactoring: Na renaming, Move gebruikt om TimeConverterFrame in een nieuwe package (view) te plaatsen
package view;

import model.TimeConverter;
import model.TimeValidator;
import model.TimeValidatorBuilder;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class TimeConverterFrame implements ActionListener {
    // Replace Inheritance With Delegation
    private final JFrame jFrame = new JFrame();
    private JLabel converterOutput;
    private JTextField hoursField;
    private JTextField minutesField;
    // Extract Constant
    private static final String ERROR_MESSAGE = "Ongeldige input";

    private TimeConverterFrame() {
        // Replace Inheritance With Delegation
        jFrame.setLayout(new BorderLayout());

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
        // Replace Inheritance With Delegation
        jFrame.add(north, BorderLayout.NORTH);

        converterOutput = new JLabel("Voer tijd in...");
        converterOutput.setHorizontalAlignment(JLabel.CENTER);
        // Replace Inheritance With Delegation
        jFrame.add(converterOutput, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(100,30));
        JButton convertButton = new JButton("Verwerk");
        south.add(convertButton);
        convertButton.addActionListener(this);
        // Replace Inheritance With Delegation
        jFrame.add(south, BorderLayout.SOUTH);

        pack();
        // Replace Inheritance With Delegation
        jFrame.setVisible(true);
        // Replace Inheritance With Delegation
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Replace Constructor with Factory Method
    private static TimeConverterFrame createTimeConverterFrame() {
        return new TimeConverterFrame();
    }

    // Change Method Signature (Eerste commit: drukTijAf())
    private void setOutputLabel(String data) {
        converterOutput.setText(data);
    }

    // Make Method Static
    private static int parse(String input) {
        return Integer.parseInt(input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int amountOfHours = parse(hoursField.getText());
        int amountOfMinutes = parse(minutesField.getText());
        // Replace Constructor With Builder
        TimeValidator validator = new TimeValidatorBuilder().setAmountOfHours(amountOfHours).setAmountOfMinutes(amountOfMinutes).createTimeValidator();

        if (validator.runValidations()) {
            TimeConverter converter = new TimeConverter(amountOfHours, amountOfMinutes);

            // Inline
            setOutputLabel(converter.convertTimeToString());
        } else {
            // Extract Constant
            setOutputLabel(ERROR_MESSAGE);
        }
    }

    // Replace Constructor With Factory Method
    public static void main(String[] arg)
    {
         createTimeConverterFrame();
    }

    // Replace Inheritance With Delegation
    private void pack() {
        jFrame.pack();
    }
}
