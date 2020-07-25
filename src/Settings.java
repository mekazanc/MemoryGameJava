import javax.swing.JButton;
import java.util.List;


public class Settings {

    // Define getters and setters to update game parameters.
    private int colId;
    private int rowId;
    private int diffLevel;
    private int timeInfo;
    private String playerName;
    private boolean singlePlayer;
    private List<String> multiplePlayerName;


    public int getDiffLevel() {

        return this.diffLevel;

    }

    public void setDiffLevel(int level) {

        this.diffLevel = level;
        System.out.println("Setting is ok " + level);

    }

    public void setrowId(int id) {
        this.rowId = id;
    }

    public int getrowId() {
        return this.rowId;
    }


    public void setcolId(int id) {
        this.colId = id;
//return this.id;
    }

    public int getcolId() {
        return this.colId;
    }

    public int getTimeInfo() {

        return this.timeInfo;

    }

    public void setTimeInfo(int time) {

        this.timeInfo = time;
    }


    public String setSingleName(String name) {

        return this.playerName = name;
    }

    public boolean setSinglePlayer(boolean name) {

        if (name) {
            return this.singlePlayer = true;
        } else {
            return this.singlePlayer = false;
        }
    }

    public boolean getSinglePlayer() {

        return this.singlePlayer;

    }


    public String getSingleName() {
        return this.playerName;
    }


    public List<String> getTwoPlayersName() {
        return multiplePlayerName;
    }

    public void setTwoPlayersName(List<String> tmpList) {
        this.multiplePlayerName = tmpList;
    }


}

