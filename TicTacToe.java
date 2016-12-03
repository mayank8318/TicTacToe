/*
Game of Tic Tac Toe where player plays against computer.
 */
import java.util.*;
public class TicTacToe
{
    Scanner s=new Scanner(System.in);
    String board[][]=new String[3][3];       
    String us,co;

    TicTacToe()
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                //Filling board with Dummy character A
                board[i][j]="A";
            }
        }
        while(true)
        {
            System.out.println("Enter your selected character(X or O)");
            us=s.nextLine();
            System.out.println("Enter computer selected character(X or O)");
            co=s.nextLine();
            if(us.equals("X") && co.equals("O"))
                break;
            if(us.equals("O") && co.equals("X"))
                break;
            System.out.println("Enter the characters properly");
        }
        main();
    }

    void userInput()
    {
        System.out.println("Enter the coordinates");
        while(true)
        {
            try
            {
                int r=s.nextInt();//row input
                int c=s.nextInt();//column input
                if(isLegal(r,c))
                {
                    board[r][c]=us;return;
                }
                else
                {
                    System.out.println("Illegal Move");
                }
            }
            catch(Exception e)
            {
                System.out.println("Enter properly. No mischief.\nEnter again like a Good Boy/Girl");
                s.nextLine();
            }
        }
    }

    //checking illegal move
    boolean isLegal(int r,int c)
    {
        if(board[r][c].equals("A"))
            return true;
        else
            return false;
    }

    public void main()
    {
        int i=1;
        int c2=0;
        int fm=0;//first move 0 for user 1 for computer
        if(co.equals("X"))
        {
            fm=1;
            System.out.println("Computer plays first\n\n");
        }
        else
        {
            System.out.println("User plays first\n\n");
        }

        while(true)
        {           
            if(fm==1)
            {
                if(c2==0)
                    firstMove();

                if(c2!=0)
                    compInput();
                isWin();
                display();
                userInput();
                isWin();
                display();
                c2++;
            }
            else
            {
                userInput();
                isWin();
                display();
                if(c2==0)
                    firstMove();

                if(c2!=0)
                    compInput();
                isWin();
                display();                
                c2++;
            }            
            System.out.println("\n\nTurn "+i);
            i++;
            display();
            boolean b1=isMovePossible();
            if(!b1)
            {
                System.out.println("DRAW");
                for(int o=-200;o<1000000;o++);

                System.out.println("DO YOU WANT TO CONTINUE?ENTER y TO CONTINUE\nANY OTHER KEY TO EXIT");
                s.nextLine();
                String s1=s.nextLine();
                System.out.println(s1);
                if(s1.equalsIgnoreCase("y"))
                {
                    TicTacToe obj=new TicTacToe();
                    System.exit(0);
                }
                else
                {
                    System.exit(0);
                }
            }
        }
    }

    void isWin()
    {
        //Checking User's win
        boolean b=false;
        a:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(us))
                {
                    int k1=i;
                    int k2=j;
                    if(k1==0 && k2==0)
                    {
                        if(board[0][1].equals(us))
                        {
                            if(board[0][2].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }

                        if(board[1][0].equals(us))
                        {
                            if(board[2][0].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {
                            if(board[2][2].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }
                    }

                    if(k1==0&& k2==1)
                    {
                        if(board[1][1].equals(us))
                        {
                            if(board[2][1].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }
                    }

                    if(k1==0&& k2==2)
                    {
                        if(board[0][1].equals(us))
                        {
                            if(board[0][0].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {
                            if(board[2][0].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }

                        if(board[1][2].equals(us))
                        {
                            if(board[2][2].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }
                    }

                    if(k1==1&& k2==0)
                    {                    
                        if(board[1][1].equals(us))
                        {
                            if(board[1][2].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }                                               
                    }

                    if(k1==2&& k2==0)
                    {                    
                        if(board[2][1].equals(us))
                        {
                            if(board[2][2].equals(us))
                            {
                                b=true;
                                break a;
                            }
                        }                                               
                    }
                }
            }
        }

        if(b)
        {
            System.out.println("Congrats you win!!!");
            display();
            for(int o=-200;o<1000000;o++);

            System.out.println("DO YOU WANT TO CONTINUE?ENTER y TO CONTINUE\nANY OTHER KEY TO EXIT");
            s.nextLine();
            String s1=s.nextLine();
            if(s1.equalsIgnoreCase("y"))
            {
                TicTacToe obj=new TicTacToe();
                System.exit(0);
            }
            else
            {
                System.exit(0);
            }
        }

        c:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(co))
                {
                    int k1=i;
                    int k2=j;
                    if(k1==0 && k2==0)
                    {
                        if(board[0][1].equals(co))
                        {
                            if(board[0][2].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }

                        if(board[1][0].equals(co))
                        {
                            if(board[2][0].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }

                        if(board[1][1].equals(co))
                        {
                            if(board[2][2].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }
                    }

                    if(k1==0&& k2==1)
                    {
                        if(board[1][1].equals(co))
                        {
                            if(board[2][1].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }
                    }

                    if(k1==0&& k2==2)
                    {
                        if(board[0][1].equals(co))
                        {
                            if(board[0][0].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }

                        if(board[1][1].equals(co))
                        {
                            if(board[2][0].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }

                        if(board[1][2].equals(co))
                        {
                            if(board[2][2].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }
                    }

                    if(k1==1&& k2==0)
                    {                    
                        if(board[1][1].equals(co))
                        {
                            if(board[1][2].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }                                               
                    }

                    if(k1==2&& k2==0)
                    {                    
                        if(board[2][1].equals(co))
                        {
                            if(board[2][2].equals(co))
                            {
                                b=true;
                                break c;
                            }
                        }                                               
                    }
                }
            }
        }

        if(b)
        {
            System.out.println("YOU LOSE!!!");
            display();
            for(int o=-200;o<1000000;o++);

            System.out.println("DO YOU WANT TO CONTINUE?ENTER y TO CONTINUE\nANY OTHER KEY TO EXIT");
            s.nextLine();
            String s1=s.nextLine();
            if(s1.equalsIgnoreCase("y"))
            {
                TicTacToe obj=new TicTacToe();
                System.exit(0);
            }
            else
            {
                System.exit(0);
            }
        }
    }

    void display()
    {
        System.out.println("\n\nEnd of Turn");
        System.out.println("C1\tC2\tC3\n");

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals("A"))
                    System.out.print("\t");
                else
                    System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }

    void compInput()
    {
        int c=0;
        //Attack
        b:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(co))
                {
                    int k1=i;
                    int k2=j;
                    if(k1==0 && k2==0)
                    {
                        if(board[0][1].equals(co))
                        {                           
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][0].equals(co))
                        {                           
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][0].equals(co))
                        {                            
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][2].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][2].equals(co))
                        {                            
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break b;
                            }
                        }
                    }

                    if(k1==0&& k2==1)
                    {
                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][1].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }
                    }

                    if(k1==0&& k2==2)
                    {
                        if(board[0][1].equals(co))
                        {
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][2].equals(co))
                        {                            
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][0].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][0].equals(co))
                        {                            
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][2].equals(co))
                        {                            
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break b;
                            }
                        }
                    }

                    if(k1==1&& k2==0)
                    {                    
                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][2].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }  
                    }

                    if(k1==1&& k2==2)
                    {                    
                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][0].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }
                    }

                    if(k1==2&& k2==0)
                    {                    
                        if(board[2][1].equals(co))
                        {                           
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][0].equals(co))
                        {                            
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][0].equals(co))
                        {                            
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[2][2].equals(co))
                        {                            
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][2].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }                        
                    }

                    if(k1==2&& k2==1)
                    {                    
                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][1].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }
                    }

                    if(k1==2&& k2==2)
                    {                    
                        if(board[2][1].equals(co))
                        {                            
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;
                                c++;
                                break b;
                            }
                        }   

                        if(board[2][0].equals(co))
                        {                            
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][1].equals(co))
                        {                            
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[0][0].equals(co))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break b;
                            }
                        }

                        if(board[1][2].equals(co))
                        {                            
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break b;
                            }
                        } 

                        if(board[0][2].equals(co))
                        {                            
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break b;
                            }
                        }   
                    }
                }
            }
        }

        if(c>0)
            return;

        //Defence
        a:        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(us))
                {
                    int k1=i;
                    int k2=j;
                    if(k1==0 && k2==0)
                    {
                        if(board[0][1].equals(us))
                        {
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break a;                                 
                            }
                        }

                        if(board[1][0].equals(us))
                        {
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;                           
                                c++;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][2].equals(us))
                        {
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][2].equals(us))
                        {
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][0].equals(us))
                        {
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break a;
                            }
                        }
                    }

                    if(k1==0&& k2==1)
                    {
                        if(board[1][1].equals(us))
                        {                            
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][1].equals(us))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }
                    }

                    if(k1==0&& k2==2)
                    {
                        if(board[0][1].equals(us))
                        {                           
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][2].equals(us))
                        {                           
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][0].equals(us))
                        {
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][2].equals(us))
                        {
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][0].equals(us))
                        {
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }
                    }

                    if(k1==1&& k2==0)
                    {                    
                        if(board[1][1].equals(us))
                        {                           
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break a;
                            }
                        }   

                        if(board[1][2].equals(us))
                        {                           
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }   
                    }

                    if(k1==1&& k2==2)
                    {
                        if(board[1][1].equals(us))
                        {                            
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][0].equals(us))
                        {                            
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }
                    }

                    if(k1==2&& k2==0)
                    {                    
                        if(board[2][1].equals(us))
                        {                            
                            if(isLegal(2,2))
                            {
                                board[2][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][0].equals(us))
                        {
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][0].equals(us))
                        {
                            if(isLegal(1,0))
                            {
                                board[1][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][2].equals(us))
                        {
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][2].equals(us))
                        {
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }
                    }

                    if(k1==2&& k2==1)
                    {                    
                        if(board[1][1].equals(us))
                        {                           
                            if(isLegal(0,1))
                            {
                                board[0][1]=co;
                                c++;
                                break a;
                            }
                        }   

                        if(board[0][1].equals(us))
                        {                           
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }   
                    }

                    if(k1==2&& k2==2)
                    {                    
                        if(board[2][1].equals(us))
                        {                           
                            if(isLegal(2,0))
                            {
                                board[2][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[2][0].equals(us))
                        {                           
                            if(isLegal(2,1))
                            {
                                board[2][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][1].equals(us))
                        {                           
                            if(isLegal(0,0))
                            {
                                board[0][0]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][0].equals(us))
                        {                           
                            if(isLegal(1,1))
                            {
                                board[1][1]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[1][2].equals(us))
                        {                           
                            if(isLegal(0,2))
                            {
                                board[0][2]=co;
                                c++;
                                break a;
                            }
                        }

                        if(board[0][2].equals(us))
                        {                           
                            if(isLegal(1,2))
                            {
                                board[1][2]=co;
                                c++;
                                break a;
                            }
                        }  
                    }
                }
            }
        }

        if(c>0)
        {
            return;
        }

        att:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(co))
                {
                    int k1=i;
                    int k2=j;
                    if(k1==0 && k2==0)
                    {
                        if(isLegal(0,1) && isLegal(0,2))
                        {
                            board[0][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,0) && isLegal(2,0))
                        {
                            board[1][0]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,1) && isLegal(2,2))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==0 && k2==1)
                    {
                        if(isLegal(1,1) && isLegal(2,1))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==0 && k2==2)
                    {
                        if(isLegal(0,1) && isLegal(0,0))
                        {
                            board[0][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,2) && isLegal(2,2))
                        {
                            board[1][2]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,1) && isLegal(2,0))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==1 && k2==0)
                    {
                        if(isLegal(1,1) && isLegal(1,2))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(0,0) && isLegal(2,0))
                        {
                            board[0][0]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==1 && k2==1)
                    {
                        if(isLegal(0,0) && isLegal(2,2))
                        {
                            board[0][0]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(0,2) && isLegal(2,0))
                        {
                            board[0][2]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,0) && isLegal(1,2))
                        {
                            board[1][0]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(0,1) && isLegal(2,1))
                        {
                            board[0][1]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==1 && k2==2)
                    {
                        if(isLegal(1,1) && isLegal(1,0))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(0,2) && isLegal(2,2))
                        {
                            board[0][2]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==2 && k2==0)
                    {
                        if(isLegal(1,0) && isLegal(0,0))
                        {
                            board[0][0]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,1) && isLegal(0,2))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(2,1) && isLegal(2,2))
                        {
                            board[2][2]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==2 && k2==1)
                    {
                        if(isLegal(1,1) && isLegal(0,1))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }
                    }

                    if(k1==2 && k2==2)
                    {
                        if(isLegal(2,1) && isLegal(2,0))
                        {
                            board[2][0]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,1) && isLegal(0,0))
                        {
                            board[1][1]=co;
                            c++;
                            break att;
                        }

                        if(isLegal(1,2) && isLegal(0,2))
                        {
                            board[0][2]=co;
                            c++;
                            break att;
                        }
                    }
                }
            }
        }

        if(c>0)
            return;

        //Defence 1
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(us))
                {
                    int k1=i;
                    int k2=j;
                    int temp[]=isNextLegal();
                    board[temp[0]][temp[1]]=co;
                    return;
                }
            }
        }
    }

    int[] isNextLegal()
    {
        int arr[]=new int[2];
        a:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(isLegal(i,j))
                {
                    arr[0]=i;
                    arr[1]=j;
                    break a;
                }
            }
        }

        return arr;
    }

    boolean isMovePossible()
    {
        boolean b=false;
        a:
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(isLegal(i,j))
                {
                    b=true;
                    break a;
                }
            }
        }
        return b;
    }

    void firstMove()
    {
        int i=0;
        int j=0;
        fr:
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[0].length;j++)
            {
                if(board[i][j].equals(us))
                {
                    break fr;
                }
            }
        }

        if(((i==0) && (j==0 || j==2 )) || ((i==2) && (j==0 || j==2)))
            board[1][1]=co;
        else if(i==1 &&j==1 || i==1 && j==0 || i==1 && j==2 || i==0 && j==1 || i==2 && j==1)
        {
            board[0][0]="0";
        }
        else if(i==1 && j==1)
            board[0][0]=co;
        else
            board[1][1]=co;
    }
}