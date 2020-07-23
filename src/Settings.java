import javax.swing.JButton;
import java.util.List;


public class Settings {

// Define getters and setters to update game parameters.
private int colid;
private int rowid;
private int diffLevel;
private int timeInfo;
private String playerName;
private List<String> multiplePlayerName;



public int getDiffLevel() {

return this.diffLevel;

}

public void setDiffLevel(int level) {

this.diffLevel = level;
System.out.println("Setting is ok " + level);

}

public void setrowId(int id) {
this.rowid = id;
//return this.id;
}

public int getrowId() {
return this.rowid;
}


public void setcolId(int id) {
this.colid = id;
//return this.id;
}

public int getcolId() {
return this.colid;
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

