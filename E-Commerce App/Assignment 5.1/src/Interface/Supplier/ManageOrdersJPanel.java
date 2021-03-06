/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Supplier;

import Business.Business;
import Business.Customer.Customer;
import Business.Order.OrderItem;
import Business.Supplier.Supplier;
import java.awt.CardLayout;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ankit
 */
public class ManageOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrdersJPanel
     */
    public ManageOrdersJPanel() {
    }
    
    private JPanel userProcessContainer;
    private Business business;
    private Supplier sup;

    ManageOrdersJPanel(JPanel userProcessContainer, Business business, Supplier sup) {
                initComponents();
                this.userProcessContainer=userProcessContainer;
                this.business=business;
                this.sup=sup;
                populateTable();

    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) orderListJTbl.getModel();
        dtm.setRowCount(0);

        for (Map.Entry<OrderItem, Customer> e : sup.getSuppOrderList().entrySet()) {
            OrderItem oi = e.getKey();
            Customer c = e.getValue();
            Object row[] = new Object[5];
            row[0] = c.getFirstName() + " " + c.getLastName();
            row[1] = oi;
            row[2] = oi.getQuantity();
            row[3] = oi.getSalesPrice();
            row[4] = oi.getOrderStatus();
            dtm.addRow(row);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderListJTbl = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        deliverJBtn = new javax.swing.JButton();
        cancelOrderJBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Manage Orders");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Order Details");

        orderListJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Detail", "Product Name", "Order Quantity", "Order Price", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderListJTbl);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        deliverJBtn.setText("Deliver Order");
        deliverJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliverJBtnActionPerformed(evt);
            }
        });

        cancelOrderJBtn.setText("Cancel Order");
        cancelOrderJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderJBtnActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pics/download (1).jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deliverJBtn)
                        .addGap(165, 165, 165)
                        .addComponent(cancelOrderJBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(deliverJBtn)
                    .addComponent(cancelOrderJBtn))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void deliverJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliverJBtnActionPerformed
        // TODO add your handling code here:
        
        int row = orderListJTbl.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem oi = (OrderItem) orderListJTbl.getValueAt(row, 1);
        if (oi.getOrderStatus().equals("Waiting to be Shipped")) {
            oi.setOrderStatus("Delivered");
             JOptionPane.showMessageDialog(null, "The order has been delivered successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateTable();
        } else if (oi.getOrderStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(null, "This is already delivered", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (oi.getOrderStatus().equals("Canceled")) {
            JOptionPane.showMessageDialog(null, "This product is canceled.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
    }//GEN-LAST:event_deliverJBtnActionPerformed

    private void cancelOrderJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderJBtnActionPerformed
        // TODO add your handling code here:
        
        int row = orderListJTbl.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem oi = (OrderItem) orderListJTbl.getValueAt(row, 1);
        if (oi.getOrderStatus().equals("Waiting to be Shipped")) {
          //  oi.setOrderStatus("Canceled");
            sup.cancelOrder(oi);
             JOptionPane.showMessageDialog(null, "The order has been cancelled successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateTable();
        } else if (oi.getOrderStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(null, "This is already delivered", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (oi.getOrderStatus().equals("Canceled")) {
            JOptionPane.showMessageDialog(null, "This product is already canceled.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_cancelOrderJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cancelOrderJBtn;
    private javax.swing.JButton deliverJBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderListJTbl;
    // End of variables declaration//GEN-END:variables
}
