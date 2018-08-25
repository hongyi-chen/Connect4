package u4a3_finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 File Name:   U4A3_ScoreboardScreen.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: This is the scoreboard screen that outputs all of the previous 
 *            scores from Scoreboard.txt. Uses algorithms to sort and search
 *            data.
 */
public class U4A3_ScoreboardScreen extends javax.swing.JFrame {

    /**
     * Creates new form U4A3_ScoreboardScreen
     */
    public U4A3_ScoreboardScreen() {
        super("Scoreboard");
        initComponents();
    }
    // Creates ArrayList to store gameInstance objects in allGames.
    static ArrayList <gameInstance> allGames = new ArrayList();
    // Declared boolean variable to make sure readInput is only ran once.
    boolean isExecuted = false;
    
    /**
     * gameInstance class to store winner, loser, time, and moves.
     */
    class gameInstance{
        String strWinner, strLoser;
        double dblTotalTime;
        int intTotalMoves;
        
        // Default constructor, initializing variables.
        gameInstance(){
            strWinner = "";
            strLoser = "";
            dblTotalTime = 0;
            intTotalMoves = 0;
        }
        
        // Constructor for winner, loser, time, total moves
        gameInstance(String _strWinner, String _strLoser, Double _dblTotalTime,
                     int _intTotalMoves){
            strWinner = _strWinner;
            strLoser = _strLoser;
            dblTotalTime = _dblTotalTime;
            intTotalMoves = _intTotalMoves;
        }
        // Creates a duplicate of the class
        gameInstance duplicate(){
            return new gameInstance(this.strWinner, this.strLoser, this.dblTotalTime, this.intTotalMoves);
        }
    }
   
    /**
     * Reads the Scoreboard.txt file and stores data into object ArrayList.
     */
    public void readTxt() {
        // Try catch statement to handle errors.
        try {
            // Reads Scoreboard.txt using BufferReader and FileReader
            BufferedReader br = new BufferedReader(new FileReader("Scoreboard.txt"));
            // Declares variable to read line with
            String strLine;
            // While there is data on the line, read it:
            while ((strLine = br.readLine()) != null) {
                // New gameInstance object declaration (looped each time):
                gameInstance newGame = new gameInstance();
                // Reads winner name
                newGame.strWinner = strLine;
                strLine = br.readLine();
                // Reads loser name
                newGame.strLoser = strLine;
                strLine = br.readLine();
                // Reads game time
                newGame.dblTotalTime = Double.parseDouble(strLine);
                // Reads amount of moves
                strLine = br.readLine();
                newGame.intTotalMoves = Integer.parseInt(strLine);
                // Add new gameInstance object to allGames
                allGames.add(newGame);            
            }   
            // Catch statement, pritns out stack trace
        } catch(IOException e) {
          e.printStackTrace();
        }
    }
    
    /**
     * Displays the information on either txtOriginalScores or txtSortedScores.
     * @param intDisplay as integer to signify which type of display it is.
     */
    public void displayData(int intDisplay){
        // If it is option 1, print on txtOriginalScores
        if(intDisplay == 1){
            // Resets txtbox
            txtOriginalScores.setText("");
            // Loops through all of array list, prints out all of the objects
            for(int i = 0; i < allGames.size(); i++){
            // Prints out 1 unsorted object with winner name, loser name, total
            // time, total moves
            txtOriginalScores.setText(txtOriginalScores.getText() + 
                    "Winner: " + allGames.get(i).strWinner + "\n" +
                    "Loser: " + allGames.get(i).strLoser +"\n" +
                    "Total Time(s): " + Double.toString(allGames.get(i).dblTotalTime)+"\n" +
                    "Total Moves: " + Integer.toString(allGames.get(i).intTotalMoves)+"\n\n");
            }
        // If it is option 2, print on txtSortedScores
        }  else if (intDisplay == 2){
            // Resets txtbox
            txtSortedScores.setText("");
            // Loops through all of array list, prints out all of the objects
            for(int i = 0; i < allGames.size() ; i++){
            // Prints out 1 sorted object with winner name, loser name, total 
            // time, total moves
            txtSortedScores.setText(txtSortedScores.getText() + 
                    "Winner: " + allGames.get(i).strWinner + "\n" +
                    "Loser: " + allGames.get(i).strLoser +"\n" +
                    "Total Time(s): " + Double.toString(allGames.get(i).dblTotalTime)+"\n" +
                    "Total Moves: " + Integer.toString(allGames.get(i).intTotalMoves)+"\n\n");
            }
        }
    }
    

    /**
     * Recursive bubble sort algorithm to sort by time.
     * @param intN as integer value (length of arrayList).
     */
    public void recursiveBubbleSortTime(int intN){
        if (intN == 1) return; // base case
        // Loops through all array list objects
        for(int i = 0; i < intN - 1; i++)
            // Swaps the elements in the object array list if the time is
            // smaller. The shortest times are moved to the front.
            if(allGames.get(i).dblTotalTime > allGames.get(i+1).dblTotalTime){
                // Swapped using duplicates.
                        gameInstance temp = allGames.get(i+1).duplicate();
                        allGames.set(i+1, allGames.get(i).duplicate());
                        allGames.set(i, temp.duplicate());
            }
        // Recursion
        recursiveBubbleSortTime(intN - 1);
    }
    
    /**
     * Recursive bubble sort algorithm to sort by amount of moves.
     * @param intN as integer value (length of arrayList).
     */
    public void recursiveBubbleSortMoves(int intN){
        if (intN == 1) return; // Base case
        // Loops through all array list objects
        for(int i = 0; i < intN - 1; i++)
            // Swaps the elemnts in the object array list if the amount of moves
            // is smaller. The least amount of moves are moved to the front.
            if(allGames.get(i).intTotalMoves > allGames.get(i+1).intTotalMoves){
                // Swapped using duplicates.
                        gameInstance temp = allGames.get(i+1).duplicate();
                        allGames.set(i+1, allGames.get(i).duplicate());
                        allGames.set(i, temp.duplicate());
            }
        // Recursion
        recursiveBubbleSortMoves(intN - 1);
    }

    /**
     * Linear search to find time in all the game times.
     * @param dblUserTime as double that is being searched for.
     * @return the index of the time, or that it was not found.
     */
    public static int intLinearSearchTime(double dblUserTime) {
        // For loop searches through the length of the array.
        for (int i = 0; i < allGames.size(); i++) {
            // If the value stored at index i is equal to dblUserTime, i is 
            // the index for the time.
            if (allGames.get(i).dblTotalTime == dblUserTime) {
                return i;
            }
        }
        // If match is not found
        return -1;
    }
    
    /**
     * Linear search to find amount of moves in all the game moves.
     * @param intUserMoves as integer that is being searched for.
     * @return the index of the amount of moves, or that it was not found.
     */
    public static int intLinearSearchMoves(int intUserMoves) {
        // For loop searches through the length of the array.
        for (int i = 0; i <allGames.size(); i++) {
            // If the value stored at index i is equal to intUserMoves, i is
            // the index for the amount of moves.
            if (allGames.get(i).intTotalMoves == intUserMoves) {
                return i;
            }
        }
        // If match is not found
        return -1;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblScoreBoardTitle = new javax.swing.JLabel();
        scrollPaneSortedScores = new javax.swing.JScrollPane();
        txtSortedScores = new javax.swing.JTextArea();
        btnQuickestWin = new javax.swing.JButton();
        btnLeastMoves = new javax.swing.JButton();
        lblSearchTime = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearchTime = new javax.swing.JTextField();
        btnSearchTime = new javax.swing.JButton();
        btnDisplayAll = new javax.swing.JButton();
        scrollPaneOriginalScores = new javax.swing.JScrollPane();
        txtOriginalScores = new javax.swing.JTextArea();
        btnSearchMoves = new javax.swing.JButton();
        txtSearchMoves = new javax.swing.JTextField();
        lblSearchMoves = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblScoreBoardTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblScoreBoardTitle.setForeground(new java.awt.Color(0, 0, 255));
        lblScoreBoardTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScoreBoardTitle.setText("Scoreboard");

        txtSortedScores.setColumns(20);
        txtSortedScores.setRows(5);
        scrollPaneSortedScores.setViewportView(txtSortedScores);

        btnQuickestWin.setText("Sort by Quickest Win");
        btnQuickestWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickestWinActionPerformed(evt);
            }
        });

        btnLeastMoves.setText("Sort by Least Moves Win");
        btnLeastMoves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeastMovesActionPerformed(evt);
            }
        });

        lblSearchTime.setText("Search for a specific time:");

        btnSearchTime.setText("Search for specific amount of time");
        btnSearchTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTimeActionPerformed(evt);
            }
        });

        btnDisplayAll.setText("Display All");
        btnDisplayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayAllActionPerformed(evt);
            }
        });

        txtOriginalScores.setColumns(20);
        txtOriginalScores.setRows(5);
        scrollPaneOriginalScores.setViewportView(txtOriginalScores);

        btnSearchMoves.setText("Search for specific amount of moves");
        btnSearchMoves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMovesActionPerformed(evt);
            }
        });

        lblSearchMoves.setText("Search for a specific move:");

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblScoreBoardTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnQuickestWin, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLeastMoves, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(scrollPaneOriginalScores, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPaneSortedScores, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearchTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchTime))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnDisplayAll))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSearchMoves)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchMoves, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchMoves)
                                .addGap(18, 18, 18)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearchTime))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScoreBoardTitle)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneSortedScores, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneOriginalScores, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisplayAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuickestWin)
                    .addComponent(btnLeastMoves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchTime)
                    .addComponent(txtSearchTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearchTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSearchMoves)
                            .addComponent(txtSearchMoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchMoves))
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuickestWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickestWinActionPerformed
        // Only allows to read input once.
        if(!isExecuted) {
            readTxt();
            isExecuted = true;
        }
        // Calls recursive bubble sort to sort the time in descending order
        recursiveBubbleSortTime(allGames.size());
        // Displays data
        displayData(2);
    }//GEN-LAST:event_btnQuickestWinActionPerformed

    private void btnLeastMovesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeastMovesActionPerformed
        // Only allows to read input once.
        if(!isExecuted) {
            readTxt();
            isExecuted = true;
        }
        
        // Calls recursive bubble sort to sort the moves in descending order
        recursiveBubbleSortMoves(allGames.size());
        // Displays data
        displayData(2);
    }//GEN-LAST:event_btnLeastMovesActionPerformed

    private void btnDisplayAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayAllActionPerformed
        // Only allows to read input once.
        if(!isExecuted) {
            readTxt();
            isExecuted = true;
        }
        // Displays data
        displayData(1);
    }//GEN-LAST:event_btnDisplayAllActionPerformed

    private void btnSearchTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTimeActionPerformed
        // Reads the input
        readTxt();
        
        // Takes user input and converts to double
        Double dblUserTimes = Double.parseDouble(txtSearchTime.getText());
        // Uses user input to search through times. Tries to find if it is in 
        // it.
        int intCounter = intLinearSearchTime(dblUserTimes);
        // If it returns anything other than -1, it returns the index value.
        if (intCounter != -1){
            // Sets text.
            txtSortedScores.setText( 
                    "Winner: " + allGames.get(intCounter).strWinner + "\n" +
                    "Loser: " + allGames.get(intCounter).strLoser +"\n" +
                    "Total Time(s): " + Double.toString(allGames.get(intCounter).dblTotalTime)+"\n" +
                    "Total Moves: " + Integer.toString(allGames.get(intCounter).intTotalMoves)+"\n\n");
        // If it returns -1, then it does not exist.
        } else if (intCounter == -1){
            txtSortedScores.setText("Error, please make sure \nthe correct time "
                    + "was inputted.");
        }
    }//GEN-LAST:event_btnSearchTimeActionPerformed

    private void btnSearchMovesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMovesActionPerformed
        // reads input
        readTxt();
        
        // Takes user input and converts to integer
        int intUserMoves = Integer.parseInt(txtSearchMoves.getText());
        // Uses user input to search through moves. Tries to find if it is in 
        // it.
        int intCounter = intLinearSearchMoves(intUserMoves);
        // If returns anything other than -1, it returns the index value.
        if (intCounter != -1){
            // Sets text.
            txtSortedScores.setText( 
                    "Winner: " + allGames.get(intCounter).strWinner + "\n" +
                    "Loser: " + allGames.get(intCounter).strLoser +"\n" +
                    "Total Time(s): " + Double.toString(allGames.get(intCounter).dblTotalTime)+"\n" +
                    "Total Moves: " + Integer.toString(allGames.get(intCounter).intTotalMoves)+"\n\n");
        // If it returns -1, it does not exist.
        } else if(intCounter == -1){
            txtSortedScores.setText("Error, please make sure \nthe correct "
                    + "amount of moves \nwas inputted.");
        }
    }//GEN-LAST:event_btnSearchMovesActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // Closes scoreboard screen
        this.setVisible(false);
        this.dispose();

        // Opens homescreen
        U4A3_OpeningScreen homeScreen = new U4A3_OpeningScreen();
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4A3_ScoreboardScreen().setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplayAll;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLeastMoves;
    private javax.swing.JButton btnQuickestWin;
    private javax.swing.JButton btnSearchMoves;
    private javax.swing.JButton btnSearchTime;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblScoreBoardTitle;
    private javax.swing.JLabel lblSearchMoves;
    private javax.swing.JLabel lblSearchTime;
    private javax.swing.JScrollPane scrollPaneOriginalScores;
    private javax.swing.JScrollPane scrollPaneSortedScores;
    private javax.swing.JTextArea txtOriginalScores;
    private javax.swing.JTextField txtSearchMoves;
    private javax.swing.JTextField txtSearchTime;
    private javax.swing.JTextArea txtSortedScores;
    // End of variables declaration//GEN-END:variables
}
