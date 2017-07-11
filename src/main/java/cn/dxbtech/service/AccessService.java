package cn.dxbtech.service;

import cn.dxbtech.domain.HistoryAccess;
import cn.dxbtech.domain.HistoryAccessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccessService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final HistoryAccessRepository historyAccessRepository;

    @Autowired
    public AccessService(HistoryAccessRepository historyAccessRepository) {
        this.historyAccessRepository = historyAccessRepository;
    }

    public Date history(String uri, String ip, String ua) {
        HistoryAccess historyAccess = historyAccessRepository.save(new HistoryAccess(uri, ip, ua));
        logger.info("Access : {}", historyAccess);
        return historyAccess.getTime();
    }
}
