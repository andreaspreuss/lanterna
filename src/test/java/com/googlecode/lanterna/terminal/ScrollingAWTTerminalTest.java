/*
 * This file is part of lanterna (https://github.com/mabe02/lanterna).
 *
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010-2020 Martin Berglund
 */
package com.googlecode.lanterna.terminal;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.swing.ScrollingAWTTerminal;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorColorConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorDeviceConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Martin
 */
@SuppressWarnings("FieldCanBeLocal")
public class ScrollingAWTTerminalTest extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final ScrollingAWTTerminal scrollingAwtTerminal;

    /**
     * Creates new form ScrollingSwingTerminalTest
     */
    public ScrollingAWTTerminalTest() {
        initComponents();
        scrollingAwtTerminal = new ScrollingAWTTerminal(
                TerminalEmulatorDeviceConfiguration.getDefault().withLineBufferScrollbackSize(150),
                SwingTerminalFontConfiguration.getDefault(),
                TerminalEmulatorColorConfiguration.getDefault());
        panelTerminalContainer.add(scrollingAwtTerminal, BorderLayout.CENTER);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTerminalContainer = new javax.swing.JPanel();
        buttonPrint100Lines = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        buttonPrint10Lines = new javax.swing.JButton();
        buttonPrint1Line = new javax.swing.JButton();
        buttonMoveCursor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTerminalContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Terminal"));
        panelTerminalContainer.setLayout(new java.awt.BorderLayout());

        buttonPrint100Lines.setText("Print 100 lines");
        buttonPrint100Lines.addActionListener(this::buttonPrint100LinesActionPerformed);

        buttonPrint10Lines.setText("Print 10 lines");
        buttonPrint10Lines.addActionListener(this::buttonPrint10LinesActionPerformed);

        buttonPrint1Line.setText("Print 1 line");
        buttonPrint1Line.addActionListener(this::buttonPrint1LineActionPerformed);

        buttonMoveCursor.setText("Move cursor");
        buttonMoveCursor.addActionListener(this::buttonMoveCursorActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTerminalContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(buttonMoveCursor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(buttonPrint1Line)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPrint10Lines)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPrint100Lines))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTerminalContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrint100Lines)
                    .addComponent(buttonPrint10Lines)
                    .addComponent(buttonPrint1Line)
                    .addComponent(buttonMoveCursor))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPrint100LinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrint100LinesActionPerformed
        printLines(100);
    }//GEN-LAST:event_buttonPrint100LinesActionPerformed

    private void buttonPrint10LinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrint10LinesActionPerformed
        printLines(10);
    }//GEN-LAST:event_buttonPrint10LinesActionPerformed

    private void buttonPrint1LineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrint1LineActionPerformed
        printLines(1);
    }//GEN-LAST:event_buttonPrint1LineActionPerformed

    private void buttonMoveCursorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoveCursorActionPerformed
        TerminalSize terminalSize = scrollingAwtTerminal.getTerminalSize();
        Random random = new Random();
        scrollingAwtTerminal.setCursorPosition(random.nextInt(terminalSize.getColumns()), random.nextInt(terminalSize.getRows()));
        scrollingAwtTerminal.flush();
    }//GEN-LAST:event_buttonMoveCursorActionPerformed

    private void printLines(int howMany) {
        Random random = new Random();
        String selection = "abcdefghijklmnopqrstuvxyzåäö";
        for(int i = 0; i < howMany; i++) {
            int words = random.nextInt(10) + 1;
            for(int j = 0; j < words; j++) {
                int length = random.nextInt(10) + 2;
                for(int k = 0; k < length; k++) {
                    scrollingAwtTerminal.putCharacter(selection.charAt(random.nextInt(selection.length())));
                }
                scrollingAwtTerminal.putCharacter(' ');
            }
            scrollingAwtTerminal.putCharacter('\n');
        }
        scrollingAwtTerminal.flush();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScrollingAWTTerminalTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ScrollingAWTTerminalTest().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonMoveCursor;
    private javax.swing.JButton buttonPrint100Lines;
    private javax.swing.JButton buttonPrint10Lines;
    private javax.swing.JButton buttonPrint1Line;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelTerminalContainer;
    // End of variables declaration//GEN-END:variables
}
