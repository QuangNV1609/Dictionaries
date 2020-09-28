package uet.quangnv.view;

import uet.quangnv.model.Word;
import uet.quangnv.service.DictionaryManagement;

import java.util.List;
import java.util.Scanner;

public class DictionaryCommandLine {

    private static DictionaryManagement management = new DictionaryManagement();

    private static Scanner scanner = new Scanner(System.in);

    public void dictionaryBasic() {
        int choice;
        do {
            System.out.println("1-Insert Form ComandLine");
            System.out.println("2-Show All");
            System.out.println("3-Advanced");
            System.out.println("0-Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String word_target = scanner.nextLine();
                    String word_explain = scanner.nextLine();
                    management.insertFromCommandline(word_target, word_explain);
                    break;
                case 2:
                    management.showAllWords(null);
                    break;
                case 3:
                    dictionaryAdvanced();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    public void dictionaryAdvanced() {
        int choice;
        do {
            System.out.println("1-LookUp");
            System.out.println("2-Insert form file");
            System.out.println("3-Export to file");
            System.out.println("4-Seacher");
            System.out.println("0-Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String word_target = scanner.nextLine();
                    System.out.println(management.dictionaryLookup(word_target));
                    break;
                case 2:
                    management.insertFromFile();
                    break;
                case 3:
                    management.dictionaryExportToFile();
                    break;
                case 4:
                    word_target = scanner.nextLine();
                    List<Word> list = management.dictionarySearcher(word_target);
                    management.showAllWords(list);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
