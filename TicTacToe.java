import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {

    Random random=new Random();
    JFrame frame=new JFrame("Tic Tac Toe");
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textFiled=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;



    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textFiled.setBackground(Color.CYAN);
        textFiled.setForeground(Color.BLACK);
        textFiled.setFont(new Font("Ink Free",Font.BOLD,70));
        textFiled.setHorizontalAlignment(SwingConstants.CENTER);
        textFiled.setText("TIC-TAC-TOE");
        textFiled.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.GRAY);

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        title_panel.add(textFiled);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("O");
                        player1_turn=false;
                        textFiled.setText("X turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn=true;
                        textFiled.setText("O turn");
                        check();
                    }
                }
            }
        }

    }
    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1_turn=true;
            textFiled.setText("X Turn");
        }
        else{
            player1_turn=false;
            textFiled.setText("O Turn");
        }

    }
    public void check(){
        if((buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")){
            XWins(0,1,2);

        }
        if((buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")){
            XWins(3,4,5);

        }
        if((buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")){
            XWins(6,7,8);

        }
        if((buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")){
            XWins(0,3,6);

        }
        if((buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")){
            XWins(1,4,7);

        }
        if((buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")){
            XWins(2,4,8);

        }
        if((buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")){
            XWins(0,5,8);

        }
        if((buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")){
            XWins(2,4,6);

        }
        if((buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")){
            OWins(0,1,2);

        }
        if((buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")){
            OWins(3,4,5);

        }
        if((buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")){
            OWins(6,7,8);

        }
        if((buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")){
            OWins(0,3,6);

        }
        if((buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")){
            OWins(1,4,7);

        }
        if((buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")){
            OWins(2,4,8);

        }
        if((buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")){
            OWins(0,5,8);

        }
        if((buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")){
            OWins(2,4,6);

        }

    }
    public void XWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textFiled.setText("X wins");

    }
    public void OWins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textFiled.setText("O wins");

    }
}
