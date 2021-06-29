package kr.ac.kopo.kopo28.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo28.domain.Board;

public class BoardDaoImpl implements BoardDao {		
	
	private static BoardDaoImpl instance;

	public static BoardDaoImpl getInstance(){
		if(instance == null)
			instance = new BoardDaoImpl();
		return instance;
	}
	
	private Connection conn;	 
    private static String URL="jdbc:mysql://192.168.23.73/kopoctc"; 
    private static String USERNAME="root"; 
    private static String PASSWORD="kopoctc";

    public BoardDaoImpl(){    	 
        try {      
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
        } catch (ClassNotFoundException e) { 
            e.printStackTrace(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }
    
	@Override
	public void create(Board board) {
		String sql = "insert into board (title) value (?);";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	@Override
	public Board selectOne(int id) {
		
		return null;
	}

	@Override
	public List<Board> selectAll() {		
		String sql = "select * from board;";		
		List<Board> boards = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		try {			
			stmt = conn.createStatement();  //생성하기
			rset = stmt.executeQuery(sql);
			    while (rset.next()) {
			    	Board board = new Board();
			    	board.setId(rset.getInt(1));
			    	board.setTitle(rset.getString(2));			    	
			    	boards.add(board);
			    }
			    rset.close();
			    stmt.close();
			    conn.close();
		}  catch (SQLException e) {
			// TODO: handle exception
		}  finally {
			
		}
		return boards;		
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

}
