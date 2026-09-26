import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BirthdayInvitation extends JFrame {


private JTextField nameField;
private JTextField dobField;

public BirthdayInvitation() {
    setTitle("Birthday Invitation");
    setSize(620, 620);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.setBackground(new Color(248, 246, 255));
    mainPanel.setBorder(new EmptyBorder(30, 45, 35, 45));

    JLabel cake = new JLabel("🎂", SwingConstants.CENTER);
    cake.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 58));

    JLabel title = new JLabel("Birthday Invitation", SwingConstants.CENTER);
    title.setFont(new Font("SansSerif", Font.BOLD, 34));
    title.setForeground(new Color(76, 55, 130));

    JLabel subtitle = new JLabel(
            "<html><center>Enter the details to create a special<br>birthday greeting!</center></html>",
            SwingConstants.CENTER
    );
    subtitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
    subtitle.setForeground(new Color(55, 65, 110));

    JPanel heading = new JPanel();
    heading.setOpaque(false);
    heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));

    cake.setAlignmentX(Component.CENTER_ALIGNMENT);
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

    heading.add(cake);
    heading.add(Box.createVerticalStrut(5));
    heading.add(title);
    heading.add(Box.createVerticalStrut(12));
    heading.add(subtitle);

    JPanel form = new JPanel(new GridBagLayout());
    form.setOpaque(false);

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(18, 5, 8, 5);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
    nameLabel.setForeground(new Color(25, 35, 75));

    JLabel dobLabel = new JLabel("Date of Birth:");
    dobLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
    dobLabel.setForeground(new Color(25, 35, 75));

    nameField = createTextField();
    dobField = createTextField();
    dobField.setToolTipText("Enter date as dd/MM/yyyy");

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 0;
    form.add(nameLabel, gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    form.add(nameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 0;
    form.add(dobLabel, gbc);

    gbc.gridx = 1;
    gbc.weightx = 1;
    form.add(dobField, gbc);

    JLabel format = new JLabel("  (dd/MM/yyyy)");
    format.setFont(new Font("SansSerif", Font.PLAIN, 13));
    format.setForeground(new Color(100, 100, 120));

    gbc.gridx = 1;
    gbc.gridy = 2;
    form.add(format, gbc);

    JButton generateButton = new JButton("✨  Generate");
    generateButton.setFont(new Font("SansSerif", Font.BOLD, 18));
    generateButton.setForeground(Color.WHITE);
    generateButton.setBackground(new Color(137, 112, 220));
    generateButton.setFocusPainted(false);

    generateButton.setBorder(
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(95, 70, 170), 2
                    ),
                    new EmptyBorder(14, 50, 14, 50)
            )
    );

    generateButton.setOpaque(true);
    generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    generateButton.addActionListener(e -> generateInvitation());

    JPanel buttonPanel = new JPanel();
    buttonPanel.setOpaque(false);
    buttonPanel.add(generateButton);

    JPanel center = new JPanel(new BorderLayout());
    center.setOpaque(false);
    center.add(form, BorderLayout.CENTER);
    center.add(buttonPanel, BorderLayout.SOUTH);

    mainPanel.add(heading, BorderLayout.NORTH);
    mainPanel.add(center, BorderLayout.CENTER);

    setContentPane(mainPanel);
}

private JTextField createTextField() {
    JTextField field = new JTextField();

    field.setFont(new Font("SansSerif", Font.PLAIN, 18));
    field.setPreferredSize(new Dimension(350, 48));

    field.setBorder(
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(205, 200, 235), 2
                    ),
                    new EmptyBorder(5, 12, 5, 12)
            )
    );

    field.setBackground(Color.WHITE);

    return field;
}

private void generateInvitation() {

    String name = nameField.getText().trim();
    String dobText = dobField.getText().trim();

    if (name.isEmpty() || dobText.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter both name and date of birth.",
                "Missing Details",
                JOptionPane.WARNING_MESSAGE
        );

        return;
    }

    try {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate birthDate =
                LocalDate.parse(dobText, formatter);

        LocalDate today = LocalDate.now();

        if (birthDate.isAfter(today)) {
            throw new DateTimeParseException(
                    "Future date",
                    dobText,
                    0
            );
        }

        int age = Period.between(
                birthDate,
                today
        ).getYears();

        new BirthdayCard(name, age).setVisible(true);

    } catch (DateTimeParseException ex) {

        JOptionPane.showMessageDialog(
                this,
                "Please enter a valid date in dd/MM/yyyy format.",
                "Invalid Date",
                JOptionPane.ERROR_MESSAGE
        );
    }
}

public static String getOrdinal(int number) {

    if (number % 100 >= 11 &&
            number % 100 <= 13) {
        return number + "th";
    }

    switch (number % 10) {
        case 1:
            return number + "st";
        case 2:
            return number + "nd";
        case 3:
            return number + "rd";
        default:
            return number + "th";
    }
}

public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> {
        BirthdayInvitation app =
                new BirthdayInvitation();

        app.setVisible(true);
    });
}


}

class BirthdayCard extends JFrame {


public BirthdayCard(String name, int age) {

    setTitle("Birthday Invitation - " + name);
    setSize(760, 700);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);

    JPanel card = new JPanel();
    card.setBackground(new Color(255, 250, 245));
    card.setBorder(new EmptyBorder(25, 40, 30, 40));
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

    JLabel balloonsTop = label(
            "🎈   🎈   🎈   🎈   🎈",
            30,
            new Color(90, 65, 150)
    );

    JLabel happy = label(
            "HAPPY",
            38,
            new Color(76, 55, 130)
    );

    JLabel birthday = label(
            "BIRTHDAY",
            46,
            new Color(235, 92, 125)
    );

    JLabel person = label(
            name.toUpperCase() + "!",
            44,
            new Color(76, 55, 130)
    );

    JLabel cake = label(
            "🎂",
            85,
            Color.BLACK
    );

    JLabel wish1 = label(
            "Wishing you a very happy and",
            25,
            new Color(76, 55, 130)
    );

    JLabel wish2 = label(
            "wonderful " +
            BirthdayInvitation.getOrdinal(age) +
            " Birthday!",
            27,
            new Color(76, 55, 130)
    );

    JLabel decoration = label(
            "✨   💕   ⭐   🎉   ⭐   💕   ✨",
            25,
            new Color(235, 92, 125)
    );

    card.add(balloonsTop);
    card.add(Box.createVerticalStrut(20));
    card.add(happy);
    card.add(Box.createVerticalStrut(2));
    card.add(birthday);
    card.add(Box.createVerticalStrut(2));
    card.add(person);
    card.add(Box.createVerticalStrut(20));
    card.add(cake);
    card.add(Box.createVerticalStrut(15));
    card.add(wish1);
    card.add(Box.createVerticalStrut(5));
    card.add(wish2);
    card.add(Box.createVerticalStrut(25));
    card.add(decoration);
    card.add(Box.createVerticalStrut(20));

    JLabel balloonsBottom = label(
            "🎈              🎈",
            30,
            new Color(90, 65, 150)
    );

    card.add(balloonsBottom);

    setContentPane(card);
}

private JLabel label(
        String text,
        int size,
        Color color
) {

    JLabel label =
            new JLabel(text, SwingConstants.CENTER);

    label.setFont(
            new Font(
                    "SansSerif",
                    Font.BOLD,
                    size
            )
    );

    label.setForeground(color);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);

    return label;
}


}
