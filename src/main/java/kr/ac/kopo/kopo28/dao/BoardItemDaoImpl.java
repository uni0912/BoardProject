package kr.ac.kopo.kopo28.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo28.domain.BoardItem;

public class BoardItemDaoImpl implements BoardItemDao {
	
	private Connection conn;	 
    private static String URL="jdbc:mysql://192.168.23.73/kopoctc"; 
    private static String USERNAME="root"; 
    private static String PASSWORD="kopoctc";
    
    public BoardItemDaoImpl(){    	 
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
	public void create(BoardItem boardItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardItem selectOne(int boardID) {
		String sql = "select * from boardItem where boardID = ?;";		
		PreparedStatement pstmt = null;
		BoardItem boardItem = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, boardID);
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				boardItem = new BoardItem();
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getString(3));
				boardItem.setContent(rset.getString(4));
				boardItem.setBoardID(rset.getInt(5));		
			}			
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return boardItem;
	}

	@Override
	public List<BoardItem> selectAll() {
		String sql = "select * from boardItem;";
		List<BoardItem> boardItems = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		try {			
			stmt = conn.createStatement(); 
		    rset = stmt.executeQuery(sql);
		    
			    while (rset.next()) {
			    	BoardItem boardItem = new BoardItem();
			    	boardItem.setId(rset.getInt(1));
			    	boardItem.setTitle(rset.getString(2));
			    	boardItem.setDate(rset.getString(3));
			    	boardItems.add(boardItem);
			    }
			    rset.close();
			    stmt.close();
			    conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return boardItems;
	}

	@Override
	public void update(BoardItem boardItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardItem boardItem) {
		// TODO Auto-generated method stub
		
	}


}
