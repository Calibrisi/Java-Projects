package dealornodeal;
import javax.swing.JOptionPane;

public class DealOrNoDealMain {

    
        public static void pickCases(Cases mycase, Cases valuecases) {
            
            for(int i = 0; i < casesToPick ; i++){
            String t[] = mycase.casesleft();
            String values = valuecases.valuesleft();
            int n = JOptionPane.showOptionDialog(null,
                values,
                "What case do you want? Pick " + (casesToPick - i) + " more",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, t, t[1]);
            int location = mycase.location(n);
            int value = mycase.ValueOfCase(location);
            JOptionPane.showMessageDialog(null, "This case has " + value + " in it");
            mycase.setLocation(location);
            valuecases.findvalue(value);
            }
    }
    
    public static int casesToPick = 6;
    public static void main(String[] args) {
        
        Cases test = new Cases();
        test.shuffle();
        
        Cases test2 = new Cases();
        
        boolean choose = true;
        int value = 0;
        while(choose){
            pickCases(test,test2);
            
            value = (test2.middleValue() + (int)test2.Average()) / 2;
            int ch = JOptionPane.showConfirmDialog(null, "Your offer is " + value + ". Deal or no deal?");
            if(ch == 0){
                choose = false;
            }
            if(casesToPick > 1){
                casesToPick = casesToPick - 1;
            }
            if(test.numcasesleft() <= 2)
            {
                choose = false;
            }
        }
        JOptionPane.showMessageDialog(null,"Your case had " + test.ValueOfCase(0));
    }
    
}
