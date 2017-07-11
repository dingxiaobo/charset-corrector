package cn.dxbtech.service;

import cn.dxbtech.domain.HistoryCorrect;
import cn.dxbtech.domain.HistoryCorrectRepository;
import cn.dxbtech.dto.CorrectDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;

@Service
public class CorrectService {
    private final String[] CHARSET_NAMES = new String[]{"ISO8859-1", "GBK", "UTF-8"};

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final HistoryCorrectRepository historyCorrectRepository;

    @Autowired
    public CorrectService(HistoryCorrectRepository historyCorrectRepository) {
        this.historyCorrectRepository = historyCorrectRepository;
    }

    @Transactional
    public CorrectDto correct(String origin, String ip, String ua) throws UnsupportedEncodingException {

        int strLength = Integer.MAX_VALUE;    //字符长度
        String result = null;                   //从乱码字符串分析出的字符串
        String originCharset = "";               //当前乱码字符串编码
        String resultCharset = "";            //乱码字符串正确的编码

        //遍历可能的编码组合，从中造成编码长度最小的编码格式
        for (String charsetNameOrigin : CHARSET_NAMES) {
            for (String charsetNameResult : CHARSET_NAMES) {
                String test = new String(origin.getBytes(charsetNameOrigin), charsetNameResult);
                if (test.length() <= strLength) {
                    strLength = test.length();
                    result = test;
                    originCharset = charsetNameOrigin;
                    resultCharset = charsetNameResult;
                }
            }
        }
        //输出查询到的编码及正确文本格式
        logger.info(originCharset + "-->" + resultCharset + ":" + result);

        historyCorrectRepository.save(new HistoryCorrect(origin, originCharset, result, resultCharset, ip, ua));

        return new CorrectDto(origin, originCharset, result, resultCharset);
    }

}
