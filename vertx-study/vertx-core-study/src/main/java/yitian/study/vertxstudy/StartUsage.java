package yitian.study.vertxstudy;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class StartUsage {
    public static void createVerxObject() {
        Vertx vertx = Vertx.vertx();

        VertxOptions options = new VertxOptions();
        options.setWorkerPoolSize(20);
        Vertx vertx2 = Vertx.vertx(options);
    }

}
