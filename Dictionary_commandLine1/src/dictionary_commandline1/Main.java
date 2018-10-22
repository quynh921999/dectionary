/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_commandline1;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    
    public static void main(String[] args){
        DictionaryCommandline DCl = new DictionaryCommandline();
        //DictionaryCommandLine_1 DCL = new DictionaryCommandLine_1();
        //DCL.dictionaryBasic();
        //DCl.dictionaryAdvanced();
        Scanner input = new Scanner(System.in);
        DictionaryManagement manager = new DictionaryManagement();
        Dictionary dictionary = new Dictionary();
        manager.insertFromFile(dictionary.words);
       DCl.showAllWords(dictionary.words);
        System.out.println("Nhan phim 1 de them tu vao tu dien");
        System.out.println("Nhan phim 2 de xoa tu trong tu dien");
        System.out.println("Nhan phim 3 de sua tu trong tu dien");
        System.out.println("Nhan phim 4 de tim tu trong tu dien");
        System.out.println("Nhan phim 5 de tim tu tuong doi trong tu dien");
        System.out.print("Moi nhap: ");
        int command = input.nextInt();
        switch (command) {
            case 1: 
                manager.dictionaryAdd(dictionary.words);
                DCl.showAllWords(dictionary.words);
                break;
            case 2:
                manager.dictionaryDelete(dictionary.words);
                DCl.showAllWords(dictionary.words);
                break;
            case 3:
                input.nextLine();
                System.out.print("Nhap tu can sua( nghia cach tu 1 tab): ");
                String content = input.nextLine();
                String[] temp = content.split("\\t");
                Word wordIsUpdate = new Word(temp[0], temp[1]);
                manager.dictionaryUpdate(dictionary.words, wordIsUpdate);
                DCl.showAllWords(dictionary.words);
                break;
            case 4:
                manager.dictionaryLookUp(dictionary.words);
                break;
            case 5:
                manager.dictinarySearch(dictionary.words);
                break;
            default:
                System.out.println("Ban nhap sai!!!");     
        }
        manager.dictionaryExportToFile(dictionary.words);
        
    }
}