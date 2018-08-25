package u4a3_finalproject;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 File Name:   U4A3_GameScreen.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: This is the connect 4 game, this is where users are able to play
 *            connect 4. Scores are kept on Scoreboard.txt.
 */
public class U4A3_GameScreen extends javax.swing.JFrame {
    // Declare string variables for names and colours
    String strPlayer1Name, strPlayer2Name, strPlayer1Colour, strPlayer2Colour;
    // Declare string variables for winner and loser
    String strWinner = "";
    String strLoser = "";
    // Declare double variable to calculate elapsed time
    double dblStartTime, dblTotalTime;
    // Declare integer variables to store who's turn it is, if there is a win,
    // and the total amount of moves.
    int intPlayerTurn, intCheckWin, intTotalMoves;
    // Declare boolean variable to store whether or not a chip has been dropped.
    boolean isDropped = false;
    // Declare boolean variable to check if there is a tie.
    boolean isTie;
    // Declare image icons for player turns and player game pieces.
    ImageIcon imgPlayer1Turn, imgPlayer2Turn, imgPlayer1Chip, imgPlayer2Chip;
    // Declare image icon and assigns it to background image for when there is
    // no chip inside.
    ImageIcon imgBackground = new ImageIcon("images/game/background.png");
    // Declare image icons and assigns them to arrows pointing left and right
    // depending on player turns.
    ImageIcon imgPlayer2TurnArrow = new ImageIcon("images/player turn/arrowRight.png");
    ImageIcon imgPlayer1TurnArrow = new ImageIcon("images/player turn/arrowLeft.png");
    
    // Declare 2-D JLabel array for a 7x6 grid.
    JLabel[][] lblArrGameBlocks = new JLabel[6][7];
    // Declare grid layout for JLabels (7x6).
    GridLayout gameLayout = new GridLayout(6, 7);
    // Declare 2-D Integer array to represent 7x6 connect4 grid.
    int[][] intArrGameLayout = new int[6][7];
    
    // Declare player 1 and player 2 objects.
    U4A3_Player player1 = new U4A3_Player(strPlayer1Name, strPlayer1Colour);
    U4A3_Player player2 = new U4A3_Player(strPlayer2Name, strPlayer2Colour);
    
    /**
     * Standard initiation of components.
     */
    public U4A3_GameScreen(){   
        initComponents();
    }
    
    /**
     * Setup of game board and assigning player data.
     * @param player1 as player object.
     * @param player2 as player object.
     */
    public U4A3_GameScreen(U4A3_Player player1, U4A3_Player player2){
        super("Connect 4!"); // Sets title of program/window to Connect 4!
        initComponents();
        
        // Assigns player names and colours to String variables.
        strPlayer1Name = player1.getName();
        strPlayer2Name = player2.getName();
        strPlayer1Colour = player1.getColour();
        strPlayer2Colour = player2.getColour();
        
        // Sets the label to player names.
        lblPlayer1Name.setText("Player 1: " + strPlayer1Name);
        lblPlayer2Name.setText("Player 2: " + strPlayer2Name);
        
        // Sets the panel to gameLayout.
        panelBoard.setLayout(gameLayout);
        
        // Uses JLabels to create a 7x6 connect 4 grid.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                intArrGameLayout[i][j] = 0;
                lblArrGameBlocks[i][j] = new JLabel();
                // Sets icon background to imgBackground
                lblArrGameBlocks[i][j].setIcon(imgBackground);
                panelBoard.add(lblArrGameBlocks[i][j]);
            }
        }
        
        // Depending on the selected colour of the user, player 1 will be set to
        // their chosen colour.
        switch(strPlayer1Colour){
            case "Red":
                imgPlayer1Turn = new ImageIcon("images/player turn/redGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/redGamePiece.png");
                break;
            case "Yellow":
                imgPlayer1Turn = new ImageIcon("images/player turn/yellowGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/yellowGamePiece.png");
                break;
            case "Black":
                imgPlayer1Turn = new ImageIcon("images/player turn/blackGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/blackGamePiece.png");
                break;
            case "White":
                imgPlayer1Turn = new ImageIcon("images/player turn/whiteGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/whiteGamePiece.png");
                break;
            case "Green":
                imgPlayer1Turn = new ImageIcon("images/player turn/greenGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/greenGamePiece.png");
                break;
            case "Blue":
                imgPlayer1Turn = new ImageIcon("images/player turn/blueGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/blueGamePiece.png");
                break;
            case "Crazy":
                imgPlayer1Turn = new ImageIcon("images/player turn/crazyGamePiece.png");
                imgPlayer1Chip = new ImageIcon("images/game/crazyGamePiece.png");
                break;
        }
        lblPlayer1Icon.setIcon(imgPlayer1Turn);
        
        // Depending on the selected colour of user, player 2 will be set to the
        // chosen colour.
        switch(strPlayer2Colour){
            case "Red":
                imgPlayer2Turn = new ImageIcon("images/player turn/redGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/redGamePiece.png");
                break;
            case "Yellow":
                imgPlayer2Turn = new ImageIcon("images/player turn/yellowGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/yellowGamePiece.png");
                break;
            case "Black":
                imgPlayer2Turn = new ImageIcon("images/player turn/blackGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/blackGamePiece.png");
                break;
            case "White":
                imgPlayer2Turn = new ImageIcon("images/player turn/whiteGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/whiteGamePiece.png");
                break;
            case "Green":
                imgPlayer2Turn = new ImageIcon("images/player turn/greenGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/greenGamePiece.png");
                break;
            case "Blue":
                imgPlayer2Turn = new ImageIcon("images/player turn/blueGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/blueGamePiece.png");
                break;
            case "Crazy":
                imgPlayer2Turn = new ImageIcon("images/player turn/crazyGamePiece.png");
                imgPlayer2Chip = new ImageIcon("images/game/crazyGamePiece.png");
                break;
        }
        lblPlayer2Icon.setIcon(imgPlayer2Turn);
        
        // Player 1 starts the game with the first turn
        intPlayerTurn = 1;
        // Sets the turn label
        lblPlayerTurn.setText(strPlayer1Name + "'s turn.");
        // When it is player 1's turn, arrow points left.
        lblPlayerTurnLeft.setIcon(imgPlayer1TurnArrow);
        // When it is player 2's turn, arrow points right.
        lblPlayerTurnRight.setIcon(imgPlayer1TurnArrow);
        // Starts counting time elapsed
        dblStartTime = System.nanoTime();
    }
    /**
     * Switches between player turns, starts with 1 and changes to 2. 
     * @param strPlayer1Name as String player 1 name.
     * @param strPlayer2Name as String player 2 name.
     */
    public void playerTurns(String strPlayer1Name, String strPlayer2Name){
        // If it was player 2's turn, turn to player 1's turn
        if(intPlayerTurn == 2){
            intPlayerTurn = 1;
            // Changes turn label and arrows
            lblPlayerTurn.setText(strPlayer1Name + "'s turn.");
            lblPlayerTurnLeft.setIcon(imgPlayer1TurnArrow);
            lblPlayerTurnRight.setIcon(imgPlayer1TurnArrow);
        // If it was player 1's turn, turn to player 2's turn
        } else if (intPlayerTurn == 1){           
            intPlayerTurn = 2;
            // Changes turn label and arrows
            lblPlayerTurn.setText(strPlayer2Name + "'s turn.");
            lblPlayerTurnLeft.setIcon(imgPlayer2TurnArrow);
            lblPlayerTurnRight.setIcon(imgPlayer2TurnArrow);
        }
    }

    /**
     * 
     * @param intPlayer
     * @param intColumn
     * @return if the piece was dropped or if the piece was not dropped.
     */
    public boolean isDroppedGamePiece(int intPlayer, int intColumn) {  
        // Loops through the rows, starting from the bottom
        for (int intRow = 5; intRow > -1; intRow--) {
            // If the space is not taken by player 1 or player 2
            if (intArrGameLayout[intRow][intColumn] != 1 && intArrGameLayout[intRow][intColumn] != 2){
                // Drop
                isDropped = true;
                // If the player is player 1, set block to 1 and change icon.
                if (intPlayer == 1) {
                    intArrGameLayout[intRow][intColumn] = 1;
                    lblArrGameBlocks[intRow][intColumn].setIcon(imgPlayer1Chip);
                // If the player is player 2, set block to 2 and change icon.
                } else if (intPlayer == 2) {
                    intArrGameLayout[intRow][intColumn] = 2;
                    lblArrGameBlocks[intRow][intColumn].setIcon(imgPlayer2Chip);
                }
                break;
            }
        }
        // returns whether or not the piece was dropped.
        return isDropped;
    }

    /**
     * Checks to see if a win has occurred or not.
     * @param player1 as player 1 object.
     * @param player2 as player 2 object.
     */
    public void checkPlayerWin(U4A3_Player player1, U4A3_Player player2){
        
        // Checks to see if there has been a vertical connect 4.
        for(int intColumn = 0; intColumn <= 6; intColumn++){
            for(int intRow = 0; intRow <= 2; intRow++){
                intCheckWin = intArrGameLayout[intRow][intColumn];
                // If the block is not empty:
                if(intCheckWin != 0){
                    // Checks for 4 vertical in a row.
                    if(intArrGameLayout[intRow][intColumn] == intCheckWin &&
                       intArrGameLayout[intRow + 1][intColumn] == intCheckWin &&
                       intArrGameLayout[intRow + 2][intColumn] == intCheckWin &&
                       intArrGameLayout[intRow + 3][intColumn] == intCheckWin){ 
                       // Adds wins / losses to player 1 and player 2.
                       addWinner(player1, player2);
                       // Counts amount of moves.
                       totalMoves();
                       // Opens the game over screen.
                       openGameOver(player1, player2);
                    }
                }
            }
        }
        
        // Check to see if there has been a horizontal connect 4.
        for(int intColumn = 0; intColumn <= 3; intColumn++){
            for(int intRow = 0; intRow <= 5; intRow++){
                intCheckWin = intArrGameLayout[intRow][intColumn];
                if(intCheckWin != 0){
                    // Checks to see if there is 4 in a row that are the same
                    // value.
                    if(intArrGameLayout[intRow][intColumn] == intCheckWin &&
                       intArrGameLayout[intRow][intColumn + 1] == intCheckWin &&
                       intArrGameLayout[intRow][intColumn + 2] == intCheckWin &&
                       intArrGameLayout[intRow][intColumn + 3] == intCheckWin){
                       // Adds wins/losses to player 1 and player 2
                       addWinner(player1, player2);
                       // Counts the total amount of moves
                       totalMoves();
                       // Opens the game over screen
                       openGameOver(player1, player2);
                    }
                }
            }
        }
        
        // Check to see if there has been a descending diagonal connect 4.
        for(int intColumn = 3; intColumn <= 6; intColumn++){
            for(int intRow = 3; intRow <= 5; intRow++){
                intCheckWin = intArrGameLayout[intRow][intColumn];
                if(intCheckWin != 0){
                    if(intArrGameLayout[intRow][intColumn] == intCheckWin &&
                       // Checks to see if there is 4 in a row going from the
                       // top left to bottom right.
                       intArrGameLayout[intRow - 1][intColumn - 1] == intCheckWin &&
                       intArrGameLayout[intRow - 2][intColumn - 2] == intCheckWin &&
                       intArrGameLayout[intRow - 3][intColumn - 3] == intCheckWin){
                       // Adds wins/losses to players 1 and player 2
                       addWinner(player1, player2);
                       // Counts the total amount of moves
                       totalMoves();
                       // Opens the game over screen
                       openGameOver(player1, player2);
                    }
                }
            }
        }
        
        // Check to see if there as been an ascending diagonal connect 4.
        for(int intColumn = 0; intColumn <= 3; intColumn++){
            for(int intRow = 3; intRow <= 5; intRow++){
                intCheckWin = intArrGameLayout[intRow][intColumn];
                if(intCheckWin != 0){
                    // Checks to see if there is 4 in a row going from the 
                    // bottom left to the top right of the board.
                    if(intArrGameLayout[intRow][intColumn] == intCheckWin &&
                       intArrGameLayout[intRow - 1][intColumn + 1] == intCheckWin &&
                       intArrGameLayout[intRow - 2][intColumn + 2] == intCheckWin &&
                       intArrGameLayout[intRow - 3][intColumn + 3] == intCheckWin){
                       // Adds wins/losses to player 1 and player 2
                       addWinner(player1, player2);
                       // Counts the total amount of moves
                       totalMoves();
                       // Opens the game over screen
                       openGameOver(player1, player2);
                    }
                }
            }
        }
        
        // Checks to see if there has been a tie
        for(int intRow = 0; intRow < 6; intRow++){
            for(int intColumn = 0; intColumn < 7; intColumn++){
                // If board is filled up with anything other than empty
                if(intArrGameLayout[intRow][intColumn] == 0){
                    isTie = false; 
                    break;
                } 
            } 
            if (!isTie){
                break;
            }
        }
        
        // If it is a tie, move on to the game over screen
        if(isTie){
            // Sets both players to tie
            player1.setWin(0);
            player2.setWin(0);
            // Closes the screen
            this.setVisible(false);
            dispose();
            // Opens the new Screen
            U4A3_GameOverScreen gameOver = new U4A3_GameOverScreen(player1, player2);
            gameOver.setVisible(true); 
        }

    }
    
    /**
     * Checks if it is a win/loss or tie. If it is a win/loss, player 1 and 
     * player 2 will be assigned either win or loss.
     * @param player1 as player 1 object.
     * @param player2 as player 2 object.
     */
    public void addWinner(U4A3_Player player1, U4A3_Player player2){
        // Stops the time elapsed and stores time in seconds. 
        // Time is converted from nanoseconds to seconds.
        dblTotalTime = (System.nanoTime() - dblStartTime) / 1000000000.0;
        
        // If case = 0, tie. 
        // If case = 1, player 1 wins.
        // If case = 2, player 2 wins.
        // 0 = tie, 1 = win, 2 = loss.
        switch(intPlayerTurn){
            case 0:
                player1.setWin(0);
                player2.setWin(0);
                break;
            case 1: 
                player1.setWin(1);
                player2.setWin(2);
                // Assigns winner + loser names.
                strWinner = strPlayer1Name;
                strLoser = strPlayer2Name;
                break;
            case 2:
                player1.setWin(2);
                player2.setWin(1);
                // Assigns winner + loser names.
                strWinner = player2.getName();
                strLoser = player1.getName();
                break;
        }
    }
    
    /**
     * Closes the game screen and opens the game over screen.
     * @param player1 as player 1 object.
     * @param player2 as player 2 object.
     */
    public void openGameOver(U4A3_Player player1, U4A3_Player player2){
        // Score is outputted to txt file.
        outputScore();
        // Sets player names for game over screen.
        player1.setName(strPlayer1Name);
        player2.setName(strPlayer2Name);
        // Closes game screen.
        this.setVisible(false);
        dispose();
        // Opens game over screen.
        U4A3_GameOverScreen gameOver = new U4A3_GameOverScreen(player1, player2);
        gameOver.setVisible(true); 
    }
    
    /**
     * Method to count the total moves by seeing which of the blocks are not 
     * empty.
     */
    public void totalMoves(){
        for (int intColumn = 0; intColumn <= 6; intColumn++){
            for(int intRow = 0; intRow <= 5; intRow++){
                if (intArrGameLayout[intRow][intColumn] != 0){
                    // Increments intTotalMoves everytime there is something
                    // that is not empty.
                    intTotalMoves++;
                }
            } 
        }
    }
    
    /**
     * Outputs the score onto Scoreboard.txt.
     */
    public void outputScore(){
        // Try catch statement to handle exceptions.
        try(
        // New File writer to Scoreboard.txt
        FileWriter fw = new FileWriter("Scoreboard.txt", true);
        // Writes onto Scoreboard.txt
        BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw)){
                // Winner name, loser name, game time, and total moves will be
                // recorded on Scoreboard.txt.
                pw.println(strWinner);
                pw.println(strLoser);
                pw.println(dblTotalTime);
                pw.println(intTotalMoves);
            } catch (IOException e) {
                System.out.println("Error, cannot write to txt file.");
                // Prints stack trace
                e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDrop1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnInstructions = new javax.swing.JButton();
        btnDrop2 = new javax.swing.JButton();
        btnDrop3 = new javax.swing.JButton();
        btnDrop4 = new javax.swing.JButton();
        btnDrop5 = new javax.swing.JButton();
        btnDrop6 = new javax.swing.JButton();
        btnDrop7 = new javax.swing.JButton();
        lblPlayerTurn = new javax.swing.JLabel();
        lblPlayer2Name = new javax.swing.JLabel();
        lblPlayer1Name = new javax.swing.JLabel();
        lblConnect4Title = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        lblPlayer1Icon = new javax.swing.JLabel();
        panelBoard = new javax.swing.JPanel();
        lblPlayer2Icon = new javax.swing.JLabel();
        lblPlayerTurnLeft = new javax.swing.JLabel();
        lblPlayerTurnRight = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDrop1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop1.setText("DROP");
        btnDrop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop1ActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnInstructions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInstructions.setText("Instructions");
        btnInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructionsActionPerformed(evt);
            }
        });

        btnDrop2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop2.setText("DROP");
        btnDrop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop2ActionPerformed(evt);
            }
        });

        btnDrop3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop3.setText("DROP");
        btnDrop3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop3ActionPerformed(evt);
            }
        });

        btnDrop4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop4.setText("DROP");
        btnDrop4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop4ActionPerformed(evt);
            }
        });

        btnDrop5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop5.setText("DROP");
        btnDrop5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop5ActionPerformed(evt);
            }
        });

        btnDrop6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop6.setText("DROP");
        btnDrop6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop6ActionPerformed(evt);
            }
        });

        btnDrop7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDrop7.setText("DROP");
        btnDrop7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrop7ActionPerformed(evt);
            }
        });

        lblPlayerTurn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayerTurn.setText("Player 1's Turn.");

        lblPlayer2Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlayer2Name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPlayer2Name.setText("lblPlayer2Name");

        lblPlayer1Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPlayer1Name.setText("lblPlayer1Name");

        lblConnect4Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblConnect4Title.setForeground(new java.awt.Color(0, 0, 255));
        lblConnect4Title.setText("Connect 4!");

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHeader.setText("The Digital Edition 2018");

        lblPlayer1Icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\blueGamePiece.png")); // NOI18N

        panelBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBoard.setPreferredSize(new java.awt.Dimension(380, 325));

        javax.swing.GroupLayout panelBoardLayout = new javax.swing.GroupLayout(panelBoard);
        panelBoard.setLayout(panelBoardLayout);
        panelBoardLayout.setHorizontalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        panelBoardLayout.setVerticalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        lblPlayer2Icon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\blueGamePiece.png")); // NOI18N

        lblPlayerTurnLeft.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\blueGamePiece.png")); // NOI18N

        lblPlayerTurnRight.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\blueGamePiece.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(lblHeader))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(lblConnect4Title))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnDrop1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnDrop7))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnInstructions))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(lblPlayer1Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPlayer1Name)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPlayerTurnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPlayerTurn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblPlayerTurnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPlayer2Name)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblPlayer2Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(8, 8, 8))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblConnect4Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDrop1)
                    .addComponent(btnDrop2)
                    .addComponent(btnDrop3)
                    .addComponent(btnDrop4)
                    .addComponent(btnDrop5)
                    .addComponent(btnDrop6)
                    .addComponent(btnDrop7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPlayer2Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPlayer2Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPlayer1Icon, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(lblPlayer1Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInstructions)))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblPlayerTurnRight)
                            .addComponent(lblPlayerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPlayerTurnLeft))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDrop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop1ActionPerformed
    // Drops on column 1 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 0)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); // Exit/ends the program.
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructionsActionPerformed
        // Opens instructions screen during game.
        U4A3_InstructionsScreenGame openInstructionsGame = new U4A3_InstructionsScreenGame();
        openInstructionsGame.setVisible(true);
    }//GEN-LAST:event_btnInstructionsActionPerformed

    private void btnDrop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop2ActionPerformed
    // Drops on column 2 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 1)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop2ActionPerformed

    private void btnDrop3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop3ActionPerformed
    // Drops on column 3 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 2)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop3ActionPerformed

    private void btnDrop4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop4ActionPerformed
    // Drops on column 4 and checks if player wins, switches player turns 
    if(isDroppedGamePiece(intPlayerTurn, 3)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop4ActionPerformed

    private void btnDrop5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop5ActionPerformed
    // Drops on column 5 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 4)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop5ActionPerformed

    private void btnDrop6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop6ActionPerformed
    // Drops on column 6 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 5)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop6ActionPerformed

    private void btnDrop7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrop7ActionPerformed
    // Drops on column 7 and checks if player wins, switches player turns
    if(isDroppedGamePiece(intPlayerTurn, 6)){
        checkPlayerWin(player1, player2);
        playerTurns(strPlayer1Name, strPlayer2Name);
    }
    }//GEN-LAST:event_btnDrop7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4A3_GameScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDrop1;
    private javax.swing.JButton btnDrop2;
    private javax.swing.JButton btnDrop3;
    private javax.swing.JButton btnDrop4;
    private javax.swing.JButton btnDrop5;
    private javax.swing.JButton btnDrop6;
    private javax.swing.JButton btnDrop7;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInstructions;
    private javax.swing.JLabel lblConnect4Title;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblPlayer1Icon;
    private javax.swing.JLabel lblPlayer1Name;
    private javax.swing.JLabel lblPlayer2Icon;
    private javax.swing.JLabel lblPlayer2Name;
    private javax.swing.JLabel lblPlayerTurn;
    private javax.swing.JLabel lblPlayerTurnLeft;
    private javax.swing.JLabel lblPlayerTurnRight;
    private javax.swing.JPanel panelBoard;
    // End of variables declaration//GEN-END:variables
}
