# Hybrid Encryption

A GUI-based hybrid encryption and decryption application developed in Java using the Swing framework. The application implements a simple encryption algorithm combining XOR operations and Lucas numbers for enhanced data security.

## Features

- **Encrypt Text**: Securely encrypts input text using a combination of two keys and Lucas numbers.
- **Decrypt Text**: Decrypts the encrypted text to retrieve the original plaintext.
- **User-Friendly Interface**: Intuitive GUI for input and output of encryption and decryption operations.

## How It Works

1. **Keys**: The user provides two keys:
   - `Key 1`: Used in an XOR operation with the plaintext characters.
   - `Key 2`: Used to generate a Lucas number sequence for additional encryption.
2. **Lucas Numbers**: A sequence of numbers used for an added layer of complexity.
3. **Encryption**: Combines XOR and Lucas transformations on each character of the input text.
4. **Decryption**: Reverses the transformations to retrieve the original text.

## Technologies Used

- **Programming Language**: Java
- **GUI Framework**: Swing

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Harisankar-A/HybridEncryptionAndDecryption-Java
   
2. Navigate to the project directory:
   ```bash
   cd <repository-folder>

3. Compile the java file:
   ```bash
   javac HybridEncryption.java

4. Run the application:
   ```bash
   java HybridEncryption

## Usage

- Launch the application.
- Enter Key 1 and Key 2.
- Input the text to encrypt or decrypt.
- Click Encrypt or Decrypt to perform the respective operation.
- View the result in a dialog box.

## Screenshot

### Screenshot of the UI

![image](https://github.com/user-attachments/assets/7fd6a0ae-d3a0-4cbf-9180-84f06e041248)

### Screenshot of the Encryption Process

![image](https://github.com/user-attachments/assets/ee42ad96-67f2-4fc9-8ebd-49aa210de0b0)
![image](https://github.com/user-attachments/assets/11d096f8-d080-4578-97ce-64f23e7c5c30)


### Screenshot of the Decryption Process

![image](https://github.com/user-attachments/assets/408b13ff-dc41-4f41-8366-aec0cab7cc61)
![image](https://github.com/user-attachments/assets/d63650dc-896b-4364-9fa9-de33896c9d32)

## Limitations

- Supports only ASCII characters (values between 0 and 255).
- Lucas number sequence modulo operation is limited by `Key 2`.

