package kr.ac.kopo.kopo28.service;

import java.util.List;

import kr.ac.kopo.kopo28.dao.BoardItemDao;
import kr.ac.kopo.kopo28.dao.BoardItemDaoImpl;
import kr.ac.kopo.kopo28.domain.BoardItem;

public class BoardItemServiceImpl implements BoardItemService {
	
	private BoardItemDao boardItemDao = new BoardItemDaoImpl();

	@Override
	public void create(BoardItem boardItem) {
		boardItemDao.create(boardItem);
		
	}

	@Override
	public BoardItem selectOne(int id) {		
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll() {
		// TODO Auto-generated method stub
		return boardItemDao.selectAll();
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
