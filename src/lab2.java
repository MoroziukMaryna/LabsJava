//c3: StringBuilder; c17: В кожному реч. заданого тексту змінити місцями 1 та ост. слово, не змін. довжини речення.
public class lab2 { //оголошую клас lab2
    public static void main(String[] args) { //цей рядок визначає метод main
        String text = "Вчора я вийшов на прогулянку і побачив чудовий захід сонця."; //створюю змінну text
        String modifiedText = swapFirstAndLastWord(text); //функція що змінює місцями перше та останнє слово місцями
        //зберігає змінений text як modifiedText
        System.out.println(modifiedText); //виводжу змінений текст
    }
    public static String swapFirstAndLastWord(String text) { //оголошую функції swapFirstAndLastWord з параметром text
        StringBuilder stringBuilder = new StringBuilder(text); //створюю об'єкту StringBuilder зі вхідним текстом
        //індекси початку та кінця речення
        int sentenceStartIndex = 0;
        int sentenceEndIndex = 0;

        for (int i = 0; i < stringBuilder.length(); i++) { //ітерація по символам в рядку
            if (stringBuilder.charAt(i) == '.' || stringBuilder.charAt(i) == '?' || stringBuilder.charAt(i) == '!') {
                sentenceEndIndex = i; //запам'ятовую індекс кінця речення

                // Знаходимо перше та останнє слово в реченні
                String sentence = stringBuilder.substring(sentenceStartIndex, sentenceEndIndex); // Виділення речення зі строки
                String[] words = sentence.split("\\s+"); //розбиваю речення на слова за пробілом
                if (words.length >= 2) { //перевіряю, щоб в реченні було хоча б два слова
                    String firstWord = words[0]; //перше слово в реченні
                    String lastWord = words[words.length - 1]; //останнє слово в реченні

                    //заміна місцями першого та останнього слова
                    stringBuilder.replace(sentenceStartIndex, sentenceStartIndex + firstWord.length(), lastWord);
                    stringBuilder.replace(sentenceEndIndex - lastWord.length(), sentenceEndIndex, firstWord);
                }

                // Оновлюємо позиції початку та кінця речення
                sentenceStartIndex = i + 1;
            }
        }

        return stringBuilder.toString(); //повернення зміненого тексту у вигляді рядка
    }
}
