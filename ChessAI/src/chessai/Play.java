/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessai;

/**
 *
 * @author karan venkatesh
 */
public class Play {
    ChessAI board=new ChessAI();
    int move=11;
    String unit="";
    int score=0;
    void copy(Play p)
    {
        
        board.copy(p.board);
        move=p.move;
        unit=p.unit;
        score=p.score;
    }
}
