package com.ljz.myblog_admin.service.impl;

import com.ljz.myblog_admin.pojo.Comment;
import com.ljz.myblog_admin.mapper.CommentMapper;
import com.ljz.myblog_admin.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljz
 * @since 2022-07-15 16-40-17
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
