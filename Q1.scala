def shiftChar(c: Char, shift: Int): Char = {
  if (!c.isLetter) c
  else {
    val alphabet =
      if (c.isUpper) ('A' to 'Z') else ('a' to 'z') // Creates a Sequence
    val index = alphabet.indexOf(c) // Checks the Position of c in that Sequence
    alphabet((index + shift + alphabet.length) % alphabet.length)
  }
}

def encrypt(plaintext: String, shift: Int): String = {
  plaintext.map(shiftChar(_, shift))
}

def decrypt(ciphertext: String, shift: Int): String = {
  ciphertext.map(shiftChar(_, -shift)) // We Shift Backwards
}

def cipher(
    text: String,
    shift: Int,
    operation: (String, Int) => String
): String = {
  operation(text, shift)
}

@main
def main(): Unit = {
  val plaintext = "Hello, World!"
  val shift = 3

  val encryptedText = cipher(plaintext, shift, encrypt)
  println(s"Encrypted Text : $encryptedText")

  val decryptedText = cipher(encryptedText, shift, decrypt)
  println(s"Decrypted Text : $decryptedText")
}
