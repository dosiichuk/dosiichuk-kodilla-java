package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify(String poemToBeautify, PoemDecorator poemDecorator) {
        System.out.println("Beautified poem: " + poemDecorator.decorate(poemToBeautify));
    }
}
