import java.util.ArrayList;
import java.util.List;

public class lab4 {
    public static void main(String[] args) {
        String text = "Вчора я вийшов на прогулянку і побачив чудовий захід сонця."; //початковий текст

        Text initialText = parseText(text);  //розбивання тексту на компоненти

        Text modifiedText = swapFirstAndLastWord(initialText); //замінюю перше та останнє слово в кожному реченні
        System.out.println("Замінений текст: " + modifiedText); //виводжу замінений текст
    }

    public static Text parseText(String text) {
        TextParser parser = new TextParser();
        return parser.parse(text);
    }

    public static Text swapFirstAndLastWord(Text text) {
        Text modifiedText = new Text();
        List<Sentence> modifiedSentences = new ArrayList<>();

        for (Sentence sentence : text.getSentences()) { //проходжуся по кожному реченню
            List<Word> words = sentence.getWords();
            if (words.size() >= 2) {
                Word firstWord = words.get(0);  //знаходжу перше слово
                Word lastWord = words.get(words.size() - 1); //знаходжу останнє слово

                //міняю їх місцями
                words.set(0, lastWord);
                words.set(words.size() - 1, firstWord);
            }
            modifiedSentences.add(sentence);
        }

        modifiedText.setSentences(modifiedSentences);
        return modifiedText;
    }
}

class TextParser {
    public Text parse(String text) {
        Text parsedText = new Text();
        List<Sentence> sentences = new ArrayList<>();

        String[] sentenceStrings = text.split("[.]"); //розбиваю текст на речення
        for (String sentenceString : sentenceStrings) {
            List<Word> words = parseWords(sentenceString.trim()); //розбиваю речення на слова
            List<Symbol> symbols = parseSymbols(sentenceString.trim()); //розбиваю речення на символи

            Sentence sentence = new Sentence(words, symbols); //створюю об'єкт речення зі словами та символами
            sentences.add(sentence);
        }

        parsedText.setSentences(sentences);
        return parsedText;
    }

    private List<Word> parseWords(String sentence) {
        List<Word> words = new ArrayList<>();
        String[] wordStrings = sentence.split("\\s+"); //розбиваю рядок на слова за допомогою пробілів
        for (String wordString : wordStrings) {
            List<Letter> letters = parseLetters(wordString); //розбиваю слово на літери
            Word word = new Word(letters); //створюю об'єкт Word зі списком літер
            words.add(word); //додаю слово до списку слів
        }
        return words;
    }

    private List<Letter> parseLetters(String word) {
        List<Letter> letters = new ArrayList<>();
        for (char c : word.toCharArray()) { //створюю об'єкт Letter з поточним символом
            Letter letter = new Letter(c); //створюю об'єкт літери
            letters.add(letter);//додаю список літер
        }
        return letters;
    }

    private List<Symbol> parseSymbols(String sentence) {
        List<Symbol> symbols = new ArrayList<>();
        String[] symbolStrings = sentence.split(" "); //розбиваю символи за допомогою пробілів
        for (String symbolString : symbolStrings) {
            Symbol symbol = new Symbol(symbolString); //створюю об'єкт символу
            symbols.add(symbol); //додаю символ до списку символів
        }
        return symbols;
    }
}

class Text {
    private List<Sentence> sentences; //приватне поле, що зберігає список речень тексту

    public List<Sentence> getSentences() {
        return sentences; //повертаю список речень тексту
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences; //встановлюю список речень тексту
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(); //створюю об'єкт StringBuilder для побудови рядка
        for (Sentence sentence : sentences) {
            builder.append(sentence.toString()).append(" "); //додаю рядок кожного речення до StringBuilder
        }
        return builder.toString().trim(); //повертаю отриманий рядок, прибираючи зайві пробіли в кінці
    }
}


class Sentence {
    private List<Word> words; //приватне поле, що зберігає список слів у реченні
    private List<Symbol> symbols; //приватне поле, що зберігає список символів у реченні

    public Sentence(List<Word> words, List<Symbol> symbols) {
        this.words = words; //встановлюю список слів у реченні
        this.symbols = symbols; //встановлюю список символів у реченні
    }

    public List<Word> getWords() {
        return words; //повертаю список слів у реченні
    }

    public List<Symbol> getSymbols() {
        return symbols; //повертаю список символів у реченні
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(); //створюю об'єкт StringBuilder для побудови рядка
        for (Word word : words) {
            builder.append(word.toString()); //додаю рядок кожного слова до StringBuilder
            builder.append(" "); //додаю пробіл між словами
        }
        for (Symbol symbol : symbols) {
            builder.append(symbol.toString()); //додаю рядок кожного символу до StringBuilder
            builder.append(" "); //додаю пробіл між символами
        }
        return builder.toString().trim(); //повертаю отриманий рядок, прибираючи зайві пробіли в кінці
    }
}

class Word {
    private List<Letter> letters; //приватне поле, що зберігає список літер у слові

    public Word(List<Letter> letters) {
        this.letters = letters; //встановлюю список літер у слові
    }

    public List<Letter> getLetters() {
        return letters; //повертаю список літер у слові
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(); //створюю об'єкт StringBuilder для побудови рядка
        for (Letter letter : letters) {
            builder.append(letter.toString()); //додаю рядок кожної літери до StringBuilder
        }
        return builder.toString(); //повертаю отриманий рядок
    }
}


class Letter {
    private char value; //приватне поле, що зберігає значення літери

    public Letter(char value) {
        this.value = value; //встановлюю значення літери
    }

    public char getValue() {
        return value; //повертаю значення літери
    }

    public String toString() {
        return String.valueOf(value); //перетворюю літеру на рядок і повертає його
    }
}

class Symbol {
    private String value; //приватне поле, що зберігає значення символу

    public Symbol(String value) {
        this.value = value; //встановлюю значення символу
    }

    public String getValue() {
        return value; //повертаю значення символу
    }

    public String toString() {
        return value; //повертаю значення символу у вигляді рядка
    }
}
