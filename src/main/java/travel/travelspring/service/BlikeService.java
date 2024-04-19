package travel.travelspring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import travel.travelspring.domain.Blike;
import travel.travelspring.domain.Board;
import travel.travelspring.repository.BlikeRepository;
import travel.travelspring.repository.BoardRepository;

@Service
public class BlikeService {
	
	private final BlikeRepository blikeRepository;
	private final BoardRepository boardRepository;

	public BlikeService(BlikeRepository blikeRepository, BoardRepository boardRepository) {
		this.blikeRepository = blikeRepository;
		this.boardRepository = boardRepository;
	}
	
	// 좋아요 등록
	public void like(Long bno, String username) {
		Blike blike = new Blike();
		blike.setBno(bno);
		blike.setUsername(username);
		blikeRepository.save(blike);
		
		// 게시글에 좋아요 수 반영
		Board board = boardRepository.findById(bno).get();
		board.setLikeCount(board.getLikeCount() + 1);
		boardRepository.save(board);
	}
	
	// 이미 등록된 좋아요 있는지 확인
	public boolean checkLikeByBno(Long bno, String username) {
		return blikeRepository.existsByBnoAndUsername(bno, username);
	}
	
	// 좋아요 삭제
	public void deleteLike(Long bno, String username) {
		Blike like = blikeRepository.findByBnoAndUsername(bno, username);
		blikeRepository.delete(like);
		
		// 게시글에 좋아요 수 반영
		Board board = boardRepository.findById(bno).get();
		board.setLikeCount(board.getLikeCount() - 1);
		boardRepository.save(board);
	}
	
	// 자신이 누른 좋아요 전체 조회
	public List<Blike> getMyLikes(String username){
		return blikeRepository.findAllByUsernameOrderByLikenoDesc(username);
	}
	
}
