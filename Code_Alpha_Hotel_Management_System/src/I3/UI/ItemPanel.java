 
package I3.UI;

import I3.DatabaseOperation.DatabaseOperation;
import I3.Classes.Food;
import I3.Classes.Item;
import I3.DatabaseOperation.FoodDb;
import I3.DatabaseOperation.ItemDb;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
 
public class ItemPanel extends javax.swing.JDialog {

     
    Item  item;
    ResultSet result;
    ItemDb db = new ItemDb();
    Vector comboItems = new Vector();

    public ItemPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(new Color(241,241,242));
        populateFoodTable();
     
       
    }

    private void itemObjectCreation() {
        item = new Item();
        item.setItem_name(tf_item_name.getText());
        item.setDescription(tf_item_desc.getText());
        item.setPrice(Integer.parseInt(tf_item_price.getText()));

        try {
            item.setItem_id(Integer.parseInt(tf_item_id.getText()));
        } catch (Exception ex) {
            item.setItem_id(-1);
        }
    }

     
    @SuppressWarnings("unchecked")
     private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_item = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_item_id = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        tf_item_price = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_item_name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_item_desc = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_itemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_item);

        jPanel1.setBackground(new java.awt.Color(230, 231, 232));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/EditButton.png"))); 
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel2.setText("Item Description");

        tf_item_id.setEditable(false);
        tf_item_id.setBackground(new java.awt.Color(209, 210, 212));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DeleteButton.png"))); 
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Item  ID");

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DefaultButton.png"))); 
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        tf_item_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_item_priceKeyTyped(evt);
            }
        });

        jLabel3.setText("Price");

        jLabel4.setText("Item Name");

        tf_item_desc.setColumns(20);
        tf_item_desc.setRows(5);
        jScrollPane2.setViewportView(tf_item_desc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(tf_item_name)
                    .addComponent(tf_item_id)
                    .addComponent(tf_item_price, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tf_item_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_item_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_item_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void populateFoodTable() {
        result = db.getItems();
        table_item.setModel(DbUtils.resultSetToTableModel(result));
        db.flushAll();
    }


    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {
        itemObjectCreation();
        db.insertItem(item);
        populateFoodTable();
        clearAllFields();

    }

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {
        itemObjectCreation();
        db.updateItem(item);
        populateFoodTable();
        clearAllFields();
        
    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {
       int itemId = Integer.parseInt(tf_item_id.getText());
       db.deleteItem(itemId);
       populateFoodTable();
       clearAllFields();
       
    }

    private void table_itemMouseClicked(java.awt.event.MouseEvent evt) {
       btn_edit.setEnabled(true);
       btn_delete.setEnabled(true);
       btn_add.setEnabled(false);
       int row = table_item.getSelectedRow();
        displayToTextFields(row);
       
    }

    private void tf_item_priceKeyTyped(java.awt.event.KeyEvent evt) {
         char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c== KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
        {
            evt.consume();
        }
    }

    
    private void clearAllFields()
    {
        item  = new Item();
        tf_item_id.setText("");
        tf_item_desc.setText("");
        tf_item_price.setText("");
        table_item.clearSelection();
        btn_add.setEnabled(true);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        
    }
    
    private void displayToTextFields(int row)
    {
        tf_item_id.setText(table_item.getModel().getValueAt(row, 0)+"");
        tf_item_name.setText( table_item.getModel().getValueAt(row, 1)+"");
        tf_item_desc.setText(table_item.getModel().getValueAt(row, 2)+"");
        tf_item_price.setText(table_item.getModel().getValueAt(row, 3)+"");
        
    }
    
 
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ItemPanel dialog = new ItemPanel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

     private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_item;
    private javax.swing.JTextArea tf_item_desc;
    private javax.swing.JTextField tf_item_id;
    private javax.swing.JTextField tf_item_name;
    private javax.swing.JTextField tf_item_price;
 
}
