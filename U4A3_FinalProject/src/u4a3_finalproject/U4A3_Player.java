package u4a3_finalproject;
/**
 File Name:   U4A3_Player.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: Player class, blueprint for all player objects.
 */
public class U4A3_Player {
    
    // Declare public variables to store player information
    public String strPlayerName, strPlayerColour;
    public int intPlayerWin;
    
    /**
     * Default constructor for player.
     * @param strName as String inputted name.
     * @param strColour as String inputted colour.
     */
    public U4A3_Player(String strName, String strColour){
        strPlayerName = strName;
        strPlayerColour = strColour;
    }
    
    /**
     * Assigns inputted name to player name.
     * @param strName as String inputted name.
     */
    public void setName(String strName){
        strPlayerName = strName; 
    }
    
    /**
     * Assigns inputted colour to player colour.
     * @param strColour as String inputted colour.
     */
    public void setColour(String strColour){
        strPlayerColour = strColour; 
    }
    
    /**
     * When called, returns player name.
     * @return strPlayerName.
     */
    public String getName(){
        return strPlayerName;
    }
    
    /**
     * When called, returns player colour.
     * @return strPlayerColour.
     */
    public String getColour(){
        return strPlayerColour;
    }
    
    /**
     * Assigns win/tie/loss to intPlayerWin.
     * @param intWinner as Integer.
     */
    public void setWin(int intWinner){
        intPlayerWin = intWinner;
    }
    
    /**
     * When called, returns whether or not player won, tied, or lost.
     * @return intPlayerWin.
     */
    public int getWin(){
        return intPlayerWin;
    }
    
}


