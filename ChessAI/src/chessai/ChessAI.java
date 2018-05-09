/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessai;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.HashMap;
import javax.swing.JLabel;

/**
 *
 * @author karan venkatesh
 */
public class ChessAI {

    IntObj br1 = new IntObj(), br2 = new IntObj(), bk1 = new IntObj(), bk2 = new IntObj(), bb1 = new IntObj(), bb2 = new IntObj(), bk = new IntObj(), bq = new IntObj(), wr1 = new IntObj(), wr2 = new IntObj(), wk1 = new IntObj(), wk2 = new IntObj(), wb1 = new IntObj(), wb2 = new IntObj(), wk = new IntObj(), wq = new IntObj();
    IntObj[] wp = new IntObj[9];
    IntObj[] bp = new IntObj[9];

    String player;

    HashMap<String, IntObj> bs = new HashMap<>();

    
    
    public ChessAI() {
        for (int i = 0; i < 9; i++) {
            wp[i] = new IntObj();
            bp[i] = new IntObj();
        }
    }

    void setup_board() {
        br1.value = 11;
        bk1.value = 12;
        bb1.value = 13;
        bk.value = 14;
        bq.value = 15;
        bb2.value = 16;
        bk2.value = 17;
        br2.value = 18;
        bp[1].value = 21;
        bp[2].value = 22;
        bp[3].value = 23;
        bp[4].value = 24;
        bp[5].value = 25;
        bp[6].value = 26;
        bp[7].value = 27;
        bp[8].value = 28;
        bp[1].first = 0;
        bp[2].first = 0;
        bp[3].first = 0;
        bp[4].first = 0;
        bp[5].first = 0;
        bp[6].first = 0;
        bp[7].first = 0;
        bp[8].first = 0;
        wr1.value = 81;
        wk1.value = 82;
        wb1.value = 83;
        wk.value = 84;
        wq.value = 85;
        wb2.value = 86;
        wk2.value = 87;
        wr2.value = 88;
        wp[1].value = 71;
        wp[2].value = 72;
        wp[3].value = 73;
        wp[4].value = 74;
        wp[5].value = 75;
        wp[6].value = 76;
        wp[7].value = 77;
        wp[8].value = 78;
        wp[1].first = 0;
        wp[2].first = 0;
        wp[3].first = 0;
        wp[4].first = 0;
        wp[5].first = 0;
        wp[6].first = 0;
        wp[7].first = 0;
        wp[8].first = 0;

        /*
    Black Peices s11-s18
    Black Pawns s21-s28
    White Peices s81-s88
    White Pawns s71-s78
    Rooks are ending with 1 and 8
    Knight with 2 and 7
    Bishop with 3 and 6
    The Black King is 4 and Queen is 5
    The White King is 4 and Queen is 5
         */
        //Black peices
        bs.put("s11", br1);
        bs.put("s12", bk1);
        bs.put("s13", bb1);
        bs.put("s14", bk);
        bs.put("s15", bq);
        bs.put("s16", bb2);
        bs.put("s17", bk2);
        bs.put("s18", br2);
        //White Peices
        bs.put("s81", wr1);
        bs.put("s82", wk1);
        bs.put("s83", wb1);
        bs.put("s84", wk);
        bs.put("s85", wq);
        bs.put("s86", wb2);
        bs.put("s87", wk2);
        bs.put("s88", wr2);
        //Black Pawns
        bs.put("s21", bp[1]);
        bs.put("s22", bp[2]);
        bs.put("s23", bp[3]);
        bs.put("s24", bp[4]);
        bs.put("s25", bp[5]);
        bs.put("s26", bp[6]);
        bs.put("s27", bp[7]);
        bs.put("s28", bp[8]);
        //White Pawns
        bs.put("s71", wp[1]);
        bs.put("s72", wp[2]);
        bs.put("s73", wp[3]);
        bs.put("s74", wp[4]);
        bs.put("s75", wp[5]);
        bs.put("s76", wp[6]);
        bs.put("s77", wp[7]);
        bs.put("s78", wp[8]);
        player="W";
    }
    
    int countmove(String val)
    {
        int[] a=new int[64];
        
        if (val.charAt(1) == '7' || val.charAt(1) == '2') {
            return 6;
                    }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '8' || val.charAt(2) == '1')) {
            return 14;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '7' || val.charAt(2) == '2')) {
            return 8;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '6' || val.charAt(2) == '3'))
        {
            
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '5')) {
            return 42;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '4')) {
            return 9;
        }
        
        return 0;
    }
    
    int posmove(String val,int index)
    {
        int x=bs.get(val).value%10,y=bs.get(val).value/10,temp,temp1,temp2;
         if (val.charAt(1) == '7' || val.charAt(1) == '2') {
             
            
            
               if(y==7)
               {
                   temp=((index-1)+x)+(y-(index/3)-1)*10;
                    return temp;
               }
            
               else if (y==2)
            {
                temp=((index-1)+x)+(y+(index/3)+1)*10;
                return temp;
            }
            
        }
         else if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '8' || val.charAt(2) == '1')) {
            if(index<7)
            {
                temp=index+1+y*10;
                 return temp;
            }
            else if(index>=7)
            {
                temp=x+(index%7+1)*10;
                 return temp;      
            }
            
            
              
        }
          else if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '7' || val.charAt(2) == '2')) {
           
            
              temp=(index%2)*2-1;//-1,1,-1,1,-1,1...
              temp1=(index/4)*2-1;//-1,-1,-1,-1,1,1...
              temp2=(index/2)%2;//0,0,1,1,0,0,1,1...
              temp= (x+temp*(temp2*2+(temp2+1)%2*1))+(y+temp1*(temp2*1+(temp2+1)%2*2))*10;
              if((temp%10>0&&temp%10<9)&&(temp/10>0&&temp/10<9))
              {return temp;}
              
        }
         else if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '6' || val.charAt(2) == '3')) 
         {
             
             if(index<7)//LU
             {
                 index=index%7+1;
                 temp=(x-index)%10+10*(y-index);
             }
             else if(index>=7&&index<14)//RU
             {
                 index=index%7+1;
                 temp=(x+index)%10+10*(y-index);
             }
             else if(index>=14&&index<21)//RD
             {
                 index=index%7+1;
                 temp=(x+index)%10+10*(y+index);
             }
             else//LD
             {
                 index=index%7+1;
                 temp=(x-index)%10+10*(y+index);
             }
             if((temp%10>0&&temp%10<9)&&(temp/10>0&&temp/10<9))
              {return temp;}
             }
          else if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '5') ) 
          {
            if(index<7)
            {
                temp=index+1+y*10;
                 return temp;
            }
            else if(index>=7&&index<14)
            {
                temp=x+(index%7+1)*10;
                 return temp;      
            }
             else if(index>=14&&index<21)//LU
             {
                 index=index%7+1;
                 temp=(x-index)%10+10*(y-index);
             }
             else if(index>=21&&index<28)//RU
             {
                 index=index%7+1;
                 temp=(x+index)%10+10*(y-index);
             }
             else if(index>=28&&index<35)//RD
             {
                 index=index%7+1;
                 temp=(x+index)%10+10*(y+index);
             }
             else//LD
             {
                 index=index%7+1;
                 temp=(x-index)%10+10*(y+index);
             }
             if((temp%10>0&&temp%10<9)&&(temp/10>0&&temp/10<9))
              {return temp;}
             }
           
          else if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '4') ) 
          {
              temp2=index%3-1;
              temp1=index/3-1;
              temp=x+temp1+(y+temp2)*10;
               if((temp%10>0&&temp%10<9)&&(temp/10>0&&temp/10<9))
               {return temp;}
          }
                     
        
        
        return -1;
    }

    int value(String val) {
        if (val.charAt(1) == '7' || val.charAt(1) == '2') {
            return 1;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '8' || val.charAt(2) == '1')) {
            return 5;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '7' || val.charAt(2) == '6' || val.charAt(2) == '3' || val.charAt(2) == '2')) {
            return 3;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '5')) {
            return 8;
        }
        if ((val.charAt(1) == '8' || val.charAt(1) == '1') && (val.charAt(2) == '4')) {
            return 14;
        }
        return 0;
    }

    boolean valid(String unit_mov) {
        int flag = 0;
        if ((unit_mov.charAt(0) == 'B' || unit_mov.charAt(0) == 'W')) {
            for (int i = 0; i <= 8; i++) {
                if (unit_mov.substring(1).equalsIgnoreCase("p" + i)) {
                    // System.out.println("Valid Peice");
                    flag++;
                }
            }
            if (unit_mov.substring(1).equalsIgnoreCase("r1") || unit_mov.substring(1).equalsIgnoreCase("r2") || unit_mov.substring(1).equalsIgnoreCase("k1") || unit_mov.substring(1).equalsIgnoreCase("k2") || unit_mov.substring(1).equalsIgnoreCase("b1") || unit_mov.substring(1).equalsIgnoreCase("b2") || unit_mov.substring(1).equalsIgnoreCase("k") || unit_mov.substring(1).equalsIgnoreCase("q")) {
                // System.out.println("Valid Peice");
                flag++;
            }
        }
        if (flag == 0) {
            //System.out.println("Invalid Peice");  
            return false;
        }
        return true;

    }
    
    void copy(ChessAI a)
    {
        
        br1.value = a.br1.value;
        bk1.value = a.bk1.value;
        bb1.value = a.bb1.value;
        bk.value = a.bk.value;
        bq.value = a.bq.value;
        bb2.value = a.bb2.value;
        bk2.value = a.bk2.value;
        br2.value = a.br2.value;
        bp[1].value = a.bp[1].value;
        bp[2].value = a.bp[2].value;
        bp[3].value = a.bp[3].value;
        bp[4].value = a.bp[4].value;
        bp[5].value = a.bp[5].value;
        bp[6].value = a.bp[6].value;
        bp[7].value = a.bp[7].value;
        bp[8].value = a.bp[8].value;
        bp[1].first = a.bp[1].first;
        bp[2].first = a.bp[2].first;
        bp[3].first = a.bp[3].first;
        bp[4].first = a.bp[4].first;
        bp[5].first = a.bp[5].first;
        bp[6].first = a.bp[6].first;
        bp[7].first = a.bp[7].first;
        bp[8].first = a.bp[8].first;
        wr1.value = a.wr1.value;
        wk1.value = a.wk1.value;
        wb1.value = a.wb1.value;
        wk.value = a.wk.value;
        wq.value = a.wq.value;
        wb2.value = a.wb2.value;
        wk2.value = a.wk2.value;
        wr2.value = a.wr2.value;
        wp[1].value = a.wp[1].value;
        wp[2].value = a.wp[2].value;
        wp[3].value = a.wp[3].value;
        wp[4].value = a.wp[4].value;
        wp[5].value = a.wp[5].value;
        wp[6].value = a.wp[6].value;
        wp[7].value = a.wp[7].value;
        wp[8].value = a.wp[8].value;
        wp[1].first = a.wp[1].first;
        wp[2].first = a.wp[2].first;
        wp[3].first = a.wp[3].first;
        wp[4].first = a.wp[4].first;
        wp[5].first = a.wp[5].first;
        wp[6].first = a.wp[6].first;
        wp[7].first = a.wp[7].first;
        wp[8].first = a.wp[8].first;

         //Black peices
        bs.put("s11", br1);
        bs.put("s12", bk1);
        bs.put("s13", bb1);
        bs.put("s14", bk);
        bs.put("s15", bq);
        bs.put("s16", bb2);
        bs.put("s17", bk2);
        bs.put("s18", br2);
        //White Peices
        bs.put("s81", wr1);
        bs.put("s82", wk1);
        bs.put("s83", wb1);
        bs.put("s84", wk);
        bs.put("s85", wq);
        bs.put("s86", wb2);
        bs.put("s87", wk2);
        bs.put("s88", wr2);
        //Black Pawns
        bs.put("s21", bp[1]);
        bs.put("s22", bp[2]);
        bs.put("s23", bp[3]);
        bs.put("s24", bp[4]);
        bs.put("s25", bp[5]);
        bs.put("s26", bp[6]);
        bs.put("s27", bp[7]);
        bs.put("s28", bp[8]);
        //White Pawns
        bs.put("s71", wp[1]);
        bs.put("s72", wp[2]);
        bs.put("s73", wp[3]);
        bs.put("s74", wp[4]);
        bs.put("s75", wp[5]);
        bs.put("s76", wp[6]);
        bs.put("s77", wp[7]);
        bs.put("s78", wp[8]);
    }
    
    String converter(String bloc)
    {
        String convert="";
              if(bloc.charAt(1)=='1'||bloc.charAt(1)=='2')
              {
                  convert=convert+"B";
                  if(bloc.charAt(1)=='2')
                  {
                     convert=convert+"P"+bloc.charAt(2); 
                  }
                  else
                  {
                    if(bloc.charAt(2)=='1'||bloc.charAt(2)=='8')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"R"+con;
                    }
                    else if(bloc.charAt(2)=='2'||bloc.charAt(2)=='7')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"K"+con;                        
                    }
                    else if(bloc.charAt(2)=='3'||bloc.charAt(2)=='6')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"B"+con;
                    }
                    else if(bloc.charAt(2)=='4')
                    {
                        convert=convert+"K";                        
                    }
                    else if(bloc.charAt(2)=='5')
                    {
                        convert=convert+"Q";
                    }
                  }
              }
              else
              {
                  convert=convert+"W";
                  if(bloc.charAt(1)=='7')
                  {
                     convert=convert+"P"+bloc.charAt(2); 
                  }
                  else
                  {
                    if(bloc.charAt(2)=='1'||bloc.charAt(2)=='8')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"R"+con;
                    }
                    else if(bloc.charAt(2)=='2'||bloc.charAt(2)=='7')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"K"+con;                        
                    }
                    else if(bloc.charAt(2)=='3'||bloc.charAt(2)=='6')
                    {
                        int con=(Integer.parseInt(bloc.charAt(2)+"")/5)+1;
                        convert=convert+"B"+con;
                    }
                    else if(bloc.charAt(2)=='4')
                    {
                        convert=convert+"K";                        
                    }
                    else if(bloc.charAt(2)=='5')
                    {
                        convert=convert+"Q";
                    }
                  }
              }
        return convert;
    }
    
    String revert(String bloc)
    {
        String convert="s";
        int t1,t2;
              if(bloc.charAt(0)=='W')
              {
                  if(bloc.charAt(1)=='P'){
                  convert=convert+"7"+bloc.charAt(2);
                    }
                  else if(bloc.charAt(1)=='K'&&bloc.length()==3)
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=2+(t1-1)*5;
                      convert=convert+"8"+t1;
                  }
                  else if(bloc.charAt(1)=='R')
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=1+(t1-1)*7;
                      convert=convert+"8"+t1;
                  }
                  else if(bloc.charAt(1)=='B')
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=3+(t1-1)*3;
                      convert=convert+"8"+t1;
                  }
                  else if(bloc.charAt(1)=='K'&&bloc.length()==2)
                  {
                     
                      convert=convert+"84";
                  }
                  else if(bloc.charAt(1)=='Q'&&bloc.length()==2)
                  {
                      
                      convert=convert+"85";
                  }
              }
              else if(bloc.charAt(0)=='B')
              {
                  if(bloc.charAt(1)=='P'){
                  convert=convert+"2"+bloc.charAt(2);
                    }
                  else if(bloc.charAt(1)=='K'&&bloc.length()==3)
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=2+(t1-1)*5;
                      convert=convert+"1"+t1;
                  }
                  else if(bloc.charAt(1)=='R')
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=1+(t1-1)*7;
                      convert=convert+"1"+t1;
                  }
                  else if(bloc.charAt(1)=='B')
                  {
                      t1=Integer.parseInt(bloc.charAt(2)+"");
                      t1=3+(t1-1)*3;
                      convert=convert+"1"+t1;
                  }
                  else if(bloc.charAt(1)=='K'&&bloc.length()==2)
                  {
                     
                      convert=convert+"14";
                  }
                  else if(bloc.charAt(1)=='Q'&&bloc.length()==2)
                  {
                      
                      convert=convert+"15";
                  }
              }
        return convert;
    }
    
     boolean bcheck(ChessAI x)
    {
        ChessAI a=new ChessAI();
        a.copy(x);
       
         for (int i = 0; i < 32; i++) {
           a.copy(x);
           String bloc="";
            int q1, q2;
            if (i < 16) {
                q1 = i / 8 + 1;
                q2 = (i % 8) + 1;
                bloc = "s" + q1 + q2;
            }
            if (i >= 16) {
                q1 = i / 8 + 5;
                q2 = ((i % 8) + 1);
                bloc = "s" + q1 + q2;
            }
            
            for(int j=0;j<64;j++)
            {
                
               a.copy(x);
               int q3 = j/ 8 + 1;
               int q4 = (j % 8) + 1;
               int q5 = q3*10+q4;
               
              //System.out.println("Peice "+bloc+" to "+q5);
              String convert=converter(bloc);
             
             
             if(a.bs.get(bloc).value!=q5&&a.bs.get(bloc).value!=-1&&a.wk.value==q5)
             {
               if(a.move(convert, q5)!=0)
               {
                 
                   if(a.wk.value==-1)
                   {
                       return true;
                   }
               }
             }
               
            }
         }
             
            
             

           
        
                //ChessAI a=x;
        
        return false;
    }
    
    boolean wcheck(ChessAI x)
    {
        ChessAI a=new ChessAI();
        a.copy(x);
       
         for (int i = 0; i < 32; i++) {
           a.copy(x);
           String bloc="";
            int q1, q2;
            if (i < 16) {
                q1 = i / 8 + 1;
                q2 = (i % 8) + 1;
                bloc = "s" + q1 + q2;
            }
            if (i >= 16) {
                q1 = i / 8 + 5;
                q2 = ((i % 8) + 1);
                bloc = "s" + q1 + q2;
            }
          
            for(int j=0;j<64;j++)
            {
                
               a.copy(x);
               int q3 = j/ 8 + 1;
               int q4 = (j % 8) + 1;
               int q5 = q3*10+q4;
              
              String convert=converter(bloc);
              
           
             if(a.bs.get(bloc).value!=q5&&a.bs.get(bloc).value!=-1&&a.bk.value==q5)
             {
               if(a.move(convert, q5)!=0)
               {
                  
                   if(a.bk.value==-1)
                   {
                       return true;
                   }
               }
             }
               
            }
         }
             
            
             

           
        
                //ChessAI a=chessai.board.c1;
        
        return false;
    }

    String colision(int b) {
        String bloc = "";
        for (int i = 0; i < 32; i++) {
            bloc = "";
            int q1, q2;
            if (i < 16) {
                q1 = i / 8 + 1;
                q2 = (i % 8) + 1;
                bloc = "s" + q1 + q2;
            }
            if (i >= 16) {
                q1 = i / 8 + 5;
                q2 = ((i % 8) + 1);
                bloc = "s" + q1 + q2;
            }

            if (bs.get(bloc).value == b) {
                return bloc;
            }
        }
        return "miss";
    }
    
    int score(ChessAI c)
    {
        int score=0;
        ChessAI a=new ChessAI();
        for (int i = 0; i < 32; i++) {
           a.copy(c);
           String bloc="";
            int q1, q2;
            if (i < 16) {
                q1 = i / 8 + 1;
                q2 = (i % 8) + 1;
                bloc = "s" + q1 + q2;
            }
            if (i >= 16) {
                q1 = i / 8 + 5;
                q2 = ((i % 8) + 1);
                bloc = "s" + q1 + q2;
            }
            if(i<16&&a.bs.get(bloc).value!=-1)
            {
               score=score+value(bloc);
            }
            else if(i>=16&&a.bs.get(bloc).value!=-1)
            {
                score=score-value(bloc);
            }
        }
        return score;
    }
    
    Play blackai(int deep,ChessAI a)
    {
      
        Play p=new Play();
        p.board=new ChessAI();
        Play temp=new Play();
        int score1=0,score2=-666,score3=666;
        
        Play max=new Play();
        max.board=new ChessAI();
        temp.board=new ChessAI();
        p.board.copy(a);
        temp.board.copy(p.board);
        if(deep%2==0&&deep>=0)
        {
         
        for (int i = 0; i < 16; i++) 
        {
            //p.board.copy(temp.board);
           
            String bloc = "";
            String bloc2="";
            int q1, q2;
            q1 = i / 8 + 1;
            q2 = (i % 8) + 1;
            bloc = "s" + q1 + q2;
            bloc2=converter(bloc);
            for(int j=0;j<64;j++)
            {
            int q6=0;
            p.board.copy(temp.board);
            int q3 = j/ 8 + 1;
            int q4 = (j % 8) + 1;
            int q5 = q3*10+q4;
            p.move=q5;
            p.unit=bloc;
            
            if(p.board.bs.get(bloc).value!=q5)
            {
          
           
            q6=p.board.move(bloc2, q5);
            
           
            if(q6!=0)
            {
                
                p.copy(blackai(deep-1,p.board));
                score1=p.board.score(p.board);
               // System.out.println("Move is "+bloc2+" to loc "+q5+" deep is "+deep+" gives score "+p.score);
                if(score1>score2)
                {
                    
                    score2=score1;
                    max.board.copy(p.board);
                    max.score=p.score;
                    max.move=q5;
                    max.unit=bloc;
                }
                
            }
            
            }
           
            
            }

        }
        System.out.println("deepth "+deep+" max unit "+max.unit+" goes to "+max.move+" giving best score "+max.score);
        return max;
        }
        else if(deep%2==1&&deep>=0)
        {
         
        for (int i = 16; i < 32; i++) 
        {
           // p.board.copy(a);
            String bloc = "";
            String bloc2="";
            int q1, q2;
            q1 = i / 8 + 5;
            q2 = ((i % 8) + 1);
            bloc = "s" + q1 + q2;
            bloc2=converter(bloc);
            for(int j=0;j<64;j++)
            {
            int q6=0;
            p.board.copy(temp.board);
            int q3 = j/ 8 + 1;
            int q4 = (j % 8) + 1;
            int q5 = q3*10+q4;
            p.move=q5;
            p.unit=bloc;
            
            if(p.board.bs.get(bloc).value!=q5)
            {
           
           
            q6=p.board.move(bloc2, q5);
            
            
            if(q6!=0)
            {
                
               
                p.copy(blackai(deep-1,p.board));
               // System.out.println("Move is "+bloc2+" to loc "+q5+" deep "+deep+" gives score "+p.score);
                score1=p.board.score(p.board);
                if(p.score<score3)
                {
                   // System.out.println("Move is "+bloc2+" to loc "+q5+" deep "+deep+" gives score "+p.score); 
                    score3=score1;
                    max.board.copy(p.board);
                    max.score=p.score;
                    max.move=q5;
                    max.unit=bloc;
                }
                
            }
             
            }
            
            }

        }
        System.out.println("deepth "+deep+" max unit "+max.unit+" goes to "+max.move+" giving best score "+max.score);
        
        return max;
        }
        else
        {
          
        p.board.copy(a);
        p.score=score(p.board);
        p.move=0;
        p.unit="";
        
        return p;
        }
        
    }
    
     Play blackai2(int deep,ChessAI a)
    {
       int moves;
        Play p=new Play();
        p.board=new ChessAI();
        Play temp=new Play();
        int score1=0,score2=-666,score3=666;
        
        Play max=new Play();
        max.board=new ChessAI();
        temp.board=new ChessAI();
        p.board.copy(a);
        temp.board.copy(p.board);
        if(deep%2==0&&deep>=0)
        {
         
        for (int i = 0; i < 16; i++) 
        {
            //p.board.copy(temp.board);
           
            String bloc = "";
            String bloc2="";
            int q1, q2;
            q1 = i / 8 + 1;
            q2 = (i % 8) + 1;
            bloc = "s" + q1 + q2;
            bloc2=converter(bloc);
            moves=countmove(bloc);
            for(int j=0;j<moves;j++)
            {
            int q6=0;
            p.board.copy(temp.board);
            int q5 = posmove(bloc,j);
            p.move=q5;
            p.unit=bloc;
            if(p.board.bs.get(bloc).value!=q5)
            {
          
           
            q6=p.board.move(bloc2, q5);
            
           
            if(q6!=0)
            {
                
                p.copy(blackai2(deep-1,p.board));
                score1=p.board.score(p.board);
               // System.out.println("Move is "+bloc2+" to loc "+q5+" deep is "+deep+" gives score "+p.score);
                if(score1>score2)
                {
                    
                    score2=score1;
                    max.board.copy(p.board);
                    max.score=p.score;
                    max.move=q5;
                    max.unit=bloc;
                }
                
            }
            
            }
           
            
            }

        }
        System.out.println("deepth "+deep+" max unit "+max.unit+" goes to "+max.move+" giving best score "+max.score);
        return max;
        }
        else if(deep%2==1&&deep>=0)
        {
         
        for (int i = 16; i < 32; i++) 
        {
           // p.board.copy(a);
            String bloc = "";
            String bloc2="";
            int q1, q2;
            q1 = i / 8 + 5;
            q2 = ((i % 8) + 1);
            bloc = "s" + q1 + q2;
            bloc2=converter(bloc);
            moves=countmove(bloc);
            for(int j=0;j<moves;j++)
            {
            int q6=0;
            p.board.copy(temp.board);
            int q5 = posmove(bloc,j);
            p.move=q5;
            p.unit=bloc;
            
            if(p.board.bs.get(bloc).value!=q5)
            {
           
           
            q6=p.board.move(bloc2, q5);
            
            
            if(q6!=0)
            {
                
               
                p.copy(blackai2(deep-1,p.board));
               // System.out.println("Move is "+bloc2+" to loc "+q5+" deep "+deep+" gives score "+p.score);
                score1=p.board.score(p.board);
                if(p.score<score3)
                {
                   // System.out.println("Move is "+bloc2+" to loc "+q5+" deep "+deep+" gives score "+p.score); 
                    score3=score1;
                    max.board.copy(p.board);
                    max.score=p.score;
                    max.move=q5;
                    max.unit=bloc;
                }
                
            }
             
            }
            
            }

        }
        System.out.println("deepth "+deep+" max unit "+max.unit+" goes to "+max.move+" giving best score "+max.score);
        
        return max;
        }
        else
        {
          
        p.board.copy(a);
        p.score=score(p.board);
        p.move=0;
        p.unit="";
        
        return p;
        }
        
    }

    int move(String s, int des) {
        int ret;
        int x, y;
        int t = 1;
        int counter=0;
        String hit = colision(des);
        if(bs.get(revert(s)).value!=-1&&des!=-1){
        if (s.length() == 3) {
            t = Integer.parseInt(s.charAt(2) + "");
        }
        

        if (s.charAt(0) == 'W') {
            if (s.charAt(1) == 'P')//If it is a pawn
            {
                if (((des / 10 - wp[t].value / 10 == -1) || ((des / 10 - wp[t].value / 10 == -2) && (wp[t].first == 0)))&&wp[t].pqueen==0)//foward movement limits
                {
                    if (wp[t].value % 10 == des % 10)//same line
                    {

                        if (hit.equals("miss")) // if not blocking
                        {
                            if(des/10==1)
                        {
                            wp[t].pqueen=1;
                        }
                            ret = wp[t].value;
                            wp[t].value = des;
                            wp[t].first = 1;
                            return ret;
                        } else {
                            return 0;
                        }
                    }
                }
                if (wp[t].value / 10 == des / 10 + 1 && (wp[t].value % 10 - des % 10 == 1 || wp[t].value % 10 - des % 10 == -1)&&(wp[t].pqueen==0))//Cut cheking for pawn
                {
                    if (!hit.equals("miss") && (hit.charAt(1) == '1' || hit.charAt(1) == '2')) {

                        if(des/10==1)
                        {
                            wp[t].pqueen=1;
                            
                        }
                        bs.get(hit).value = -1;
                        ret = wp[t].value;
                        wp[t].value = des;
                        
                        wp[t].first = 1;
                        return ret;

                        //System.out.println("bs.get value "+bs.get(hit));
                        //System.out.println("value at the key adress"+ bp[2]);
                        //return Integer.parseInt(hit.substring(1, 2));
                    }
                }
                if(wp[t].pqueen==1)
                {
                    {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=wp[t].value;
                y1=iloc/10;
                x1=iloc%10;
               // ln("Init loc "+iloc+" .");
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                         
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                           // System.out.println(x1+i*f1+(y1+i*f2)*10);
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=wp[t].value;
                        wp[t].value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=wp[t].value;
                        wp[t].value=des;
                        return ret;
                    }
                                    
                
                }
                else if (wp[t].value / 10 == des / 10) 
                    {
                        
                        if (wp[t].value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=wp[t].value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                            
                        if(colision(j)!="miss")
                        {
                            
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=wp[t].value;
                            wp[t].value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wp[t].value;
                                wp[t].value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (wp[t].value % 10 == des % 10) 
                    {
                        if (wp[t].value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=wp[t].value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                            
                        if(colision(j)!="miss")
                        {
                           
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=wp[t].value;
                            wp[t].value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wp[t].value;
                                wp[t].value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                
                
             }
                }
            } 
            else if (s.charAt(1) == 'R')//If it is a rook
            {
                
                
                if (s.charAt(2) == '1') 
                {
                   
                    if (wr1.value / 10 == des / 10) 
                    {
                        
                        if (wr1.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=wr1.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                            
                        if(colision(j)!="miss")
                        {
                          
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                           
                            
                            if(hit=="miss")
                            {
                            ret=wr1.value;
                            wr1.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                               
                                bs.get(hit).value=-1;
                                ret=wr1.value;
                                wr1.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (wr1.value % 10 == des % 10) 
                    {
                        if (wr1.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=wr1.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                            
                        if(colision(j)!="miss")
                        {
                        
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=wr1.value;
                            wr1.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wr1.value;
                                wr1.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                }
                if (s.charAt(2) == '2') 
                {
                 
                    if (wr2.value / 10 == des / 10) 
                    {
                       
                        if (wr2.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=wr2.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                         
                        if(colision(j)!="miss")
                        {
                          
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                           
                            
                            if(hit=="miss")
                            {
                            ret=wr2.value;
                            wr2.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wr2.value;
                                wr2.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (wr2.value % 10 == des % 10) 
                    {
                        if (wr2.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=wr2.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                           
                        if(colision(j)!="miss")
                        {
                           
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=wr2.value;
                            wr2.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wr2.value;
                                wr2.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                }
                }
             else if (s.charAt(1) == 'K'&&s.length()==3)//If it is a Knight
             {
                 
                 int temp1;
                temp1 = Integer.parseInt(s.charAt(2)+"");
                temp1=(temp1-1)*5+2;
                int iloc=bs.get("s8"+temp1).value;
              
                if(iloc%10-des%10==2||iloc%10-des%10==-2)
                {
                if(iloc/10-des/10==1||iloc/10-des/10==-1)
                {
                    if(hit=="miss")
                    {
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }
                                    
                }
                }
                else if(iloc%10-des%10==1||iloc%10-des%10==-1)
                {
                if(iloc/10-des/10==2||iloc/10-des/10==-2)
                {
                              if(hit=="miss")
                    {
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }        
                }
                }
             }
            else if (s.charAt(1) == 'B')//If it is a Bishop
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                temp1 = Integer.parseInt(s.charAt(2)+"");
                temp1=(temp1)*3;
                int iloc=bs.get("s8"+temp1).value;
                y1=iloc/10;
                x1=iloc%10;
               
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                        
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                       
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s8"+temp1).value;
                        bs.get("s8"+temp1).value=des;
                        return ret;
                    }
                                    
                
                }
                
             }
            else if (s.charAt(1) == 'Q')//If it is a Queen
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=bs.get("s85").value;
                y1=iloc/10;
                x1=iloc%10;
             
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                         
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                           
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=bs.get("s85").value;
                        bs.get("s85").value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s85").value;
                        bs.get("s85").value=des;
                        return ret;
                    }
                                    
                
                }
                else if (wq.value / 10 == des / 10) 
                    {
                       
                        if (wq.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=wq.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                            
                        if(colision(j)!="miss")
                        {
                          
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                          
                            
                            if(hit=="miss")
                            {
                            ret=wq.value;
                            wq.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                              
                                bs.get(hit).value=-1;
                                ret=wq.value;
                                wq.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (wq.value % 10 == des % 10) 
                    {
                        if (wq.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=wq.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                            
                        if(colision(j)!="miss")
                        {
                   
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                           
                            
                            if(hit=="miss")
                            {
                            ret=wq.value;
                            wq.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '1' || hit.charAt(1) == '2'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=wq.value;
                                wq.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                
                
             }
            else if (s.charAt(1) == 'K'&&s.length()==2)//If it is a King
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=bs.get("s84").value;
                y1=iloc/10;
                x1=iloc%10;
               
               
                if((des%10-x1==0||des%10-x1==1||des%10-x1==-1)&&(des/10-y1==0||des/10-y1==1||des/10-y1==-1))
                {
                 if(hit=="miss")
                    {
                        ret=bs.get("s84").value;
                        bs.get("s84").value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='1'||hit.charAt(1)=='2')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s84").value;
                        bs.get("s84").value=des;
                        return ret;
                    }
                }
                      
             }
            
        } else if (s.charAt(0) == 'B') //If it is Black
        {
            if (s.charAt(1) == 'P')//If it is a pawn
            {
                if (((des / 10 - bp[t].value / 10 == 1) || ((des / 10 - bp[t].value / 10 == 2) && (bp[t].first == 0)))&&bp[t].pqueen==0)//foward movement limits
                {
                    if (bp[t].value % 10 == des % 10)//same line
                    {

                        if (hit.equals("miss")) // if not blocking
                        {
                            if(des/10==8)
                        {
                            bp[t].pqueen=1;
                        }
                            ret = bp[t].value;
                            bp[t].value = des;
                            bp[t].first = 1;
                            return ret;
                        } else {
                            return 0;
                        }
                    }
                }
                if ((bp[t].value / 10 == des / 10 - 1 && (bp[t].value % 10 - des % 10 == 1 || bp[t].value % 10 - des % 10 == -1))&&bp[t].pqueen==0)//Cut cheking for pawn
                {
                    if (!hit.equals("miss") && (hit.charAt(1) == '7' || hit.charAt(1) == '8')) 
                    {
                        if(des/10==8)
                        {
                            bp[t].pqueen=1;
                        }

                        bs.get(hit).value = -1;
                        ret = bp[t].value;
                        bp[t].value = des;
                        
                        bp[t].first = 1;
                        return ret;

                        //System.out.println("bs.get value "+bs.get(hit));
                        //System.out.println("value at the key adress"+ bp[2]);
                        //return Integer.parseInt(hit.substring(1, 2));
                    }
                }
                if(bp[t].pqueen==1)
                {
                    {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=bp[t].value;
                y1=iloc/10;
                x1=iloc%10;
               // System.out.println("Init loc "+iloc+" .");
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                         
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                           // System.out.println(x1+i*f1+(y1+i*f2)*10);
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=bp[t].value;
                        bp[t].value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bp[t].value;
                        bp[t].value=des;
                        return ret;
                    }
                                    
                
                }
                else if (bp[t].value / 10 == des / 10) 
                    {
                     
                        if (bp[t].value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=bp[t].value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                           
                        if(colision(j)!="miss")
                        {
                            
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                          
                            
                            if(hit=="miss")
                            {
                            ret=bp[t].value;
                            bp[t].value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                              
                                bs.get(hit).value=-1;
                                ret=bp[t].value;
                                bp[t].value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (bp[t].value % 10 == des % 10) 
                    {
                        if (bp[t].value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=bp[t].value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                            
                        if(colision(j)!="miss")
                        {
                         
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=bp[t].value;
                            bp[t].value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=bp[t].value;
                                bp[t].value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                
                
             }
                }
            } 
            else if (s.charAt(1) == 'R')//If it is a rook
            {
              
                
                if (s.charAt(2) == '1') 
                {
                  
                    if (br1.value / 10 == des / 10) 
                    {
                        
                        if (br1.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=br1.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                            
                        if(colision(j)!="miss")
                        {
                           
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                           
                            
                            if(hit=="miss")
                            {
                            ret=br1.value;
                            br1.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=br1.value;
                                br1.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (br1.value % 10 == des % 10) 
                    {
                        if (br1.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=br1.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                           
                        if(colision(j)!="miss")
                        {
                          
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                          
                            
                            if(hit=="miss")
                            {
                            ret=br1.value;
                            br1.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                              
                                bs.get(hit).value=-1;
                                ret=br1.value;
                                br1.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                }
                if (s.charAt(2) == '2') 
                {
                    
                    if (br2.value / 10 == des / 10) 
                    {
                   
                        if (br2.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=br2.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                           
                        if(colision(j)!="miss")
                        {
                          
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                          
                            
                            if(hit=="miss")
                            {
                            ret=br2.value;
                            br2.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                           
                                bs.get(hit).value=-1;
                                ret=br2.value;
                                br2.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (br2.value % 10 == des % 10) 
                    {
                        if (br2.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=br2.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                           
                        if(colision(j)!="miss")
                        {
                            
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                  
                            
                            if(hit=="miss")
                            {
                            ret=br2.value;
                            br2.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=br2.value;
                                br2.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                }
                }
             else if (s.charAt(1) == 'K'&&s.length()==3)//If it is a Knight
             {
                 
                 int temp1;
                temp1 = Integer.parseInt(s.charAt(2)+"");
                temp1=(temp1-1)*5+2;
                int iloc=bs.get("s1"+temp1).value;
              
                if(iloc%10-des%10==2||iloc%10-des%10==-2)
                {
                if(iloc/10-des/10==1||iloc/10-des/10==-1)
                {
                    if(hit=="miss")
                    {
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }
                                    
                }
                }
                else if(iloc%10-des%10==1||iloc%10-des%10==-1)
                {
                if(iloc/10-des/10==2||iloc/10-des/10==-2)
                {
                              if(hit=="miss")
                    {
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }        
                }
                }
             }
            else if (s.charAt(1) == 'B')//If it is a Bishop
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                temp1 = Integer.parseInt(s.charAt(2)+"");
                temp1=(temp1)*3;
                int iloc=bs.get("s1"+temp1).value;
                y1=iloc/10;
                x1=iloc%10;
             
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                      
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                          
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s1"+temp1).value;
                        bs.get("s1"+temp1).value=des;
                        return ret;
                    }
                                    
                
                }
                
             }
            else if (s.charAt(1) == 'Q')//If it is a Queen
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=bs.get("s15").value;
                y1=iloc/10;
                x1=iloc%10;
              
               for(int i=1;i<=8;i++)
               {
                  if(x1-i==des%10&&y1+i==des/10)
                  {
                   f1=-1;
                   f2=1;
                  }
                  else if(x1-i==des%10&&y1-i==des/10)
                  {
                   f1=-1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1-i==des/10)
                  {
                   f1=1;
                   f2=-1;
                  }
                  else if(x1+i==des%10&&y1+i==des/10)
                  {
                   f1=1;
                   f2=1;
                  }
                         
               }
                
                if(f1!=0&&f2!=0)
                {
                    for(int i=1;x1+i*f1!=des%10&&y1+i*f2!=des/10;i++)
                    {
                         
                        if(colision(x1+i*f1+(y1+i*f2)*10)!="miss")
                        {
                          
                            return 0;
                        }
                    }
                
                    if(hit=="miss")
                    {
                        ret=bs.get("s15").value;
                        bs.get("s15").value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s15").value;
                        bs.get("s15").value=des;
                        return ret;
                    }
                                    
                
                }
                else if (bq.value / 10 == des / 10) 
                    {
                       
                        if (bq.value % 10 > des % 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                        for(int i=bq.value%10+x;i!=des%10;i+=x)
                        {
                            int j=(des/10)*10+i;
                           
                        if(colision(j)!="miss")
                        {
                           
                            counter=1;
                        }
                        }
                        if(counter==0)
                        {
                         
                            
                            if(hit=="miss")
                            {
                            ret=bq.value;
                            bq.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                               
                                bs.get(hit).value=-1;
                                ret=bq.value;
                                bq.value=des;
                                return ret;
                            }
                        }
                        counter=0;

                    }
                    else if (bq.value % 10 == des % 10) 
                    {
                        if (bq.value / 10 > des / 10) 
                        {
                            x = -1;
                        } else {
                            x = 1;
                        }
                         for(int i=bq.value/10+x;i!=des/10;i+=x)
                        {
                            int j=des%10+i*10;
                           
                        if(colision(j)!="miss")
                        {
                           
                            counter=1;
                        }
                        }
                        
                        
                        if(counter==0)
                        {
                            
                            
                            if(hit=="miss")
                            {
                            ret=bq.value;
                            bq.value=des;
                            return ret;
                            }
                            else if( (hit.charAt(1) == '7' || hit.charAt(1) == '8'))
                            {
                                
                                bs.get(hit).value=-1;
                                ret=bq.value;
                                bq.value=des;
                                return ret;
                            }
                        }
                        counter=0;


                    }
                
                
             }
            else if (s.charAt(1) == 'K'&&s.length()==2)//If it is a King
             {
                 
                 int temp1,f1=0,f2=0,x1,y1;
                
                int iloc=bs.get("s14").value;
                y1=iloc/10;
                x1=iloc%10;
               
               
                if((des%10-x1==0||des%10-x1==1||des%10-x1==-1)&&(des/10-y1==0||des/10-y1==1||des/10-y1==-1))
                {
                 if(hit=="miss")
                    {
                        ret=bs.get("s14").value;
                        bs.get("s14").value=des;
                        return ret;
                    }
                    else if(hit.charAt(1)=='7'||hit.charAt(1)=='8')
                    {
                        bs.get(hit).value=-1;
                        ret=bs.get("s14").value;
                        bs.get("s14").value=des;
                        return ret;
                    }
                }
                      
             }
            

        } else {
            return 0;
        }
        ChessAI a=new ChessAI();
        return 0;
        }
        else{
        return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
    }

}
