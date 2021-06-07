package kr.ac.kopo.kopo28.service;

import java.util.List;

import kr.ac.kopo.kopo28.domain.Board;

public interface BoardService {
	void create(Board board);
	Board selectOne(int id);
	List<Board> selectAll();
	void update(Board board);
	void delete(Board board);
}
