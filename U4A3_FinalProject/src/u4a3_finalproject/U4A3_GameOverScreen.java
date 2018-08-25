package u4a3_finalproject;
/**
 File Name:   U4A3_GameOverScreen.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: This is the game over screen that the user will be taken to once
 *            the connect 4 game is completed.
 */
public class U4A3_GameOverScreen extends javax.swing.JFrame{

    public U4A3_GameOverScreen() {      
        initComponents();
    }
    
    /**
     * Edits lblWinner depending on who won the game and their name.
     * @param player1 as player1 instance of player object.
     * @param player2 as player2 instance of player object.
     */
    public U4A3_GameOverScreen(U4A3_Player player1, U4A3_Player player2) {
        super("Game Over!");// Sets title of window/program to Game Over!
        initComponents();
        
        // Declaring string variables to hold player names and assigning them
        // with player 1 and player 2 names.
        String strPlayer1Name = player1.getName();
        String strPlayer2Name = player2.getName();
        
        // Declaring int variables to determine who won, assigned with
        // player.getWin() from player class.
        int intPlayer1Win = player1.getWin();
        int intPlayer2Win = player2.getWin();
        
        // Depending on the outcome of the game, lblWinner will be set.
        // 0 = tie, 1 = win, 2 = loss
        // If tie: 
        if(intPlayer1Win == 0 || intPlayer2Win == 0){
            lblWinner.setText("The game is a tie!");
         // If Player 1 win:
        } else if (intPlayer1Win == 1 && intPlayer2Win == 2){
            lblWinner.setText(strPlayer1Name + " is the Winner!");
        // If Player 2 win:
        } else if (intPlayer1Win == 2 && intPlayer2Win == 1){
            lblWinner.setText(strPlayer2Name + " is the Winner!");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGameOver = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblBannerRight = new javax.swing.JLabel();
        lblBannerLeft = new javax.swing.JLabel();
        btnScoreboard = new javax.swing.JButton();
        lblWinner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGameOver.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblGameOver.setForeground(new java.awt.Color(0, 0, 204));
        lblGameOver.setText("Game Over!");

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblBannerRight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBannerRight.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\images\\banner\\bannerRight.png")); // NOI18N

        lblBannerLeft.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBannerLeft.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\U4A3_FinalProject\\images\\banner\\bannerLeft.png")); // NOI18N

        btnScoreboard.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnScoreboard.setText("Scoreboard");
        btnScoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreboardActionPerformed(evt);
            }
        });

        lblWinner.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblWinner.setText("X is the Winner!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblGameOver)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnScoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWinner)
                        .addGap(126, 126, 126))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblBannerLeft)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                    .addComponent(lblBannerRight)
                    .addGap(31, 31, 31)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblGameOver)
                .addGap(31, 31, 31)
                .addComponent(lblWinner)
                .addGap(26, 26, 26)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnScoreboard)
                .addGap(13, 13, 13)
                .addComponent(btnExit)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblBannerLeft)
                        .addComponent(lblBannerRight))
                    .addContainerGap(27, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); // Exit/ends the program.
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreboardActionPerformed
        this.setVisible(false);
        this.dispose();
        
        U4A3_ScoreboardScreen openScores = new U4A3_ScoreboardScreen();
        openScores.setVisible(true);
    }//GEN-LAST:event_btnScoreboardActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.setVisible(false);
        this.dispose();
        
        U4A3_OpeningScreen homeScreen = new U4A3_OpeningScreen();
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(U4A3_GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4A3_GameOverScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4A3_GameOverScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnScoreboard;
    private javax.swing.JLabel lblBannerLeft;
    private javax.swing.JLabel lblBannerRight;
    private javax.swing.JLabel lblGameOver;
    private javax.swing.JLabel lblWinner;
    // End of variables declaration//GEN-END:variables
}
