package yitian.javafxsample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInput extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //网格布局
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        //网格垂直间距
        grid.setHgap(10);
        //网格水平间距
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //新建场景
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        //添加标题
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        //添加标签及文本框
        Label userName = new Label("用户名:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        //添加标签及密码框
        Label pw = new Label("密码:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        //添加提交按钮
        Button btn = new Button("登录");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(event -> {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("已经登录");
        });

        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
