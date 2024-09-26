# EBNF for Compiler24 Language

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
