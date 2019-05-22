package tictactoe;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTacToe {
    private JFrame window;
    private String wordA;
    private JFormattedTextField input;
    private TextField output;
    private DecimalFormat inputFormat;
    private char[][] theGrid;
    private JButton[][] theGridButtons;
    
        
    private class GridButtonHandler implements ActionListener {
        private int i;
        private int j;
        public void actionPerformed(ActionEvent e) {
            Toggle(i, j);
            RedrawGrid();
      }
        public GridButtonHandler(int i_, int j_){
            i = i_;
            j = j_;
        }
        
   }
    
    private void OnePlayer(){
        
    }
    
    private void TwoPlayer(){
        
    }
    
    private class P1ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
      }
   }
    
    private class P2ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
      }
   }
    
    public TicTacToe(){
        theGrid = new char[3][3];
        theGridButtons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                theGrid[i][j] = '-';
                theGridButtons[i][j] = new JButton();
                theGridButtons[i][j].addActionListener(new GridButtonHandler(i, j));
            }
        }
    }
    
    private void Toggle(int i, int j){
        switch(theGrid[i][j]){
                case 'O':
                    theGrid[i][j] = 'X';
                    break;
                case 'X':
                    theGrid[i][j] = '-';
                    break;
                 case '-':
                 default:
                    theGrid[i][j] = 'O';
                    break;
            }
    }
    
    private void RedrawGrid(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                theGridButtons[i][j].setText(String.format("%c", theGrid[i][j]));
            }
        }
    }
    
    private boolean isThereAMove(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(theGrid[i][j] == '-') return true;
            }
        }
       return false; 
    }
    
    private void GameOver(){
        
    }
    
    private void ComputerMove(){
        if(isThereAMove() == false){
            GameOver();
            return;
        }
        while(true){
            int i = new Random().nextInt(3);
            int j = new Random().nextInt(3);
            if(theGrid[i][j] == '-'){
                theGrid[i][j] = 'X';
                return;
            }
        }
    }
    
    public void run() {
      
//      JButton USDbutt = new JButton("euro to USD");
//      JButton eurobutt = new JButton("USD to euro");
//      USDButtonHandler USDlistener = new USDButtonHandler();
//      USDbutt.addActionListener(USDlistener);
//      P1ButtonHandler eurolistener = new P1ButtonHandler();
//      eurobutt.addActionListener(eurolistener);
//      inputFormat = new DecimalFormat("0.00");
//      input = new JFormattedTextField(inputFormat);
//      output = new TextField();
      
      
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(4,3));
        content.add(new JButton("1 Player"));
        content.add(new JButton("2 Player"));
        content.add(new JButton());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                content.add(theGridButtons[i][j]);
            }
        }

      window = new JFrame("Tic tac toe yay!");
      
      window.setContentPane(content);
      window.setSize(300,400);
      window.setLocation(500,500);
      window.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        TicTacToe c = new TicTacToe();
        c.run();
    }
    


}

//make other 3 buttons
//in 2 player, toggle
//in 1 player, computer move
