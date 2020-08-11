import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Objects;

// Define getters and setters to update card information and info button.

@SuppressWarnings("serial")
public class Cards extends JButton {
    private int id;
    private boolean cardMatched = false;


    public void getIcon(int id) {

    }


    public void setCardNo(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return this.id;
    }


    public void setCardMatchedInfo(boolean cardMatched) {
        this.cardMatched = cardMatched;
    }

    public boolean getCardMatchedInfo() {
        return this.cardMatched;
    }

    public void setImageVisible(String no, String themeFolder ) {

        //System.out.println("./photos/" + themeFolder + "/" + no + ".png");
        String filename = themeFolder + "/" + no + ".png";
        
        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        setIcon(new ImageIcon(file.getPath()));

    }

    public void changeButtonParams(int[] scores, int time, List<String> names) {

        // if  it is single player
        if (names.size() == 1) {

            changeParameters(scores[0], time, names.get(0));

        // if it is multiple player.
        } else {

            changeParametersMultiPlayer(scores[0], scores[1],  names.get(0), names.get(1));

        }

    }


    public void changeParameters(int score, int time, String name) {
        setText("Points achieved by " + name + " : " + score + " |  Time left : " + time);

    }

    public void changeParametersMultiPlayer(int score, int score2, String name, String name2) {
        setText("Points  " + name + " : " + score + " |  " + name2 + " : " + score2);

    }

}