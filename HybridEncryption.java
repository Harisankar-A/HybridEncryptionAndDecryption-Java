import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HybridEncryption extends JFrame {
    private JTextField key1Input;
    private JTextField key2Input;
    private JTextField encryptInput;
    private JTextField decryptInput;

    public HybridEncryption() {
        setTitle("Hybrid Encryption");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 100);
        initUI();
    }

    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel key1Label = new JLabel("Enter Key 1:");
        key1Input = new JTextField(15);
        JLabel key2Label = new JLabel("Enter Key 2:");
        key2Input = new JTextField(15);
        JLabel encryptLabel = new JLabel("Enter Text to Encrypt:");
        encryptInput = new JTextField(15);
        JButton encryptButton = new JButton("Encrypt");
        JLabel decryptLabel = new JLabel("Enter Text to Decrypt:");
        decryptInput = new JTextField(15);
        JButton decryptButton = new JButton("Decrypt");

        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                encrypt();
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrypt();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(key1Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(key1Input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(key2Label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(key2Input, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(encryptLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(encryptInput, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(encryptButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(decryptLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(decryptInput, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        add(decryptButton, gbc);

        setVisible(true);
    }

    private void encrypt() {
        String key1 = key1Input.getText();
        String key2 = key2Input.getText();
        String plaintext = encryptInput.getText();
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int xored = plaintext.charAt(i) ^ Integer.parseInt(String.valueOf(key1.charAt(i % key1.length())));
            int lucas = lucas(Integer.parseInt(key2), i);
            int encryptedChar = (xored + lucas) % 256;
            ciphertext.append((char) encryptedChar);
        }

        JOptionPane.showMessageDialog(this, "Encrypted Text: " + ciphertext.toString());
    }

    private void decrypt() {
        String key1 = key1Input.getText();
        String key2 = key2Input.getText();
        String ciphertext = decryptInput.getText();
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            int lucas = lucas(Integer.parseInt(key2), i);
            int decryptedChar = (ciphertext.charAt(i) - lucas + 256) % 256;
            int xored = decryptedChar ^ Integer.parseInt(String.valueOf(key1.charAt(i % key1.length())));
            plaintext.append((char) xored);
        }

        JOptionPane.showMessageDialog(this, "Decrypted Text: " + plaintext.toString());
    }

    private int lucas(int n, int k) {
        if (k == 0) {
            return 2 % n;
        } else if (k == 1) {
            return 1 % n;
        } else {
            return (lucas(n, k - 1) + lucas(n, k - 2)) % n;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HybridEncryption();
            }
        });
    }
}

