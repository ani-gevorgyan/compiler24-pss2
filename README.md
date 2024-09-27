# EBNF for PSS2 Language

### Digit Definition:
```ebnf
digit = "0123456789".
```
- A **digit** is defined as any single numeral from 0 to 9.

### Number Definition:
```ebnf
number = digit { digit }.
```
- A **number** is defined as a sequence of one or more digits. The curly braces `{ digit }` denote that a number can consist of multiple digits.

---

### Lexemes:
The following are the lexemes (tokens) recognized by the language:

```
+
-
=
```
- **`+`**: Plus symbol (addition operator)
- **`-`**: Minus symbol (subtraction operator)
- **`=`**: Equals symbol (assignment or equality operator)

---

This defines the basic structure of the language, recognizing numbers (sequences of digits) and three operators: `+`, `-`, and `=`.

---

### Examples of Correct and Incorrect Code:

#### ✅ Correct Code:
```plaintext
4 + 67= 71
```
- **Explanation**: The code consists of numbers and valid lexemes (`+`, `=`), making it a valid expression.

---

#### ❌ Incorrect Code:
```plaintext
4d + 1`=;8
```
- **Errors**:
  - **`d`**: Invalid character (not a digit).
  - **Backtick (`\``)**: Invalid character.
  - **Semicolon (`;`)**: Not a recognized lexeme in this language.
  
---

This updated document explains the EBNF, lexemes, and includes examples of valid and invalid code, providing clarity on what is acceptable within the language’s syntax.

--- 

The examples now clearly demonstrate what correct and incorrect code looks like, helping users understand the rules of the language.
