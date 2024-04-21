package view; // Declares the package name

import javax.swing.*; // Imports Swing classes
import javax.swing.table.DefaultTableModel; // Imports DefaultTableModel class
import java.awt.*; // Imports AWT classes
import java.awt.event.MouseAdapter; // Imports MouseAdapter class for mouse events
import java.awt.event.MouseEvent; // Imports MouseEvent class for mouse events
import java.util.ArrayList; // Imports ArrayList class for collections

public class Layout extends JFrame { // Declares the Layout class which extends JFrame

    public Layout(){ // Constructor for Layout class

    }

    // Method to set up the page layout
    public void pageArt(int width, int height, String title){ // Declares a method to set up the page layout
        setSize(width, height); // Sets the size of the frame
        setTitle(title); // Sets the title of the frame
        setResizable(false); // Sets the frame to be not resizable
        setVisible(true); // Sets the frame to be visible
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2; // Calculates the x-coordinate to center the frame
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2; // Calculates the y-coordinate to center the frame
        setLocation(x, y); // Sets the location of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the default close operation of the frame
    }

    // Method to set the look and feel theme
    public void setTheme(String themeName){ // Declares a method to set the look and feel theme
        for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()){ // Iterates through installed look and feel themes
            if(i.getName().equals(themeName)){ // Checks if the theme name matches the specified theme
                try {
                    UIManager.setLookAndFeel(i.getClassName()); // Sets the look and feel theme
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e); // Throws a runtime exception if an error occurs
                }
            }
        }
    }

    // Method to create a table with specified columns and rows
    public void createTable(DefaultTableModel model, JTable table, Object[] column, ArrayList<Object[]> rows){ // Declares a method to create a table
        model = (DefaultTableModel) table.getModel(); // Gets the table model
        model.setColumnIdentifiers(column); // Sets column identifiers
        table.getTableHeader().setReorderingAllowed(false); // Disallows column reordering

        model.setRowCount(0); // Clears the table content

        if(rows == null){ // Checks if rows are null
            rows = new ArrayList<>(); // Initializes rows if null
        }

        for(Object[] i : rows){ // Iterates through rows
            model.addRow(i); // Adds rows to the table model
        }
    }

    // Method to get the selected row from a table
    public int getSelectedRow(JTable table, int column){ // Declares a method to get the selected row from a table
        int selectId = (int) table.getValueAt(table.getSelectedRow(), column); // Gets the selected row ID
        return selectId; // Returns the selected row ID
    }

    // Method to handle mouse selection in a table
    public void tableMouseSelect(JTable table){ // Declares a method to handle mouse selection in a table
        table.addMouseListener(new MouseAdapter() { // Adds a mouse listener to the table
            @Override
            public void mousePressed(MouseEvent e) { // Handles mouse press event
                int selectrow = table.rowAtPoint(e.getPoint()); // Gets the selected row
                table.setRowSelectionInterval(selectrow, selectrow); // Sets row selection interval
            }
        });
    }
}
