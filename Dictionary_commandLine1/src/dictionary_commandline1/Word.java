/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_commandline1;

/**
 *
 * @author ADMIN
 */
public class Word {
    private String spelling;
    private String explain;

    public Word() {}
    public String getSpelling() {
        return this.spelling;
    }
    public void setSpelling(String s) {
	this.spelling = s;
    }
	
    public String getExplain() {
	return this.explain;
    }
    public void setExplain(String e) {
	this.explain = e;
    }
    public Word(String spelling, String explain){
        this.explain = explain;
        this.spelling = spelling;
    }
}
