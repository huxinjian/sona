import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xinjian.hu
 * @Date: 2020/12/18 15:43
 * @Email: huxinjian@jiuyescm.com
 */
public class logTest {

    private static final Logger logger = LoggerFactory.getLogger(logTest.class);

    /**
     * logger 打印测试
     */
    @Test
    public void logPrint() {
        logger.info("123");
    }
}
