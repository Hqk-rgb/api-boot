package top.whf.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.whf.common.constant.Constant;
import top.whf.common.excel.ExcelFinishCallBack;
import top.whf.common.exception.ServerException;
import top.whf.common.utils.DateUtils;
import top.whf.common.utils.ExcelUtils;
import top.whf.common.utils.PageResult;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.whf.rbac.convert.SysUserConvert;
import top.whf.rbac.dao.SysUserDao;
import top.whf.rbac.entity.SysUserEntity;
import top.whf.rbac.enums.SuperAdminEnum;
import top.whf.rbac.query.SysUserQuery;
import top.whf.rbac.service.SysUserService;
import top.whf.rbac.vo.SysUserExcelVO;
import top.whf.rbac.vo.SysUserVO;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @ClassName SysUserServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:37
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long id, String newPassword) {
        // 修改密码
        SysUserEntity user = getById(id);
        user.setPassword(newPassword);
        updateById(user);
    }

    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        //查询参数
        Map<String,Object> params = getParams(query);
        //分页查询
        IPage<SysUserEntity> page = getPage(query);
        params.put(Constant.PAGE,page);
        //获得数据列表
        List<SysUserEntity> list = baseMapper.getList(params);
        return new PageResult<>(SysUserConvert.INSTANCE.convertList(list),page.getTotal());
    }

    private Map<String, Object> getParams(SysUserQuery query) {
        System.out.println(query);
        Map<String, Object> params = new HashMap<>();
        params.put("username", query.getUsername());
        params.put("realName", query.getRealName());
        params.put("beginTime", query.getBeginTime());
        params.put("endTime", query.getEndTime());
        params.put("mobile", query.getMobile());
        params.put("gender", query.getGender());
        return params;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        entity.setSuperAdmin(SuperAdminEnum.NO.getValue());
        //判断用户是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user != null) {
            throw new ServerException("用户名已存在");
        }
        //判断手机号是否存在
        SysUserEntity mobile = baseMapper.getByMobile(entity.getMobile());
        if (mobile!= null){
            throw new ServerException("手机号已存在");
        }
        baseMapper.insert(entity);
    }

    @Override
    public void update(SysUserVO vo) {
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(vo);
        //判断用户名是否存在
        SysUserEntity user = baseMapper.getByUsername(entity.getUsername());
        if (user!= null && !user.getId().equals(entity.getId())){
            throw new ServerException("用户名已存在");
        }
        //判断手机号是否存在
        SysUserEntity mobile = baseMapper.getByMobile(entity.getMobile());
        if (mobile!= null){
            throw new ServerException("手机号已存在");
        }
       updateById(entity);

    }

    @Override
    public void delete(List<Long> ids) {
        //批量删除用户
        removeByIds(ids);

    }

    @Override
    public void importByExcel(MultipartFile file, String password) {
        ExcelUtils.readAnalysis(file, SysUserExcelVO.class, new ExcelFinishCallBack<SysUserExcelVO>() {
            @Override
            public void doAfterAllAnalysed(List<SysUserExcelVO> result) {
                saveUser(result);
            }
            @Override
            public void doSaveBatch(List<SysUserExcelVO> result) {
                saveUser(result);
            }
            private void saveUser(List<SysUserExcelVO> result) {
                //ExcelUtils.parseDict(result);
                //数据转化为
                List<SysUserEntity> sysUserEntities = SysUserConvert.INSTANCE.convertListEntity(result);
                //给每个导入的用户设置密码
                sysUserEntities.forEach(user -> user.setPassword(password));
                //批量新增
                saveBatch(sysUserEntities);
            }
        });
    }

    @Override
    @SneakyThrows
    public void export() {
        List<SysUserEntity> list = list(Wrappers.lambdaQuery(SysUserEntity.class).eq(SysUserEntity::getSuperAdmin,SuperAdminEnum.NO.getValue()));
        List<SysUserExcelVO> userExcelVOList = SysUserConvert.INSTANCE.convert2List(list);
        //导出到下载
        ExcelUtils.excelExport(SysUserExcelVO.class,"system_user_excel"+ DateUtils.format(new Date()),"sheet1",userExcelVOList);
    }

    @Override
    public void updateStatus(long id, int status) {
        SysUserEntity user = baseMapper.getById(id);
        user.setStatus(status);
        baseMapper.updateById(user);
    }
}
