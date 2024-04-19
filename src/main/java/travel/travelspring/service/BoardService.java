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

import travel.travelspring.domain.Board;
import travel.travelspring.repository.BoardRepository;
import travel.travelspring.repository.BoardSpecification;

@Service
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	// 여행후기 게시글 목록 조회
	public Page<Board> getBoards(int page, int size){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "bno");
		
		return boardRepository.findAll(PageRequest.of(page, size, sort));
	}
	
	
	// 여행후기 게시글 작성 처리
	public void writeBoard(String username, String title, String content, String filename) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setCreateDate(LocalDate.now());
		board.setFilename(filename);
		board.setHit(0L);
		board.setUsername(username);
		board.setReply_count(0L);
		board.setLikeCount(0L);
		
		boardRepository.save(board);
	}
	
	// 여행후기 게시글 상세 조회
	public Optional<Board> getBoardOne(Long bno) {
		return boardRepository.findById(bno);
	}
	
	// 여행후기 게시글 조회수 증가
	public void increaseBoardHit(Long bno) {
		Board board = getBoardOne(bno).get();
		board.setHit(board.getHit() + 1);
		boardRepository.save(board);
	}
	
	// 여행후기 게시글 삭제
	public void deleteBoard(Long bno) {
		boardRepository.deleteById(bno);
	}
	
	// 여행후기 게시글 수정
	public void updateBoard(Long bno, String title, String content, String filename) {
		Board board = getBoardOne(bno).get();
		board.setTitle(title);
		board.setContent(content);
		board.setFilename(filename);
		board.setModifyDate(LocalDate.now());
		
		boardRepository.save(board);
	}
	
	// 여행후기 게시글 검색
	public Page<Board> searchBoardList(int page, int size, String field,String kw){
		Specification<Board> spec = Specification.where(BoardSpecification.likeField(field, kw));
		Sort sort = Sort.by(Sort.Direction.DESC, "bno");
		Pageable pageable = PageRequest.of(page, size, sort);
		return boardRepository.findAll(spec, pageable);
	}
	
	// 여행후기 게시글 인기글 조회
	public List<Board> getBoardLikeList(){
		return boardRepository.findAllByOrderByLikeCountDesc();
	}
}
