package travel.travelspring.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import travel.travelspring.domain.Board3;
import travel.travelspring.repository.Board3Repository;
import travel.travelspring.repository.BoardSpecification;

@Service
public class Board3Service {
	
	private final Board3Repository board3Repository;
	
	public Board3Service(Board3Repository board3Repository) {
		this.board3Repository = board3Repository;
	}

	// Q&A 게시글 목록 조회
	public Page<Board3> getBoards(int page, int size){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "bno3");
		
		return board3Repository.findAll(PageRequest.of(page, size, sort));
	}
	
	
	// Q&A 게시글 작성 처리
	public void writeBoard(String username, String title, String content, String filename) {
		Board3 board = new Board3();
		board.setTitle3(title);
		board.setContent3(content);
		board.setCreateDate3(LocalDate.now());
		board.setFilename3(filename);
		board.setHit3(0L);
		board.setUsername3(username);
		board.setReply_count3(0L);
		board.setLikeCount3(0L);
		
		board3Repository.save(board);
	}
	
	// Q&A 게시글 상세 조회
	public Optional<Board3> getBoardOne(Long bno) {
		return board3Repository.findById(bno);
	}
	
	// Q&A 게시글 조회수 증가
	public void increaseBoardHit(Long bno) {
		Board3 board = getBoardOne(bno).get();
		board.setHit3(board.getHit3() + 1);
		board3Repository.save(board);
	}
	
	// Q&A 게시글 삭제
	public void deleteBoard(Long bno) {
		board3Repository.deleteById(bno);
	}
	
	// Q&A 게시글 수정
	public void updateBoard(Long bno, String title, String content, String filename) {
		Board3 board = getBoardOne(bno).get();
		board.setTitle3(title);
		board.setContent3(content);
		board.setFilename3(filename);
		board.setModifyDate3(LocalDate.now());
		
		board3Repository.save(board);
	}
	
	// Q&A 게시글 검색
	public Page<Board3> searchBoardList(int page, int size, String field,String kw){
		Specification<Board3> spec = Specification.where(BoardSpecification.likeField3(field, kw));
		Sort sort = Sort.by(Sort.Direction.DESC, "bno3");
		Pageable pageable = PageRequest.of(page, size, sort);
		return board3Repository.findAll(spec, pageable);
	}
	
	// Q&A 게시글 인기글 조회
	public List<Board3> getBoardLikeList(){
		return board3Repository.findAllByOrderByLikeCount3Desc();
	}
}
