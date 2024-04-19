package travel.travelspring.repository;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import travel.travelspring.domain.Board;
import travel.travelspring.domain.Board1;
import travel.travelspring.domain.Board2;
import travel.travelspring.domain.Board3;
import travel.travelspring.domain.Notice;

public class BoardSpecification {
	
	
	// like 쿼리(게시글 검색용)
	public static Specification<Board> likeField(String field, String kw){
		return new Specification<Board>() {
			@Override
			public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(field), "%" + kw + "%");
			}
		};
	}
	
	// like 쿼리(게시글 검색용) 1
	public static Specification<Board1> likeField1(String field, String kw){
		return new Specification<Board1>() {
			@Override
			public Predicate toPredicate(Root<Board1> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(field), "%" + kw + "%");
			}
		};
	}
	
	// like 쿼리(게시글 검색용) 2
	public static Specification<Board2> likeField2(String field, String kw){
		return new Specification<Board2>() {
			@Override
			public Predicate toPredicate(Root<Board2> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(field), "%" + kw + "%");
			}
		};
	}
	
	// like 쿼리(게시글 검색용) 3
	public static Specification<Board3> likeField3(String field, String kw){
		return new Specification<Board3>() {
			@Override
			public Predicate toPredicate(Root<Board3> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(field), "%" + kw + "%");
			}
		};
	}
	
	// like 쿼리(게시글 검색용) N
	public static Specification<Notice> likeFieldN(String field, String kw){
		return new Specification<Notice>() {
			@Override
			public Predicate toPredicate(Root<Notice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(root.get(field), "%" + kw + "%");
			}
		};
	}
}
