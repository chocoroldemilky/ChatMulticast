package views;

import com.formdev.flatlaf.util.UIScale;
import components.ImageLabel;
import components.PlaceholderTextField;
import controller.Client;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.UserModel;
import utils.AppColors;

public class MulticastChat extends javax.swing.JFrame {
  private static MulticastChat instance;
  private UserModel userModel;
  private final String PATH_IMG_LABEL = "/logo.png";
  
  private Map<String, JPanel> chats = new HashMap<>();
  private boolean isMulticast = true;
  
  private MulticastChat() {
    initComponents();
    setLocationRelativeTo(null);
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); // Panel de grupo
    paneFriends.setLayout(new BoxLayout(paneFriends, BoxLayout.Y_AXIS));
    setUsersOnline();
    
    openChat("ChatGrupal");
  }
  
  /**
   * Patrón singleton para obtener una única instancia de MulticastChat
   * @return MulticastChat
   */
  public static MulticastChat getInstance() {
    if(instance == null) {
      instance = new MulticastChat();
    }
    
    return instance;
  }
  
  /**
   * Método para establecer los usuarios en linea. Realiza una petición get al servidor
   * el cual devuelve la lista de usuarios activos.
   */
  private void setUsersOnline() {
    Client client = Client.getInstanceClient();
    List<String> usersOnline = client.getUsersOnline();
    
    if(usersOnline!=null) {
      for(String username: usersOnline) {
        addUser(username);
      }
    }
  }
  
  /**
   * Método público para establecer los parámetros clave del usuario, como 
   * su nombre e identificador.
   * @param userModel 
   */
  public void setUserModel (UserModel userModel) {
    this.userModel = userModel;
    this.userInfoComponent.setUsernameLabel(userModel.getUsername());
  }
  
  /**
   * Método se llama para agregar un nuevo usuario en la lista de usuarios conectados de la interfaz
   * @param username Nombre del usuario en línea.
   */
  public void addUser(String username) {
    JButton userBtn = new JButton(username);
    
    // Se establece la fuente, alineamiento, tamaño y cursor.
    userBtn.setFont(new Font("Lucida Sans", 0, 16));
    userBtn.setOpaque(true);
    userBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    userBtn.setPreferredSize(new Dimension(paneFriends.getWidth(), 25));
    userBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    // Estableciendo el borde del botón
    userBtn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(AppColors.PRIMARY_COLOR, 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
    ));
    
    // Se agrega la acción
    userBtn.addActionListener(e -> openChat(username));
    
    paneFriends.add(Box.createVerticalStrut(5));
    paneFriends.add(userBtn);
    
    paneFriends.revalidate();
    paneFriends.repaint();
  }
  
  private void openChat(String username) {
    this.isMulticast = username.equals("ChatGrupal");
    
    if(chats.containsKey(username)) {
      
      JPanel chatPanel = chats.get(username);
      ScrollPane.setViewportView(chatPanel);
      this.pane = chatPanel;
    }
    
    else {
      JPanel chatPanel = new JPanel();
      chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
      
      // Almacenar el chat
      chats.put(username, chatPanel);
      
      // Mostrar el nuevo chat
      ScrollPane.setViewportView(chatPanel);
      this.pane = chatPanel;
    }
    
    ScrollPane.revalidate();
    ScrollPane.repaint();
  }
  
  /**
   * Este método se llama para limpiar la lista de usuarios en línea y 
   * posteriormente actualizarla
   */
  public void clearUsersList() {
    paneFriends.removeAll();
    paneFriends.revalidate();
    paneFriends.repaint();
  }
  
  /**
   * Este método se implementa para poder agregar un mensaje en la vista.
   * Se agrega el mensaje del lado derecho cuando el mensaje pertenece al usuario
   * y se agrega del lado izquierdo cuando el mensaje es un mensaje externo.
   * @param username Nombre de usuario que envió el mensaje
   * @param message Mensaje del usuario
   * @param alignRight Alinear dependiendo el tipo de mensaje
   */
  public void addMessage(String username, String message, boolean alignRight) {
    JLabel usernameLabel = new JLabel(username);
    usernameLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
    usernameLabel.setForeground(AppColors.getGRAY_COLOR());
    usernameLabel.setBackground(AppColors.getWHITE_COLOR());
    
    // Crear etiqueta para el mensaje
    JLabel messageLabel = new JLabel(message);
    messageLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
    messageLabel.setForeground(AppColors.getWHITE_COLOR());
    messageLabel.setOpaque(true);
    messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    // Crear contenedor para el mensaje
    JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
    
    if (alignRight) {
        messageLabel.setBackground(AppColors.getPRIMARY_COLOR());
    } else {
        messageLabel.setBackground(AppColors.getSECONDARY_COLOR());
        
    }
    
    messagePanel.setOpaque(true);
    messagePanel.setBackground(Color.GREEN);
    
    // Agregar usuario y mensaje.
    messagePanel.add(usernameLabel);
    messagePanel.add(Box.createVerticalStrut(5));
    messagePanel.add(messageLabel);
    
    pane.add(messagePanel);
    pane.add(Box.createVerticalStrut(10));
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
    labelImg = new ImageLabel(PATH_IMG_LABEL);
    BtnLogout = new javax.swing.JButton();
    userInfoComponent = new components.UserInfoComponent();
    scrollPaneFriends = new javax.swing.JScrollPane();
    paneFriends = new javax.swing.JPanel();
    btnGroupChat = new javax.swing.JButton();
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
    PanelLateral.add(LabelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, -1));

    labelImg.setPreferredSize(new java.awt.Dimension(250, 250));
    PanelLateral.add(labelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 60));

    BtnLogout.setBackground(new java.awt.Color(204, 0, 0));
    BtnLogout.setFont(new java.awt.Font("Goudy Old Style", 0, 24)); // NOI18N
    BtnLogout.setForeground(new java.awt.Color(255, 255, 255));
    BtnLogout.setText("Cerrar Sesión");
    BtnLogout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BtnLogoutActionPerformed(evt);
      }
    });
    PanelLateral.add(BtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 160, -1));

    userInfoComponent.setBackground(new java.awt.Color(0, 0, 0));
    PanelLateral.add(userInfoComponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 200, 130));

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

    PanelLateral.add(scrollPaneFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 250));

    btnGroupChat.setBackground(new java.awt.Color(51, 153, 255));
    btnGroupChat.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
    btnGroupChat.setForeground(new java.awt.Color(255, 255, 255));
    btnGroupChat.setText("Grupo");
    btnGroupChat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGroupChatActionPerformed(evt);
      }
    });
    PanelLateral.add(btnGroupChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 180, 30));

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

    pane.setLayout(new javax.swing.BoxLayout(pane, javax.swing.BoxLayout.X_AXIS));
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
      addMessage(userModel.getUsername(), message, true);
      textFieldMessage.setText("");
    }
  }//GEN-LAST:event_textFieldMessageActionPerformed

  private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed
    Client.getInstanceClient().disconnect();
    this.setVisible(false);
    Login.getInstanceLogin().setVisible(true);
  }//GEN-LAST:event_BtnLogoutActionPerformed

  private void btnGroupChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupChatActionPerformed
    openChat("ChatGrupal");
  }//GEN-LAST:event_btnGroupChatActionPerformed

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
  private javax.swing.JButton BtnLogout;
  private javax.swing.JPanel ContainerMessage;
  private javax.swing.JLabel LabelUsers;
  private javax.swing.JPanel PanelChat;
  private javax.swing.JPanel PanelLateral;
  private javax.swing.JScrollPane ScrollPane;
  private javax.swing.JButton btnGroupChat;
  private javax.swing.JLabel labelImg;
  private javax.swing.JPanel pane;
  private javax.swing.JPanel paneFriends;
  private javax.swing.JScrollPane scrollPaneFriends;
  private javax.swing.JTextField textFieldMessage;
  private components.UserInfoComponent userInfoComponent;
  private javax.swing.JPanel welcomePanel;
  // End of variables declaration//GEN-END:variables
}
