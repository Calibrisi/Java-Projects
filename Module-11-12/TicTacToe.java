package tictactoe;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TicTacToe {
    private JFrame window;
    private char[][] theGrid;
    private JButton[][] theGridButtons;
    private boolean dualPlayer = false;
    
        
    private class GridButtonHandler implements ActionListener {
        private int i;
        private int j;
        public void actionPerformed(ActionEvent e) {
            if(dualPlayer){
                Toggle(i, j);
            }
            else{
                if(theGrid[i][j] == '-'){
                    theGrid[i][j] = 'O';
                    ComputerMove();
                }
            }
            
            RedrawGrid();
      }
        public GridButtonHandler(int i_, int j_){
            i = i_;
            j = j_;
        }
        
   }
    
    
    private class P1ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dualPlayer = false;
      }
   }
    
    private class P2ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dualPlayer = true;
      }
   }
    
    private class clearButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                theGrid[i][j] = '-';
                }
            }
            RedrawGrid();
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
    
        JButton P1 = new JButton("1 Player");
        P1.addActionListener(new P1ButtonHandler());
        JButton P2 = new JButton("2 Player");
        P2.addActionListener(new P2ButtonHandler());
        JButton clear = new JButton("clear");
        clear.addActionListener(new clearButtonHandler());
      
      
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(4,3));
        content.add(P1);
        content.add(P2);
        content.add(clear);
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
