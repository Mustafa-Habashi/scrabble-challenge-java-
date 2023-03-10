import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Scrabble {

    HashMap< Character, Integer> scoreCard = new HashMap<Character,Integer>();
    private String word;
    private Character[] doubleLetter;
    private Character[] tripleLetter;
    private boolean doubleWord;
    private boolean tripleWord;
    private int totalScore;


   public Scrabble(String word) {
      this.word = word;
      this.totalScore = 0;
      scrabbleScoreCard();


   }

    public Scrabble(String word, Character[] doubleLetter, Character[] tripleLetter, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetter = doubleLetter;
        this.tripleLetter = tripleLetter;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.totalScore = 0;
        scrabbleScoreCard();
    }

    public int score(){
       scoreCardCal();
       doubleWordScore();
       tripleWordScore();
       tripleLetterCal();
       doubleLetterCal();
       return this.totalScore;
    }


    public void scoreCardCal(){

      if (this.word == null){
          this.word = "";
      }
      this.word = this.word.toUpperCase();
      char[] letterArray = this.word.toCharArray();
      for (Map.Entry<Character, Integer> entry : scoreCard.entrySet()) {
          for (Character letter : letterArray) {
                  if(letter == entry.getKey()){
                      this.totalScore += entry.getValue();
                  }
              }
          }


   }


   private void doubleWordScore(){
       if (this.doubleWord){
           this.totalScore *=2;
       }
   }

    private void tripleWordScore(){
        if (this.tripleWord){
            this.totalScore *=3;
        }
    }


    private void doubleLetterCal() {
        if (this.doubleLetter != null) {
            for (Character letter: this.doubleLetter) {
                this.totalScore += scoreCard.get(letter);
            }
        }
    }
    private void tripleLetterCal(){
        if(this.tripleLetter!=null){
            for(Character letter : this.tripleLetter){
                this.totalScore += scoreCard.get(letter)*2;
            }
        }
    }





    public void scrabbleScoreCard(){

       scoreCard.put('A', 1);
       scoreCard.put('E', 1);
       scoreCard.put('I', 1);
       scoreCard.put('O', 1);
       scoreCard.put('N', 1);
       scoreCard.put('R', 1);
       scoreCard.put('S', 1);
       scoreCard.put('T', 1);
       scoreCard.put('U', 1);
       scoreCard.put('L', 1);

//
       scoreCard.put('D', 2);
       scoreCard.put('G', 2);

       scoreCard.put('B', 3);
       scoreCard.put('C', 3);
       scoreCard.put('M', 3);
       scoreCard.put('P', 3);

       scoreCard.put('H', 4);
       scoreCard.put('F', 4);
       scoreCard.put('Y', 4);
       scoreCard.put('V', 4);
       scoreCard.put('W', 4);

       scoreCard.put('K', 5);

       scoreCard.put('J', 8);
       scoreCard.put('X', 8);

       scoreCard.put('Q', 10);
       scoreCard.put('Z', 10);
    }

}
