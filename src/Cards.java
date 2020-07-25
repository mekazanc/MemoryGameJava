import javax.swing.*;
import java.io.File;
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


        String header = "photos/" + themeFolder + "/";

        ClassLoader cl = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(cl.getResource(header + no + ".png")).getFile());
        String FILE_NAME = file.toString();
        setIcon(new ImageIcon(FILE_NAME));

    }

    public void changeParameters(int score, int time, String name) {
        setText("Points achieved by " + name + " : " + score + " |  Time left : " + time);

    }

    public void changeParametersMultiPlayer(int score, int score2, String name, String name2) {
        setText("Points  " + name + " : " + score + " |  " + name2 + " : " + score2);

    }

}