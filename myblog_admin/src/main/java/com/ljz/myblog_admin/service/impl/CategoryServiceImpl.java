package com.ljz.myblog_admin.service.impl;

import com.ljz.myblog_admin.pojo.Category;
import com.ljz.myblog_admin.mapper.CategoryMapper;
import com.ljz.myblog_admin.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
