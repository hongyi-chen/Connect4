package u4a3_finalproject;
import javax.swing.JOptionPane;
/**
 File Name:   U4A3_OpeningScreen.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: This is the opening menu for the user. This allows the user to
 *            either play the game, look at the scoreboard, instructions, or
 *            exit.
 */
public class U4A3_OpeningScreen extends javax.swing.JFrame {

    public U4A3_OpeningScreen() {
        super("Welcome to Connect 4!"); // Sets program/window title to message.
        initComponents();
        
    }
    // Declare string variables for names and colours.
    String strPlayer1Name, strPlayer2Name, strPlayer1Colour, strPlayer2Colour;
    // String array of colours.
    String[] strColours = {"Red", "Yellow", "Black", "White", "Green", "Blue",
        "Crazy"};
    
    // Create new player1 and player2 instances of U4A3_Player.
    public U4A3_Player player1 = new U4A3_Player(strPlayer1Name, strPlayer1Colour);
    public U4A3_Player player2 = new U4A3_Player(strPlayer2Name, strPlayer2Colour);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConnect4Title = new javax.swing.JLabel();
        lblHeader = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnInstructions = new javax.swing.JButton();
        btnScoreboard = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblBannerLeft = new javax.swing.JLabel();
        lblBannerRight = new javax.swing.JLabel();
        txtCredits = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConnect4Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblConnect4Title.setForeground(new java.awt.Color(0, 0, 204));
        lblConnect4Title.setText("Connect 4!");

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHeader.setText("The Digital Edition 2018");

        btnPlay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPlay.setText("Play!");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnInstructions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInstructions.setText("Instructions");
        btnInstructions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstructionsActionPerformed(evt);
            }
        });

        btnScoreboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnScoreboard.setText("Scoreboard");
        btnScoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreboardActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblBannerLeft.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBannerLeft.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\images\\banner\\bannerLeft.png")); // NOI18N

        lblBannerRight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBannerRight.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\images\\banner\\bannerRight.png")); // NOI18N

        txtCredits.setBackground(new java.awt.Color(204, 204, 204));
        txtCredits.setColumns(20);
        txtCredits.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtCredits.setRows(3);
        txtCredits.setText("                          Digital Connect 4 V.1.0 \n      Game and Software © 2018 CONNECT4 PROJECT\n           Created by: HONG YI CHEN | AUG 21, 2018\n\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBannerLeft)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeader)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInstructions)
                                    .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnScoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBannerRight)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblConnect4Title)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblConnect4Title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHeader)
                        .addGap(23, 23, 23)
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInstructions)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnScoreboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblBannerLeft))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBannerRight)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); // Exit/ends the program.
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // Closes the Opening Screen
        this.setVisible(false);
        this.dispose();
                   
        // Opens a JOptionPane to ask User to input Player1 name
        strPlayer1Name = JOptionPane.showInputDialog(null, "Enter Player 1 Name: ");
        // If the user enters nothing, it is set to "Player 1"
        if(strPlayer1Name == null){
            strPlayer1Name = "Player 1";
        }
        // Assigns the name of player1 object to strPlayerName.
        player1.setName(strPlayer1Name);
        
        // Opens a JOptionPane to ask User to input Player2 name
        strPlayer2Name = JOptionPane.showInputDialog(null, "Enter Player 2 Name: ");
        // If the user enters nothing, it is set to "Player 2"
        if(strPlayer2Name == null){
            strPlayer2Name = "Player 2";
        }
        // If player1 name is the same as player 2 name, it asks the user
        // to choose another one.
        if(strPlayer2Name.equals(strPlayer1Name)){
            strPlayer2Name = JOptionPane.showInputDialog(null, "Sorry, that name"
                                 + " is taken, \nplease choose another one:  ");
        }
        // Assigns the name of player 2 to strPlayer2Name
        player2.setName(strPlayer2Name);
        
        // Opens JOptionPane to show choices of colour. Asks the user to choose
        // a colour for player 1.
        strPlayer1Colour = (String) JOptionPane.showInputDialog(null, "Choose "
                + "Player 1 colour:", "Colour", JOptionPane.QUESTION_MESSAGE, 
                   null, strColours, strColours[0]); 
        // Assigns the colour of player 1 to strPlayer1Colour
        player1.setColour(strPlayer1Colour);
        
        // Opens JOptionPane to show choices of colour. Asks the user to choose
        // a colour for player 2.
        strPlayer2Colour = (String) JOptionPane.showInputDialog(null, "Choose "
                + "Player 2 colour:", "Colour", JOptionPane.QUESTION_MESSAGE, 
                   null, strColours, strColours[1]); 
        
        // If player1 colour is the same as player 2 colour, asks the user to
        // choose a different colour.
        if(strPlayer1Colour.equals(strPlayer2Colour)){
            strPlayer2Colour = (String) JOptionPane.showInputDialog(null, 
                    "Sorry, " + strPlayer1Colour + " is taken, please \nchoose"
                  + " another colour", "Colour",
                 JOptionPane.QUESTION_MESSAGE, null, strColours, strColours[1]);
        }
        // Assigns the colour of player 2 to strPlayer2Colour
        player2.setColour(strPlayer2Colour); 
        
        // Opens the play game Screen
        U4A3_GameScreen playGame = new U4A3_GameScreen(player1, player2);
        playGame.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreboardActionPerformed
        // Closes opening screen
        this.setVisible(false);
        this.dispose();
        
        // Opens instructions screen
        U4A3_ScoreboardScreen openScoreboard = new U4A3_ScoreboardScreen();
        openScoreboard.setVisible(true);
    }//GEN-LAST:event_btnScoreboardActionPerformed

    private void btnInstructionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstructionsActionPerformed
        // Closes opening screen
        this.setVisible(false);
        this.dispose();
        
        // Opens instructions screen
        U4A3_InstructionsScreen openInstructions = new U4A3_InstructionsScreen();
        openInstructions.setVisible(true);
    }//GEN-LAST:event_btnInstructionsActionPerformed

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
            java.util.logging.Logger.getLogger(U4A3_OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4A3_OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4A3_OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4A3_OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4A3_OpeningScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInstructions;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnScoreboard;
    private javax.swing.JLabel lblBannerLeft;
    private javax.swing.JLabel lblBannerRight;
    private javax.swing.JLabel lblConnect4Title;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTextArea txtCredits;
    // End of variables declaration//GEN-END:variables
}
