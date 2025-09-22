# Cryptography Algorithms in Java

This repository contains implementations of various cryptographic algorithms written in Java. Each algorithm is implemented as a separate `.java` file, showcasing its functionality and usage. Cryptography plays a vital role in securing sensitive information, and this project aims to provide educational implementations for understanding these algorithms.

## Algorithms Included

### 1. Caesar Cipher
- **Description**: A substitution cipher where each letter in the plaintext is shifted by a fixed number of positions in the alphabet.
- **Use Cases**: Basic encryption for text messages.
- **Features**:
  - Supports variable shift values.
  - Handles uppercase and lowercase letters.

### 2. Playfair Cipher
- **Description**: A digraph substitution cipher using a 5x5 matrix of letters to encrypt pairs of letters.
- **Use Cases**: Historical encryption of text.
- **Features**:
  - Generates the matrix based on a keyword.
  - Handles repeated letters and padding.

### 4. AES (Advanced Encryption Standard)
- **Description**: A symmetric encryption algorithm widely used for secure data transmission.
- **Use Cases**: Securing sensitive data like passwords, files, and communications.
- **Features**:
  - Supports key sizes of 128, 192, and 256 bits.
  - Implements CBC mode with padding.

### 5. DES (Data Encryption Standard)
- **Description**: An older symmetric encryption algorithm using a 56-bit key.
- **Use Cases**: Legacy systems requiring encryption.
- **Features**:
  - Demonstrates block cipher operations.
  - Includes key generation and encryption/decryption methods.

### 6. RSA (Rivest–Shamir–Adleman)
- **Description**: An asymmetric encryption algorithm based on prime factorization, used for secure key exchange.
- **Use Cases**: Digital signatures, secure communication, and public-key cryptography.
- **Features**:
  - Key generation (public/private keys).
  - Encryption and decryption methods.

### 7. Vigenère Cipher
- **Description**: A polyalphabetic substitution cipher using a keyword to encrypt text.
- **Use Cases**: Secure text messaging with stronger resistance to frequency analysis compared to Caesar Cipher.
- **Features**:
  - Handles variable-length keywords.
  - Supports both encryption and decryption.

### 8. SHA-512 (Secure Hash Algorithm)
- **Description**: A cryptographic hash function producing a fixed-length hash value (512 bits).
- **Use Cases**: Data integrity verification, password hashing.
- **Features**:
  - Generates unique hash values for input data.
  - Resistant to collision attacks.

### 9. MD5 (Message Digest Algorithm)
- **Description**: A cryptographic hash function producing a fixed-length hash value (128 bits).
- **Use Cases**: Legacy systems requiring checksum verification.
- **Features**:
  - Generates hash values quickly.
  - Demonstrates hashing operations but should not be used for secure applications due to vulnerabilities.

---

## Repository Structure

- CaesarCipher.java
- PlayfairCipher.java
- HillCipher.java
- AES_1.java
- AES_2.java
- DES_SBOX.java
- DES_initialFinal.java
- RSA.java
- vigenere_cipher.java
- SHA512.java
- MD5.java
- README.md


Each `.java` file contains the implementation of the respective algorithm along with comments explaining its functionality.

---

## How to Use

1. Clone the repository:

git clone https://github.com/aprajita0401/Cryptographic-Algorithms

2. Open the `.java` files in your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
3. Compile and run the files individually to test the algorithms.

---

## Notes

1. These implementations are intended for educational purposes and may not be optimized for production use.
2. Ensure that you have Java installed on your system before running the programs.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

By using a single `README.md` file, you provide users with a comprehensive overview of your project while keeping it organized and easy to navigate. If you have additional documentation or examples for each algorithm, you can include them as separate markdown files linked from the main `README.md` file.



