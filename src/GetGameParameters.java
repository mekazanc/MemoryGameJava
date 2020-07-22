import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.*;

public class GetGameParameters {

    // initialize class variables.
    private JPanel rulesPanel = new JPanel();
    private JPanel diffPanel = new JPanel();
    private JPanel timePanel = new JPanel();
    private JPanel oppPanel = new JPanel();
    private JPanel rowColPanel = new JPanel();
    private JButton buttonPanel = new JButton();


    private SetGameParameters gameParams = new SetGameParameters();




    public static void main(String[] args) {

        GetGameParameters game = new GetGameParameters();
        game.gameParameter();

    }


    private void gameParameter() {

        // designBoard();

        // Add the frame, panel for the initial window.
        JFrame frame = new JFrame("Memory Matching Game");
        JPanel panelAll = new JPanel();




        // Define as Box Layout
        panelAll.setBorder(new EmptyBorder(5, 5, 5, 5));
        //panelAll.setLayout(new BoxLayout(panelAll,BoxLayout.Y_AXIS));
        panelAll.setLayout(new GridLayout(6, 5, 5, 5));


        // Add Rule Button
        addRuleButton(panelAll);

        // Add Difficulty Level Button
        addDiffLevelButton(panelAll);

        // Add Time Info Level Button
        addTimeButton(panelAll);

        // Add Name/Opponent Button
        addOpponentButton(panelAll);

        // Add Size information of the game.
        addRowColumnButton(panelAll);


        // initialize final layer buttons
        buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));

        // add final layer buttons successively.
        addCardThemeButton(buttonPanel);
        addThemeChangeButton(buttonPanel);
        addLeaderBoardButton(buttonPanel);
        addStartButton(buttonPanel);
        addExitButton(buttonPanel);


        // add final layer into whole panel.
        panelAll.add(buttonPanel);


        // Finally, merge all information into one.
        frame.add(panelAll);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    // This is a method to add Rule Info button.
    public  void addRuleButton(JPanel panel) {


        // Add rule panel
        JButton b1 = new JButton("Rules About Memory Game");
        rulesPanel.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Basic info about game.
                JOptionPane.showMessageDialog(null, "This is a Memory Game. It can be played as single or double" + "\n" +
                        "To win the game you need to find all pairs in the board." + "\n" +
                        "Just click buttons. That's all :)" + "\n" +
                        "Find all pairs and finish the game. " + "\n"  +
                        "If you like challenge, let's increase difficulty level. ");


            }
        });

        panel.add(rulesPanel);

    }


    // This is a method to add Difficulty Level Button.
    public  void addDiffLevelButton(JPanel panel)  {

        // create and initialize panel with 1 rows 4 columns format.
        diffPanel.setLayout(new GridLayout(1, 4, 5, 5));

        // add buttons for panel.
        JRadioButton button1 = new JRadioButton("Easy");
        JRadioButton button2 = new JRadioButton(("Medium"));
        JRadioButton button3 = new JRadioButton("Difficult");

        // create 3 buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);

        JLabel radioLabel = new JLabel("Difficulty Level");

        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button2.setHorizontalAlignment(SwingConstants.CENTER);
        button3.setHorizontalAlignment(SwingConstants.CENTER);
        radioLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        diffPanel.add(radioLabel);
        diffPanel.add(button1);
        diffPanel.add(button2);
        diffPanel.add(button3);

        // add final panel into the given panel.
        panel.add(diffPanel);


        // In addition to that we need to add action listeners for this button
        // This button information will determine difficulty level of the game.

        //** action listener for time information. It includes time table info.
        ActionListener groupDiffButtonActList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                System.out.println("Selected: " + aButton.getText());

                if (aButton.getText().equals("Easy")) {
                    //System.out.println(2000);
                    //System.out.println("The game will be EASY..!");
                    gameParams.setDiffLevel(2000);
                    //System.out.println("now get it " + table.getDiffLevel());
                    //gameDiff = "Easy";
                } else if (aButton.getText().equals("Medium")) {
                    //System.out.println(1000);
                    //System.out.println("The game will be MEDIUM..!");
                    gameParams.setDiffLevel(1000);
                    //gameDiff = "Medium";
                    //System.out.println("now get it " + table.getDiffLevel());
                } else if (aButton.getText().equals("Difficult")) {
                    //System.out.println(500);
                    //System.out.println("The game will be DIFFICULT..!");
                    gameParams.setDiffLevel(500);
                    //System.out.println("now get it " + table.getDiffLevel());
                    //gameDiff = "Difficult";
                }

            }
        };

        // Add actions to the whole button..!
        button1.addActionListener(groupDiffButtonActList);
        button2.addActionListener(groupDiffButtonActList);
        button3.addActionListener(groupDiffButtonActList);


    }


    // This is a method to add time information button.
    public  void addTimeButton(JPanel panel) {


        timePanel.setLayout(new GridLayout(1, 5, 5, 5));
        JRadioButton b11 = new JRadioButton("0 sec");
        JRadioButton b22 = new JRadioButton("10 sec");
        JRadioButton b33 = new JRadioButton("60 sec");
        JRadioButton b44 = new JRadioButton("90 sec");
        JRadioButton b55 = new JRadioButton("120 sec");


        ButtonGroup groupTime = new ButtonGroup();
        groupTime.add(b11);
        groupTime.add(b22);
        groupTime.add(b33);
        groupTime.add(b44);
        groupTime.add(b55);

        // action listener for time information.
        ActionListener groupButtonActList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                System.out.println("Selected: " + aButton.getText());
                String timeText = aButton.getText().replaceAll("[A-Za-z\\s+]", "");
                //String timeText_ = timeText.replaceAll("[\\s+]","");
                //System.out.println("new time " + timeText);
                int intTimeText = Integer.valueOf(timeText);
                //System.out.println(intTimeText);
                // ** table.setTimeInfo(intTimeText);
                // timeStatus = true;
            }
        };


        b11.addActionListener(groupButtonActList);
        b22.addActionListener(groupButtonActList);
        b33.addActionListener(groupButtonActList);
        b44.addActionListener(groupButtonActList);
        b55.addActionListener(groupButtonActList);


        JLabel timeLabel = new JLabel("Time Setting");

        b11.setHorizontalAlignment(SwingConstants.CENTER);
        b22.setHorizontalAlignment(SwingConstants.CENTER);
        b33.setHorizontalAlignment(SwingConstants.CENTER);
        b44.setHorizontalAlignment(SwingConstants.CENTER);
        b55.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        timePanel.add(timeLabel);
        timePanel.add(b11);
        timePanel.add(b22);
        timePanel.add(b33);
        timePanel.add(b44);
        timePanel.add(b55);
        panel.add(timePanel);


    }


    // This is a method to add player number count.
    public  void addOpponentButton(JPanel panel) {



        // Add opponent Type
        oppPanel.setLayout(new GridLayout(1, 3, 5, 5));
        JRadioButton button11 = new JRadioButton("Single");
        JRadioButton button21 = new JRadioButton(("Double"));
        JLabel radioLabel1 = new JLabel("Opponent Type");

        ButtonGroup groupOpp = new ButtonGroup();
        groupOpp.add(button11);
        groupOpp.add(button21);



        // action listener for opponent type information.
        ActionListener oppButtonActList = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton aButton = (AbstractButton) e.getSource();
                System.out.println("Selected: " + aButton.getText());
                if (aButton.getText().equals("Single")) {

                    String Player1 = JOptionPane.showInputDialog("Please enter your name : ");
                    if (Player1 == null) {
                        System.out.println("The user canceled");

                    } else {
                        System.out.println("Entered name is " + Player1);
                        //table.setSingleName(Player1);
                    }

                    //oppStatus = true;
                } else if (aButton.getText().equals("Double")) {

                    String Player1 = JOptionPane.showInputDialog("Please enter name for Player 1  : ");
                    if (Player1 == null) {
                        System.out.println("The user canceled");

                    } else {
                        System.out.println("Entered name is " + Player1);
                    }

                    String Player2 = JOptionPane.showInputDialog("Please enter name for Player 2 : ");
                    if (Player1 == null) {
                        System.out.println("The user canceled");

                    } else {
                        System.out.println("Entered name is " + Player2);
                    }

                    //multiPlayerName.add(Player1);
                    //multiPlayerName.add(Player2);

                    //System.out.println(multiPlayerName);
                    //table.setTwoPlayersName(multiPlayerName);

                    //oppStatus = true;

                }
            }
        };

        // add buttons into action listener.
        button11.addActionListener(oppButtonActList);
        button21.addActionListener(oppButtonActList);


        button11.setHorizontalAlignment(SwingConstants.CENTER);
        button21.setHorizontalAlignment(SwingConstants.CENTER);
        radioLabel1.setHorizontalAlignment(SwingConstants.RIGHT);

        oppPanel.add(radioLabel1);
        oppPanel.add(button11);
        oppPanel.add(button21);
        panel.add(oppPanel);



    }


    // This is method to add size(col and row) of the game.
    public  void addRowColumnButton(JPanel panel) {



        // Add row-col info.
        rowColPanel.setLayout(new GridLayout(1, 4, 5, 5));
        //create a new label
        JLabel rowlabel = new JLabel("# of rows ");
        JLabel collabel = new JLabel("# of cols ");


        //String array to store weekdays
        String[] rows = {"1", "2", "3",
                "4", "5", "6"};
        String[] cols = {"1", "2", "3",
                "4", "5", "6"};

        //create list
        JComboBox<String> rows_ = new JComboBox(rows);
        JComboBox<String> cols_ = new JComboBox(cols);

        rows_.setSelectedItem(null);
        cols_.setSelectedItem(null);

        rows_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
                String s = (String) rows_.getSelectedItem();
                int s2 = Integer.parseInt(s);
                System.out.println("Row button is selected as : " + s);
                //table.setrowId(s2);
                //rowStatus = true;

            }
        });

        cols_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //
                String s3 = (String) cols_.getSelectedItem();
                int s4 = Integer.parseInt(s3);
                System.out.println("Column button is selected as : " + s3);
                //table.setcolId(s4);
                //colStatus = true;


                String s33 = (String) cols_.getSelectedItem();
                s4 = Integer.parseInt(s33);
                //table.setcolId(s4);

            }


        });


        rowlabel.setHorizontalAlignment(SwingConstants.RIGHT);
        collabel.setHorizontalAlignment(SwingConstants.RIGHT);

        rowColPanel.add(rowlabel);
        rowColPanel.add(rows_);
        rowColPanel.add(collabel);
        rowColPanel.add(cols_);
        panel.add(rowColPanel);



    }


    // This is a method to add CardThem Button in the final layer.
    public  void addCardThemeButton(JButton button) {



        JButton bf0 = new JButton("Card Theme");

        bf0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //declarations:
                String[] options = new String[]{"Gastronomy", "Social Media", "Countries"};
                int option = JOptionPane.showOptionDialog(null, "Choose Background", "Option",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options);

                if (option != JOptionPane.CLOSED_OPTION) {
                    System.out.println(options[option]);
                    //backgroundColor = options[option];

                    if (options[option].equals("Gastronomy")) {
                        System.out.println("Selected Theme : Gastronomy");

                        //themeFolder = "gastronomy";

                    } else if (options[option].equals("Social Media")) {
                        System.out.println("Selected Theme : Social Media");

                        //themeFolder = "socialmedia";

                    } else if (options[option].equals("Countries")) {
                        System.out.println("Selected Theme : Countries");
                        //themeFolder = "countries";
                    }

                } else {
                    System.out.println("No option selected");
                }


            }
        });

        button.add(bf0);

    }

    // Change Background Color of the game.
    public  void addThemeChangeButton(JButton button) {

        JButton bf1 = new JButton("Change Theme");

        bf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //declarations:
                String[] options = new String[]{"White", "Gray", "Yellow", "Blue", "Green"};
                int option = JOptionPane.showOptionDialog(null, "Choose Background", "Option",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                        null, options, options);

                if (option != JOptionPane.CLOSED_OPTION) {
                    System.out.println(options[option]);
                    //backgroundColor = options[option];

                    try {
                        Color backgroundColor = (Color) Color.class.getField(options[option].toLowerCase()).get(null);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (NoSuchFieldException ex) {
                        ex.printStackTrace();
                    }


                } else {
                    System.out.println("No option selected");
                }


            }
        });

        button.add(bf1);
    }


    // add high score board in the initial window.
    public  void addLeaderBoardButton(JButton button) {

        // Add High Scores Button.
        JButton bf2 = new JButton("High Scores");
        bf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //declarations:
                scoreDisplay();

            }
        });

        button.add(bf2);
    }

    // add start button.
    public  void addStartButton(JButton button) {

        JButton bf3 = new JButton("Start");
        bf3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // We need to control number of columns and rows.
                // Their multiplication must be even number.
                // Also, control status of all buttons.

                /*System.out.println(rowStatus);
                System.out.println(colStatus);
                System.out.println(oppStatus);
                System.out.println(timeStatus);
                System.out.println(diffStatus);*/

                /*if ((table.getrowId() % 2 == 1) && (table.getcolId() % 2 == 1)) {

                    JOptionPane.showMessageDialog(new JFrame(), "Error. You can not choose both row and columns " +
                            "are odd. Let's make it again.");
                    frame.dispose();
                    initialize();


                } else if (rowStatus == false || colStatus == false || oppStatus == false || timeStatus == false || diffStatus == false) {
                    // Control all buttons are selected or NOT.

                    JOptionPane.showMessageDialog(new JFrame(), "Error. You need to choose every part in the window. " +
                            "Let's make it again.");
                    frame.dispose();
                    initialize();


                } else {

                    startGame();


                }*/


            }

        });

        button.add(bf3);


    }


    // this button exits the window.
    public  void addExitButton(JButton button) {

        JButton bf4 = new JButton("Exit");
        bf4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closing the program
                System.out.println("Program is closed ");
                System.exit(0);
            }
        });

        button.add(bf4);


    }


    // display the highest score by reading a file.
    public  void scoreDisplay() {

        String[] titles = {"Names", "Date", "Total Points"};
        String[] names = new String[3];
        String[] dates = new String[3];
        String[] points = new String[3];

        int count = 0;

        try {

            Scanner input = new Scanner("./src/highscore.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineArray = line.split(",");
                //System.out.println(Arrays.toString(lineArray));
                names[count] = lineArray[0];
                dates[count] = lineArray[1];
                points[count] = lineArray[2];
                count++;

            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //System.out.println(names[0] + names[1] + names[2]);
        System.out.println("Score Board");

        String rows = titles[0] + " | " + titles[1] + " | " + titles[2] + "\n";
        for (int i = 0; i < names.length; i++) {

            rows = rows + " " + names[i] + " | " + dates[i] + " | " + points[i] + " " + "\n";
        }

        System.out.println(rows);


        JOptionPane.showMessageDialog(null, rows);


    }


}








