package views;

import com.formdev.flatlaf.util.UIScale;
import components.ImageLabel;
import components.PlaceholderTextField;
import controller.Client;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import model.UserModel;
import utils.AppColors;

public class MulticastChat extends javax.swing.JFrame {
  private static MulticastChat instance;
  private UserModel userModel;
  private final String PATH_IMG_LABEL = "/logo.png";
  
  private MulticastChat() {
    initComponents();
    setLocationRelativeTo(null);
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    paneFriends.setLayout(new BoxLayout(paneFriends, BoxLayout.Y_AXIS));
  }
  
  public void setUserModel (UserModel userModel) {
    this.userModel = userModel;
    this.userInfoComponent.setUsernameLabel(userModel.getUsername());
  }
  
  public static MulticastChat getInstance() {
    if(instance == null) {
      instance = new MulticastChat();
    }
    
    return instance;
  }
  
  public void addUser(String username) {
    JLabel userLabel = new JLabel(username);
    userLabel.setFont(new Font("Lucida Sans", 0, 16));
    userLabel.setForeground(AppColors.getWHITE_COLOR());
    userLabel.setBackground(AppColors.getPRIMARY_COLOR());
    userLabel.setOpaque(true);
    userLabel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
    userLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    paneFriends.add(Box.createVerticalStrut(5));
    paneFriends.add(userLabel);
    // pane.revalidate();
    pane.repaint();
  }
  
  public void clearUsersList() {
    paneFriends.removeAll();
    paneFriends.revalidate();
    paneFriends.repaint();
  }
  
  public void addMessage(String message, boolean alignRight) {
    JLabel messageLabel = new JLabel(message);
    messageLabel.setFont(new Font("Lucida Sans", 0, 16));
    messageLabel.setForeground(AppColors.getWHITE_COLOR());
    messageLabel.setBackground(AppColors.getPRIMARY_COLOR());
    messageLabel.setOpaque(true);
    messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
   
    // Alinear mensaje dependiendo si es propio o externo.
    if(alignRight)
      messageLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
    else 
      messageLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
    
    pane.add(Box.createVerticalStrut(10)); 
    pane.add(messageLabel);
    pane.revalidate();
    pane.repaint();
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    PanelChat = new javax.swing.JPanel();
    PanelLateral = new javax.swing.JPanel();
    LabelUsers = new javax.swing.JLabel();
    LabelGroups = new javax.swing.JLabel();
    labelImg = new ImageLabel(PATH_IMG_LABEL);
    panelGroups = new javax.swing.JPanel();
    BtnGroup = new javax.swing.JButton();
    userInfoComponent = new components.UserInfoComponent();
    scrollPaneFriends = new javax.swing.JScrollPane();
    paneFriends = new javax.swing.JPanel();
    ContainerMessage = new javax.swing.JPanel();
    textFieldMessage = new PlaceholderTextField("Escribe un mensaje...");
    welcomePanel = new javax.swing.JPanel();
    ScrollPane = new javax.swing.JScrollPane();
    pane = new javax.swing.JPanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    PanelChat.setBackground(new java.awt.Color(236, 236, 236));
    PanelChat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    PanelLateral.setBackground(AppColors.getPRIMARY_COLOR());
    PanelLateral.setBackground(new java.awt.Color(204, 0, 51));
    PanelLateral.setForeground(new java.awt.Color(255, 255, 255));
    PanelLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    LabelUsers.setFont(new java.awt.Font("Goudy Old Style", 1, 18)); // NOI18N
    LabelUsers.setForeground(new java.awt.Color(255, 255, 255));
    LabelUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    LabelUsers.setText("En línea");
    PanelLateral.add(LabelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 70, -1));

    LabelGroups.setFont(new java.awt.Font("Goudy Old Style", 1, 18)); // NOI18N
    LabelGroups.setForeground(new java.awt.Color(255, 255, 255));
    LabelGroups.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelGroups.setText("Grupos");
    PanelLateral.add(LabelGroups, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 60, -1));

    labelImg.setPreferredSize(new java.awt.Dimension(250, 250));
    PanelLateral.add(labelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 60));

    panelGroups.setBackground(new java.awt.Color(229, 229, 229));
    panelGroups.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    BtnGroup.setBackground(new java.awt.Color(153, 0, 0));
    BtnGroup.setFont(new java.awt.Font("Lucida Bright", 1, 12)); // NOI18N
    BtnGroup.setForeground(new java.awt.Color(255, 255, 255));
    BtnGroup.setText("Animatrónicos");
    BtnGroup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
    panelGroups.add(BtnGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, -1));

    PanelLateral.add(panelGroups, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, 90));

    userInfoComponent.setBackground(new java.awt.Color(204, 204, 204));
    PanelLateral.add(userInfoComponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 200, -1));

    javax.swing.GroupLayout paneFriendsLayout = new javax.swing.GroupLayout(paneFriends);
    paneFriends.setLayout(paneFriendsLayout);
    paneFriendsLayout.setHorizontalGroup(
      paneFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 177, Short.MAX_VALUE)
    );
    paneFriendsLayout.setVerticalGroup(
      paneFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 247, Short.MAX_VALUE)
    );

    scrollPaneFriends.setViewportView(paneFriends);

    PanelLateral.add(scrollPaneFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 180, 250));

    PanelChat.add(PanelLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 700));

    ContainerMessage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    textFieldMessage.setBackground(new java.awt.Color(190, 190, 190));
    textFieldMessage.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
    textFieldMessage.setForeground(new java.awt.Color(255, 255, 255));
    textFieldMessage.setBorder(null);
    textFieldMessage.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        textFieldMessageActionPerformed(evt);
      }
    });
    ContainerMessage.add(textFieldMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 630, 40));

    PanelChat.add(ContainerMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 770, 60));

    welcomePanel.setBackground(new java.awt.Color(255, 102, 102));

    javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
    welcomePanel.setLayout(welcomePanelLayout);
    welcomePanelLayout.setHorizontalGroup(
      welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 780, Short.MAX_VALUE)
    );
    welcomePanelLayout.setVerticalGroup(
      welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 50, Short.MAX_VALUE)
    );

    PanelChat.add(welcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 780, 50));

    pane.setLayout(new javax.swing.BoxLayout(pane, javax.swing.BoxLayout.LINE_AXIS));
    ScrollPane.setViewportView(pane);

    PanelChat.add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 760, 560));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(52, 52, 52))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(PanelChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(43, 43, 43))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void textFieldMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldMessageActionPerformed
    if(!textFieldMessage.equals("Escribe un mensaje...") && !textFieldMessage.equals("")) {
      String message = textFieldMessage.getText();
      Client.getInstanceClient().sendMessage(message);
      addMessage(message, true);
      textFieldMessage.setText("");
    }
  }//GEN-LAST:event_textFieldMessageActionPerformed

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
      java.util.logging.Logger.getLogger(MulticastChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MulticastChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MulticastChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MulticastChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MulticastChat().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton BtnGroup;
  private javax.swing.JPanel ContainerMessage;
  private javax.swing.JLabel LabelGroups;
  private javax.swing.JLabel LabelUsers;
  private javax.swing.JPanel PanelChat;
  private javax.swing.JPanel PanelLateral;
  private javax.swing.JScrollPane ScrollPane;
  private javax.swing.JLabel labelImg;
  private javax.swing.JPanel pane;
  private javax.swing.JPanel paneFriends;
  private javax.swing.JPanel panelGroups;
  private javax.swing.JScrollPane scrollPaneFriends;
  private javax.swing.JTextField textFieldMessage;
  private components.UserInfoComponent userInfoComponent;
  private javax.swing.JPanel welcomePanel;
  // End of variables declaration//GEN-END:variables
}
