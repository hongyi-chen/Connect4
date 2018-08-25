package u4a3_finalproject;
/**
 File Name:   U4A3_InstructionsScreenGame.java
 Programmer:  @author Hong Yi Chen
 Date:        August 21st, 2018
 Description: This program is a screen that displays the instructions for 
 *            Connect 4 during the game. The window can only exit as the user
 *            is in the game and cannot go back to the beginning.
 */
public class U4A3_InstructionsScreenGame extends javax.swing.JFrame {

    public U4A3_InstructionsScreenGame() {
        super("Instructions"); // Sets title of program/window to Instructions.
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConnect4Title = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblInstructionsTitle = new javax.swing.JLabel();
        txtInstructions = new javax.swing.JTextArea();

        lblConnect4Title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblConnect4Title.setText("Connect 4!");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblInstructionsTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInstructionsTitle.setForeground(new java.awt.Color(0, 0, 204));
        lblInstructionsTitle.setText("Instructions");

        txtInstructions.setBackground(new java.awt.Color(204, 204, 204));
        txtInstructions.setColumns(20);
        txtInstructions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInstructions.setRows(5);
        txtInstructions.setText("Connect 4 is a simple game for all audiences, \nrecommended for ages 5+. The objective of the \ngame is to be the first player to get 4 game pieces\nin a row either vertically, horitonally, or diagonally.\nIt is typically played on a 7 x 6 grid with 2 players\nwith 2 different colours.\n\nThe 2 players take turns dropping their coloured\ngame pieces into the game board. If the game board\nfills up before anyone achieves 4 in a row, the game\nis considered a tie. \n\nWhat are you waiting for? Get dropping!\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(lblInstructionsTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstructionsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); // Exit/ends the program.
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(U4A3_InstructionsScreenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4A3_InstructionsScreenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4A3_InstructionsScreenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4A3_InstructionsScreenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4A3_InstructionsScreenGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel lblConnect4Title;
    private javax.swing.JLabel lblInstructionsTitle;
    private javax.swing.JTextArea txtInstructions;
    // End of variables declaration//GEN-END:variables
}
