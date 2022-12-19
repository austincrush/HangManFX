package com.example.hangmanfx;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HangManController {

    private String[] words = {
            "abruptly", "absurd", "abyss", "affix", "askew", "avenue", "awkward", "azure",
            "bagpipes", "bandwagon", "banjo", "bayou", "beekeeper", "bikini", "blitz", "blizzard", "boggle", "bookworm", "boxcar", "boxful", "buckaroo", "buffalo", "buffoon", "buxom", "buzzard", "buzzing", "buzzword",
            "caliph", "cobweb", "cockiness", "croquet", "crypt", "cycle",
            "daiquiri", "disavow", "dizzying", "duplex", "dwarves",
            "embezzle", "equip", "espionage", "exodus",
            "faking", "fishhook", "fixable", "flapjack", "flopping", "fluffiness", "flyby", "frazzled", "frizzled", "fuchsia", "funny",
            "gabby", "galaxy", "galvanize", "gazebo", "gizmo", "glowworm", "gnarly", "gnostic", "gossip", "grogginess",
            "haiku", "haphazard", "hyphen",
            "inside", "icebox", "injury", "ivory", "ivy",
            "jackpot", "jawbreaker", "jaywalk", "jazziest", "jazzy", "jelly", "jigsaw", "jinx", "jiujitsu", "jockey", "jogging", "joking", "jovial", "joyful", "juicy", "jukebox", "jumbo",
            "kayak", "kazoo", "keyhole", "khaki", "kilobyte", "kiosk", "kiwi", "klutz", "knapsack",
            "lazy", "lengths", "lucky", "luxury", "lymph",
            "marquis", "matrix", "megahertz", "microwave", "mnemonic", "mystify",
            "nightclub", "nowadays", "numskull", "nymph",
            "onyx", "ovary", "oxidize", "oxygen",
            "pajama", "peekaboo", "pixel", "pizazz", "pneumonia", "polka", "pshaw", "psyche", "puppy", "puzzling",
            "quartz", "queue", "quips", "quixotic", "quiz", "quizzes", "quorum",
            "razzmatazz", "rhubarb", "rhythm", "rickshaw",
            "schnapps", "scratch", "shiv", "snazzy", "sphinx", "spritz", "squawk", "staff", "strength", "strengths", "stretch", "stronghold", "subway", "swivel", "syndrome",
            "thriftless", "thumbscrew", "topaz", "transcript", "transgress", "transplant", "twelve",
            "unknown", "unworthy", "unzip", "uptown",
            "vaporize", "vixen", "vodka", "voodoo", "vortex",
            "walkway", "waltz", "wave", "wavy", "waxy", "wellspring", "wheezy", "whiskey", "whizzing", "whomever", "wimpy", "witchcraft", "wizard", "woozy", "wristwatch",
            "xylophone",
            "yachtsman", "yippee", "yoked", "youthful", "yummy",
            "zephyr", "zigzag", "zilch", "zipper", "zodiac", "zombie"
    };

    public TextField guessInput;
    public Button guessButton;
    public Button playAgainButton;
    public Text outputText;
    public Text outputWord;
    public Text outputWin;
    public Text outputWrongLetters;

    public String wrongLetters = "Wrong Guesses: ";

    private String word = words[(int) (Math.random() * words.length)];
    private String dashes = new String(new char[word.length()]).replace("\0", "_");
    private int guessCount = 0;

    public void updateWord() {

        playAgainButton.setVisible(false);

        String guess = guessInput.getText();
        String newDash = "";

        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == guess.charAt(0)){
                newDash += guess.charAt(0);
            } else if(dashes.charAt(i) != '_'){
                newDash += word.charAt(i);
            } else{
                newDash += "_";
            }
        }

        if(dashes.equals(newDash)){
            guessCount++;
            hangmanImage();
            wrongLetters += guess + " ";
        } else {
            dashes = newDash;
        }
        if(dashes.equals(word)){
            outputWin.setText("YOU WIN! The word was : " + word.toUpperCase());
            guessButton.setDisable(true);
            guessInput.setDisable(true);
            playAgainButton.setVisible(true);
            outputText.setText(" ");
        }

        if(guessCount == 7){
            guessButton.setDisable(true);
            guessInput.setDisable(true);
            playAgainButton.setVisible(true);
        }

        outputWord.setText(dashes);
        outputWrongLetters.setText(wrongLetters);
        guessInput.clear();
    }

    public void playAgain(){
        word = words[(int) (Math.random() * words.length)];
        dashes = new String(new char[word.length()]).replace("\0", "_");
        guessCount = 0;
        wrongLetters = "Wrong Guesses: ";
        outputWin.setText(" ");

        guessButton.setDisable(false);
        guessInput.setDisable(false);

        outputWord.setText(dashes);
        outputWrongLetters.setText(wrongLetters);

        hangmanImage();

        playAgainButton.setVisible(false);
    }

    public void hangmanImage() {
        if(guessCount == 0){
            outputText.setText(" ");
        }
        if (guessCount == 1) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            " " + "\n" +
                            " " + "\n" +
                            " " + "\n" +
                            " " + "\n" +
                            " " + "\n" +
                            "___|___" + "\n"
            );
        }
        if (guessCount == 2) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            "     _" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "___|___" + "\n"
            );
        }
        if (guessCount == 3) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            "     __________" + "\n" +
                            "      |                _|_" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "___|___" + "\n"
            );
        }
        if (guessCount == 4) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            "     __________" + "\n" +
                            "      |                _|_" + "\n" +
                            "      |                 ( )" + "\n" +
                            "      |" + "\n" +
                            "      |" + "\n" +
                            "___|___" + "\n"
            );
        }
        if (guessCount == 5) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            "     __________" + "\n" +
                            "      |                _|_" + "\n" +
                            "      |                 ( )" + "\n" +
                            "      |                  |" + "\n" +
                            "      |                  |" + "\n" +
                            "___|___" + "\n"
            );
        }
        if (guessCount == 6) {
            outputText.setText(
                    "Wrong guess, try again" + "\n" +
                            "     __________" + "\n" +
                            "      |                _|_" + "\n" +
                            "      |                 ( )" + "\n" +
                            "      |                  |" + "\n" +
                            "      |                  |" + "\n" +
                            "___|___          /  \\" + "\n"
            );
        }
        if (guessCount == 7) {
            outputText.setText(
                    "GAME OVER" + "\n" +
                            "     __________" + "\n" +
                            "      |                _|_" + "\n" +
                            "      |                 ( )" + "\n" +
                            "      |               --|--" + "\n" +
                            "      |                  |" + "\n" +
                            "___|___          /  \\" + "\n" +
                            "GAME OVER! The word was : " + word
            );
        }
    }
}
