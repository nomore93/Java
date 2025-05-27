import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// PREZENTAČNÍ VRSTVA 
// SWING GUI

public class ContactApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        ContactDAO dao = new ContactDAO();
        ContactService service = new ContactService(dao);

        // Hlavní okno
        JFrame contactFrame = new JFrame("Formulář");
        contactFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contactFrame.setSize(1000, 700);

        // Mřížka
       /*  JPanel contactPanel = new JPanel(new GridLayout(6,4 , 10, 10));
        contactPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); */

        JPanel contactPanel = new JPanel(new GridBagLayout());
        contactPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        contactPanel.add(new JLabel("Jméno"));

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JTextField nameField = new JTextField(15);
        contactPanel.add(nameField,gbc);
        // Přidání jména
       /*  contactPanel.add(new JLabel("Jméno:"));
        JTextField nameField = new JTextField();
        contactPanel.add(nameField); */

        

        // Přidání příjmení
        JTextField surnameField = new JTextField("Příjmení:");
        contactPanel.add(surnameField);

        // Přidání věku
        JTextField ageField = new JTextField("Věk:");
        contactPanel.add(ageField);

        // ID 
        JTextField idField = new JTextField("ID");
        contactPanel.add(idField);

        // Vypsání seznamu
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        contactFrame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // Tlačítko pro přidání
        JButton addButton = new JButton("Přidat");
        contactPanel.add(addButton);

        // Tlačítko pro odebrání ze seznamu
        JButton remButton = new JButton("Odebrat");
        contactPanel.add(remButton);

        // Tlačítko pro zobrazení seznamu
        JButton listButton = new JButton("Zobrazit seznam");
        contactPanel.add(listButton);

        // Hide button
        JButton hButton = new JButton("");
        hButton.setVisible(false);
        contactPanel.add(hButton);

        // Plnoletý nebo nezletilý
        JRadioButton adultButton = new JRadioButton("Dospělý");
        JRadioButton underButton = new JRadioButton("Nezletilý");

        ButtonGroup ageGroup = new ButtonGroup();
        ageGroup.add(adultButton);
        ageGroup.add(underButton);

        contactPanel.add(adultButton);
        contactPanel.add(underButton);

        // Muž nebo žena
        JRadioButton maleButton = new JRadioButton("Muž");
        JRadioButton femaleButton = new JRadioButton("Žena");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        contactPanel.add(maleButton);
        contactPanel.add(femaleButton);

        // Přidání osoby do seznamu po stisku tlačítka přidat
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    int age = Integer.parseInt(ageField.getText());

                    service.addContact(name, surname, age);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contactFrame, "Věk musí být číslo");
                }
            }
        });

        // Zobrazení seznamu po stisku tlačítka zobrazit
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                    List<Contact> contacts = service.getAllContacts();
                    resultArea.setText("");
                    for (Contact x : contacts) {
                        resultArea.append(x.toString() + "\n");
                    }
                 
            }
        });

        // Dokončení UI
        contactFrame.add(contactPanel);
        contactFrame.setVisible(true);

    }
}