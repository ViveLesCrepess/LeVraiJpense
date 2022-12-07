package gui_swing_events;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import gui_swing_events.Excel;

public class Main extends JFrame {
    JLabel lblInstructions = new JLabel("Enter your numbers seperated by spaces:");
    JTextField txtNumbers = new JTextField(10);

    JRadioButton rdoSum = new JRadioButton("Sum");
    JRadioButton rdoAverage = new JRadioButton("Average");
    JRadioButton rdoMin = new JRadioButton("Minimum");
    JRadioButton rdoMax = new JRadioButton("Maximum");

    ButtonGroup grpOperation = new ButtonGroup();

    JButton btnCalculate = new JButton("Calculate");

    String selectedOperation;

    public static void main(String[] args) {
        JFrame frame = new Main();

        frame.setTitle("Wilhem");
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    Main() {
        JPanel panel = new JPanel();
        panel.add(lblInstructions);
        panel.add(txtNumbers);

        panel.add(rdoSum);
        panel.add(rdoAverage);
        panel.add(rdoMin);
        panel.add(rdoMax);

        // Add ItemListener
        rdoSum.addItemListener(this::itemListener);
        rdoAverage.addItemListener(this::itemListener);
        rdoMin.addItemListener(this::itemListener);
        rdoMax.addItemListener(this::itemListener);

        rdoSum.setSelected(true);
        selectedOperation = "sum";

        grpOperation.add(rdoSum);
        grpOperation.add(rdoAverage);
        grpOperation.add(rdoMin);
        grpOperation.add(rdoMax);

        panel.add(btnCalculate);

        add(panel);

        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtNumbers.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please input numbers.");
                    txtNumbers.requestFocus();
                    return;
                }
                String strNumbers = txtNumbers.getText();
                List<Integer> numbers = new ArrayList<>();

                String[] array = strNumbers.split(" ");

                for (int i = 0; i < array.length; i++) {
                    String number = array[i];
                    int intNumber = Integer.parseInt(number);
                    numbers.add(intNumber);
                }

                if (selectedOperation.equals("sum")) {
                    // Sum
                    int Sum = Excel.Sum(numbers);

                    JOptionPane.showMessageDialog(null, "The sum is " + Sum + ".");
                } else if (selectedOperation.equals("average")) {
                    // Average
                    float Average = Excel.Average(numbers);

                    JOptionPane.showMessageDialog(null, "The average is " + Average + ".");
                } else if (selectedOperation.equals("min")) {
                    // Minimum
                    int Min = Excel.Minimum(numbers);

                    JOptionPane.showMessageDialog(null, "The min is " + Min + ".");
                } else {
                    // Maximum
                    int Max = Excel.Maximum(numbers);

                    JOptionPane.showMessageDialog(null, "The max is " + Max + ".");
                }
            }
        });
    }

    private void itemListener(ItemEvent e) {
        if (e.getSource() == rdoSum) {
            selectedOperation = "sum";
        } else if (e.getSource() == rdoAverage) {
            selectedOperation = "average";
        } else if (e.getSource() == rdoMin) {
            selectedOperation = "min";
        } else {
            selectedOperation = "max";
        }
    }
}
