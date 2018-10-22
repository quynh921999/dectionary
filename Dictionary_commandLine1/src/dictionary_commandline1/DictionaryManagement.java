/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_commandline1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DictionaryManagement {
    private int amountWord;
    
    public int getAmountWord() {
        return amountWord;
    }
    public void setAmountWord(int amountWord) {
        this.amountWord = amountWord;
    }
    public DictionaryManagement(){}
    /*public void insertFromCommandline(ArrayList<Word> words){ // cai nay sai sai uhm 
        //Dictionary dictionary = new Dictionary();
        System.out.print("Nhap so luong tu vung: ");
        Scanner input = new Scanner(System.in);
        this.setAmountWord(input.nextInt());
        input.nextLine();
        for(int i = 0; i < this.getAmountWord(); i++){
            Word word = new Word();
            word.setSpelling(input.nextLine());
            //input.nextLine();
            word.setExplain(input.nextLine());
           // input.nextLine();
            words.add(word);
        }
    }*/
    public void insertFromFile(ArrayList<Word> words){
        String fullFilePath = "Dictionaries.txt";
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fullFilePath)); 
            while ((line = br.readLine()) != null){
                String[] temp = line.split("\\t");
                Word word = new Word();
                word.setSpelling(temp[0]);
                word.setExplain(temp[1]);
                words.add(word);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public int binarySearch(ArrayList<Word> words, String x){
        int lower = 0;
        int upper = words.size()-1;
       
        while(lower <= upper){
            int mid = (upper+lower)/2;
            if(words.get(mid).getSpelling().compareTo(x) < 0)
                lower = mid+1;
            else if(words.get(mid).getSpelling().compareTo(x) > 0)
                upper = mid -1;
            else 
                return mid;
        }
        return -1;
    }
    public void dictionaryLookUp(ArrayList<Word> words){
        Scanner input = new Scanner(System.in);
        System.out.print("nhap vao tu can tim: ");
        String wordSearch = input.nextLine();
        if(this.binarySearch(words, wordSearch) == -1)
            System.out.println("khong co tu can tim");
        else {
            int index = this.binarySearch(words, wordSearch);
            System.out.println("Nghia cua tu can tim la: " + words.get(index).getExplain());
        }
    }
    public void writeToFile(ArrayList<Word> words){
        Scanner input = new Scanner(System.in);
        String fullFilePath = "Dictionaries.txt";
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(fullFilePath, true);
            bw = new BufferedWriter(fw);
            System.out.print("Nhap tu can them: ");
            String content = input.nextLine();
            String[] temp = content.split("\t");
            if(this.binarySearch(words, temp[0]) == -1)
                bw.append(content +"\n");
            bw.close();
        } catch(IOException e) {
            
        }
    }
    public void dictinarySearch(ArrayList<Word> words){
        String wordSearch = "";
        System.out.print("Nhap tu can tra: ");
        Scanner input = new Scanner(System.in);
        wordSearch = input.nextLine();
        for(int i = 0; i < words.size(); i++){
            String temp = words.get(i).getSpelling().substring(0, wordSearch.length());
            if(temp.equalsIgnoreCase(wordSearch))
                System.out.println(words.get(i).getSpelling());
        }
    }
    public void dictionaryDelete(ArrayList<Word> words){
        String wordDelete = "";
        System.out.print("Nhap tu can xoa: ");
        Scanner input = new Scanner(System.in);
        wordDelete = input.nextLine();
        for(int i = 0; i < words.size();i++)
            if(words.get(i).getSpelling().equalsIgnoreCase(wordDelete))
                words.remove(i);
    }
    public void dictionaryAdd(ArrayList<Word> words){
        Word wordAdd = new Word();
        System.out.print("Nhap tu can them(nghia cach tu 1 dau tab): ");
        Scanner input = new Scanner(System.in);
        String add = input.nextLine();
        String[] temp = add.split("\\t");
        wordAdd.setSpelling(temp[0]);
        wordAdd.setExplain(temp[1]);
        if(temp[0].compareTo(words.get(0).getSpelling()) < 0){ 
            words.add(0, wordAdd);
            return;
        }
        if(temp[0].compareTo(words.get(words.size()- 1).getSpelling()) > 0){ 
            words.add(wordAdd);
            return;
        }
        for(int i = 0; i < words.size()- 1; i++) 
            if(temp[0].compareTo(words.get(i).getSpelling()) > 0 && temp[0].compareTo(words.get(i+1).getSpelling()) < 0){
                words.add(i + 1, wordAdd);
                return;
            }
    }
    public void dictionaryUpdate(ArrayList<Word> words, Word wordIsUpdate){
        Dictionary dictionary = new Dictionary();
        Scanner input = new Scanner(System.in);
        String stringWordUpdate = "";
        System.out.print("Nhap vao tu sua( tu cach nghia 1 dau tab): ");
        stringWordUpdate = input.nextLine();
        String[] temp = stringWordUpdate.split("\\t");
        for(int i = 0; i < words.size(); i++) {
            if(words.get(i).getSpelling().equalsIgnoreCase(wordIsUpdate.getSpelling()) && words.get(i).getExplain().equalsIgnoreCase(wordIsUpdate.getExplain())) {
                words.get(i).setExplain(temp[1]);
                words.get(i).setSpelling(temp[0]);
            }
                
        }
    }
    public void dictionaryExportToFile(ArrayList<Word> words) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Dictionaries.txt"));
            for(int i = 0; i < words.size(); i++) {
                writer.write(words.get(i).getSpelling() + "\t" + words.get(i).getExplain());
                writer.newLine();
            }
            writer.close();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}
