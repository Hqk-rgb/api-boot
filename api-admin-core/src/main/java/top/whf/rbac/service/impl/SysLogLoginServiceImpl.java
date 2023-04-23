package top.whf.rbac.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import top.whf.common.utils.AddressUtils;
import top.whf.common.utils.HttpContextUtils;
import top.whf.common.utils.IpUtils;
import top.whf.common.utils.PageResult;
import top.whf.mybatis.service.impl.BaseServiceImpl;
import top.whf.rbac.convert.SysLogLoginConvert;
import top.whf.rbac.dao.SysLogLoginDao;
import top.whf.rbac.entity.SysLogLoginEntity;
import top.whf.rbac.query.SysLogLoginQuery;
import top.whf.rbac.service.SysLogLoginService;
import top.whf.rbac.vo.SysLogLoginVO;

import java.util.List;
/**
 * @ClassName SysLogLoginServiceImpl
 * @Description TODO
 * @Author Dr.king
 * @Date 2023/4/23 19:42
 */
@Service
public class SysLogLoginServiceImpl extends BaseServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService{
    @Override
    public PageResult<SysLogLoginVO> page(SysLogLoginQuery query) {
        IPage<SysLogLoginEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<SysLogLoginEntity> list = page.getRecords();
        List<SysLogLoginVO> resList = SysLogLoginConvert.INSTANCE.converList(list);
        long count = page.getTotal();
        return new PageResult<>(resList, count);
    }

    private LambdaQueryWrapper<SysLogLoginEntity> getWrapper(SysLogLoginQuery query) {
        LambdaQueryWrapper<SysLogLoginEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(query.getUsername()), SysLogLoginEntity::getUsername, query.getUsername());
        wrapper.like(StrUtil.isNotBlank(query.getAddress()), SysLogLoginEntity::getAddress, query.getAddress());
        wrapper.like(query.getStatus() != null, SysLogLoginEntity::getStatus, query.getStatus());
        wrapper.orderByDesc(SysLogLoginEntity::getId);
        return wrapper;
    }

    @Override
    public void save(String username, Integer status, Integer operation) {
        // 获得请求对象
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 从请求对象中获取请求地址、IP、UA 等信息
        assert request != null;
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);  // 要加 org.springframework.http.HttpHeaders
        String ip = IpUtils.getIpAddr(request);
        String address = AddressUtils.getAddressByIP(ip);

        SysLogLoginEntity entity = new SysLogLoginEntity();
        entity.setUsername(username);
        entity.setIp(ip);
        entity.setAddress(address);
        entity.setUserAgent(userAgent);
        entity.setStatus(status);
        entity.setOperation(operation);
        baseMapper.insert(entity);
    }
}
