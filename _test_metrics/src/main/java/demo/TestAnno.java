package demo;

import com.codahale.metrics.annotation.*;

/**
 * @author noear 2021/1/27 created
 */

public class TestAnno {
    @Gauge
    @Counted
    @Metered
    @Metric
    @Timed
    public void main(){

    }
}
