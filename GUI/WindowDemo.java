/**
 * Created by CedricCheng on 2016/2/16.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class WindowDemo
{
    private Frame f;
    private TextField tf;
    private Button but_1;
    private Button but_2;
    private TextArea ta;

    WindowDemo(){
        init();
    }
    public void init(){
        f = new Frame("my window");
        f.setBounds(300,100,600,500);
        f.setLayout(new FlowLayout());

        tf = new TextField(60);

        but_1 = new Button("Trans");
        but_2 = new Button("Filter");

        ta = new TextArea(25,70);

        f.add(tf);
        f.add(but_1);
        f.add(but_2);
        f.add(ta);

        myEvent();
        f.setVisible(true);
    }
    private void myEvent(){
        but_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String dirPath = tf.getText();

                File dir = new File(dirPath);
                if(dir.exists() && dir.isDirectory()){
                    tf.setText("");		//清空前一次目录
                    String[] names = dir.list();
                    for(String name : names){
                        ta.append(name+"\r\n");
                    }
                }
                else{
                    ta.setText("Directory does not exists!");
                }

                //ta.setText(text);
                //System.out.println(text);
                //tf.setText("");
            }
        });

        but_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String text = ta.getText();
                ta.setText("");
                String[] textArray = text.split("\r\n");
                for(String name : textArray){
                    if(name.endsWith(".java")){
                        ta.append(name+"\r\n");
                    }
                }
            }
        });


            f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
        }

    public static void main(String[] args){
        new WindowDemo();
    }
}
