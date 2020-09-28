package uet.quangnv.service;

import uet.quangnv.model.Word;
import uet.quangnv.repository.Dictionary;
import uet.quangnv.repository.DictionaryFile;

import java.util.List;

public class DictionaryManagement {

    public void insertFromCommandline(String word_target, String word_explain) {
        Word word = new Word(word_target, word_explain);
        Dictionary.addWord(word);
    }

    public void showAllWords(List<Word> list) {
        if (list == null) {
            list = Dictionary.getDictionary();
        }
        System.out.println("No\t|English\t|Vietnamese");
        int i = 1;
        for (Word word : list) {
            System.out.println(i + "\t|" + word.getWord_target() + "\t\t|" + word.getWord_explain());
            i++;
        }
    }

    public void insertFromFile() {
        for (Word word : DictionaryFile.getWordFromFile()) {
            Dictionary.getDictionary().add(word);
        }
    }

    public String dictionaryLookup(String word_target) {
        return Dictionary.findWordByWordTarget(word_target);
    }

    public List<Word> dictionarySearcher(String regex) {
        return Dictionary.findWordByRegex(regex);
    }

    public void dictionaryExportToFile() {
        DictionaryFile.writeWordToFile(Dictionary.getDictionary());
    }
}
