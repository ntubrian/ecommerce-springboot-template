package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<User> findByUsernameILike(String searchTerm) {
        QUser user = QUser.user;
        BooleanExpression predicate = user.username.toLowerCase().containsIgnoreCase(searchTerm);
        return queryFactory.selectFrom(user)
                .where(predicate)
                .fetch();
    }
}
