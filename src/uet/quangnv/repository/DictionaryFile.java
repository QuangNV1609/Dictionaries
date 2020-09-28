package uet.quangnv.repository;

import uet.quangnv.model.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryFile {

    private static String filePath = new File("src/uet/quangnv/repository/dictionaries.txt").getAbsolutePath();

    public static void writeWordToFile(List<Word> listWord) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Word word : listWord) {
                bufferedWriter.write(word.getWord_target() + "\t" + word.getWord_explain() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Xuất dữ liệu vào file thất bại!");
        }
        System.out.println("Xuất dữ liệu vào file thành công!");
    }

    public static List<Word> getWordFromFile() {
        List<Word> listWord = new ArrayList<Word>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String word[] = line.split("\t");
                listWord.add(new Word(word[0], word[1]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return listWord;
    }
}
