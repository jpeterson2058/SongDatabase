/** File: SongDB.java
 * 
 */
/**Import the packages.
 * 
 */
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**Definition of the class SongDB.
 * 
 * @author joshuapeterson
 *
 */
public class SongDatabase extends JFrame implements ActionListener 
{
   /**Declare an ArrayList.
    * 
    */
   private ArrayList<Song> songs;
   
   /**Create labels using JLabel class.
    * 
    */
   private JLabel jlblSelect = new JLabel("Select Song:");
   private JLabel jlblItemCode = new JLabel("Item Code:");
   private JLabel jlblDescription = new JLabel("Description:");
   private JLabel jlblArtist = new JLabel("Artist:");
   private JLabel jlblAlbum = new JLabel("Album: ");
   private JLabel jlblPrice = new JLabel("Price:");
   /**Create a Combobox.
    * 
    */
   private JComboBox<Song> combobox = new JComboBox<Song>();
   /**Create the text fields.
    * 
    */
   private JTextField jtfItemCode = new JTextField(20);
   private JTextField jtfDescription = new JTextField(20);
   private JTextField jtfArtist = new JTextField(20);
   private JTextField jtfAlbum = new JTextField(20);
   private JTextField jtfPrice = new JTextField(20);
   /**Create the buttons.
    * 
    */
   private JButton jbtnAdd = new JButton("Add");
   private JButton jbtnEdit = new JButton("Edit");
   private JButton jbtnDelete = new JButton("Delete");
   private JButton jbtnAccept = new JButton("Accept");
   private JButton jbtnCancel = new JButton("Cancel");
   private JButton jbtnExit = new JButton("Exit");
   /**Create 8 panels in the Frame.
    * 
    */
   private JPanel panel1 = new JPanel();
   private JPanel panel2 = new JPanel();
   private JPanel panel3 = new JPanel();
   private JPanel panel4 = new JPanel();
   private JPanel panel5 = new JPanel();
   private JPanel panel6 = new JPanel();
   private JPanel panel7 = new JPanel();
   private JPanel panel8 = new JPanel();

   /**Definition of the Constructor with parameter
   ArrayList of songs.
   */
   public SongDatabase(ArrayList<Song> list) {
       /**Create an ArrayList.
        * 
        */
       songs = new ArrayList<Song>();
       // Find the size of the ArrayList.
       if (list.size() > 0) {
           /**If the size is greater than 0, then add
           the song in the combo box and sons List.
           */
           for (Song song : list) {
               songs.add(song);
               combobox.addItem(song);
           }
       }
       /**If condition fails, then add the fist song.
        * 
        */
       else {
           Song oneSong = new Song("BT012", "Yellow Submarine", "The Beatles", "Beatles Greatest Hits 1", 1.99);

           songs.add(oneSong);
           combobox.addItem(oneSong);
       }
       /**Add a combo box in the panel1.
        * 
        */
       panel1.add(jlblSelect);
       panel1.add(combobox);
       /**Add ItemCode in the panel2.
        * 
        */
       panel2.add(jlblItemCode);
       panel2.add(jtfItemCode);
       /**Add Description in the panel3.
        * 
        */
       panel3.add(jlblDescription);
       panel3.add(jtfDescription);
       /**Add Artist in the panel4.
        * 
        */
       panel4.add(jlblArtist);
       panel4.add(jtfArtist);
       /**Add Album in the panel5.
        * 
        */
       panel5.add(jlblAlbum);
       panel5.add(jtfAlbum);
       /**Add Price in the panel6.
        * 
        */
       panel6.add(jlblPrice);
       panel6.add(jtfPrice);
       /**Add buttons Add, Delete, Accept,and Cancel
       in the panel7.
       */
       panel7.add(jbtnAdd);
       panel7.add(jbtnEdit);
       panel7.add(jbtnDelete);
       panel7.add(jbtnAccept);
       panel7.add(jbtnCancel);
       /**Add Exit in the panel8.
        * 
        */
       panel8.add(jbtnExit);
       /**Set all the panels as Flow layout.
        * 
        */
       setLayout(new FlowLayout());
       add(panel1);
       add(panel2);
       add(panel3);
       add(panel4);
       add(panel5);
       add(panel6);
       add(panel7);
       add(panel8);
       /**Select a song in the combobox.
        * 
        */
       Song currentSong = (Song) combobox.getSelectedItem();
       showSong(currentSong);
       /**If the user press Accept or Cancel button,
       then the operation is cancelled.
       */
       jbtnAccept.setEnabled(false);
       jbtnCancel.setEnabled(false);
       /**Call the method addActionListener().
        * 
        */
       combobox.addActionListener(this);
       jbtnAdd.addActionListener(this);
       jbtnEdit.addActionListener(this);
       jbtnDelete.addActionListener(this);
       jbtnAccept.addActionListener(this);
       jbtnCancel.addActionListener(this);
       jbtnExit.addActionListener(this);
   }// End of the class SongsDB.
   
       /**Definition of the method actionPerformed().
        * 
        */

   public void actionPerformed(ActionEvent ae) 
   {
       /**create an object source and call
       getSource() method.
       */
       Object source = ae.getSource();
       Song currentSong;
       /**Define a boolean variable.
        * 
        */
       boolean isNewSong = false;
       /**If the user clicks the combobox, then
       a song in the combobox get selected.
       */
       if (source == combobox) 
       {
           currentSong = (Song) combobox.getSelectedItem();
           showSong(currentSong);

       }
       /**If the user clicks the Add button, then
       Itemcode, Description, Artist, Album,
       and Price fields are enabled and the
       buttons Add, Edit, and Delete are disabled.
       */
       else if (source == jbtnAdd) 
       {
           isNewSong = true;

           jtfItemCode.setText("");
           jtfDescription.setText("");
           jtfArtist.setText("");
           jtfAlbum.setText("");
           jtfPrice.setText("0");

           jtfItemCode.setEnabled(true);
           jtfDescription.setEnabled(true);
           jtfArtist.setEnabled(true);
           jtfAlbum.setEnabled(true);
           jtfPrice.setEnabled(true);

           jbtnAdd.setEnabled(false);
           jbtnEdit.setEnabled(false);
           jbtnDelete.setEnabled(false);

           jbtnAccept.setEnabled(true);
           jbtnCancel.setEnabled(true);
       }
       /**If the user clicks the Edit button, then the
       fields Description, Artist, Album, and Price
       are enabled and the buttons Add, Delete,
       Edit are disabled.the buttons Accept and
       Cancel are enabled.
       */
       else if (source == jbtnEdit) {
           isNewSong = false;

           jtfDescription.setEnabled(true);
           jtfArtist.setEnabled(true);
           jtfAlbum.setEnabled(true);
           jtfPrice.setEnabled(true);

           jbtnAdd.setEnabled(false);
           jbtnEdit.setEnabled(false);
           jbtnDelete.setEnabled(false);

           jbtnAccept.setEnabled(true);
           jbtnCancel.setEnabled(true);
       }
       /**if the user clicks the Delete button
       the selected song is deleted.
       */
       else if (source == jbtnDelete) {
       }
       /**if the user clicks the Accept button then
       a new song is added into the comobobox list.
       */
       else if (source == jbtnAccept) 
       {
           if (isNewSong) 
           {
               currentSong = new Song(jtfItemCode.getText(), jtfDescription.getText(), jtfArtist.getText(),
                       jtfAlbum.getText(), Double.parseDouble(jtfPrice.getText()));

               songs.add(currentSong);
               combobox.addItem(currentSong);

               combobox.setSelectedIndex(songs.size() - 1);
               currentSong = (Song) combobox.getSelectedItem();
               showSong(currentSong);
           } 
           else 
           {
        	   		jbtnAccept.setEnabled(false);
        	   		jbtnCancel.setEnabled(false);

        	   		jbtnAdd.setEnabled(true);
        	   		jbtnEdit.setEnabled(true);
        	   		jbtnDelete.setEnabled(true);
           }
           
       }
       		else if (source == jbtnCancel) 
       		{
       			jbtnAccept.setEnabled(false);
                jbtnCancel.setEnabled(false);

                jbtnAdd.setEnabled(true);
                jbtnEdit.setEnabled(true);
                jbtnDelete.setEnabled(true);
             }
       
       		else 
       {
           System.exit(0);
       }
   }// End of the method actionPerformed().

   /**Definition of the method showSong().
    * 
    * @param currentSong
    */
   private void showSong(Song currentSong) {
       /**Display the contents in the fields ItemCode,
       Description, Artist, Album, and Price.
       */
       jtfItemCode.setText(currentSong.getItemCode());
       jtfDescription.setText(currentSong.getDescription());
       jtfArtist.setText(currentSong.getArtist());
       jtfAlbum.setText(currentSong.getAlbum());
       jtfPrice.setText("" + currentSong.getPrice());
       /**Disable the fields.
        * 
        */
       jtfItemCode.setEnabled(false);
       jtfDescription.setEnabled(false);
       jtfArtist.setEnabled(false);
       jtfAlbum.setEnabled(false);
       jtfPrice.setEnabled(false);
   }// End of the method showSong().

   /**Definition of the main() method.
    * 
    * @param args
    */
   public static void main(String[] args) {
       /**Create an object of the ArrayList.
        * 
        */
       ArrayList<Song> list = new ArrayList<Song>();

       Scanner input = new Scanner(System.in);
       /**Prompt the user to enter the database
       file name.
       */
       System.out.print("Enter the database file name:");
       /**Read the file name.
        * 
        */
       String filename = input.nextLine();
       String choice = "";

       try {

           Scanner infile = new Scanner(new File("joshuapeterson/Intro to Java Programming/12 Module 12/java SongDB.data"));
           /**Read the contents of the file.
            * 
            */
           while (infile.hasNextLine()) {
               String line = infile.nextLine();
               String[] tokens = line.split(",");
               /**Add the songs in the file to the
               songs list.
               */
               Song newSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3], Double.parseDouble(tokens[4]));
               list.add(newSong);
           }

       }
       /**If the file is not found, then prompt
       the user to create a new database.
       */
       catch (FileNotFoundException e) 
       {
           System.out.println("The database " + "file does not exist.");
           System.out.print("Do you want to" + " create a new one? (Y/N): ");
           choice = input.nextLine();
       }

       if (choice.charAt(0) == 'Y' || choice.charAt(0) == 'y') {
           /**if the user wants to create a
           database, then create a frame.
           */
    	   SongDatabase sdb = new SongDatabase(list);
           /**Set the title.
            * 
            */
           sdb.setTitle("Song Database");
           /**Set the dimensions of the frame.
            * 
            */
           sdb.setSize(400, 350);
           sdb.setVisible(true);
           sdb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       } else 
       
       {
           System.out.println("Thank you");
       }
   }
}// End of the main() method.
