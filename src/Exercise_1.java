public class Exerc_1 {
    private JFrame frame;
    private JTextField massField;
    private JTextField velocityField;
    private JTextField energyField;
    private JButton calculateButton;

    public h1() {
        frame = new JFrame("Розрахунок кінетичної енергії тіла");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel massLabel = new JLabel("Маса (m):");
        massField = new JTextField();
        JLabel velocityLabel = new JLabel("Швидкість (v):");
        velocityField = new JTextField();
        JLabel energyLabel = new JLabel("Кінетична енергія:");
        energyField = new JTextField();
        calculateButton = new JButton("Обчислити");

        panel.add(massLabel);
        panel.add(massField);
        panel.add(velocityLabel);
        panel.add(velocityField);
        panel.add(energyLabel);
        panel.add(energyField);
        panel.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private void calculate() {
        try {
            String massText = massField.getText();
            String velocityText = velocityField.getText();
            String energyText = energyField.getText();

            if (!massText.isEmpty() && !velocityText.isEmpty() && energyText.isEmpty()) {
                double mass = Double.parseDouble(massText);
                double velocity = Double.parseDouble(velocityText);

                double kineticEnergy = 0.5 * mass * Math.pow(velocity, 2);

                energyField.setText(String.valueOf(kineticEnergy));
            } else if (!massText.isEmpty() && velocityText.isEmpty() && !energyText.isEmpty()) {
                double mass = Double.parseDouble(massText);
                double energy = Double.parseDouble(energyText);

                double velocity = Math.sqrt(2 * energy / mass);

                velocityField.setText(String.valueOf(velocity));
            } else if (massText.isEmpty() && !velocityText.isEmpty() && !energyText.isEmpty()) {
                double velocity = Double.parseDouble(velocityText);
                double energy = Double.parseDouble(energyText);

                double mass = 2 * energy / Math.pow(velocity, 2);

                massField.setText(String.valueOf(mass));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Помилка: некоректні дані", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new h1();
            }
        });
    }
}
