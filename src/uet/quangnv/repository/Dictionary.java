package uet.quangnv.repository;

import uet.quangnv.model.Word;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private static List<Word> dictionary = new ArrayList<Word>();

    private Dictionary() {

    }

    public static String findWordByWordTarget(String word_target) {
        for (Word word : dictionary) {
            if (word_target.equals(word.getWord_target())) {
                return word.getWord_explain();
            }
        }
        return null;
    }

    public static List<Word> findWordByRegex(String regex) {
        List<Word> list = new ArrayList<Word>();
        for (Word word : dictionary) {
            if (word.getWord_target().contains(regex)) {
                list.add(word);
            }
        }
        return list;

    }

    public static List<Word> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List<Word> dictionary) {
        Dictionary.dictionary = dictionary;
    }

    public static void addWord(Word word) {
        dictionary.add(word);
    }
}
