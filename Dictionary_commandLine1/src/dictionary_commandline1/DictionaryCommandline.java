/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_commandline1;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DictionaryCommandline {
    DictionaryManagement manager = new DictionaryManagement(); 
    Dictionary dictionary = new Dictionary();
    public void showAllWords(ArrayList<Word> words){
        System.out.println("No" + "\t" + "|English" + "\t" + "|Vietnamese");
        for(int i = 0; i < words.size(); i++){
            System.out.println(i + "\t" + "|" + words.get(i).getSpelling() + "\t\t" + "|" + words.get(i).getExplain());
        }
    }
    public void dictionaryAdvanced(){
        
        //DictionaryCommandline DCl = new DictionaryCommandline(); 
        //manager.insertFromFile(dictionary.words);
        //showAllWords(dictionary.words);
        //manager.dictionaryLookUp(dictionary.words);
        //manager.dictinarySearch(dictionary.words);
        //manager.dictionaryDelete(dictionary.words);
        //manager.dictionaryAdd(dictionary.words);
        //Word oldWord = new Word("banana", "qua chuoi");
        //manager.dictionaryUpdate(dictionary.words,oldWord );
        //showAllWords(dictionary.words);
        //manager.dictionaryExportToFile(dictionary.words);
    }
}
