import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
public class Board extends JFrame{

    // initialize parameters.

    private List<Cards> cards;
    private Cards selectedCard;
    private Cards c1;
    private Cards c2;
    private Timer t;

    public Board(){

        // Create a BigRootPane with border layout.
        // We will put cards and info button inside it.
        Container big = getRootPane();
        big.setLayout(new BorderLayout());
        big.setBackground(Color.white);

        // Define title.
        setTitle("Game : Memory Matching");


        int pairs = 10;
        List<Cards> cardsList = new ArrayList<Cards>();
        List<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
        Collections.shuffle(cardVals);

        for (int val : cardVals){
            Cards c = new Cards();
            c.setCardNo(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        //set up the timer
        t = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (Cards c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");


        Cards infoButton = new Cards();

        // Merge to structure into Rootpane.
        big.add(pane, BorderLayout.CENTER);
        big.add(infoButton, BorderLayout.SOUTH);


    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getCardNo()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getCardNo()));
            t.start();

        }
    }

    public void checkCards(){
        if (c1.getCardNo() == c2.getCardNo()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setCardMatchedInfo(true); //flags the button as having been matched
            c2.setCardMatchedInfo(true);
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

        else{
            c1.setText(""); //'hides' text
            c2.setText("");
        }
        c1 = null; //reset c1 and c2
        c2 = null;
    }

    public boolean isGameWon(){
        for(Cards c: this.cards){
            if (c.getCardMatchedInfo() == false){
                return false;
            }
        }
        return true;
    }

}