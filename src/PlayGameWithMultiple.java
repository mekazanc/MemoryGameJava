import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;
        import java.util.Set;

public class PlayGameWithMultiple extends JFrame {

    private int col;
    private int row;
    private int diffLevel;
    private String playerName;
    private Settings gameParams;
    private List<String> playersName;
    private Cards choseMyCard;
    private Cards card1 = null ;
    private Cards card2 = null;
    private Cards infoCard;
    private int[] gameScores;
    private int timeScore ;
    private boolean timeScoreStatus;
    private Timer cardTimeControl;
    private Timer gameTimeControl;
    private List<Cards> Cards;
    private boolean alreadyExecuted = false;
    private String DEFAULT_IMAGE = "/Users/mekazanc/Desktop/AugustJava/photos/logo3.png";



    public PlayGameWithMultiple(Settings gameParams) {

        this.col = gameParams.getcolId();
        this.row = gameParams.getrowId();
        this.diffLevel = gameParams.getDiffLevel();
        this.timeScore = gameParams.getTimeInfo();
        this.playersName = gameParams.getPlayersName();
        this.gameScores = new int[gameParams.getPlayersName().size()];
        this.timeScoreStatus = gameParams.getTimeInfo() != 0;



        // initialize card Number and List of Card Objects.
        this.Cards = initCards(row, col, gameParams);

        // Create a BigRootPane with borderlayout.
        // We will put cards and info button inside.
        Container big = getRootPane();
        big.setLayout(new BorderLayout());
        //big.setBackground(Color.white);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(row, col));
        //pane.setBackground(Color.white);

        // Create another card object for info button.
        Cards infoButton = new Cards();


        // Merge to structure into Rootpane.
        big.add(pane, BorderLayout.CENTER);
        big.add(infoButton, BorderLayout.SOUTH);


        this.infoCard = infoButton;
        infoCard.changeButtonParams( gameScores,  timeScore, playersName);



        for (Cards comp : Cards) {
            pane.add(comp);
            comp.setIcon(new ImageIcon(DEFAULT_IMAGE));
        }


    }


    private List<Cards> initCards(int row, int col, Settings gameParams) {

        // create list of Card objects.
        List<Cards> listOfCards = new ArrayList<Cards>();
        // create list of Card values.
        List<Integer> valuesOfCards = new ArrayList<Integer>();


        // Calculate total number of buttons for the game.
        int pairs = (row * col) / 2;
        String pairS = String.valueOf(pairs);
        System.out.println("Pair is : " + pairS);

        // Create two card lists as many as pairs.
        for (int j = 0; j < pairs; j++) {
            valuesOfCards.add(j);
            valuesOfCards.add(j);
        }

        System.out.println(valuesOfCards);

        // Mix card values randomly.
        Collections.shuffle(valuesOfCards);

        // retrieve type of the game. (Singe/Double)
        int playerSize = gameParams.getPlayersName().size();


        for (Integer valuesOfCard : valuesOfCards) {
            // Create Card object for each image.
            Cards mySelect = new Cards();
            mySelect.setCardNo(valuesOfCard);
            // Add action listener to change image of the card.
            mySelect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    // assign mySelect as chosen card and then call flipCards method.
                    choseMyCard = mySelect;
                    // Flip cards will be called after any of cards is pressed.
                    if (playerSize == 1) {
                        flipCardsSingle();
                    } else {
                        flipCardsMulti();
                    }

                }
            });
            // Add all buttons into one list to process them in a board.
            listOfCards.add(mySelect);
        }
        System.out.println(listOfCards.toString());

        return listOfCards;
    }




    public void showBoard(JFrame boardFrame) {

        JButton buttonPanel = new JButton();

        // Create a BigRootPane with border layout.
        // We will put cards and info button inside it.
        Container big = getRootPane();
        big.setLayout(new BorderLayout());
        big.setBackground(Color.white);

        // Define title.
        boardFrame.setTitle("Game : Memory Matching");
        //boardFrame.add(big);

        buttonPanel.setText("hellooo");
        boardFrame.add(buttonPanel);

        // Other Board remaining initializations.
        boardFrame.setPreferredSize(new Dimension(600, 600)); //need to use this instead of setSize
        boardFrame.setVisible(true);

    }


    public void initGameMultiple() {

    }

    public void timeCounter(Timer timeControl) {

        //set up the timer
        timeControl = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                controlCards();
            }
        });

        timeControl.setRepeats(false);
        timeControl.start();

    }


    public void flipCardsMulti() {


    }



    // This method fills card1 and card2 objects according to actions in the board.
    // Each button has action listeners so that choseMyCard object is filled.
    public void flipCardsSingle() {

        // This condition helps us to understand first card is selected.
        if (card1 == null && card2 == null) {

            // start timer of the game once.
            if(!alreadyExecuted) {
                trackTime();
                alreadyExecuted = true;
            }



            System.out.println("Card 1 is selected");
            // After card is chosen, image need to be showed.
            card1 = choseMyCard;
            // In this step, image was taken according to card no.
            String no = String.valueOf(card1.getCardNo());
            // Then, card-button displays image.
            card1.setImageVisible(no, "socialmedia");

        }

        // This case helps us to select second card.
        else if (card1 != null && card1 != choseMyCard && card2 == null) {

            // Assign selected card as my new card.
            card2 = choseMyCard;
            // Then, get card no of it.
            String no = String.valueOf(card2.getCardNo());
            // Finally, card object shows its image.
            card2.setImageVisible(no, "socialmedia");

            // start time to come back.
            timeCounter(gameTimeControl);

        }

    }


    public void controlCards() {

        if (card1.getCardNo() == card2.getCardNo()){//match condition
            card1.setEnabled(false); //disables the button
            card2.setEnabled(false);
            card1.setCardMatchedInfo(true); //flags the button as having been matched
            card2.setCardMatchedInfo(true);
            //gameScore++;
            gameScores[0] = gameScores[0] + 1;

            if (this.checkWinning()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

        else{
            // Then we need to change picture of our unselected cards.
            card1.setIcon(new ImageIcon(DEFAULT_IMAGE));
            card2.setIcon(new ImageIcon(DEFAULT_IMAGE));

        }
        card1 = null; //reset c1 and c2
        card2 = null;
    }

    public boolean checkWinning(){
        for(Cards c: this.Cards){
            if (!c.getCardMatchedInfo()){
                return false;
            }
        }

        stopTime();
        return true;
    }

    // This method counts time and change infoButton status (score-time info.)
    public void trackTime() {

        // Define timer with 1 second period.
        gameTimeControl = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //System.out.println("test timer has started");

                // Control timeCounter is true or false. If it is true, time will be decreased.
                // Otherwise, only infobutton will be updated.

                if (timeScoreStatus) {
                    timeScore--;
                    //infoCard.changeParameters(score, remTime, playerNameOne);
                    infoCard.changeButtonParams(gameScores, timeScore, playersName);

                }
            }


        });
        gameTimeControl.start();
    }

    // stop timer.
    public void stopTime() {

        gameTimeControl.stop();
    }

}




