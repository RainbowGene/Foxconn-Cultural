package com.cultural.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.dto.SessionUserAdminDto;
import com.cultural.entity.enums.SysAccountStatusEnum;
import com.cultural.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.SysAccountQuery;
import com.cultural.entity.po.SysAccount;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.SysAccountMapper;
import com.cultural.service.SysAccountService;
import com.cultural.utils.StringTools;


/**
 * 业务接口实现
 */
@Service("sysAccountService")
public class SysAccountServiceImpl implements SysAccountService {

    @Resource
    private SysAccountMapper<SysAccount, SysAccountQuery> sysAccountMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysAccount> findListByParam(SysAccountQuery param) {
        return this.sysAccountMapper.selectList(param);
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysAccountQuery param) {
        return this.sysAccountMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysAccount> findListByPage(SysAccountQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysAccount> list = this.findListByParam(param);
        PaginationResultVO<SysAccount> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysAccount bean) {
        return this.sysAccountMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysAccount> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysAccountMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysAccount> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysAccountMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysAccount bean, SysAccountQuery param) {
        StringTools.checkParam(param);
        return this.sysAccountMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysAccountQuery param) {
        StringTools.checkParam(param);
        return this.sysAccountMapper.deleteByParam(param);
    }

    /**
     * 根据UserId获取对象
     */
    @Override
    public SysAccount getSysAccountByUserId(Integer userId) {
        return this.sysAccountMapper.selectByUserId(userId);
    }

    /**
     * 根据UserId修改
     */
    @Override
    public Integer updateSysAccountByUserId(SysAccount bean, Integer userId) {
        return this.sysAccountMapper.updateByUserId(bean, userId);
    }

    /**
     * 根据UserId删除
     */
    @Override
    public Integer deleteSysAccountByUserId(Integer userId) {
        return this.sysAccountMapper.deleteByUserId(userId);
    }

    /**
     * 根据Phone获取对象
     */
    @Override
    public SysAccount getSysAccountByPhone(String phone) {
        return this.sysAccountMapper.selectByPhone(phone);
    }

    /**
     * 根据Phone修改
     */
    @Override
    public Integer updateSysAccountByPhone(SysAccount bean, String phone) {
        return this.sysAccountMapper.updateByPhone(bean, phone);
    }

    /**
     * 根据Phone删除
     */
    @Override
    public Integer deleteSysAccountByPhone(String phone) {
        return this.sysAccountMapper.deleteByPhone(phone);
    }

    @Override
    public SessionUserAdminDto login(String phone, String password) {
        SysAccount sysAccount = this.sysAccountMapper.selectByPhone(phone);
        if (sysAccount == null) {
            throw new BusinessException("账号或密码错误！");
        }
        if (SysAccountStatusEnum.DISABLE.getStatus().equals(sysAccount.getStatus())) {
            throw new BusinessException("账号已禁用！");
        }
        if (!sysAccount.getPassword().equals(password)) {
            throw new BusinessException("账号或密码错误！");
        }
        SessionUserAdminDto adminDto = new SessionUserAdminDto();
        adminDto.setSuperAdmin(true);
        adminDto.setUserid(sysAccount.getUserId());
        adminDto.setUserName(sysAccount.getUserName());
        return adminDto;
    }
}