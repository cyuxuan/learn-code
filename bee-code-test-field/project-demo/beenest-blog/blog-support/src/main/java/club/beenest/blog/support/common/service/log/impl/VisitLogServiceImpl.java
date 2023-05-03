package club.beenest.blog.support.common.service.log.impl;

import club.beenest.blog.support.common.dao.log.VisitLogMapper;
import club.beenest.blog.support.common.entity.log.VisitLog;
import club.beenest.blog.support.common.entity.log.VisitLogUuidTime;
import club.beenest.blog.support.common.entity.useragent.UserAgent;
import club.beenest.blog.support.common.service.log.VisitLogService;
import club.beenest.blog.support.exception.PersistenceException;
import club.beenest.blog.support.util.IpAddressUtils;
import club.beenest.blog.support.util.UserAgentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 访问日志业务层实现
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Service
public class VisitLogServiceImpl implements VisitLogService {
    @Autowired
	VisitLogMapper visitLogMapper;
    @Autowired
	UserAgentUtils userAgentUtils;

    @Override
    public List<VisitLog> getVisitLogListByUUIDAndDate(String uuid, String startDate, String endDate) {
        return visitLogMapper.getVisitLogListByUUIDAndDate(uuid, startDate, endDate);
    }

    @Override
    public List<VisitLogUuidTime> getUUIDAndCreateTimeByYesterday() {
        return visitLogMapper.getUUIDAndCreateTimeByYesterday();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveVisitLog(VisitLog log) {
        String ipSource = IpAddressUtils.getCityInfo(log.getIp());
        UserAgent userAgentDTO = userAgentUtils.parseOsAndBrowser(log.getUserAgent());
        log.setIpSource(ipSource);
        log.setOs(userAgentDTO.getOs());
        log.setBrowser(userAgentDTO.getBrowser());
        if (visitLogMapper.saveVisitLog(log) != 1) {
            throw new PersistenceException("日志添加失败");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteVisitLogById(Long id) {
        if (visitLogMapper.deleteVisitLogById(id) != 1) {
            throw new PersistenceException("删除日志失败");
        }
    }
}
