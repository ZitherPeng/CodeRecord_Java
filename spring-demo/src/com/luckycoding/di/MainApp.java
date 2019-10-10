package com.luckycoding.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/luckycoding/di/Beans.xml");
        TextEditor editor = (TextEditor) applicationContext.getBean("textEditor");
        editor.setSpellChecker(spellChecker);
        editor.spellCheck();
    }
}
