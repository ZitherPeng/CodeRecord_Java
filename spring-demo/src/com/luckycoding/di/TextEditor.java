package com.luckycoding.di;

public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
        System.out.println("this is setter method ");
    }

    public TextEditor(SpellChecker sp, String foo) {
        System.out.println("this is TextEditor construction" + foo);
        this.spellChecker = sp;
    }


    public void spellCheck() {
        spellChecker.ckeckerSpelling();
    }

}
