/*

        // Create a BigRootPane with borderlayout.
        // We will put cards and info button inside.
        Container big = getRootPane();
        big.setLayout(new BorderLayout());


        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(row, col));
        //pane.setBackground(Color.white);

        // Create another card object for infobutton.
        Cards infoButton = new Cards();


        // Merge to structure into Rootpane.
        big.add(pane, BorderLayout.CENTER);
        big.add(infoButton, BorderLayout.SOUTH);



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

        for (int tmpNo = 0 ;  tmpNo<valuesOfCards.size(); tmpNo++) {
            // Create Card object for each image.
            Cards mySelect = new Cards();
            mySelect.setCardNo(valuesOfCards.get(tmpNo));
            // Add all buttons into one list to process them in a board.
            listOfCards.add(mySelect);
        }


        this.Cards = listOfCards;

        for (Cards comp : Cards) {
            pane.add(comp);
            comp.setIcon(new ImageIcon(DEFAULT_IMAGE));
        }



 */