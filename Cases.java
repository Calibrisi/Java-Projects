package dealornodeal;

public class Cases {
    private int[] cases;
    
    public Cases()
    {
        cases = new int[27];
        cases[0] = 0;
        cases[1] = 1;
        cases[2] = 2;
        cases[3] = 5;
        cases[4] = 10;
        cases[5] = 25;
        cases[6] = 50;
        cases[7] = 75;
        cases[8] = 100;
        cases[9] = 200;
        cases[10] = 300;
        cases[11] = 400;
        cases[12] = 500;
        cases[13] = 750;
        cases[14] = 1000;
        cases[15] = 5000;
        cases[16] = 10000;
        cases[17] = 25000;
        cases[18] = 50000;
        cases[19] = 75000;
        cases[20] = 100000;
        cases[21] = 200000;
        cases[22] = 300000;
        cases[23] = 400000;
        cases[24] = 500000;
        cases[25] = 750000;
        cases[26] = 1000000;
    }
    
    public String toString()
    {
        String temp = "";
        for (int i = 0; i < cases.length; i++) {
            temp += cases[i] + " ";
            
        }
        return temp;
    }
    
    public int numcasesleft()
    {
        int count = 0;
        for (int i = 1; i < cases.length; i++) {
            if(cases[i] != 0)
                count++;
        }
        return count;
    }
    
    public String[] casesleft()
    {
        int left = numcasesleft();
        String [] toRet = new String[left];
        
        int location = 0;
        
        for (int i = 1; i < cases.length; i++) {
            if(cases[i] != 0)
            {
                toRet[location] = i + "";
                location++;
            }
        }
        return toRet;
    }
    
    public String valuesleft()
    {
       String toRet = "";
       //just started on Day 2 Part B video
        for (int i = 1; i < cases.length; i++) {
            if(cases[i] != 0)
            {
                toRet = toRet + cases[i] + " ";
            }
        }
       
       return toRet;
    }
    
    public void swap(int A, int B)
    {
        int temp = cases[A];
        cases[A] = cases[B];
        cases[B] = temp;
    }
    
    public int location (int number)
    {
        String [] location = this.casesleft();
        String val = location[number];
        int intval = Integer.parseInt(val.trim());
        
        return intval;
    }
    
    public int ValueOfCase (int location)
    {
        return cases [location];
    }
    
    public void findvalue(int value)
    {
        for (int i = 1; i < cases.length; i++) {
            if(cases[i] == value)
            {
                cases[i] = 0;
                break;
            }
            
        }
    }
    
    public void setLocation(int location)
    {
        cases[location] = 0;
    }
    
    public int SumOfValues(int numcasesleft)
    {
        int sum = 0;
        //int avg = 0;
        for (int i = 0; i < numcasesleft; i++) {
            if(cases[i] != 0){
                sum = sum + cases[i];
                //avg = sum / numcasesleft;
            }
        }
        return sum;
    }
    
    public double Average(int SumOfValues)
    {
        int sum = SumOfValues;
        int count = numcasesleft();
        return sum / count;
    }
    
    public int middleValue()
    {
        int value = 0;
        int spot = numcasesleft() / 2;
        int count = 0;
        for (int i = 0; i < cases.length; i++) {
            if(cases[i] > 0){
                count ++;
            }
            
            if(count >= spot){
                value = cases[i];
                break;
            }
                
            
        }
        return value;
    }
    
}
