import javax.swing.JButton;
import java.util.List;


public class SetGameParameters {

// Define getters and setters to update table information.

private int diffLevel;



    public int getDiffLevel() {

        return this.diffLevel;

    }

    public void setDiffLevel(int level) {

        this.diffLevel = level;
        System.out.println("Setting is ok " + level);

    }


}

