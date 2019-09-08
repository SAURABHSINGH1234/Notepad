import java.awt.FileDialog;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Demo extends JFrame implements WindowListener,ActionListener
{
    JTextArea jarea;
    JMenuBar menuBar;
    JMenu mnuFile,mnuEdit,mnuFormat,mnuView,mnuHelp;
    JMenuItem mniNew,mniOpen,mniSave,mniSaveAs,mniClose;
    public Demo()
    {
        setSize(400,400);
        setTitle("Untitled - Notepad");
        
        jarea = new JTextArea();
        menuBar = new JMenuBar();
        mnuFile = new JMenu("File");
        mnuFile.setMnemonic('F');
        
        mnuEdit = new JMenu("Edit");
        mnuFormat = new JMenu("Format");
        mnuView = new JMenu("View");
        mnuHelp = new JMenu("Help");
        
        mniNew = new JMenuItem("New");
        mniOpen = new JMenuItem("Open");
        mniSave = new JMenuItem("Save");
        mniSaveAs = new JMenuItem("SaveAs..");
        mniClose = new JMenuItem("Close");
        
        mnuFile.add(mniNew);
        mnuFile.add(mniOpen);
        mnuFile.add(mniSave);
        mnuFile.add(mniSaveAs);
        mnuFile.addSeparator();
        mnuFile.add(mniClose);
        
        menuBar.add(mnuFile);
        
        add("North",menuBar);
        add(jarea);
    mniNew.addActionListener(this);
    mniOpen.addActionListener(this);
    mniSave.addActionListener(this);
    mniSaveAs.addActionListener(this);
    mniClose.addActionListener(this);
            
        addWindowListener(this);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        new Demo();
    }

    public void windowOpened(WindowEvent e){}
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}

    
    public void actionPerformed(ActionEvent e) 
    {
        Object o = e.getSource();
        FileDialog fd;
        if(o==mniNew)
        {
            jarea.setText("");
            jarea.getFocusListeners();
        }
        else if(o==mniOpen)
        {
            fd = new FileDialog(this,"Open",0);
            fd.setVisible(true);
            try
            {
                FileReader fr = new FileReader(fd.getDirectory()+fd.getFile());
                int data=0;
                String d="";
                while((data=fr.read())!=-1)
                {
                    d = d + (char)data;
                }
                jarea.setText(d);
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            
            
            
        }
        else if(o==mniSave)
        {
            fd = new FileDialog(this,"Save",1);
            fd.setVisible(true);
                        try
            {
                FileWriter fw = new FileWriter(fd.getDirectory()+fd.getFile());
                fw.write(jarea.getText());
                fw.close();
                System.out.println("Save...");
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
            

                        
        }
        else if(o==mniSaveAs)
        {
            jarea.cut();
            //jarea.copy();
            //jarea.paste();
            
            //System.out.println("SaveAs");
        }
        else if(o==mniClose)
        {
            //System.exit(0);
            jarea.selectAll();
        }
    }
}