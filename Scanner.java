import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

enum TokenType {
    NUMBER, TERM, INVALID
}

class Token {
    TokenType type;
    String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type.toString().toLowerCase() + ": \"" + value + "\"";
    }
}

public class Scanner {
    private String input;
    private int position;
    private List<String> symbols = List.of("+", "-", "=");

    public Scanner(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        this.input = reader.readLine();
        this.position = 0;
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isSymbol(char ch) {
        return symbols.contains(String.valueOf(ch));
    }

    private char current() {
        if (position >= input.length()) return '\0';
        return input.charAt(position);
    }

    private char next() {
        if (position >= input.length()) return '\0';
        return input.charAt(position++);
    }

    private void skipWhitespace() {
        while (current() == ' ' || current() == '\n' || current() == '\t') {
            next();
        }
    }

    private boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public Token getToken() {
        skipWhitespace();
        char currentChar = current();

        if (currentChar == '\0') return null;

        if (isDigit(currentChar)) {
            StringBuilder value = new StringBuilder();
            while (isDigit(current())) {
                value.append(next());
            }
            
            if (isLetter(current())) {
                value.append(next());
                return new Token(TokenType.INVALID, value.toString());
            }
            return new Token(TokenType.NUMBER, value.toString());
        }

        if (isSymbol(currentChar)) {
            return new Token(TokenType.TERM, String.valueOf(next()));
        }

        return new Token(TokenType.INVALID, String.valueOf(next()));
    }


    public static void main(String[] args) {
        try {
            String filePath = args[0];
            Scanner scanner = new Scanner(filePath);
            Token token;
            while ((token = scanner.getToken()) != null) {
                System.out.println(token.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}